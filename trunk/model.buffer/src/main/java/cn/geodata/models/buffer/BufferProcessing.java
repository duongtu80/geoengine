package cn.geodata.models.buffer;

import java.util.ArrayList;
import java.util.Collection;

import cn.geodata.model.GeoProcessing;
import cn.geodata.model.value.ComplexValue;
import cn.geodata.model.value.LiteralValue;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.MultiPolygon;
import com.vividsolutions.jts.geom.Polygon;

public class BufferProcessing extends GeoProcessing {

	@Override
	protected void execute() throws Exception {
//		Parser _parser = new Parser(new GMLConfiguration());
//		GmlReference _ref = new GmlReference(new URI("http://www.geodata.cn"));
//
		Float _distance = (Float)((LiteralValue)this.getInputs().get("Distance")).getValue();
//		MultiPolygon _polygon = (MultiPolygon)((ComplexValue)this.getInputs().get("Geometry")).getValue();
		
		Geometry _geometry = (Geometry)((ComplexValue)this.getInputs().get("Geometry")).getValue();
		if (_geometry instanceof MultiPolygon) {
			MultiPolygon _polygons = (MultiPolygon) _geometry;
			Collection<Polygon> _col = new ArrayList<Polygon>();
			for(int i=0;i<_polygons.getNumGeometries();i++){
				Polygon _polyon = (Polygon)_polygons.getGeometryN(i).buffer(_distance);
				_col.add(_polyon);
			}
			
			GeometryFactory _geometryFactory = new GeometryFactory();
			MultiPolygon _result = _geometryFactory.createMultiPolygon((Polygon[])_col.toArray(new Polygon[0]));
			
			this.getOutput().put("BufferedGeometry", new ComplexValue("BufferedGeometry", "BufferedGeometry", null ,_result));
		}
		else if(_geometry instanceof Polygon) {
			Polygon _polygon = (Polygon) _geometry;
			this.getOutput().put("BufferedGeometry", new ComplexValue("BufferedGeometry", "BufferedGeometry", null ,_polygon.buffer(_distance.floatValue())));
		}
		
//		this.getOutput().put("BufferedGeometry", new ComplexValue("BufferedGeometry", "BufferedGeometry", null ,_polygon.buffer(_distance.floatValue())));
//		this.getOutput().put("BufferedGeometry", _ref);
	}
}
