package cn.geodata.models.buffer;

import java.util.ArrayList;
import java.util.Collection;

import net.opengeospatial.wps.IOValueType;
import cn.geodata.model.GeoProcessing;
import cn.geodata.model.value.ModelValueParserFinder;
import cn.geodata.model.value.ModelValueUtil;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.MultiPolygon;
import com.vividsolutions.jts.geom.Polygon;

public class BufferProcessing extends GeoProcessing {

	@Override
	protected void execute() throws Exception {
		ModelValueParserFinder _finder = ModelValueUtil.createParserFinder();
		
		double _distance = _finder.getDefaultLiteralParser().parseLiteralDouble(this.getInputs().get("distance").get(0).getLiteralValue());
		Geometry _geometry = _finder.getDefaultComplexParser().parseGeometry(this.getInputs().get("geometry").get(0).getComplexValue());

		if (_geometry instanceof MultiPolygon) {
			MultiPolygon _polygons = (MultiPolygon) _geometry;
			Collection<Polygon> _col = new ArrayList<Polygon>();
			for(int i=0;i<_polygons.getNumGeometries();i++){
				Polygon _polyon = (Polygon)_polygons.getGeometryN(i).buffer(_distance);
				_col.add(_polyon);
			}
			
			GeometryFactory _geometryFactory = new GeometryFactory();
			MultiPolygon _result = _geometryFactory.createMultiPolygon((Polygon[])_col.toArray(new Polygon[0]));
			
			IOValueType _output = ModelValueUtil.createOutputValue(this.getOutputDefinitions().get("result"));
			_output.setComplexValue(_finder.getDefaultComplexEncoder().encodeGeometry(_result));
			
			this.getOutputs().get("result").add(_output);
		}
		else if(_geometry instanceof Polygon) {
			Polygon _polygon = (Polygon) _geometry;

			IOValueType _output = ModelValueUtil.createOutputValue(this.getOutputDefinitions().get("result"));
			_output.setComplexValue(_finder.getDefaultComplexEncoder().encodeGeometry(_polygon.buffer(_distance)));
		}
	}
}
