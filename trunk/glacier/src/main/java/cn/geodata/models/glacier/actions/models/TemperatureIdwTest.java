package cn.geodata.models.glacier.actions.models;

import org.apache.commons.io.IOUtils;

import junit.framework.TestCase;

public class TemperatureIdwTest extends TestCase {

	public void testExecute() throws Exception {
		TemperatureIdw _model = new TemperatureIdw();
		
		_model.setStartYear(1989);

		System.out.println(_model.execute());
		System.out.println(IOUtils.toString(_model.getStream()));
	}
}
