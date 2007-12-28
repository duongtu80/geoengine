package cn.geodata.models.landfire;

import org.geotools.feature.FeatureCollection;

import cn.geodata.models.AbstractProcessing;

public class CollectSampleAgent extends AbstractProcessing {

	@Override
	public void execute() throws Exception {
		String _datasetId = (String) this.getInputs().get("datasetId");
		Integer _maxCount = (Integer) this.getInputs().get("maxCount");
		Double _minDistance = (Double) this.getInputs().get("minDistance");
		
		CollectSamples _val = new CollectSamples();
		FeatureCollection _fs = _val.findSamples(_datasetId, _maxCount, _minDistance);
		
		this.getOutputs().put("samples", _fs);
	}
}
