package cn.geodata.models.landfire;

import java.io.IOException;

import com.vividsolutions.jts.geom.Point;

public class ModelDayMet extends AbstractSampleModel {

	@Override
	public String[] getFields() {
		return new String[0];
	}

	@Override
	public String getModelName() {
		return "daymet";
	}

	@Override
	public Double[] getSample(String id, Point pt) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
