package cn.geodata.models.sealevel.cities;

import java.io.InputStream;
import java.util.Map;

import cn.geodata.model.GeoProcessing;
import cn.geodata.model.ProcessingFactory;

public class SwampCitiesFactory extends ProcessingFactory {

	@Override
	public String getDescription() {
		return "Swamp cities";
	}

	@Override
	public String getTitle() {
		return "Swamp cities";
	}

	@Override
	public Map getImplementationHints() {
		return null;
	}

	@Override
	public String getIdentifier() {
		return "SwampCities";
	}

	@Override
	public InputStream getMetadataStream() throws Exception {
		return SwampCitiesFactory.class.getResourceAsStream("/META-INF/metadata/swampCities.xml");
	}
	@Override
	public GeoProcessing createProcessing(Map<String, String> params)
			throws Exception {
		return new SwampCities();
	}
}
