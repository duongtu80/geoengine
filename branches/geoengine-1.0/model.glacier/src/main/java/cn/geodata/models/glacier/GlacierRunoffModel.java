package cn.geodata.models.glacier;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.geotools.coverage.Category;
import org.geotools.geometry.Envelope2D;
import org.geotools.wms.v1_1_1.bindings._LegendURLBinding;

import cn.geodata.models.category.data.DataCategories;
import cn.geodata.models.category.data.DataCategory;
import cn.geodata.models.tools.Utilities;
import cn.geodata.models.tools.raster.RasterManager;
import cn.geodata.models.wps.client.WpsProcess;

import com.vividsolutions.jts.geom.MultiPolygon;
import com.vividsolutions.jts.geom.Point;

public class GlacierRunoffModel {
	private Logger log = Logger.getLogger(GlacierRunoffModel.class.getName());

	private RasterManager demModel;
	
//	private TemperatureModel temperatureModel;
//	private PrecipitationModel precipitationModel;
//	private SnowDDFModel snowDDFModel;
//	private IceDDFModel iceDDFModel;

	private WpsProcess temperatureModel;
	private WpsProcess precipitationModel;
	private WpsProcess snowDdfModel;
	private WpsProcess iceDdfModel;
	
	private GlacierPrepareModel prepareModel;
	private ProjectTransformModel projectModel;
	
	private double[] levels;
	private double snowCritical;
	private double rainCritical;
	private double cellSize;
	private double evaporationRatio;
	private double snowFrozenRatio;
	private double temperatureGrad;
	private double precipitationGrad;
	
	public List<ObjectMonth> calculate(Date startDate, Date endDate, MultiPolygon catchment) throws Exception {
		if(levels == null || levels.length == 0){
			throw new NullPointerException("No valid levels");
		}
		if(cellSize <= 0){
			throw new IOException("No valid cellsize");
		}
		
		Point _sitePoint = catchment.getCentroid();
		log.info("Centeroid point:" + _sitePoint.toText());
		
		double _siteDem = demModel.getLocationValue(_sitePoint.getX(), _sitePoint.getY());
		
		//Calculate ddfs
		double _snowDDF = (Double)this.snowDdfModel.execute(new Object[]{0, 0, 2, _sitePoint}, new DataCategory[]{DataCategories.getInstance().findCategory("double")}).get(0);
		double _iceDDF = (Double)this.iceDdfModel.execute(new Object[]{0, 0, 2, _sitePoint}, new DataCategory[]{DataCategories.getInstance().findCategory("double")}).get(0);
		
		log.info("Snow DDF:" + _snowDDF);
		log.info("Ice DDF:" + _iceDDF);
		
		DateFormat _format = new SimpleDateFormat("yyyy-MM");
		
		Calendar _calendar = Calendar.getInstance();
		_calendar.setTime(startDate);
		
		Map<Integer, Integer> _areas = this.prepareModel.calculate(catchment, cellSize, null); 
		List<BandInfo> _pixels = new ArrayList<BandInfo>();
		for(int i=0;i<levels.length;i++){
			BandInfo _band = new BandInfo();
			_band.setBandAltitude(levels[i]);
			
			long _glaicerCount = 0;
			for(Integer _k : _areas.keySet()){
				if(_k <= levels[i]){
					_glaicerCount += _areas.get(_k).longValue();
				}
			}
			_band.setGlacierCount(_glaicerCount);
			
			_pixels.add(_band);
		}
		
		double _pixelArea = this.projectModel.calculate(Utilities.covertEnvelope2D(new Envelope2D(null, _sitePoint.getX(), _sitePoint.getY(), cellSize, cellSize))).getArea();
		
		log.info(Arrays.toString(_pixels.toArray()));
		log.info("Pixel Area:" + _pixelArea);
		
		List<ObjectMonth> _months = new ArrayList<ObjectMonth>();
		while(_calendar.getTime().before(endDate)){
			log.info("Date:" + _format.format(_calendar.getTime()));
			
			//Calculate precipitation temperature values
			
			
			double _prec = (Double)this.precipitationModel.execute(new Object[]{_calendar.getTime().getTime(), 0, 0, 2, _sitePoint}, new DataCategory[]{DataCategories.getInstance().findCategory("double")}).get(0);
			log.info("Precipitation:" + _prec);
			
			double _temp = (Double)this.temperatureModel.execute(new Object[]{_calendar.getTime().getTime(), 0, 0, 2, _sitePoint}, new DataCategory[]{DataCategories.getInstance().findCategory("double")}).get(0);
			log.info("Temperature:" + _temp);
			
//			double _accuml = 0;
			double _runoff = 0;
			
			//Calculate each band
			List<ObjectBand> _bands = new ArrayList<ObjectBand>();
			for(int i=0;i<levels.length ;i++){
				double _level = levels[i];

				ObjectBand _band = new ObjectBand();
				_band.setLevel(_level);

				if(_pixels.get(i).getGlacierCount() <= 0){
					log.info("No glacier found at band " + i);

					_bands.add(_band);
					continue;
				}
					
				double _precBand = precipitation4Band(_prec, _siteDem, _level);
				double _tempBand = temperature4Band(_temp, _siteDem, _level);
				
				double _snow = 0;
				if(_tempBand < this.snowCritical){
					_snow = _prec;
				}
				else{
					if(_tempBand < this.rainCritical){
						_snow = _precBand * (_tempBand - this.snowCritical) / (this.rainCritical - this.snowCritical);
					}
				}
				double _runoffBand = _precBand - _snow;
				
				if(_months.size() > 0){
					_snow += _months.get(_months.size() - 1).getBands().get(i).getAccumulation();
				}
				
				double _accumlBand = 0;
				double _pSnowMelt = _tempBand * _snowDDF;
				if(_pSnowMelt <= _snow){
					_accumlBand = _snow - _pSnowMelt;
					_runoffBand += _pSnowMelt;
				}
				else{
					_runoffBand += _snow + (_tempBand - _snow / _snowDDF) * _iceDDF;
				}
				
				double _balanceBand = _accumlBand - (1 - this.snowFrozenRatio) * _runoffBand;
				
				_band.setTemperature(_tempBand);
				_band.setPrecipitation(_precBand);
				_band.setAccumulation(_accumlBand);
				_band.setRunoff(_runoffBand);
				_band.setBalance(_balanceBand);
				
				_bands.add(_band);
				
//				_accuml += _accumlBand * _pixels[i] * _pixelArea;
				_runoff += _runoffBand * _pixels.get(i).getGlacierCount() * _pixelArea;
			}
			
			ObjectMonth _month = new ObjectMonth();
			
			_month.setDate(_calendar.getTime());
			_month.setBands(_bands);
			_month.setPrecipitation(_prec);
			_month.setTemperature(_temp);
//			_month.setAccumulation(_accuml);
			_month.setRunoff(_runoff);
			
			_months.add(_month);

			//Jump to next month
			_calendar.add(Calendar.MONTH, 1);
		}
		
		return _months;
	}
	
	public double temperature4Band(double val, double sourceLat, double targetLat) {
		return val + temperatureGrad * (targetLat - sourceLat);
	}

	public double precipitation4Band(double val, double sourceLat, double targetLat) {
		double _val =  val + precipitationGrad * (targetLat - sourceLat);
		if(_val < 0){
			_val = 0;
		}
		return _val;
	}

	public double getSnowFrozenRatio() {
		return snowFrozenRatio;
	}

	public void setSnowFrozenRatio(double snowFrozenRatio) {
		this.snowFrozenRatio = snowFrozenRatio;
	}

	public double getEvaporationRatio() {
		return evaporationRatio;
	}

	public void setEvaporationRatio(double evaporationRatio) {
		this.evaporationRatio = evaporationRatio;
	}

	public RasterManager getDemModel() {
		return demModel;
	}

	public void setDemModel(RasterManager demModel) {
		this.demModel = demModel;
	}

	public GlacierPrepareModel getPrepareModel() {
		return prepareModel;
	}

	public void setPrepareModel(GlacierPrepareModel prepareModel) {
		this.prepareModel = prepareModel;
	}

	public ProjectTransformModel getProjectModel() {
		return projectModel;
	}

	public void setProjectModel(ProjectTransformModel projectModel) {
		this.projectModel = projectModel;
	}

	public double[] getLevels() {
		return levels;
	}

	public void setLevels(double[] levels) {
		this.levels = levels;
	}

	public double getSnowCritical() {
		return snowCritical;
	}

	public void setSnowCritical(double snowCritical) {
		this.snowCritical = snowCritical;
	}

	public double getRainCritical() {
		return rainCritical;
	}

	public void setRainCritical(double rainCritical) {
		this.rainCritical = rainCritical;
	}

	public double getCellSize() {
		return cellSize;
	}

	public void setCellSize(double cellSize) {
		this.cellSize = cellSize;
	}

	public void setTemperatureModel(WpsProcess temperatureModel) {
		this.temperatureModel = temperatureModel;
	}

	public void setPrecipitationModel(WpsProcess precipitationModel) {
		this.precipitationModel = precipitationModel;
	}

	public void setSnowDdfModel(WpsProcess snowDdfModel) {
		this.snowDdfModel = snowDdfModel;
	}

	public void setIceDdfModel(WpsProcess iceDdfModel) {
		this.iceDdfModel = iceDdfModel;
	}

	public void setTemperatureGrad(double temperatureGrad) {
		this.temperatureGrad = temperatureGrad;
	}

	public void setPrecipitationGrad(double precipitationGrad) {
		this.precipitationGrad = precipitationGrad;
	}

	public WpsProcess getTemperatureModel() {
		return temperatureModel;
	}

	public WpsProcess getPrecipitationModel() {
		return precipitationModel;
	}

	public WpsProcess getSnowDdfModel() {
		return snowDdfModel;
	}

	public WpsProcess getIceDdfModel() {
		return iceDdfModel;
	}

	public double getTemperatureGrad() {
		return temperatureGrad;
	}

	public double getPrecipitationGrad() {
		return precipitationGrad;
	}
}
