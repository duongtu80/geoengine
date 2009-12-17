package cn.geodata.models.wetland.multiple;

import java.util.List;

import com.vividsolutions.jts.geom.MultiPolygon;

/**
 * Water table abstract class
 * 
 * @author tank
 *
 */
public interface WaterTable {
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
	 * Get catchment polygons
	 * 
	 * @return
	 */
	MultiPolygon getCatchmentRegion();
}
