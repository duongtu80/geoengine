package cn.geodata.models;

import cn.geodata.models.geoprocessing.ProcessType;

public interface MetadataAware {
	void setMetadata(ProcessType metadata);
}
