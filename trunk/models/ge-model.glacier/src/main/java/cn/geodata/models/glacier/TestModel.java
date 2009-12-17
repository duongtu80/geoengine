package cn.geodata.models.glacier;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;

import cn.geodata.models.Calculate;
import cn.geodata.models.annotation.GeoInput;
import cn.geodata.models.annotation.GeoOutput;
import cn.geodata.models.annotation.GeoProcess;

@GeoProcess(title="Test", keywords={"test"})
public class TestModel implements Calculate {
	
	private int percent;
	private int count;
	
	public TestModel(){
		percent = 0;
	}

	public void calculate() throws Exception {
		percent = 0;
		System.out.println("Start model...");
		for(int i=0;i<100;i++){
			System.out.println("at " + this.percent++);
			Thread.sleep(100);
		}
		
		System.out.println("End model...");
	}

	public void cancel() {
	}

	public int getPercent() {
		return this.percent;
	}

	public String getStatus() {
		return null;
	}

	@GeoInput(title="Test input")
	public void setCount(int count) {
		this.count = count;
	}
	
	@GeoOutput(title="Test output")
	public int getCount(){
		return this.count;
	}

	@GeoOutput(title="Test Point")
	public Point getPoint() {
		return (new GeometryFactory()).createPoint(new Coordinate(100, 40));
	}
}
