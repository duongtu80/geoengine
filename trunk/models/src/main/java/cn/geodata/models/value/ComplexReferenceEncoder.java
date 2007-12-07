package cn.geodata.models.value;

import java.io.IOException;

import net.opengeospatial.wps.IOValueType;

public interface ComplexReferenceEncoder extends Encoder {
	IOValueType.ComplexValueReference encodeGMLUrl(String url, String format, String encoding, String namespace) throws IOException;
}
