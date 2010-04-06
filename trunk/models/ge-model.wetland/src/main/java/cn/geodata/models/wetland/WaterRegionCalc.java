package cn.geodata.models.wetland;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.geotools.data.shapefile.shp.JTSUtilities;
import org.geotools.factory.GeoTools;
import org.geotools.geometry.Envelope2D;
import org.geotools.geometry.jts.JTS;
import org.geotools.graph.util.geom.GeometryUtil;

import cn.geodata.models.raster.GeoRaster;

import com.google.common.collect.Lists;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Envelope;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.LineString;
import com.vividsolutions.jts.geom.LinearRing;
import com.vividsolutions.jts.geom.MultiPolygon;
import com.vividsolutions.jts.geom.Polygon;

public class WaterRegionCalc {
	private static Logger log = Logger.getAnonymousLogger();
	
	private GeoRaster raster;
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
	
	public GeoRaster getRaster() {
		return raster;
	}
	public void setReader(GeoRaster raster) {
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
		
		Envelope2D _env = this.raster.getEnvelope();
		
		Extent _extent = new Extent();
		_extent.setMinX(0);
		_extent.setMinY(0);
		_extent.setMaxX(this.raster.getColNum());
		_extent.setMaxY(this.raster.getRowNum());
		
		Envelope _env2 = this.catchment.getEnvelopeInternal();
//		log.info("ENV:" + _env2.toString());
		
		if(_env.getMinX() < _env2.getMinX()){
			_extent.setMinX((int) Math.floor((_env2.getMinX() - _env.getMinX()) / this.raster.getCellSizeX()));
		}
		if(_env.getMaxX() > _env2.getMaxX()){
			_extent.setMaxX((int) Math.ceil((_env2.getMaxX() - _env.getMinX()) / this.raster.getCellSizeX()));
		}
		if(_env.getMaxY() > _env2.getMaxY()){
			_extent.setMinY((int) Math.floor((_env.getMaxY() - _env2.getMaxY())/ this.raster.getCellSizeY()));
		}
		if(_env.getMinY() < _env2.getMinY()){
			_extent.setMaxY((int) Math.floor((_env.getMaxY() - _env2.getMinY()) / this.raster.getCellSizeY()));
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
		
		Envelope2D _env = this.raster.getEnvelope();
		
		Extent _extent = new Extent();
		_extent.setMinX(0);
		_extent.setMinY(0);
		_extent.setMaxX(this.raster.getColNum());
		_extent.setMaxY(this.raster.getRowNum());
		
		Envelope _env2 = this.catchment.getEnvelopeInternal();
		log.info("ENV:" + _env2.toString());
		
		if(_env.getMinX() < _env2.getMinX()){
			_extent.setMinX((int) Math.floor((_env2.getMinX() - _env.getMinX()) / this.raster.getCellSizeX()));
		}
		if(_env.getMaxX() > _env2.getMaxX()){
			_extent.setMaxX((int) Math.ceil((_env2.getMaxX() - _env.getMinX()) / this.raster.getCellSizeX()));
		}
		if(_env.getMaxY() > _env2.getMaxY()){
			_extent.setMinY((int) Math.floor((_env.getMaxY() - _env2.getMaxY())/ this.raster.getCellSizeY()));
		}
		if(_env.getMinY() < _env2.getMinY()){
			_extent.setMaxY((int) Math.floor((_env.getMaxY() - _env2.getMinY()) / this.raster.getCellSizeY()));
		}
		
//		WetlandDemPixel[] _range = this.getPixelRange(this.catchment, _extent);
////		log.info("Range:" + _range[0].toString() + " - " + _range[1].toString());
//		
//		if(this.waterLevel < _range[0].getVal()){
//			return null;
//		}
//		
//		if(this.waterLevel >= _range[1].getVal()){
//			log.warning("Over float");
//			this.waterRegion = this.catchment;
//		}
//		else{
//			this.waterRegion = this.generateBoundary(this.catchment, _extent, this.waterLevel);
//		}
//		this.waterRegion = this.generateBoundary(this.catchment, _extent, this.waterLevel);
		this.waterRegion = this.generateSurface(this.catchment, _extent, this.waterLevel);
		
		return waterRegion;
	}
	
	/**
	 * Generate water surface by merging water polygons
	 * 
	 * @param polygon
	 * @param extent
	 * @param evl
	 * @return
	 * @throws IOException
	 */
	private MultiPolygon generateSurface(MultiPolygon polygon, Extent extent, double evl) throws IOException{
		List<Polygon> _polys = new ArrayList<Polygon>();
		
		double _pixelx2 = this.raster.getCellSizeX() / 2;
		double _pixely2 = this.raster.getCellSizeY() / 2;

		double _pixelx3 = _pixelx2 * 1.05;
		double _pixely3 = _pixely2 * 1.05;
		
		double _startX = this.raster.getEnvelope().getMinX() + this.raster.getCellSizeX() * extent.getMinX() + _pixelx2;
		double _startY = this.raster.getEnvelope().getMaxY() - this.raster.getCellSizeY() * extent.getMinY() - _pixely2;
		
		double _dis = Math.hypot(this.raster.getCellSizeX(), this.raster.getCellSizeX()) / 2;
		double _y = _startY;
		for(int _row = extent.getMinY();_row <= extent.getMaxY();_row++){
			double _x = _startX;
			int _col1 = 0;
			boolean _skip = true;
			
			for(int _col=extent.getMinX(); _col <= extent.getMaxX(); _col++){
				double _distance = polygon.distance(factory.createPoint(new Coordinate(_x, _y)));
				_skip = true;
				
				if(_distance <= _dis){
					Number _v = this.raster.getCell(_col, _row);
					if(_v != null){
						float _val = _v.floatValue();
						
						if(_val <= evl) {
							_col1++;
							
							_skip = false;
						}
					}
				}
				
				if(_skip && _col1 > 0){
					double _xx = _x - this.raster.getCellSizeX();
					this.createPolygon(_polys, _x - _col1 * this.raster.getCellSizeX() - _pixelx3, _xx + _pixelx3, _y - _pixely3, _y + _pixely3);

					_col1 = 0;
				}
				
				_x += this.raster.getCellSizeX();
			}

			if(_skip && _col1 > 0){
				double _xx = _x - this.raster.getCellSizeX();
				this.createPolygon(_polys, _xx - _col1 * this.raster.getCellSizeX() - _pixelx3, _xx + _pixelx3, _y - _pixely3, _y + _pixely3);

				_col1 = 0;
			}

			_y -= this.raster.getCellSizeY();
		}
		
		if(_polys.size() == 0){
			log.warning("No polygon be found");
			return null;
		}
		
		this.mergePolygons(_polys);
//		_polys.add(_polys.get(0));

//		System.out.println("Polygon numbers:" + _polys.size() + "," + _polys.get(0).getArea());
		return this.factory.createMultiPolygon(_polys.toArray(new Polygon[0]));
	}

	private void createPolygon(List<Polygon> polys, double startX, double endX, double startY, double endY){
		Polygon _p = JTS.toGeometry(new Envelope(startX, endX, startY, endY));
		
		int _pos = 0;
		for(;_pos<polys.size();_pos++){
			Polygon _pp = polys.get(_pos);
			if(_pp.distance(_p) == 0){
				polys.set(_pos, (Polygon) _pp.union(_p));
				break;
			}
		}

		if(_pos == polys.size()){
			polys.add(_p);
		}
	}
	
	private void mergePolygons(List<Polygon> polys){
		List<Polygon> _ppp = Lists.newArrayList();
		for(int i =0;i < polys.size();i++){
			Polygon _p = polys.get(i);
			if(_p == null)
				continue;
			
			polys.set(i, null);
			for(int j = 0;j< polys.size();j++){
				if(i != j && polys.get(j) != null && polys.get(j).intersects(_p)){
					_p = (Polygon) _p.union(polys.get(j));
					polys.set(j, null);
				}
			}
			
			_ppp.add(_p);
		}
		
		if(polys.size() > _ppp.size()){
			polys.clear();
			polys.addAll(_ppp);

			this.mergePolygons(polys);
		}
		else{
			polys.clear();
			
			for(int i=0;i<_ppp.size();i++){
				Polygon _p = _ppp.get(i);
				
//				LinearRing _ex_line = _p.getFactory().createLinearRing(_p.getExteriorRing().getCoordinates());
				LinearRing _ex_line = _p.getFactory().createLinearRing(this.smoothCoordinates(_p.getExteriorRing().getCoordinates()));
				if(_ex_line.getLength() <= (this.raster.getCellSizeX() + this.raster.getCellSizeY()) * 2 * 6){
					continue;
				}
				
				List<LinearRing> _in_lines = Lists.newArrayList();
				for(int j=0;j<_p.getNumInteriorRing();j++){
					LineString _in_line = _p.getInteriorRingN(j);
					if(_in_line.getLength() > (this.raster.getCellSizeX() + this.raster.getCellSizeY()) * 2 * 6){
						_in_lines.add(_p.getFactory().createLinearRing(smoothCoordinates(_in_line.getCoordinates())));
//						_in_lines.add(_p.getFactory().createLinearRing(_in_line.getCoordinates()));
					}
				}
				
				polys.add(_p.getFactory().createPolygon(_ex_line, _in_lines.toArray(new LinearRing[0])));
			}
		}
	}
	
	private Coordinate[] smoothCoordinates(Coordinate[] cs){
		List<Coordinate> _css = new ArrayList<Coordinate>();
		
		double _dir = Double.NaN;
		for(int i=0;i<cs.length - 1;i++){
			Coordinate _cur = new Coordinate((cs[i].x + cs[i + 1].x) / 2, (cs[i].y + cs[i + 1].y) / 2);
			
			if(!Double.isNaN(_dir)){
				double _d = this.direction(_css.get(_css.size() - 1), _cur);
				if(Math.abs(_d - _dir) > Math.toRadians(2)){
					_css.add(_cur);
					_dir = _d;
				}
			}
			else{
				if(_css.size() > 0){
					_dir = this.direction(_css.get(_css.size() - 1), _cur);
				}
				
				_css.add(_cur);
			}
		}
		if(_css.size() > 0)
			_css.add(_css.get(0));
		
		return (Coordinate[])_css.toArray(new Coordinate[0]);
	}
	
	private WetlandDemPixel[] getPixelRange(MultiPolygon polygon, Extent extent) throws IOException{
		WetlandDemPixel _min = null;
		WetlandDemPixel _max = null;
		
		double _y = this.raster.getEnvelope().getMaxY() - this.raster.getCellSizeY() * extent.getMinY() - this.raster.getCellSizeY() / 2;
		for(int _row = extent.getMinY();_row <= extent.getMaxY();_row++){
			double _x = this.raster.getEnvelope().getMinX() + this.raster.getCellSizeX() * extent.getMinX() + this.raster.getCellSizeX() / 2;
			for(int _col=extent.getMinX(); _col <= extent.getMaxX(); _col++){
				double _distance = polygon.distance(factory.createPoint(new Coordinate(_x, _y)));
				if(_distance <= 0){
					float _val = this.raster.getCell(_col, _row).floatValue();
					
					if(_min == null || _min.getVal() > _val){
						_min = new WetlandDemPixel(_row, _col, _val, _x, _y, false);
					}
					if(_max == null || _max.getVal() < _val){
						_max = new WetlandDemPixel(_row, _col, _val, _x, _y, false);
					}
				}
				_x += this.raster.getCellSizeX();
			}
			
			_y -= this.raster.getCellSizeY();
		}
		
		return new WetlandDemPixel[]{_min, _max};
	}

	private MultiPolygon generateBoundary(MultiPolygon polygon, Extent extent, double evl) throws IOException{
		ArrayList<WetlandDemPixel> _list = new ArrayList<WetlandDemPixel>();
		
		double _dis = this.raster.getCellSizeX() * 3;
		double _y = this.raster.getEnvelope().getMaxY() - this.raster.getCellSizeY() * extent.getMinY() - this.raster.getCellSizeY() / 2;
		for(int _row = extent.getMinY();_row <= extent.getMaxY();_row++){
			double _x = this.raster.getEnvelope().getMinX() + this.raster.getCellSizeX() * extent.getMinX() + this.raster.getCellSizeX() / 2;
			for(int _col=extent.getMinX(); _col <= extent.getMaxX(); _col++){
				double _distance = polygon.distance(factory.createPoint(new Coordinate(_x, _y)));
				if(_distance <= _dis){
					Number _v = this.raster.getCell(_col, _row);
					if(_v != null){
						float _val = _v.floatValue();
						
						if(_val <= evl && (_distance > 0 || isBoundary(_col, _row, polygon, _val, evl, _distance))) {
							_list.add(new WetlandDemPixel(_row, _col, _val, _x, _y, true));
						}
					}
					
				}
				_x += this.raster.getCellSizeX();
			}
			
			_y -= this.raster.getCellSizeY();
		}
		
		if(_list.size() == 0){
			log.warning("No border pixel be found");
			return null;
		}
		
		List<String> _ll = new ArrayList<String>();
		_ll.add("lon,lat,deep");
		
		for(WetlandDemPixel _w : _list){
			_ll.add(_w.getLon() + "," + _w.getLat() + "," + _w.getVal());
		}
		
		FileUtils.writeLines(new File("p:\\temp\\storage\\p2.csv"), _ll);
		
//		orginzieBoundary(_list);
		
		ArrayList<Polygon> _polygons = new ArrayList<Polygon>();
		while(_list.size() > 0){
			ArrayList<Coordinate> _coordinates = new ArrayList<Coordinate>();
			ArrayList<WetlandDemPixel> _line = new ArrayList<WetlandDemPixel>();
			
			int _pos = 0;
			ArrayList<WetlandDemPixel> _n = null;
			for(;_pos<_list.size();_pos++){
				_n = findNeighborPixels(_list, _list.get(_pos));
				if(_n.size() == 2){
					break;
//					int _angle = this.angleDifferent(this.computeAngle(_list.get(_pos), _n.get(0)), this.computeAngle(_list.get(_pos), _n.get(1)));
//					 if(_angle == 180){
//					 }
				}
			}
			
			if(_pos == _list.size()){
				break;
			}
			
			WetlandDemPixel _startPt = _list.get(_pos);
			
			_line.add(_startPt);
			_line.add(_n.get(0));

			_list.set(_pos, null);
			_list.set(_list.indexOf(_n.get(0)), null);
			
			if(this.createPointArray(_line, _list, _startPt, _n.get(0), _n.get(1))){
				if(_line.size() > 5){
					
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
	
	public double direction(Coordinate p1, Coordinate p2){
		double _x = p2.x - p1.x;
		double _y = p2.y - p1.y;
		
		if(_x == 0){
			if(_y == 0){
				return 0;
			}
			else if(_y > 0)
				return Math.PI / 2;
			else{
				return Math.PI / 2 + Math.PI;
			}
		}
		
		double _d = Math.atan(_y / _x);
		if(_x > 0){
			if(_y >= 0)
				return _d;
			else
				return Math.PI * 2 + _d;
		}
		else{
			return Math.PI + _d;
		}
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

	private boolean isBoundary(int col, int row, MultiPolygon polygon, double val, double evl, double distance) throws IOException{
		for(int _row = row - 1;_row <= row + 1;_row++){
			for(int _col = col - 1; _col <= col + 1; _col++){
				if(_row >= 0 && _row < this.raster.getRowNum() && _col >= 0 && _col < this.raster.getColNum()){
					if(_row != row || _col != col){
						Number _val = this.raster.getCell(_col, _row);
	
						if(_val == null || _val.floatValue() > evl){
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
