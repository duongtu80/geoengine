package cn.geodata.models.glacier;

import org.geotools.factory.GeoTools;
import org.geotools.geometry.jts.JTS;
import org.geotools.referencing.CRS;
import org.geotools.referencing.ReferencingFactoryFinder;
import org.opengis.referencing.operation.CoordinateOperation;

import com.vividsolutions.jts.geom.Geometry;

public class ProjectTransformModel {
	private String sourcePrj;
	private String targetPrj;
	
	public ProjectTransformModel(String sourcePrj, String targetPrj) {
		this.sourcePrj = sourcePrj;
		this.targetPrj = targetPrj;
	}

	public Geometry calculate(Geometry geo) throws Exception {
		CoordinateOperation _coFactory = ReferencingFactoryFinder.getCoordinateOperationFactory(
				GeoTools.getDefaultHints()).createOperation(
						CRS.decode(sourcePrj),
						CRS.decode(targetPrj));
		
		return JTS.transform(geo, _coFactory.getMathTransform());
	}
}
