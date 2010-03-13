package cn.geodata.models.wetland.multiple;

import java.io.Serializable;
import java.util.List;

import com.vividsolutions.jts.geom.MultiPolygon;

/**
 * Water table abstract class
 * 
 * @author tank
 *
 */
public interface WaterTable extends Serializable, Cloneable {
	/**
	 * Get spill point
	 * 
	 * @return
	 */
	SpillPoint getSpillPoint();
	
	/**
	 * Add water volume
	 * 
	 * @param waterTable
	 * @return
	 */
	void addWaterVolume(double volume);
	
	/**
	 * Calculate water region polygon
	 * 
	 * @return
	 */
	MultiPolygon calculateWaterRegion();
	
	/**
	 * Get the overflow volume
	 * 
	 * @return
	 */
	double getOverflowVolume();
	
	/**
	 * Get catchment volume
	 * 
	 * @return
	 */
	double getCatchmentVolume();
	
	/**
	 * Get catchment volumn left for the given water table
	 * @param waterTable
	 * @return
	 */
	double getCatchmentVolume(double waterTable);
	
	/**
	 * If the water is over flowing in the catchment(s)
	 * 
	 * @return
	 */
	boolean isOverFlow();
	
	/**
	 * Get current water volume
	 * 
	 * @return
	 */
	double getWaterVolume();
	
	/**
	 * Get area for the water unit
	 * 
	 * @return
	 */
	double getArea();
	
	/**
	 * Get catchments for the water unit
	 * 
	 * @return
	 */
	List<Catchment> getCatchments();
	
	/**
	 * Get elevation zones
	 * 
	 * @return
	 */
	ElevationZone getZones();
	
	/**
	 * Get water level
	 * 
	 * @return
	 */
	double getWaterLevel();
	
	/**
	 * Set water level
	 * 
	 * @param waterLevel
	 */
	void setWaterLevel(double waterLevel);
	
	/**
	 * Is the catchment full
	 * 
	 * @return
	 */
	boolean isFull();
	
	/**
	 * Get catchment polygons
	 * 
	 * @return
	 */
	MultiPolygon getCatchmentRegion();
}
