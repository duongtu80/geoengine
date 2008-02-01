package cn.geodata.models.landfire;

import java.io.File;

public class ModelDNBR extends AbstractRasterSampleModel {

	@Override
	public File getImageFile(String id) {
		return new File(this.getConfig().getString("repository"), id + "\\" + id + "_d.tif");
	}

	@Override
	public String getModelName() {
		return "dnbr";
	}

	@Override
	public String[] getFields() {
		return new String[] {"dnbr"};
	}
}
