package cn.geodata.models.data;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import javax.activation.MimeType;

import net.opengeospatial.wps.ComplexDataType;
import net.opengeospatial.wps.ComplexValueType;

import cn.geodata.models.category.data.DataCategory;
import cn.geodata.models.data.parsers.GmlComplexParser;

public class ComplexParsers {
	private static Logger log = Logger.getAnonymousLogger();
	
	private static ComplexParsers instance;
	private List<ComplexParser> parsers;
	
	private ComplexParsers(){
	}

	public List<ComplexParser> getParsers() {
		return parsers;
	}

	public void setParsers(List<ComplexParser> parsers) {
		this.parsers = parsers;
	}
	
	public ComplexParsers getInstance() {
		if(instance == null){
			instance = new ComplexParsers();
			
			instance.setParsers(Arrays.asList(new ComplexParser[]{
					new GmlComplexParser()
				}));
		}
		return instance;
	}
	
	public ComplexParser findParser(MimeType mimeType, DataCategory category){
		for(ComplexParser _p : this.parsers){
			if(_p.getMimes().contains(mimeType) && _p.getCategories().contains(category)){
				return _p;
			}
		}
		
		log.warning("Not found parser for " + mimeType + " category:" + category);
		return null;
	}
	
	public Object parser(ComplexDataType type, ComplexValueType value) throws IOException {
		return null;
	}
}
