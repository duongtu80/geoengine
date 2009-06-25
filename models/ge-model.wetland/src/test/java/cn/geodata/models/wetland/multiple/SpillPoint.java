package cn.geodata.models.wetland.multiple;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.geotools.factory.CommonFactoryFinder;
import org.geotools.factory.GeoTools;
import org.omg.CORBA.CTX_RESTRICT_SCOPE;

import cn.geodata.models.wetland.DemAnalysis;
import cn.geodata.models.wetland.DemRaster;
import cn.geodata.models.wetland.EnviRasterReader;
import cn.geodata.models.wetland.Extent;
import cn.geodata.models.wetland.RasterCell;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.MultiLineString;
import com.vividsolutions.jts.geom.MultiPolygon;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.Polygon;

public class SpillPoint {
	private Logger log = Logger.getAnonymousLogger();
	private double elevation;
	private Catchment catchment;
	
	public SpillPoint(Catchment catchment, double elevation){
		this.elevation = elevation;
		this.catchment = catchment;
	}
	
	/**
	 * Combine catchment regions into one multiple polygon
	 * 
	 * @param catchments
	 * @return
	 */
	private static MultiPolygon combineCatchments(List<Catchment> catchments){
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
	
	/**
	 * Get closest catchment from catchments list;
	 * 
	 * @param catchments
	 * @param pt
	 * @return
	 */
	private static Catchment getClosestCatchment(List<Catchment> catchmentsAll, List<Catchment> catchments, RasterCell pt, double dis){
		Catchment _catchment = null;
		double _distance = Double.MAX_VALUE;
		
		Point _pt = (new GeometryFactory()).createPoint(new Coordinate(pt.getX(), pt.getY()));
		for(Catchment _c : catchmentsAll){
			if(catchments.contains(_c) == false){
				double _dis = _c.getRegion().distance(_pt);
				if(_dis < dis){
					_catchment = _c;
					_distance = _dis;
				}
			}
		}
		
		return _catchment;
	}
	
	/**
	 * Calculate spill point for catchment(s)
	 * 
	 * @param dem
	 * @param catchmentsAll
	 * @param catchments
	 * @return
	 * @throws IOException
	 */
	public static SpillPoint calculateSpillPoint(DemRaster dem, List<Catchment> catchmentsAll, List<Catchment> catchments) throws IOException{
		MultiPolygon _c = combineCatchments(catchments);
		
		DemAnalysis _dem = new DemAnalysis(dem);
		Extent _extent = _dem.calculateExtent(_c.getEnvelopeInternal());
		
//		RasterCell _lowestC = _dem.calcuateLowest4Catchment(_c, _extent);
		RasterCell _lowestB = _dem.calculateLowest4Boundary((MultiLineString) _c.getBoundary(), _extent);
		
		EnviRasterReader _raster = dem.getRaster();
//		double _spillPoint = _raster.readFloat(_lowestB.getRow(), _lowestB.getCol()) - _raster.readFloat(_lowestC.getRow(), _lowestC.getCol());
		double _spillPoint = _raster.readFloat(_lowestB.getRow(), _lowestB.getCol());
		Catchment _catchment = getClosestCatchment(catchmentsAll, catchments, _lowestB, dem.getRaster().getCellSize() * 2);

		return new SpillPoint(_catchment, _spillPoint);
	}

	/**
	 * Calculate spill point for catchment
	 * 
	 * @param dem
	 * @param catchmentsAll
	 * @param catchments
	 * @return
	 * @throws IOException
	 */
	public static SpillPoint calculateSpillPoint(DemRaster dem, List<Catchment> catchmentsAll, Catchment catchment) throws IOException{
		List<Catchment> _cats = new ArrayList<Catchment>();
		_cats.add(catchment);
		
		return calculateSpillPoint(dem, catchmentsAll, _cats);
	}

	public double getElevation() {
		return elevation;
	}

	public Catchment getCatchment() {
		return catchment;
	}
}
