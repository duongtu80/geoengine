package cn.geodata.models.value;

import java.io.IOException;

import net.opengeospatial.wps.IOValueType;

public interface ReferenceEncoder extends Encoder {
	IOValueType.ComplexValueReference encodeUrl(String url, String format, String encoding, String namespace) throws IOException;
}
