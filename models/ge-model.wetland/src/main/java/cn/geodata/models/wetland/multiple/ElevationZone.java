package cn.geodata.models.wetland.multiple;

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Logger;

import org.geotools.data.ows.CRSEnvelope;
import org.geotools.referencing.CRS;
import org.opengis.referencing.FactoryException;
import org.opengis.referencing.crs.CoordinateReferenceSystem;

import cn.geodata.models.raster.GeoRaster;

import com.vividsolutions.jts.geom.Envelope;
import com.vividsolutions.jts.geom.MultiPolygon;

public class ElevationZone {
	private Logger log = Logger.getAnonymousLogger();
	
	private double startElevation;
	private int zoneNum;
	private double zoneHeight;
	private double pixelSize;
	private long[] elevations; //The pixel account at each elevation zone
	
	private ElevationZone(double startElevation, int zoneNum, double zoneHeight, double pixelSize, long[] elevations){
		super();
		
		this.startElevation = startElevation;
		this.zoneNum = zoneNum;
		this.zoneHeight = zoneHeight;
		this.pixelSize = pixelSize;
		this.elevations = elevations;
	}

	public ElevationZone(GeoRaster raster, MultiPolygon region) throws Exception {
		this(500, 50000, 0.01, raster, region);
	}
	
	public ElevationZone(double startElevation, int zoneNum,
			double zoneHeight, GeoRaster raster, MultiPolygon region) throws Exception {
		super();
		
		this.startElevation = startElevation;
		this.zoneNum = zoneNum;
		this.zoneHeight = zoneHeight;
		
		org.opengis.geometry.Envelope _env = CRS.transform(CRS.findMathTransform(raster.getEnvelope().getCoordinateReferenceSystem(), this.initCoordinateRefSystem()), this.pixelEnvelope(raster));

		this.pixelSize = _env.getSpan(0) * _env.getSpan(1);
		this.elevations = new long[zoneNum];
		
		Arrays.fill(this.elevations, 0L);
		this.init(raster, region);
	}
	
	private org.opengis.geometry.Envelope pixelEnvelope(GeoRaster raster){
		double _minx = raster.getX(raster.getColNum() / 2);
		double _miny = raster.getY(raster.getRowNum() / 2);
		
		return new CRSEnvelope("EPSG:4326", _minx, _miny, _minx + raster.getCellSizeX(), _miny + raster.getCellSizeY());
	}
	
	private CoordinateReferenceSystem initCoordinateRefSystem() throws FactoryException{
//		String _wkt = "PROJCS[\"Google Mercator\",GEOGCS[\"WGS 84\",DATUM[\"World Geodetic System 1984\",SPHEROID[\"WGS 84\",6378137.0,298.257223563,AUTHORITY[\"EPSG\",\"7030\"]],AUTHORITY[\"EPSG\",\"6326\"]],PRIMEM[\"Greenwich\",0.0,AUTHORITY[\"EPSG\",\"8901\"]],UNIT[\"degree\",0.017453292519943295],AXIS[\"Geodetic latitude\",NORTH],AXIS[\"Geodetic longitude\",EAST],AUTHORITY[\"EPSG\",\"4326\"]],PROJECTION[\"Mercator (1SP)\",AUTHORITY[\"EPSG\",\"9804\"]],PARAMETER[\"semi_major\",6378137.0],PARAMETER[\"semi_minor\",6378137.0],PARAMETER[\"latitude_of_origin\",0.0],PARAMETER[\"central_meridian\",0.0],PARAMETER[\"scale_factor\",1.0],PARAMETER[\"false_easting\",0.0],PARAMETER[\"false_northing\",0.0],UNIT[\"m\",1.0],AXIS[\"Easting\",EAST],AXIS[\"Northing\",NORTH],AUTHORITY[\"EPSG\",\"900913\"]]";
//		String _wkt = "PROJCS[\"Albers Conical Equal Area\",GEOGCS[\"GCS_North_American_1983\",DATUM[\"D_North_American_1983\",SPHEROID[\"GRS_1980\",6378137.0,298.257222101]],PRIMEM[\"Greenwich\",0.0],UNIT[\"Degree\",0.0174532925199433]],PROJECTION[\"Albers\"],PARAMETER[\"False_Easting\",0.0],PARAMETER[\"False_Northing\",0.0],PARAMETER[\"Central_Meridian\",-96.0],PARAMETER[\"Standard_Parallel_1\",29.5],PARAMETER[\"Standard_Parallel_2\",45.5],PARAMETER[\"Latitude_Of_Origin\",23.0],UNIT[\"Meter\",1.0]]";
//		return CRS.parseWKT(_wkt);
		
		return CRS.decode("EPSG:32614", true);
	}
	
	private void init(GeoRaster raster, MultiPolygon region) throws IOException{
		Envelope _env = region.getEnvelopeInternal();
		
		for(int _row=0;_row < raster.getRowNum();_row++){
			double _y = raster.getY(_row);
			for(int _col=0;_col < raster.getColNum();_col++){
				double _x = raster.getX(_col);
				
				if(_env.contains(_x, _y)){
					Number _val = raster.getCell(_col, _row);
					if(_val != null){
						int _pos = (int)Math.floor(((_val.doubleValue() - this.startElevation) / this.zoneHeight));
						if(_pos < 0)
							_pos = 0;
						if(_pos > this.zoneNum - 1)
							_pos = this.zoneNum - 1;
						
						this.elevations[_pos]++;
					}
				}
			}
		}
		
		for(int i=1;i<this.zoneNum;i++){
			this.elevations[i] = this.elevations[i] + this.elevations[i-1]; 
		}
		
		if(this.elevations[this.elevations.length - 1] == 0)
			throw new IOException("No elevation area found");
	}

	public double calculateFullVolume(){
		double _vol = 0;
		for(int i=0;i<this.zoneNum;i++){
			_vol += this.elevations[i] * this.pixelSize * this.zoneHeight;
		}
		
		return _vol;
	}
	
	public double calculateVolume(double waterTable){
		int _pos = (int) Math.floor((waterTable - this.startElevation) / this.zoneHeight);
		
		if(_pos <= 0)
			return 0;
		
		if(_pos > this.elevations.length - 1){
			log.warning("Water table is higher than elevation range (" + waterTable + ")");
		}
		
		double _vol = 0;
		for(int i=0;i<_pos;i++){
			long _ele = i < this.elevations.length? this.elevations[i]: this.elevations[this.elevations.length - 1];
			_vol +=_ele * this.pixelSize * this.zoneHeight;
		}
		
		double _delta = waterTable - (this.startElevation + this.zoneHeight * _pos);
		if(_delta > 0){
			long _ele = _pos < this.elevations.length? this.elevations[_pos]: this.elevations[this.elevations.length - 1];
			_vol += _ele * this.pixelSize * _delta;
		}
		
		return _vol;
	}
	
	public double calculateWaterTable(double volume){
		double _vol = volume;
		
		int _pos = 0;
		while(true){
			long _ele = _pos < this.elevations.length? this.elevations[_pos]: this.elevations[this.elevations.length - 1];
			_pos++;
			
			if(_ele <= 0){
				continue;
			}
			
			double _vv = _ele * this.pixelSize * this.zoneHeight;
			if(_vol > _vv){
				_vol -= _vv;
				
				if(_vol <= 0)
					return this.startElevation + _pos * this.zoneHeight;
			}
			else{
				return this.startElevation + (this.zoneHeight * (_pos - 1 + _vol / _vv));
			}
		}
	}
	
	public double calculateBottomElevation() throws IOException{
		for(int i=0;i<this.zoneNum;i++){
			if(this.elevations[i] > 0)
				return this.startElevation + (this.zoneHeight * (i - 1));
		}
		
		throw new IOException("No area found");
	}

	/**
	 * Merge two catchments
	 * 
	 * @param zone1
	 * @param zone2
	 * @return
	 * @throws IOException
	 */
	public static ElevationZone merge(ElevationZone zone1, ElevationZone zone2) throws IOException{
		if(zone1.startElevation != zone2.startElevation || zone1.zoneNum != zone2.zoneNum || zone1.zoneHeight != zone2.zoneHeight){
			throw new IOException("The raster data are unmatched.");
		}
		
		long[] _elevations = new long[zone1.zoneNum];
		for(int i=0;i<zone1.zoneNum;i++){
			_elevations[i] = zone1.elevations[i] + zone2.elevations[i];
		}
		
		return new ElevationZone(zone1.startElevation, zone1.zoneNum, zone1.zoneHeight, zone1.pixelSize, _elevations);
	}

	public double getStartElevation() {
		return startElevation;
	}
	
	public int getZoneNum() {
		return zoneNum;
	}

	public double getZoneHeight() {
		return zoneHeight;
	}

	public double getPixelSize() {
		return pixelSize;
	}

	public long[] getElevations() {
		return elevations;
	}
}
