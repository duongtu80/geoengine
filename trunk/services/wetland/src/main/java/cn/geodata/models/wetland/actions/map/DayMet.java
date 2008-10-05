package cn.geodata.models.wetland.actions.map;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DayMet {
	private double x;
	private double y;
	private int year;
	private int day;
	private double tmax;
	private double tmin;
	private double tday;
	private double prcp;
	private double vpd;
	private double srad;
	private double daylen;
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public double getTmax() {
		return tmax;
	}
	public void setTmax(double tmax) {
		this.tmax = tmax;
	}
	public double getTmin() {
		return tmin;
	}
	public void setTmin(double tmin) {
		this.tmin = tmin;
	}
	public double getTday() {
		return tday;
	}
	public void setTday(double tday) {
		this.tday = tday;
	}
	public double getPrcp() {
		return prcp;
	}
	public void setPrcp(double prcp) {
		this.prcp = prcp;
	}
	public double getVpd() {
		return vpd;
	}
	public void setVpd(double vpd) {
		this.vpd = vpd;
	}
	public double getSrad() {
		return srad;
	}
	public void setSrad(double srad) {
		this.srad = srad;
	}
	public double getDaylen() {
		return daylen;
	}
	public void setDaylen(double daylen) {
		this.daylen = daylen;
	}
	
	public Date getDate() throws ParseException{
		SimpleDateFormat _format = new SimpleDateFormat("yyyy.D");
		return _format.parse(this.year + "." + this.day);
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
}
