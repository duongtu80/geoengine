package cn.geodata.models.glacier;

import java.util.Date;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;

import junit.framework.TestCase;

public class PrecipitationModelTest extends TestCase {

	public void testCalculate() throws Exception {
		InvertDistanceWeightModel _idw = new InvertDistanceWeightModel();
		_idw.setMaxCount(10);
		_idw.setPow(2);
		
		PrecipitationModel _model = new PrecipitationModel();
		_model.setModel(_idw);
		
		GeometryFactory _factory = new GeometryFactory();
		_model.calculate(new Date(80, 0, 1), _factory.createPoint(new Coordinate(110, 33)));
	}

}
