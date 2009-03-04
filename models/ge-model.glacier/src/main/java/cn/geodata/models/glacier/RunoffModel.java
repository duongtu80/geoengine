package cn.geodata.models.glacier;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.vividsolutions.jts.geom.Point;

import cn.geodata.models.Calculate;
import cn.geodata.models.annotation.GeoInput;
import cn.geodata.models.annotation.GeoOutput;
import cn.geodata.models.annotation.GeoProcess;

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
	private double[] accumulationSnows;
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

	private String temperatureM;
	private String temperatureV;
	private String temperatureL;
	private String precipitationGrads1;
	private String precipitationGrads2;
	private double precipitationMaxAlt;
	private String atT1;
	private String atT2;
	private double atTx;
	
	/* 
	 * 模型运行
	 * @see cn.geodata.models.Calculate#calculate()
	 */
	public void calculate() throws Exception {
		runoffs = new double[this.levels.length];
		balances = new double[this.levels.length];
		temperatures = new double[this.levels.length];
		precipitations = new double[this.levels.length];
		accumulations = new double[this.levels.length];
		accumulatedTemperatures = new double[this.levels.length];

		//如果是没有积累或者10月份，则累计值清零 02/23/2009
		if(accumulationSnows == null || this.date.getMonth() == 9){
			accumulationSnows = new double[this.levels.length];
		}

		int _minGlacierBand = getMinGlacierBand();
		double _alt = location.getCoordinate().z;
		//计算各分带
		for(int i=0;i<levels.length ;i++){
			double _level = levels[i];

			//计算分带的气温、降水和积温
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
			
			//计算固态降水
			double _snowBand = 0;
			if(_tempBand < this.snowCritical){
				_snowBand = _precBand;
			}
			else{
				if(_tempBand < rainCritical){
					_snowBand = _precBand * (_tempBand - snowCritical) / (rainCritical - snowCritical);
					if(_snowBand > _precBand)
						_snowBand = _precBand;
				}
			}

			//计算液态降水
			double _rainBand = _precBand - _snowBand;

			//固态降水的积累
			double _accumlationSnowBand = _snowBand;
			if(accumulationSnows[i] > 0)
				_accumlationSnowBand += accumulationSnows[i];
			
			//计算融冰和融雪
			double _iceMeltBand = 0;
			double _snowMeltBand = 0;
			
			if(_acmtBand > 0){
				_snowMeltBand = _acmtBand * snowDDF;
				if(_snowMeltBand > _accumlationSnowBand){
					_iceMeltBand = (_acmtBand - _accumlationSnowBand / snowDDF) * iceDDF;
					_snowMeltBand = _accumlationSnowBand;
				}
			}
			_accumlationSnowBand -= _snowMeltBand;
			
			//计算产流
			double _runoffYieldBand = (_snowMeltBand + _iceMeltBand) * (1 - snowFrozenRatio);
			//冰川积累
			double _accumulationBand = _snowBand + _rainBand * snowFrozenRatio;
			//计算径流
			double _runoffBand = _runoffYieldBand + _rainBand * (1 - snowFrozenRatio);
			//计算物质平衡
			double _balanceBand = _accumulationBand - _runoffYieldBand;
			
			if(areas[i] > 0){
				runoffs[i] = _runoffBand > 0 ? _runoffBand: 0; 
				accumulations[i] = _accumulationBand;
				accumulationSnows[i] = _accumlationSnowBand;
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
	public double[] getAccumulationSnows() {
		return accumulationSnows;
	}

	@GeoOutput(title="积雪累积量")
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
	public void setAccumulationSnows(double[] accumulationSnows) {
		this.accumulationSnows = accumulationSnows;
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

	public void setTemperatureM(String temperatureM) {
		this.temperatureM = temperatureM;
	}

	public void setTemperatureV(String temperatureV) {
		this.temperatureV = temperatureV;
	}

	public void setTemperatureL(String temperatureL) {
		this.temperatureL = temperatureL;
	}

	public void setPrecipitationGrads1(String precipitationGrads1) {
		this.precipitationGrads1 = precipitationGrads1;
	}

	public void setPrecipitationGrads2(String precipitationGrads2) {
		this.precipitationGrads2 = precipitationGrads2;
	}

	public void setPrecipitationMaxAlt(double precipitationMaxAlt) {
		this.precipitationMaxAlt = precipitationMaxAlt;
	}

	public void setAtT1(String atT1) {
		this.atT1 = atT1;
	}

	public void setAtT2(String atT2) {
		this.atT2 = atT2;
	}

	public void setAtTx(double atTx) {
		this.atTx = atTx;
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
//		double[] _t1 = new double[]{0.114,0.134,0.148,0.127,0.085,0.07,0.074,0.099,0.11,0.105,0.154,0.153};
//		double[] _t2 = new double[]{-0.53,-0.89,-1.352,-0.864,0.192,0.107,-0.313,-1.137,-1.118,-0.337,-1.827,-1.841};
		List<Double> _t1 = this.searchNumbers(this.atT1);
		List<Double> _t2 = this.searchNumbers(this.atT2);
		
		double _drt = latitude * _t1.get(month) + _t2.get(month);
		double _tx=this.atTx;
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
	 * 从数值字符串列表中提取数值数组
	 * 
	 * @param txt
	 * @return
	 */
	private List<Double> searchNumbers(String txt){
		Pattern _p = Pattern.compile("([\\d\\.]+)");
		
		List<Double> _list = new ArrayList<Double>();
		Matcher _m = _p.matcher(txt);
		int _pos = 0;
		while(_m.find(_pos)){
			_list.add(Double.parseDouble(_m.group(1)));
			_pos = _m.end(1);
		}
		
		return _list;
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
		double[][] _m = new double[5][7];
		List<Double> _mm = this.searchNumbers(this.temperatureM);
		for(int _col=0;_col<5;_col++){
			for(int _row=0;_row<7;_row++){
				_m[_col][_row] = _mm.get(_col * 5 + _row);
			}
		}
		
		List<Double> _v = this.searchNumbers(this.temperatureV);
		List<Double> _l = this.searchNumbers(this.temperatureL);
		
		double _lat = location.getY();
		int _y = _v.size() - 1;
		for(int i=0;i<_v.size();i++){
			if(_lat >= _v.get(i)){
				_y = i;
				break;
			}
		}
		
		double _d = _m[_y][_l.size() - 1];
		for(int i=0;i<_l.size() - 1;i++){
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
	private double precipitation4Band(double val, double sourceLat, double targetLat) {
		List<Double> _k1 = this.searchNumbers(this.precipitationGrads1);
		List<Double> _k2 = this.searchNumbers(this.precipitationGrads2);
		
		double _val = 0;
		if(targetLat <= this.precipitationMaxAlt){
			_val = val + _k1.get(date.getMonth()) * (targetLat - sourceLat) / 100.0;
		}
		else{
			_val = val + _k1.get(date.getMonth()) * (this.precipitationMaxAlt - sourceLat) / 100.0 + _k2.get(date.getMonth()) * (targetLat - this.precipitationMaxAlt) / 100.0;
		}
		
		if(_val < 0){
			return 0;
		}
		return _val;
	}

	/**
	 * 根据昌马堡修正的降水梯度计算方法
	 * 
	 * @param val 源降水值
	 * @param sourceLat 源高程
	 * @param targetLat 目标分带高程
	 * @param month 月份
	 * @return
	 */
	@SuppressWarnings("deprecation")
	private double precipitation4Band(double val, double sourceLat, double targetLat, int month, int days) {
		if(month >= 4 && month <= 8){
			if(targetLat < 5100){
				double _val = val + (((targetLat - sourceLat) / 100.0) * 2);
				if(_val < 0)
					_val = 0;
				
				return _val;
			}
			else{
				double _val = val + (((5000 - sourceLat) / 100.0) * 2) + (((targetLat - sourceLat) / 100.0) * 2);
				
				return _val;
			}
		}
		else{
			return val;
		}
	}

//	/**
//	 * 根据昌马堡修正的降水梯度计算方法
//	 * 
//	 * @param val 源降水值
//	 * @param sourceLat 源高程
//	 * @param targetLat 目标分带高程
//	 * @param month 月份
//	 * @return
//	 */
//	@SuppressWarnings("deprecation")
//	private double precipitation4Band2(double val, double sourceLat, double targetLat, int month, int days) {
//		List<Double> _grads = this.searchNumbers(this.precipitationGrads);
//		//修改为100m梯度
//		double _val = val + ((targetLat - sourceLat) / 100.0) * _grads.get(month);
//		
//		if(_val < 0)
//			_val = 0;
//		
//		return _val;
//	}

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
