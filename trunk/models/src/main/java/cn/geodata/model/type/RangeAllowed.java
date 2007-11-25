package cn.geodata.model.type;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import cn.geodata.model.GeoNamespaceContext;
import cn.geodata.model.exception.InvalidParameterValueException;

public class RangeAllowed extends AllowedValues {
	protected double min;
	protected double max;
	
	public RangeAllowed(){
		this.min = Double.NEGATIVE_INFINITY;
		this.max = Double.POSITIVE_INFINITY;
	}
	
	public RangeAllowed(double min, double max){
		this.min = min;
		this.max = max;
	}
	
	@Override
	protected void encodeAllowedValues(Document doc, Element parentNode)
			throws Exception {
		Element _rangeNode = doc.createElementNS(GeoNamespaceContext.URI_OWS, "Range");
		if(this.min > Double.NEGATIVE_INFINITY){
			Element _minNode = doc.createElementNS(GeoNamespaceContext.URI_OWS, "MinimumValue");
			_rangeNode.appendChild(_minNode);
			
			_minNode.setTextContent(this.min + "");
		}

		if(this.max > Double.POSITIVE_INFINITY){
			Element _maxNode = doc.createElementNS(GeoNamespaceContext.URI_OWS, "MaximumValue");
			_rangeNode.appendChild(_maxNode);
			
			_maxNode.setTextContent(this.max + "");
		}
		
		parentNode.appendChild(_rangeNode);
	}

	@Override
	protected void validData(Object value) throws InvalidParameterValueException {
		double _val = Double.parseDouble(value.toString());
		if(this.min >= _val && this.max <= _val){
			
		}
		else{
			throw new InvalidParameterValueException(value + "不在有效取值范围内");
		}
	}

	public double getMin() {
		return min;
	}

	public void setMin(double min) {
		this.min = min;
	}

	public double getMax() {
		return max;
	}

	public void setMax(double max) {
		this.max = max;
	}
}
