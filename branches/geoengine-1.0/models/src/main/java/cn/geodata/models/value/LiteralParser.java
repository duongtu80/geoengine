package cn.geodata.models.value;

import java.io.IOException;

import net.opengeospatial.wps.LiteralValueType;

public interface LiteralParser extends Parser {
	String parseLiteralString(LiteralValueType type) throws IOException;
	
	int parseLiteralInt(LiteralValueType type) throws IOException;

	long parseLiteralLong(LiteralValueType type) throws IOException;

	float parseLiteralFloat(LiteralValueType type) throws IOException;
	
	double parseLiteralDouble(LiteralValueType type) throws IOException;
}
