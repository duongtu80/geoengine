package cn.geodata.models.glacier;

import java.util.Date;

import com.vividsolutions.jts.geom.Point;

public interface LocationModel {
	double calculate(Date date, Point point) throws Exception;
}

