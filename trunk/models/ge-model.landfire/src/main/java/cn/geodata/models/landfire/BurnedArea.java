package cn.geodata.models.landfire;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.geotools.feature.FeatureCollection;
import org.opengis.feature.type.FeatureType;

import com.vividsolutions.jts.geom.MultiPolygon;

import cn.geodata.models.Calculate;
import cn.geodata.models.annotation.GeoInput;
import cn.geodata.models.annotation.GeoOutput;
import cn.geodata.models.annotation.GeoProcess;
import cn.geodata.models.raster.GeoRaster;

@GeoProcess(title="Forest Burned Area Calculation", description="Calculate monthly forest burned area based on MODIS images.", keywords={"Fire", "Forest", "Burned"})
public class BurnedArea implements Calculate {
	private int year;
	private int month;
	private MultiPolygon region;
	private MultiPolygon burned;
	
	public void calculate() throws IOException {
		List<GeoRaster> _rs = this.loadImages(region);
		
	}

	private List<GeoRaster> loadImages(MultiPolygon poly) throws IOException {
		List<GeoRaster> _rs = new ArrayList<GeoRaster>();
		_rs.add(new GeoRaster(new File("c:\\mfeng\\data\\modis\\burned\\MCD45A1.A2009152.h24v03.005.2009219102711.hdf"), 0));
		
		return _rs;
	}

	public void cancel() {
		// TODO Auto-generated method stub
		
	}

	public int getPercent() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	@GeoOutput(title="Burned Area", description="A multiple polygon represents forest burned area for given area in given month")
	public MultiPolygon getBurned() {
		return burned;
	}

	@GeoInput(title="Year", description="The year that the model will be estimated for")
	public void setYear(int year) {
		this.year = year;
	}

	@GeoInput(title="Month", description="The month that the model will be estimated for")
	public void setMonth(int month) {
		this.month = month;
	}

	@GeoInput(title="Region", description="The region that the model will be estimated for")
	public void setRegion(MultiPolygon region) {
		this.region = region;
	}
}
