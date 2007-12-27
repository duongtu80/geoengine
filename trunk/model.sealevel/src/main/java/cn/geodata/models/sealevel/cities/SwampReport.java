package cn.geodata.models.sealevel.cities;

import org.geotools.factory.CommonFactoryFinder;
import org.geotools.factory.GeoTools;
import org.geotools.feature.Feature;
import org.geotools.feature.FeatureCollection;
import org.geotools.feature.FeatureIterator;

import cn.geodata.models.AbstractProcessing;

public class SwampReport extends AbstractProcessing {
	@Override
	public void execute() throws Exception {
		String _rise = (String)this.getInputs().get("cityId");
		FeatureCollection _cities = (FeatureCollection) this.getInputs().get("cities");

		FeatureIterator _it = _cities.features();
		try{
			while(_it.hasNext()){
				Feature _f = _it.next();
				if(_f.getID().equals(_rise)){
					FeatureCollection _fs = CommonFactoryFinder.getFeatureCollections(GeoTools.getDefaultHints()).newCollection();
					_fs.add(_f);
					
					this.getOutputs().put("report", _fs);
				}
			}
		}
		finally{
			_it.close();
		}
	}
}
