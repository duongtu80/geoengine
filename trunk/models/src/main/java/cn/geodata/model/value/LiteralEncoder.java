package cn.geodata.model.value;

import java.io.IOException;

import net.opengeospatial.wps.LiteralValueType;

public interface LiteralEncoder {
	LiteralValueType encodeLiteral(int val) throws IOException;
	
	LiteralValueType encodeLiteral(long val) throws IOException;
	
	LiteralValueType encodeLiteral(float val) throws IOException;
	
	LiteralValueType encodeLiteral(double val) throws IOException;
}
