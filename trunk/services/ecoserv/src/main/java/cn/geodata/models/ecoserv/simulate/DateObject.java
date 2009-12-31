package cn.geodata.models.ecoserv.simulate;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.geotools.feature.FeatureCollection;

public class DateObject<T> implements Serializable {
	private static final long serialVersionUID = -7346854427907686359L;

	private Date date;
	private T value;
	
	public DateObject(Date date, T value){
		this.date = date;
		this.value = value;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof DateObject){
			DateObject<T> _date = (DateObject<T>) obj;
			return this.date.equals(_date.getDate());
		}
		return false;
	}

	@Override
	public String toString() {
		return this.date.toString() + ";" + this.value == null ? "<null>": this.value.toString();
	}
}
