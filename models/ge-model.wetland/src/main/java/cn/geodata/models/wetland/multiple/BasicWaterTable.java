package cn.geodata.models.wetland.multiple;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.apache.commons.lang.StringUtils;

import cn.geodata.models.wetland.WaterRegionCalc;

import com.google.common.collect.Lists;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.MultiPolygon;
import com.vividsolutions.jts.geom.Polygon;

public abstract class BasicWaterTable implements WaterTable {
	private static final long serialVersionUID = -2069320722376582962L;

	private Logger log = Logger.getAnonymousLogger();
	
	private SpillPoint spillPoint;
	//Water level
	protected double waterLevel;
	protected ElevationZone zones;
	protected double bottomElevation;
	protected List<Catchment> catchments;

	public BasicWaterTable(ElevationZone zones, SpillPoint spillPoint, List<Catchment> catchments) throws IOException{
		this(zones, spillPoint, zones.calculateBottomElevation(), catchments);
	}
	
	public BasicWaterTable(ElevationZone zones, SpillPoint spillPoint, double waterTable, List<Catchment> catchments) throws IOException{
		this.spillPoint = spillPoint;
		this.waterLevel = waterTable;
		this.zones = zones;
		this.bottomElevation = zones.calculateBottomElevation();
		this.catchments = catchments;
	}
	
	public MultiPolygon calculateWaterRegion() {
		WaterRegionCalc _model = new WaterRegionCalc();
		_model.setCatchment(this.getCatchmentRegion());
		_model.setReader(this.catchments.get(0).getDem());
		_model.setWaterLevel(waterLevel);
		
		MultiPolygon _water = null;
		try {
			_water = _model.calculate2();
		} catch (Exception e) {
			log.info("Failed to calculate water region: " + e.getMessage());
		}
		return _water;
	}

	public void addWaterVolume(double volume) {
//		this.waterLevel += waterTable / this.getArea();
		this.waterLevel = this.zones.calculateWaterTable(this.zones.calculateVolume(this.waterLevel) + volume);
	}

	public double getBottomElevation() {
		return bottomElevation;
	}

	public double getArea() {
		double _area = 0;
		for(int i=0;i<this.catchments.size();i++){
			_area += this.catchments.get(i).getArea();
		}
		
		return _area;
	}

	public double getCatchmentVolume() {
		if(this.waterLevel >= this.spillPoint.getElevation()){
			return 0;
		}
		
		return this.zones.calculateVolume(this.spillPoint.getElevation()) - this.zones.calculateVolume(this.waterLevel);
	}

	public double getOverflowVolume() {
		if(this.waterLevel <= this.spillPoint.getElevation()){
			return 0;
		}
		
		return this.zones.calculateVolume(this.waterLevel) - this.zones.calculateVolume(this.spillPoint.getElevation());
	}

	public SpillPoint getSpillPoint() {
		return this.spillPoint;
	}

	public double getWaterLevel() {
		return this.waterLevel;
	}

	public void setWaterLevel(double waterLevel) {
		this.waterLevel = waterLevel;
	}

	@Override
	public String toString() {
		return StringUtils.join(this.catchments, ",");  
	}

	public List<Catchment> getCatchments(){
		return this.catchments;
	}

	public MultiPolygon getCatchmentRegion() {
		return this.combineCatchments(this.catchments);
	}
	
	/**
	 * Combine catchment regions into one multiple polygon
	 * 
	 * @param catchments
	 * @return
	 */
	private MultiPolygon combineCatchments(List<Catchment> catchments){
		if(catchments.size() == 0)
			return catchments.get(0).getRegion();
		
		MultiPolygon _polygon = null;
		for(Catchment _c : catchments){
			if(_polygon == null){
				_polygon = _c.getRegion();
			}
			else{
				Geometry _p = _polygon.union(_c.getRegion());
				if (_p instanceof MultiPolygon) {
					_polygon = (MultiPolygon) _p;
				}
				else if(_p instanceof Polygon){
					_polygon = (new GeometryFactory()).createMultiPolygon(new Polygon[] {(Polygon)_p});
				}
				else
					Logger.getAnonymousLogger().info("Unsupported geometry type");
			}
		}
		
		return _polygon;
	}

	public ElevationZone getZones() {
		return this.zones;
	}

	public double getWaterVolume() {
		return this.zones.calculateVolume(this.waterLevel);
	}
	
	public boolean isOverFlow() {
		return this.waterLevel > this.spillPoint.getElevation();
	}

	public boolean isFull() {
		return this.waterLevel >= this.spillPoint.getElevation();
	}

	public double getCatchmentVolume(double waterTable) {
		if(waterTable <= this.waterLevel){
			return 0;
		}
		
		return this.zones.calculateVolume(waterTable) - this.zones.calculateVolume(this.waterLevel);
	}
}
