package cn.geodata.models.wetland.actions.map;

import java.io.File;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;

public class ImageStream {
	private String code;
	private String tempDir;
	private InputStream stream;
	
	public InputStream getStream() {
		return stream;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTempDir() {
		return tempDir;
	}
	public void setTempDir(String tempDir) {
		this.tempDir = tempDir;
	}
	
	public String execute() throws Exception {
		this.stream = FileUtils.openInputStream(new File(new File(tempDir), code));
		
		return "success";
	}
}
