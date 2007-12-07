package cn.geodata.models;

import net.opengeospatial.wps.ProcessDescriptionType;

public interface MetadataAware {
	void setMetadata(ProcessDescriptionType metadata);
}
