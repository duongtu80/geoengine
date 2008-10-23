package cn.geodata.models.glacier;

import org.geotools.factory.GeoTools;
import org.geotools.geometry.jts.JTS;
import org.geotools.referencing.ReferencingFactoryFinder;
import org.opengis.referencing.crs.CoordinateReferenceSystem;
import org.opengis.referencing.operation.CoordinateOperation;

import com.vividsolutions.jts.geom.Geometry;

public class ProjectTransformModel {
	private CoordinateReferenceSystem sourcePrj;
	private CoordinateReferenceSystem targetPrj;
	
	public ProjectTransformModel(CoordinateReferenceSystem sourcePrj, CoordinateReferenceSystem targetPrj) {
		this.sourcePrj = sourcePrj;
		this.targetPrj = targetPrj;
	}

	public Geometry calculate(Geometry geo) throws Exception {
		CoordinateOperation _coFactory = ReferencingFactoryFinder.getCoordinateOperationFactory(
				GeoTools.getDefaultHints()).createOperation(this.sourcePrj, this.targetPrj);
		
		return JTS.transform(geo, _coFactory.getMathTransform());
	}
}
