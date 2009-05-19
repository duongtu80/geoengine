package cn.geodata.models.wetland;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Logger;

import org.geotools.geometry.Envelope2D;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Envelope;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.MultiPolygon;
import com.vividsolutions.jts.geom.Polygon;

public class WaterRegionCalc {
	private static Logger log = Logger.getAnonymousLogger();
	
	private DemRaster raster;
//	private Catchment catchment;
	private double waterLevel;
	private MultiPolygon waterRegion;
	private MultiPolygon catchment;
	private GeometryFactory factory;
	
	public MultiPolygon getCatchment() {
		return catchment;
	}

	public void setCatchment(MultiPolygon catchment) {
		this.catchment = catchment;
	}

	public WaterRegionCalc(){
		this.factory = new GeometryFactory();
	}
	
	public DemRaster getRaster() {
		return raster;
	}
	public void setReader(DemRaster raster) {
		this.raster = raster;
	}
	public double getWaterLevel() {
		return waterLevel;
	}
	public void setWaterLevel(double waterLevel) {
		this.waterLevel = waterLevel;
	}
	
	public MultiPolygon calculate() throws NumberFormatException, Exception{
//		MultiPolygon _polygon = this.catchment.findCatchmentByTag(this.wetlandTag);
//		
		if(this.waterLevel <= 0){
			return null;
		}
		
		Envelope2D _env = this.raster.getRaster().getEnvelope();
		
		Extent _extent = new Extent();
		_extent.setMinX(0);
		_extent.setMinY(0);
		_extent.setMaxX(this.raster.getRaster().getColCount());
		_extent.setMaxY(this.raster.getRaster().getRowCount());
		
		Envelope _env2 = this.catchment.getEnvelopeInternal();
//		log.info("ENV:" + _env2.toString());
		
		if(_env.getMinX() < _env2.getMinX()){
			_extent.setMinX((int) Math.floor((_env2.getMinX() - _env.getMinX()) / this.raster.getRaster().getCellSize()));
		}
		if(_env.getMaxX() > _env2.getMaxX()){
			_extent.setMaxX((int) Math.ceil((_env2.getMaxX() - _env.getMinX()) / this.raster.getRaster().getCellSize()));
		}
		if(_env.getMaxY() > _env2.getMaxY()){
			_extent.setMinY((int) Math.floor((_env.getMaxY() - _env2.getMaxY())/ this.raster.getRaster().getCellSize()));
		}
		if(_env.getMinY() < _env2.getMinY()){
			_extent.setMaxY((int) Math.floor((_env.getMaxY() - _env2.getMinY()) / this.raster.getRaster().getCellSize()));
		}
		log.info("Extent:" + _extent.toString());
		
		WetlandDemPixel[] _range = this.getPixelRange(this.catchment, _extent);
		log.info("Range:" + _range[0].toString() + " - " + _range[1].toString());
		
		if(_range[0].getVal() + this.waterLevel >= _range[1].getVal()){
			log.warning("Over float");
			this.waterRegion = this.catchment;
		}
		else{
			this.waterRegion = this.generateBoundary(this.catchment, _extent, _range[0].getVal() + this.waterLevel);
		}
		
		return waterRegion;
	}

	public MultiPolygon calculate2() throws NumberFormatException, Exception{
//		MultiPolygon _polygon = this.catchment.findCatchmentByTag(this.wetlandTag);
//		
		if(this.waterLevel <= 0){
			return null;
		}
		
		Envelope2D _env = this.raster.getRaster().getEnvelope();
		
		Extent _extent = new Extent();
		_extent.setMinX(0);
		_extent.setMinY(0);
		_extent.setMaxX(this.raster.getRaster().getColCount());
		_extent.setMaxY(this.raster.getRaster().getRowCount());
		
		Envelope _env2 = this.catchment.getEnvelopeInternal();
		log.info("ENV:" + _env2.toString());
		
		if(_env.getMinX() < _env2.getMinX()){
			_extent.setMinX((int) Math.floor((_env2.getMinX() - _env.getMinX()) / this.raster.getRaster().getCellSize()));
		}
		if(_env.getMaxX() > _env2.getMaxX()){
			_extent.setMaxX((int) Math.ceil((_env2.getMaxX() - _env.getMinX()) / this.raster.getRaster().getCellSize()));
		}
		if(_env.getMaxY() > _env2.getMaxY()){
			_extent.setMinY((int) Math.floor((_env.getMaxY() - _env2.getMaxY())/ this.raster.getRaster().getCellSize()));
		}
		if(_env.getMinY() < _env2.getMinY()){
			_extent.setMaxY((int) Math.floor((_env.getMaxY() - _env2.getMinY()) / this.raster.getRaster().getCellSize()));
		}
		
		WetlandDemPixel[] _range = this.getPixelRange(this.catchment, _extent);
//		log.info("Range:" + _range[0].toString() + " - " + _range[1].toString());
		
		if(this.waterLevel >= _range[1].getVal()){
			log.warning("Over float");
			this.waterRegion = this.catchment;
		}
		else{
			this.waterRegion = this.generateBoundary(this.catchment, _extent, this.waterLevel);
		}
		
		return waterRegion;
	}

	private WetlandDemPixel[] getPixelRange(MultiPolygon polygon, Extent extent) throws IOException{
		WetlandDemPixel _min = null;
		WetlandDemPixel _max = null;
		
		double _y = this.raster.getRaster().getEnvelope().getMaxY() - this.raster.getRaster().getCellSize() * extent.getMinY() - this.raster.getRaster().getCellSize() / 2;
		for(int _row = extent.getMinY();_row <= extent.getMaxY();_row++){
			double _x = this.raster.getRaster().getEnvelope().getMinX() + this.raster.getRaster().getCellSize() * extent.getMinX() + this.raster.getRaster().getCellSize() / 2;
			for(int _col=extent.getMinX(); _col <= extent.getMaxX(); _col++){
				double _distance = polygon.distance(factory.createPoint(new Coordinate(_x, _y)));
				if(_distance <= 0){
					float _val = this.raster.getRaster().readFloat(_row, _col);
					
					if(_min == null || _min.getVal() > _val){
						_min = new WetlandDemPixel(_row, _col, _val, _x, _y, false);
					}
					if(_max == null || _max.getVal() < _val){
						_max = new WetlandDemPixel(_row, _col, _val, _x, _y, false);
					}
				}
				_x += this.raster.getRaster().getCellSize();
			}
			
			_y -= this.raster.getRaster().getCellSize();
		}
		
		return new WetlandDemPixel[]{_min, _max};
	}

	private MultiPolygon generateBoundary(MultiPolygon polygon, Extent extent, double evl) throws IOException{
		ArrayList<WetlandDemPixel> _list = new ArrayList<WetlandDemPixel>();
		
		double _y = this.raster.getRaster().getEnvelope().getMaxY() - this.raster.getRaster().getCellSize() * extent.getMinY() - this.raster.getRaster().getCellSize() / 2;
		for(int _row = extent.getMinY();_row <= extent.getMaxY();_row++){
			double _x = this.raster.getRaster().getEnvelope().getMinX() + this.raster.getRaster().getCellSize() * extent.getMinX() + this.raster.getRaster().getCellSize() / 2;
			for(int _col=extent.getMinX(); _col <= extent.getMaxX(); _col++){
				double _distance = polygon.distance(factory.createPoint(new Coordinate(_x, _y)));
				if(_distance <= 0){
					float _val = this.raster.getRaster().readFloat(_row, _col);
					if(_val >= evl && isBoundary(_col, _row, polygon, _val, evl)){
						_list.add(new WetlandDemPixel(_row, _col, _val, _x, _y, true));
					}
					
				}
				_x += this.raster.getRaster().getCellSize();
			}
			
			_y -= this.raster.getRaster().getCellSize();
		}
		
//		orginzieBoundary(_list);
		
		ArrayList<Polygon> _polygons = new ArrayList<Polygon>();
		while(_list.size() > 0){
			ArrayList<Coordinate> _coordinates = new ArrayList<Coordinate>();
			ArrayList<WetlandDemPixel> _line = new ArrayList<WetlandDemPixel>();
			
			
			ArrayList<WetlandDemPixel> _n = null;
			int _pos = 0;
			for(;_pos<_list.size();_pos++){
				_n = findNeighborPixels(_list, _list.get(_pos));
				if(_n.size() == 2){
					int _angle = this.angleDifferent(this.computeAngle(_list.get(_pos), _n.get(0)), this.computeAngle(_list.get(_pos), _n.get(1)));
					 if(_angle == 180){
						 break;
					 }
				}
			}
			
			if(_pos == _list.size()){
				break;
			}
			
			WetlandDemPixel _startPt = _list.get(_pos);
			
			_list.set(_pos, null);
			_line.add(_startPt);
			_line.add(_n.get(0));
			
			_list.set(_list.indexOf(_n.get(0)), null);
			if(this.createPointArray(_line, _list, _startPt, _n.get(0), _n.get(1))){
				if(_line.size() > 2){
					
					for(int j=0;j<_line.size();j++){
						_coordinates.add(new Coordinate(_line.get(j).getLon(), _line.get(j).getLat()));
					}
					_coordinates.add(new Coordinate(_line.get(0).getLon(), _line.get(0).getLat()));
					_polygons.add(factory.createPolygon(factory.createLinearRing(_coordinates.toArray(new Coordinate[0])), null));
				}
			}
			else{
				log.warning("Failed to create polygon");
			}
			
			for(int i=_list.size() - 1;i>=0;i--){
				if(_list.get(i) == null){
					_list.remove(i);
				}
			}
			log.info("Point count left:" + _list.size());
		}
		
		if(_polygons.size() > 0){
			return factory.createMultiPolygon(_polygons.toArray(new Polygon[0]));
		}
		else{
			log.warning("No polygon has been generated.");
			return null;
		}
	}
	
	private boolean createPointArray(ArrayList<WetlandDemPixel> line, ArrayList<WetlandDemPixel> list, WetlandDemPixel previous, WetlandDemPixel pixel, WetlandDemPixel endPt){
		WetlandDemPixel[] _list = this.popNeighborPixels(list, pixel, this.computeAngle(previous, pixel));
		for(int i=0;i<_list.length;i++){
			WetlandDemPixel _temp = null;
			if(_list[i].getAngle() == line.get(line.size() - 1).getAngle()){
				_temp = line.get(line.size() - 1);
				line.remove(line.size() - 1);
			}
			
			line.add(_list[i]);

			if(_list[i].equals(endPt)){
				return true;
			}
			
			if(this.createPointArray(line, list, pixel, _list[i], endPt)){
				return true;
			}
			else{
				line.remove(_list[i]);
				if(_temp != null){
					line.add(_temp);
				}
			}
		}
		
		return false;
	}
	
	private int computeAngle(WetlandDemPixel p1, WetlandDemPixel p2){
		if(p1 == null || p2 == null){
			return 0;
		}
		
		int _x = p2.getCol() - p1.getCol();
		int _y = p2.getRow() - p1.getRow();
		
		if(_x == 1 && _y == 0){
			return 0;
		}
		if(_x == 1 && _y == 1){
			return 45;
		}
		if(_x == 0 && _y == 1){
			return 90;
		}
		if(_x == -1 && _y == 1){
			return 135;
		}
		if(_x == -1 && _y == 0){
			return 180;
		}
		if(_x == -1 && _y == -1){
			return 225;
		}
		if(_x == 0 && _y == -1){
			return 270;
		}
		if(_x == 1 && _y == -1){
			return 315;
		}
		
		log.warning("Unkown angle:" + _x + "," + _y);
		return 0;
	}
	
	private int angleDifferent(int angle1, int angle2){
		if(angle1 == -1 || angle2 == -1){
			return 0;
		}
		
		int _diff = Math.abs(angle1 - angle2);
		if(_diff > 180){
			return 360 - _diff;
		}
		else{
			return _diff;
		}
	}
		
//	private void orginzieBoundary(ArrayList<WetlandDemPixel> list){
//		while(this.removeSingePoint(list) > 0){
//			log.info("Remove single point");
//		}
//	}
	
//	private int removeSingePoint(ArrayList<WetlandDemPixel> list){
//		int _count = 0;
//		for(WetlandDemPixel _p : list){
//			ArrayList<WetlandDemPixel> _list = findNeighborPixels(list, _p);
////			log.info("Point " + _list.size());
//			if(_list.size() < 2){
//				list.set(list.indexOf(_p), null);
//				_count ++;
//			}
//		}
//		
//		return _count;
//	}
	
	private ArrayList<WetlandDemPixel> findNeighborPixels(ArrayList<WetlandDemPixel> list, WetlandDemPixel p){
		ArrayList<WetlandDemPixel> _list = new ArrayList<WetlandDemPixel>();
		for(WetlandDemPixel _p : list){
			if(_p != null && _p.equals(p) == false){
				int _x = Math.abs(p.getRow() - _p.getRow());
				int _y = Math.abs(p.getCol() - _p.getCol());
				
				if(Math.hypot(_x, _y) < 1.5){
					_list.add(_p);
				}
			}
		}
		
		return _list;
	}

	private WetlandDemPixel[] popNeighborPixels(ArrayList<WetlandDemPixel> list, WetlandDemPixel p, int angle){
		ArrayList<WetlandDemPixel> _list = new ArrayList<WetlandDemPixel>();
		for(WetlandDemPixel _p : list){
			if(_p != null && _p.equals(p) == false){
				int _x = Math.abs(p.getRow() - _p.getRow());
				int _y = Math.abs(p.getCol() - _p.getCol());
				
				if(Math.hypot(_x, _y) < 1.5){
					_p.setAngle(this.computeAngle(p, _p));
					_p.setRank(this.angleDifferent(angle, _p.getAngle()));
					
					_list.add(_p);
					list.set(list.indexOf(_p), null);
				}
			}
		}
		
		WetlandDemPixel[] _array = _list.toArray(new WetlandDemPixel[0]);
		Arrays.sort(_array);
		
		return _array;
	}

	private WetlandDemPixel popWetlandPixel(ArrayList<WetlandDemPixel> list, int index){
		WetlandDemPixel _p = list.get(index);
		list.remove(_p);
		
		return _p;
	}

	private WetlandDemPixel popNeighborPixel(ArrayList<WetlandDemPixel> list, WetlandDemPixel p){
		for(int i=0;i < list.size();i++){
			if(Math.abs(list.get(i).getRow() - p.getRow()) == 1 || Math.abs(list.get(i).getCol() - p.getCol()) == 1){
				return popWetlandPixel(list, i);
			}
		}
		
		return null;
	}

	private boolean isBoundary(int col, int row, MultiPolygon polygon, double val, double evl) throws IOException{
		for(int _row = row - 1;_row <= row + 1;_row++){
			for(int _col = col - 1; _col <= col + 1; _col++){
				if(_row >= 0 && _row < this.raster.getRaster().getRowCount() && _col >= 0 && _col < this.raster.getRaster().getColCount()){
					if(_row != row || _col != col){
						float _val = this.raster.getRaster().readFloat(_row, _col);
	
						if(_val < evl){
							return true;
						}

//						double _distance = polygon.distance(factory.createPoint(this.raster.getRaster().getLocation(_row, _col)));
//						if(_distance > 0){
//							return true;
//						}
					}
				}
				else{
					return true;
				}
			}
		}
		
		return false;
	}	
}
