package cn.geodata.model.value;

import java.io.IOException;

import net.opengeospatial.wps.IOValueType;

public interface ComplexReferenceEncoder {
	IOValueType.ComplexValueReference encodeGMLUrl(String url, String encoding) throws IOException;
}
