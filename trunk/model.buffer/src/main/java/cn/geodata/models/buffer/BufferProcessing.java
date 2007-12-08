package cn.geodata.models.buffer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Logger;

import net.opengeospatial.wps.IOValueType;
import cn.geodata.models.AbstractProcessing;
import cn.geodata.models.value.ModelValueParserFinder;
import cn.geodata.models.value.ModelValueUtil;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.MultiPolygon;
import com.vividsolutions.jts.geom.Polygon;

public class BufferProcessing extends AbstractProcessing {
	private static Logger log = Logger.getLogger("cn.geodata.models.buffer");
	
	@Override
	public void execute() throws Exception {
		ModelValueParserFinder _finder = ModelValueUtil.createParserFinder();
		
		double _distance = _finder.getLiteralParser().parseLiteralDouble(this.getInputs().get("distance").get(0).getLiteralValue());
		Geometry _geometry = _finder.getComplexParser().parseGeometry(this.getInputs().get("geometry").get(0).getComplexValue());

		if (_geometry instanceof MultiPolygon) {
			MultiPolygon _polygons = (MultiPolygon) _geometry;
			Collection<Polygon> _col = new ArrayList<Polygon>();
			for(int i=0;i<_polygons.getNumGeometries();i++){
				Polygon _polyon = (Polygon)_polygons.getGeometryN(i).buffer(_distance);
				_col.add(_polyon);
			}
			
			GeometryFactory _geometryFactory = new GeometryFactory();
			MultiPolygon _result = _geometryFactory.createMultiPolygon((Polygon[])_col.toArray(new Polygon[0]));
			
			IOValueType _output = ModelValueUtil.createOutputValue(this.outputDefinitions.get("result"));
			_output.setComplexValue(_finder.getComplexEncoder().encodeGeometry(_result));
			
			this.getOutputs().get("result").add(_output);
		}
		else if(_geometry instanceof Polygon) {
			Polygon _polygon = (Polygon) _geometry;

			IOValueType _output = ModelValueUtil.createOutputValue(this.outputDefinitions.get("result"));
			_output.setComplexValue(_finder.getComplexEncoder().encodeGeometry(_polygon.buffer(_distance)));
		}
	}
}
