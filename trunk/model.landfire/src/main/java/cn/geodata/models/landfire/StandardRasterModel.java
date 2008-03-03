package cn.geodata.models.landfire;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.configuration.HierarchicalConfiguration;

import cn.geodata.tools.RasterInfo;
import cn.geodata.tools.RasterManager;

import com.vividsolutions.jts.geom.Point;

public class StandardRasterModel extends AbstractSampleModel {
	private String modelName;
	private RasterManager manager;
	private HierarchicalConfiguration config;

	public StandardRasterModel(String modelName, HierarchicalConfiguration config) throws IOException{
		this.modelName = modelName;
		this.config = config;
		
		this.manager = new RasterManager(new File(config.getString("path")), config.getInt("nodata", 0));
	}
	
	@Override
	public String[] getFields() {
		return new String[]{this.modelName};
	}

	@Override
	public String getModelName() {
		return this.modelName;
	}

	@Override
	public Double[] getSample(String id, Point pt) throws IOException {
		List<RasterInfo> _list = this.manager.findDatasets(pt);	
		return new Double[]{(double)this.manager.getLocationValue(_list, pt.getX(), pt.getY())};
	}	
}
