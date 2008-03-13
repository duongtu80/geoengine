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

public class WaterRegionModel {
	private static Logger log = Logger.getAnonymousLogger();
	
	private EnviRasterReader reader;
//	private Catchment catchment;
	private float waterLevel;
	private MultiPolygon waterRegion;
	private MultiPolygon catchment;
	private GeometryFactory factory;
	
	public MultiPolygon getCatchment() {
		return catchment;
	}

	public void setCatchment(MultiPolygon catchment) {
		this.catchment = catchment;
	}

	public WaterRegionModel(){
		this.factory = new GeometryFactory();
	}
	
	public EnviRasterReader getReader() {
		return reader;
	}
	public void setReader(EnviRasterReader reader) {
		this.reader = reader;
	}
	public float getWaterLevel() {
		return waterLevel;
	}
	public void setWaterLevel(float waterLevel) {
		this.waterLevel = waterLevel;
	}
	
	public MultiPolygon calculate() throws NumberFormatException, Exception{
//		MultiPolygon _polygon = this.catchment.findCatchmentByTag(this.wetlandTag);
//		
		if(this.waterLevel <= 0){
			return null;
		}
		
		Envelope2D _env = this.getReader().getEnvelope();
		
		Extent _extent = new Extent();
		_extent.setMinX(0);
		_extent.setMinY(0);
		_extent.setMaxX(this.reader.getColCount());
		_extent.setMaxY(this.reader.getRowCount());
		
		Envelope _env2 = this.catchment.getEnvelopeInternal();
		log.info("ENV:" + _env2.toString());
		
		if(_env.getMinX() < _env2.getMinX()){
			_extent.setMinX((int) Math.floor((_env2.getMinX() - _env.getMinX()) / this.getReader().getCellSize()));
		}
		if(_env.getMaxX() > _env2.getMaxX()){
			_extent.setMaxX((int) Math.ceil((_env2.getMaxX() - _env.getMinX()) / this.getReader().getCellSize()));
		}
		if(_env.getMaxY() > _env2.getMaxY()){
			_extent.setMinY((int) Math.floor((_env.getMaxY() - _env2.getMaxY())/ this.getReader().getCellSize()));
		}
		if(_env.getMinY() < _env2.getMinY()){
			_extent.setMaxY((int) Math.floor((_env.getMaxY() - _env2.getMinY()) / this.getReader().getCellSize()));
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
	
	private WetlandDemPixel[] getPixelRange(MultiPolygon polygon, Extent extent) throws IOException{
		WetlandDemPixel _min = null;
		WetlandDemPixel _max = null;
		
//		FileOutputStream _stream = new FileOutputStream(new File("d:/temp/ttt1.txt"));
//		_stream.write(("X,Y,V\n").getBytes());
		double _y = this.reader.getEnvelope().getMaxY() - this.getReader().getCellSize() * extent.getMinY() - this.getReader().getCellSize() / 2;
		for(int _row = extent.getMinY();_row <= extent.getMaxY();_row++){
			double _x = this.reader.getEnvelope().getMinX() + this.getReader().getCellSize() * extent.getMinX() + this.getReader().getCellSize() / 2;
			for(int _col=extent.getMinX(); _col <= extent.getMaxX(); _col++){
				double _distance = polygon.distance(factory.createPoint(new Coordinate(_x, _y)));
				if(_distance <= 0){
					float _val = this.reader.readFloat(_row, _col);
//					log.info("Loc:" + _col + "," + _row + "," + _val);
//					log.info("Found pt");
					
					if(_min == null || _min.getVal() > _val){
						_min = new WetlandDemPixel(_row, _col, _val, _x, _y, false);
					}
					if(_max == null || _max.getVal() < _val){
						_max = new WetlandDemPixel(_row, _col, _val, _x, _y, false);
					}
					
//					_stream.write((_x + "," + _y + "," + _val + "\n").getBytes());
				}
				_x += this.getReader().getCellSize();
			}
			
			_y -= this.getReader().getCellSize();
		}
//		_stream.close();
		
		return new WetlandDemPixel[]{_min, _max};
	}

	private MultiPolygon generateBoundary(MultiPolygon polygon, Extent extent, float evl) throws IOException{
		ArrayList<WetlandDemPixel> _list = new ArrayList<WetlandDemPixel>();
		
		double _y = this.reader.getEnvelope().getMaxY() - this.getReader().getCellSize() * extent.getMinY() - this.getReader().getCellSize() / 2;
		for(int _row = extent.getMinY();_row <= extent.getMaxY();_row++){
			double _x = this.reader.getEnvelope().getMinX() + this.getReader().getCellSize() * extent.getMinX() + this.getReader().getCellSize() / 2;
			for(int _col=extent.getMinX(); _col <= extent.getMaxX(); _col++){
				double _distance = polygon.distance(factory.createPoint(new Coordinate(_x, _y)));
				if(_distance <= 0){
					float _val = this.getReader().readFloat(_row, _col);
//					if(_val <= evl){
//						log.info("test:" + _val);
//					}
					if(_val <= evl && isBoundary(_col, _row, polygon, _val, evl)){
						_list.add(new WetlandDemPixel(_row, _col, _val, _x, _y, true));
					}
					
				}
				_x += this.getReader().getCellSize();
			}
			
			_y -= this.getReader().getCellSize();
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
//			WetlandDemPixel[] _ns = popNeighborPixels(_list, _startPt, -1);
			if(this.createPointArray(_line, _list, _startPt, _n.get(0), _n.get(1))){
				if(_line.size() > 2){
					FileOutputStream _stream = new FileOutputStream(new File("d:/temp/ttt3.txt"));
					_stream.write(("X,Y,V\n").getBytes());
					
					for(int i=0;i<_line.size();i++){
						_stream.write((_line.get(i).getLon() + "," + _line.get(i).getLat() + "," + _line.get(i).getVal() + "\n").getBytes());
					}
					_stream.close();
					
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
//			WetlandDemPixel _p = this.popNeighborPixel(_list, _line.get(_line.size() - 1));
//			while(_p != null){
//				_line.add(_p);
//				
//				_p = this.popNeighborPixel(_list, _line.get(_line.size() - 1));
//			}
//			
		}
		
		if(_polygons.size() > 0){
			return factory.createMultiPolygon(_polygons.toArray(new Polygon[0]));
		}
		else{
			log.warning("No polygon has been generated.");
			throw new NullPointerException("Failed to create water region");
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

	private boolean isBoundary(int col, int row, MultiPolygon polygon, float val, float evl) throws IOException{
		for(int _row = row - 1;_row <= row + 1;_row++){
			for(int _col = col - 1; _col <= col + 1; _col++){
				if(_row >= 0 && _row < this.reader.getRowCount() && _col >= 0 && _col < this.reader.getColCount()){
					if(_row != row || _col != col){
						float _val = this.reader.readFloat(_row, _col);
	
						if(_val > evl){
							return true;
						}

						double _distance = polygon.distance(factory.createPoint(this.reader.getLocation(_row, _col)));
						if(_distance > 0){
							return true;
						}
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
