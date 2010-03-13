package cn.geodata.models.wetland.multiple;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class WaterUnion extends BasicWaterTable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5727224071082267102L;

	private Logger log = Logger.getAnonymousLogger();
	private List<WaterTable> waterTables;

	public WaterUnion(List<WaterTable> waterTables, SpillPoint spillPoint) throws IOException{
		this(createZone(waterTables), spillPoint, waterTables, createCatchments(waterTables));
	}

	public WaterUnion(ElevationZone zones, SpillPoint spillPoint, List<WaterTable> waterTables, List<Catchment> catchments) throws IOException{
		super(zones, spillPoint, catchments);
		this.waterTables = waterTables;

		averageWaterLevel();
	}
	
	private static List<Catchment> createCatchments(List<WaterTable> waterTables){
		List<Catchment> _list = new ArrayList<Catchment>();
		
		for(WaterTable _w : waterTables){
			if (_w instanceof WaterUnion) {
				WaterUnion _union = (WaterUnion) _w;
				_list.addAll(_union.getCatchments());
			}
			else{
				WetlandWater _water = (WetlandWater) _w;
				_list.addAll(_water.getCatchments());
			}
		}

		return _list;
	}
	
	private static ElevationZone createZone(List<WaterTable> waterTables) throws IOException{
		ElevationZone _zones = null;
		for(WaterTable _table : waterTables){
			if(_zones == null)
				_zones = _table.getZones();
			else
				_zones = ElevationZone.merge(_zones, _table.getZones());
		}
		
		return _zones;
	}
	
	private void averageWaterLevel(){
		double _vol = 0;
		for(WaterTable _w: this.waterTables){
			_vol += _w.getWaterVolume();
		}
		
		this.waterLevel = this.zones.calculateWaterTable(_vol);
		
		for(WaterTable _w: this.waterTables){
			_w.setWaterLevel(this.waterLevel);
		}
	}
}
