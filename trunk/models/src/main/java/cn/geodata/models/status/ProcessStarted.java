package cn.geodata.models.status;

import java.text.DecimalFormat;

import net.opengeospatial.ows.ExceptionReportDocument.ExceptionReport;
import net.opengeospatial.wps.ProcessFailedType;
import net.opengeospatial.wps.ProcessStartedType;
import net.opengeospatial.wps.StatusType;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import cn.geodata.models.GeoNamespaceContext;

/**
 * 进度进展状态
 * @author Fengm
 *
 */
public class ProcessStarted extends Status {
	private float percent;
	
	public ProcessStarted(){
		this.percent = 0;
	}

	/**
	 * 获取进度
	 * @return
	 */
	public float getPercent() {
		return percent;
	}

	/**
	 * 设置进度 
	 * @param percent 进度百分比的分值 percent >0 and percent < 100
	 */
	public void setPercent(float percent) {
		if(percent > 100){
			this.percent = 100;
		}
		else{
			if(percent < 0){
				this.percent = 0;				
			}
			else{
				this.percent = percent;
			}
		}
	}
	
	/**
	 * 前进进度
	 * @param percent
	 */
	public void step(float percent){
		this.setPercent(this.getPercent() + percent);
	}

	@Override
	protected Element createProcessStatusNode(Document doc) {
		DecimalFormat _format = new DecimalFormat("0");
		
		Element _element = (Element) doc.createElementNS(GeoNamespaceContext.URI_WPS, this.getTitle());
		_element.setAttribute("PercentCompleted", _format.format(this.getPercent()));
		
		return _element;
	}

	@Override
	public String getTitle() {
		return "ProcessStarted";
	}
	
	@Override
	public void encode(StatusType type) {
		super.encode(type);
		
		ProcessStartedType _node = type.addNewProcessStarted();
		_node.setPercentCompleted((int)this.percent);
	}
}
