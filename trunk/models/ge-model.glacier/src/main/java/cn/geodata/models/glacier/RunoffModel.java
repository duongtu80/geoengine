package cn.geodata.models.glacier;

import java.util.Date;
import java.util.logging.Logger;

import com.vividsolutions.jts.geom.Point;

import cn.geodata.models.Calculate;
import cn.geodata.models.annotation.GeoInput;
import cn.geodata.models.annotation.GeoOutput;
import cn.geodata.models.annotation.GeoProcess;

/**
 * @author tank
 *
 */
/**
 * @author tank
 *
 */
@GeoProcess(title="冰川融水径流模型", keywords={"runoff"})
public class RunoffModel implements Calculate{
	private Logger log = Logger.getLogger(RunoffModel.class.getName());

	private double snowCritical;
	private double rainCritical;
	private double evaporationRatio;
	private double snowFrozenRatio;
//	private double temperatureGrad;
//	private double precipitationGrad;

	private Date date;
	private int days;
	private double[] levels;
	private double[] areas;
	private Point location;
	private double[] accumulations;
	private double[] balances;
	private double[] runoffs;
	private double[] temperatures;
	private double[] precipitations;
	private double[] accumulatedTemperatures;
	private double temperature;
	private double precipitation;
	private double snowDDF;
	private double iceDDF;
	private double precElevation;
	
	
	/* 
	 * 模型运行
	 * @see cn.geodata.models.Calculate#calculate()
	 */
	public void calculate() throws Exception {
		runoffs = new double[this.levels.length];
		balances = new double[this.levels.length];
		temperatures = new double[this.levels.length];
		precipitations = new double[this.levels.length];
		accumulatedTemperatures = new double[this.levels.length];
		
		if(accumulations == null){
			accumulations = new double[this.levels.length];
		}

		int _minGlacierBand = getMinGlacierBand();
		double _alt = location.getCoordinate().z;
		//计算各分带
		for(int i=0;i<levels.length ;i++){
			double _level = levels[i];

			//计算分带的气温和降水
			double _precBand = precipitation4Band(precipitation, precElevation, _level);
			double _tempBand = temperature4Band(temperature, _alt, _level);
			double _acmtBand = this.computerAT(location.getY(), date.getMonth(), _tempBand, days); //temperature4Band(accumulatedTemperature, _alt, _level);
			
			temperatures[i] = _tempBand;
			precipitations[i] = _precBand;
			accumulatedTemperatures[i] = _acmtBand;
			
			//冰川末端温度跃动
			if(i == _minGlacierBand){
				_tempBand -= 1;
			}
			
			//初始化积雪
			double _snow = 0;
			
			if(_tempBand < this.snowCritical){
				_snow += _precBand;
			}
			else{
				if(_tempBand < rainCritical){
					_snow += _precBand * (_tempBand - snowCritical) / (rainCritical - snowCritical);
				}
			}
			
			_precBand -= _snow;
			if(_precBand < 0)
				_precBand = 0;

			if(accumulations[i] > 0)
				_snow += accumulations[i];
			
			double _snowDDF = snowDDF; // * days;
			double _iceDDF = iceDDF; // * days;
			//计算径流
			double _runoffBand = 0;
			if(_acmtBand > 0){
				double _pSnowMelt = _acmtBand * _snowDDF;
				if(_snow - _pSnowMelt > 0){
					_runoffBand = _pSnowMelt;
					_snow -= _pSnowMelt;
				}
				else if(_snow == 0){
					_runoffBand = _acmtBand * _iceDDF;
				}
				else{
					_runoffBand = _snow + (_acmtBand - _snow / _snowDDF) * _iceDDF;
					_snow = 0;
				}
			}
			
			_runoffBand += _precBand;
			
			//计算物质平衡
			double _balanceBand = _snow + (this.snowFrozenRatio - 1) * _runoffBand;
			_runoffBand *= (1 - this.snowFrozenRatio);
			
			if(areas[i] > 0){
				runoffs[i] = _runoffBand * areas[i] / (1000.0 * days * 24 * 60 * 60); //* 1000 
				accumulations[i] = _snow;
				balances[i] = _balanceBand;
			}
		}
	}

	@GeoOutput(title="分带气温")
	public double[] getTemperatures() {
		return temperatures;
	}

	@GeoOutput(title="分带降水量")
	public double[] getPrecipitations() {
		return precipitations;
	}

	@GeoOutput(title="积雪积累量")
	public double[] getAccumulations() {
		return accumulations;
	}
	
	@GeoOutput(title="物质平衡")
	public double[] getBalances(){
		return balances;
	}

	@GeoOutput(title="分带积温")
	public double[] getAccumulatedTemperatures() {
		return accumulatedTemperatures;
	}

	@GeoOutput(title="径流量")
	public double[] getRunoffs() {
		return runoffs;
	}

	@GeoInput(title="日期")
	public void setDate(Date date) {
		this.date = date;
	}

	@GeoInput(title="积雪积累量")
	public void setAccumulations(double[] accumulations) {
		this.accumulations = accumulations;
	}

	@GeoInput(title="降雪临界温度")
	public void setSnowCritical(double snowCritical) {
		this.snowCritical = snowCritical;
	}

	@GeoInput(title="降雨临界温度")
	public void setRainCritical(double rainCritical) {
		this.rainCritical = rainCritical;
	}

	@GeoInput(title="蒸发潜力")
	public void setEvaporationRatio(double evaporationRatio) {
		this.evaporationRatio = evaporationRatio;
	}

	@GeoInput(title="融水渗浸冻结率")
	public void setSnowFrozenRatio(double snowFrozenRatio) {
		this.snowFrozenRatio = snowFrozenRatio;
	}

	@GeoInput(title="降水标准高程")
	public void setPrecElevation(double precElevation) {
		this.precElevation = precElevation;
	}

//	@GeoInput(title="气温垂直递减率")
//	public void setTemperatureGrad(double temperatureGrad) {
//		this.temperatureGrad = temperatureGrad;
//	}
//
//	@GeoInput(title="降水垂直递减率")
//	public void setPrecipitationGrad(double precipitationGrad) {
//		this.precipitationGrad = precipitationGrad;
//	}

	@GeoInput(title="分带高度")
	public void setLevels(double[] levels) {
		this.levels = levels;
	}

	@GeoInput(title="分带冰川面积")
	public void setAreas(double[] areas) {
		this.areas = areas;
	}

	@GeoInput(title="中心点")
	public void setLocation(Point location){
		this.location = location;
	}

	@GeoInput(title="中心点气温")
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	@GeoInput(title="中心点降水")
	public void setPrecipitation(double precipitation) {
		this.precipitation = precipitation;
	}

	@GeoInput(title="中心点雪度日因子")
	public void setSnowDDF(double snowDDF) {
		this.snowDDF = snowDDF;
	}

	@GeoInput(title="中心点冰度日因子")
	public void setIceDDF(double iceDDF) {
		this.iceDDF = iceDDF;
	}

	@GeoInput(title="日数")
	public void setDays(int days) {
		this.days = days;
	}

	public int getPercent() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 计算积温
	 * 
	 * @param latitude 高程
	 * @param month 月份
	 * @param temperature 气温
	 * @param days 天数
	 * @return
	 */
	public double computerAT(double latitude, int month, double temperature, int days){
		double[] _t1 = new double[]{0.114,0.134,0.148,0.127,0.085,0.07,0.074,0.099,0.11,0.105,0.154,0.153};
		double[] _t2 = new double[]{-0.53,-0.89,-1.352,-0.864,0.192,0.107,-0.313,-1.137,-1.118,-0.337,-1.827,-1.841};
		
		double _drt = latitude * _t1[month] + _t2[month];
		double _tx=0.02;
		double _p=0;
		double _fb=0;
		
		for(int i=0;i<10000;i++){
			double _x = (i + 1) * _tx;
			double _f2 = _x * Math.exp((temperature - _x) * (_x - temperature) / (2 * _drt * _drt)) / (Math.sqrt(2 * 3.14159265) * _drt);
			double _p1 = (_fb + _f2) * _tx / 2;
			_fb = _f2;
			_p = _p + _p1;
			
			if(_p1 < 1e-7 && _x > temperature){
//				log.info("Jump out:" + i + ", p=" + _p + ", p1=" + _p1 + ", x="  + _x + ", t=" + temperature);
				break;
			}
		}
		_p = _p * days;
		if(_p < 10) _p = 0;
		
		return _p;
	}	

	/**
	 * 计算分带的气温
	 * 
	 * @param val
	 * @param sourceLat
	 * @param targetLat
	 * @return
	 */
	private double temperature4Band(double val, double sourceLat, double targetLat) {
		double[][] _m = new double[][]{
				{0.52, 0.52, 0.52, 0.52, 0.54, 0.52, 0.52},
				{0.48, 0.5, 0.48, 0.5, 0.48, 0.5, 0.5},
				{0.54, 0.52, 0.54, 0.54, 0.54, 0.54, 0.54},
				{0.46, 0.44, 0.46, 0.46, 0.46, 0.46, 0.46},
				{0.48, 0.46, 0.48, 0.46, 0.48, 0.48, 0.46}				
			};
		
		double[] _v = new double[] {28, 30, 32, 34, 36};
		double[] _l = new double[] {2000, 2500, 3000, 3500, 4000, 4500, 5000};
		
		double _lat = location.getY();
		int _y = _v.length - 1;
		for(int i=0;i<_v.length;i++){
			if(_lat >= _v[i]){
				_y = i;
				break;
			}
		}
		
		double _d = _m[_y][_l.length - 1];
		for(int i=0;i<_l.length - 1;i++){
			if(targetLat >= _m[_y][i]){
				_d = _m[_y][i];
				break;
			}
		}
		
		return val + _d * (sourceLat - targetLat) / 100.0;
	}

	/**
	 * 计算分带的降水
	 * 
	 * @param val
	 * @param sourceLat
	 * @param targetLat
	 * @return
	 */
	@SuppressWarnings("deprecation")
	private double precipitation4Band(double val, double sourceLat, double targetLat) {
		double[] _k1 = new double[]{-0.2, -0.1, 0.1, 2.5, 5.2, 5.9, 5.1, 4.3, 3.3, 1.0, 0.1, -0.1};
		double[] _k2 = new double[]{-1,-1.8,-0.2,-4, -4.2, -4.2, -4.2, -2.8, -3.4,-3.2,-3.6,-1.8};
		
		double _val = 0;
		if(targetLat <= 3500){
			_val = val + _k1[date.getMonth()] * (targetLat - sourceLat) / 100.0;
		}
		else{
			_val = val + _k1[date.getMonth()] * (3500 - sourceLat) / 100.0 + _k2[date.getMonth()] * (targetLat - 3500) / 100.0;
		}
		
		if(_val < 0){
			return 0;
		}
		return _val;
	}
	
	/**
	 * 计算冰川末端
	 * @return
	 */
	private int getMinGlacierBand(){
		for(int i=0;i<areas.length;i++){
			if(areas[i] > 0){
				return i;
			}
		}
		
		return areas.length - 1;
	}

	public void cancel() {
		// TODO Auto-generated method stub
		
	}

	public String getStatus() {
		// TODO Auto-generated method stub
		return null;
	}

}
