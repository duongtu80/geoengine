package cn.geodata.models.glacier.agent;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import cn.geodata.models.AbstractProcessing;
import cn.geodata.models.glacier.GlacierPrepareModel;
import cn.geodata.models.glacier.GlacierRunoffModel;
import cn.geodata.models.glacier.ObjectMonth;
import cn.geodata.models.glacier.ProjectTransformModel;
import cn.geodata.models.tools.raster.RasterManager;
import cn.geodata.models.wps.client.WpsProcess;
import cn.geodata.models.wps.client.WpsService;

public class RunoffAgent extends AbstractProcessing {
	private static Logger log = Logger.getLogger(RunoffAgent.class.getName());
	
	private String temperatureModelUrl; 
	private String precipitationModelUrl; 
	private String snowDdfModelUrl; 
	private String iceDdfModelUrl;
	private com.vividsolutions.jts.geom.MultiPolygon catchment;
	private org.geotools.feature.FeatureCollection glacier;
	private long startDate;
	private long endDate;
	private double cellSize;
	private double rainCritical;
	private double snowCritical;
	
	private void initializeOutputs(List<ObjectMonth> list){
		JSONArray _list = new JSONArray();
		for(int i=0;i<list.size();i++){
			JSONObject _val = new JSONObject();
			
			_val.put("date", list.get(i).getDate().getTime());
			_val.put("runoff", list.get(i).getRunoff());
			
			_list.put(_val);
		}
		
		JSONObject _runoff = new JSONObject();
		_runoff.put("runoff", _list);
		
		this.getOutputs().put("Runoff", _runoff.toString());
	}

	public void execute() throws Exception{
		this.initializeInputs();
		
//		log.info("" + this.catchment.getNumGeometries());
//		log.info(this.catchment.getCentroid().getX() + "\t" + this.catchment.getCentroid().getY());
//		log.info("Glacier count:" + this.glacier.size());
//		
		RasterManager _demModel = new RasterManager(new File("O:\\tank\\data\\dem\\tiff"), 0);
		
		double[] _levels = new double[20];
		for(int i=0;i<20;i++){
			_levels[i] = 3000 + i * 250;
		}
		
		System.out.println(Arrays.toString(_levels));
		GlacierRunoffModel _model = new GlacierRunoffModel();
		
		_model.setTemperatureModel(this.loadWpsProcess(temperatureModelUrl));
		_model.setPrecipitationModel(this.loadWpsProcess(precipitationModelUrl));
		_model.setIceDdfModel(this.loadWpsProcess(iceDdfModelUrl));
		_model.setSnowDdfModel(this.loadWpsProcess(snowDdfModelUrl));

		_model.setPrepareModel(new GlacierPrepareModel(_demModel, glacier));
		_model.setProjectModel(new ProjectTransformModel("EPSG:4326", "EPSG:21416"));
		_model.setDemModel(_demModel);

		_model.setLevels(_levels);
		_model.setCellSize(cellSize);
		_model.setRainCritical(rainCritical);
		_model.setSnowCritical(snowCritical);
		
		List<ObjectMonth> _list = _model.calculate(new Date(startDate), new Date(endDate), catchment);
		
		DateFormat _dateFormat = new SimpleDateFormat("yyyy-MM");
		DecimalFormat _deciFormat = new DecimalFormat("0.00");
		for(ObjectMonth _m : _list){
			System.out.println(_dateFormat.format(_m.getDate()) + "\t" + _deciFormat.format(_m.getTemperature()) + "\t" + _deciFormat.format(_m.getPrecipitation()) + "\t" +  _deciFormat.format(_m.getRunoff()));
		}
		
		this.initializeOutputs(_list);
	}
	
	private WpsProcess loadWpsProcess(String url) throws IOException, URISyntaxException{
		String[] _parts = url.split("#", 2);
		if(_parts.length < 2){
			throw new IOException("Failed to find process name from url " + url);
		}
		
		WpsService _s = new WpsService(new URI(_parts[0]));
		_s.connect();
		
		return _s.getWpsProcess(_parts[1]);
	}
}
