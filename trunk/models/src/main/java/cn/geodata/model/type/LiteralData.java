package cn.geodata.model.type;

import java.util.List;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import cn.geodata.model.GeoNamespaceContext;
import cn.geodata.model.util.Utilities;

public abstract class LiteralData extends ModelData {
	protected DataType dataType;
	protected List<Uom> uoms;
	
	public DataType getDataType() {
		return dataType;
	}

	public void setDataType(DataType dataType) {
		this.dataType = dataType;
	}

	public List<Uom> getUoms() {
		return uoms;
	}

	public void setUoms(List<Uom> uoms) {
		this.uoms = uoms;
	}

	protected abstract Element encodeDataType(Document doc) throws Exception;
	
	@Override
	protected Element encodeType(Document doc) throws Exception {
		Element _dataNode = doc.createElementNS(GeoNamespaceContext.URI_WPS, "LiteralData");
		
		if(dataType != null){
			_dataNode.appendChild(this.dataType.encode(doc));
		}
		
		if(uoms != null && uoms.size() > 0){
			Element _uomsNode = doc.createElementNS(GeoNamespaceContext.URI_WPS, "SupportedUOMs");
			_dataNode.appendChild(_uomsNode);
			
			for(Uom _uom : uoms){
				_uomsNode.appendChild(_uom.encode(doc));
			}
		}
		
		_dataNode.appendChild(this.encodeDataType(doc));
		return _dataNode;
	}

	@Override
	public boolean canParse(Element node) throws Exception {
		if(super.canParse(node) == false){
			return false;
		}
		
		XPath _xpath = Utilities.createInstance().getXpath();
		if((Element)_xpath.evaluate("//wps:LiteralData", node, XPathConstants.NODE) == null){
			return false;
		}
		
		return true;
	}
}
