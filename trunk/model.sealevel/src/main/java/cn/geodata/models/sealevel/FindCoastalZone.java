package cn.geodata.models.sealevel;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.geotools.data.DataStore;
import org.geotools.data.FeatureSource;
import org.geotools.data.shapefile.ShapefileDataStore;
import org.geotools.feature.FeatureIterator;
import org.geotools.geometry.Envelope2D;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.MultiPolygon;

public class FindCoastalZone {
	private int bufferSize = 43200 * 500; //50 * 1024 * 1024;
	public static String version = "0.7.0";
	
	public static void main(String[] args) throws IOException {
		System.out.println("version " + FindCoastalZone.version);
		(new FindCoastalZone()).execute2(5);
	}
	
	public FeatureSource getTmFeatureSource() throws IOException {
		File _f = new File("d:\\mfeng\\data\\tmp\\coastal.shp");
		DataStore _dataStore = new ShapefileDataStore(_f.toURL());
		return _dataStore.getFeatureSource(_dataStore.getTypeNames()[0]);
	}
	
	public List<MultiPolygon> loadCoastalLines() throws IOException{
		List<MultiPolygon> _list = new ArrayList<MultiPolygon>();
		FeatureIterator _it = this.getTmFeatureSource().getFeatures().features();
		try{
			while(_it.hasNext()){
				_list.add((MultiPolygon)_it.next().getDefaultGeometry());
			}
			
			return _list;
		}
		finally{
			_it.close();
		}
	}
	
//	public boolean coastalLocation(List<MultiPolygon> list, Coordinate c) throws IOException{
//		GeometryFactory _geometryFactory = new GeometryFactory();
//		Point _pt = _geometryFactory.createPoint(c);
//		
//		for(MultiPolygon _k : list){
//			if(_k.contains(_pt)){
////				System.out.println("find");
//				return true;
//			}
////			double _d = _k.distance(_pt);
////			if(_d < 1){
////				return true;
////			}
////			double _d = _k.distance(_pt);
////			System.out.println("dist:" + _d);
////			if(_d < 1){
////				return true;
////			}
//		}
//		return false;
//	}
	
	public boolean coastalLocation(EnviRasterReader reader, Coordinate c) throws IOException {
		int _col = (int)Math.floor((c.x - reader.getEnvelope().getMinX()) / reader.getCellSize());
		int _row = (int)Math.floor((reader.getEnvelope().getMaxY() - c.y) / reader.getCellSize());
		
		int _x1 = _col - 10;
		int _x2 = _col + 10;
		int _y1 = _row - 10;
		int _y2 = _row + 10;
		
		if(_x1 < 0)
			_x1 = 0;
		if(_x2 > reader.getColCount() - 1)
			_x2 = reader.getRowCount() - 1;
		if(_y1 < 0)
			_y1 = 0;
		if(_y2 > reader.getRowCount() - 1)
			_y2 = reader.getColCount() - 1;
		
		for(int _y=_y1;_y<_y2;_y++)
			for(int _x = _x1; _x < _x2;_x++){
				int _val = reader.read(_y, _x);
				if(_val <= -9999){
					return true;
				}
			}
		
		return false;
	}

	public void execute2(double seaLevel) throws IOException {
//		EnviRasterReader _reader = new EnviRasterReader(new File("d:\\mfeng\\data\\dem\\tmp\\011008\\dem\\dem60"), this.bufferSize);
		EnviRasterReader _coastal = new EnviRasterReader(new File("d:\\mfeng\\data\\dem\\global\\global_dem_1000"), this.bufferSize);
		
		for(String _key : _coastal.getParams().keySet()){
			System.out.println(_key + "=" + _coastal.getParams().get(_key));
		}
		
//		List<MultiPolygon> _list = this.loadCoastalLines();
		double _cellSize = _coastal.getCellSize();
		Envelope2D _env = _coastal.getEnvelope();
		
		File _output = new File("D:\\mfeng\\data\\dem\\tmp\\080116\\global");
		EnviRasterWriter _writer = new EnviRasterWriter("dem60", 1, _env, _coastal.getRowCount(), _coastal.getColCount(), _coastal.getCellSize(), _output);
		_writer.writeHeader();
		File _seed = _writer.start();

		long[] _count = new long[]{0,0,0};
		
		DecimalFormat _format = new DecimalFormat("0.0");
		try{
			double _y = _env.getMaxY() - _cellSize / 2;
			for(int _row=0;_row < _coastal.getRowCount();_row++){
				if(_row % 5 == 0)
					System.out.print("\r" + _format.format(_row * 100.0 / _coastal.getRowCount()) + "%");
				
				double _x = _env.getMinX() + _cellSize / 2;
				for(int _col=0;_col<_coastal.getColCount();_col++){
					int _val = _coastal.read(_row, _col);
					if(_val > seaLevel){
						_val = this.validateValue(_coastal, _row, _col, _x, _y);
						if(_val == 2){
							_coastal.setValue(_row, _col);
						}
//						System.out.println(_row + " " + _col + "=" + _val);
					}
					_count[_val] ++;
					_writer.outputEnvi(_val);
					
					_x += _cellSize;
				}
				_y -= _cellSize;
			}
			System.out.println("\nFinished.");
		}
		finally{
			_writer.close();
		}
		
		for(int i=0;i<3;i++){
			System.out.println(i + "=" + _count[i]);
		}
		processImage(_output, _seed, 0);
	}
	
	public void execute3() throws IOException {
		File _output = new File("D:\\mfeng\\data\\dem\\tmp\\080116\\global");
		File _seed = new File("D:\\mfeng\\data\\dem\\tmp\\080116\\global\\dem60");

		processImage(_output, _seed, 0);
	}
	
	public void processImage(File output, File seed, int loop) throws IOException{
		System.out.println("Output loop image " + loop + " ...");
		
		EnviRasterReader _reader = new EnviRasterReader(seed, ((loop % 3) + 4) * this.bufferSize);
		Envelope2D _env = _reader.getEnvelope();

		DecimalFormat _outFormat = new DecimalFormat("000");
		EnviRasterWriter _writer = new EnviRasterWriter("outputdem" + _outFormat.format(loop), 1, _env, _reader.getRowCount(), _reader.getColCount(), _reader.getCellSize(), output);
		_writer.writeHeader();
		File _writeFile = _writer.start();

		long[] _count = new long[]{0,0,0};
		long _newCount = 0;
		DecimalFormat _format = new DecimalFormat("0.0");
		try{
//			int _row1, _row2, _rowSign;
//			int _col1, _col2, _colSign;
//			
//			if(loop % 4 == 1){
//				_row1 = _reader.getRowCount() - 1;
//				_row2 = 0 - 1;
//				_rowSign = -1;
//
//				_col1 = 0;
//				_col2 = _reader.getColCount();
//				_colSign = 1;
//			}
//			else if(loop % 4 == 2){
//				_row1 = _reader.getRowCount() - 1;
//				_row2 = 0 - 1;
//				_rowSign = -1;
//
//				_col1 = _reader.getColCount() - 1;
//				_col2 = 0 - 1;
//				_colSign = -1;
//			}
//			else if(loop % 4 == 3){
//				_row1 = 0;
//				_row2 = _reader.getRowCount();
//				_rowSign = 1;
//
//				_col1 = _reader.getColCount() - 1;
//				_col2 = 0 - 1;
//				_colSign = -1;
//			}
//			else{
//				_row1 = 0;
//				_row2 = _reader.getRowCount();
//				_rowSign = 1;
//
//				_col1 = 0;
//				_col2 = _reader.getColCount();
//				_colSign = 1;
//			}
			
			int _row=0;
			int _col=0;
			long _pos = 0;
			while(_pos < _reader.getRowCount() * _reader.getColCount() * _reader.getByteSize()){
//				if(_row > 0){
//					_row -= 5;
//					_pos -= _reader.getColCount() * 5;
//				}
				
				_reader.initBuffer(_pos);
				
				for(int _p=0;_p<_reader.getBufferLen();_p++){
					if(_col >= _reader.getColCount()){
						_col = 0;
						_row ++;

						if(_row % 5 == 0)
							System.out.print("\r" + _format.format(_row * 100.0 / _reader.getRowCount()) + "%");
					}
					
					int _val = _reader.read(_row, _col);
					if(_val == 1){
						_val = this.getNeighborPixels(_reader, _row, _col);
						if(_val == 2){
							_reader.setValue(_row, _col);
							_newCount++;
						}
					}
					if(_val == 2){
						_newCount += this.updateCell2(_reader, _row, _col);
					}
					
					_col ++;
				}
				
				byte[] _buffer = _reader.getBuffer();
				for(int _p=0;_p<_reader.getBufferLen();_p++){
					_writer.outputEnvi(_buffer[_p]);
				}
				_pos += _reader.getBufferLen();
			}
			
//			for(int _row=0;_row < _reader.getRowCount();_row++){
//				if(_row % 5 == 0)
//					System.out.print("\r" + _format.format(_row * 100.0 / _reader.getRowCount()) + "%");
//
//				for(int _col=0;_col < _reader.getColCount();_col++){
//					int _val = _reader.read(_row, _col);
//					if(_val == 1){
//						_val = this.getNeighborPixels(_reader, _row, _col);
//						if(_val == 2){
//							_newCount += this.updateCell(_reader, _row, _col);
////							_newCount++;
////							_reader.setValue(_row, _col);
//						}
//					}
//					_count[_val] ++;
//					_writer.outputEnvi(_val);					
//				}
//			}
//			int _row = _row1;
//			while(_row != _row2){
//				if(_row % 5 == 0)
//					System.out.print("\r" + _format.format(Math.abs(_row - _row1) * 100.0 / _reader.getRowCount()) + "%");
//				
//				int _col = _col1;
//				while(_col != _col2){
//					int _val = _reader.read(_row, _col);
//					if(_val == 1){
//						_val = this.getNeighborPixels(_reader, _row, _col);
//						if(_val == 2){
//							_newCount += this.updateCell(_reader, _row, _col);
////							_newCount++;
////							_reader.setValue(_row, _col);
//						}
//					}
//					_count[_val] ++;
//					_writer.outputEnvi(_val);
//					
//					_col += _colSign;
//				}
//				_row += _rowSign;
//			}
			System.out.println("\nFinished.");
		}
		finally{
			_writer.close();
		}
		
		for(int i=0;i<3;i++){
			System.out.println(i + "=" + _count[i]);
		}
		System.out.println("New pixels " + _newCount);
		
		if(_newCount > 0 || loop < 3){
			if(loop > 100){
				throw new IOException("Still can not found the end :(");
			}
			this.processImage(output, _writeFile, loop + 1);
		}
	}
	
	protected int updateCell2(EnviRasterReader reader, int row, int col) throws IOException {
		Stack<int[]> _stack = new Stack<int[]>();
		_stack.add(new int[]{row, col});
		
		int _count = 0;
		while(_stack.size() > 0){
			int[] _loc = _stack.pop();
			
//			if(reader.cached(_loc[0], _loc[1]) == false){
//				return 0;
//			}
//			
//			if(reader.read(_loc[0], _loc[1]) != 1){
//				return 0;
//			}
			int _y1 = _loc[0] - 1;
			int _y2 = _loc[0] + 1;
			int _x1 = _loc[1] - 1;
			int _x2 = _loc[1] + 1;
			
			if(_x1 < 0)
				_x1 = 0;
			if(_x2 > reader.getColCount() - 1)
				_x2 = reader.getColCount() - 1;
			if(_y1 < 0)
				_y1 = 0;
			if(_y2 > reader.getRowCount() - 1)
				_y2 = reader.getRowCount() - 1;
			
			for(int _y=_y1;_y<=_y2;_y++){
				for(int _x = _x1; _x <= _x2;_x++){
					if((_y != _loc[0]) || (_x != _loc[1])){
						if(reader.cached(_y, _x)){
							if(reader.read(_y, _x) == 1){
								_stack.add(new int[]{_y, _x});
								
								reader.setValue(_y, _x);
								_count ++;
							}
						}
					}
				}
			}
		}
		
		return _count;
	}
	
	protected int updateCell(EnviRasterReader reader, int row, int col) throws IOException {
		if(reader.cached(row, col) == false){
			return 0;
		}
		
		if(reader.read(row, col) != 1){
			return 0;
		}
		reader.setValue(row, col);
		
		int _x1 = col - 1;
		int _x2 = col + 1;
		int _y1 = row - 1;
		int _y2 = row + 1;
		
		if(_x1 < 0)
			_x1 = 0;
		if(_x2 > reader.getColCount() - 1)
			_x2 = reader.getColCount() - 1;
		if(_y1 < 0)
			_y1 = 0;
		if(_y2 > reader.getRowCount() - 1)
			_y2 = reader.getRowCount() - 1;
		
		int _count = 0;
		for(int _y=_y1;_y<=_y2;_y++)
			for(int _x = _x1; _x <= _x2;_x++){
				if(_y != row || _x != col){
					if(reader.cached(_y, _x)){
						if(reader.read(_y, _x) == 1)
							_count += this.updateCell(reader, _y, _x);
					}
				}
			}
		
		return _count;
	}
	
	protected int validateValue(EnviRasterReader coastal, int row, int col, double x, double y) throws IOException{
		int _nval = this.getNeighborPixels(coastal, row, col);
		if(_nval == 2){
//			System.out.println("2");
			return 2;
		}
		if(_nval == 0){
//			System.out.println("0");
			return 0;
		}
		if(this.coastalLocation(coastal, new Coordinate(x, y))){
//			System.out.println("3");
			return 2;
		}
		return 1;
	}
	
	protected int getNeighborPixels(EnviRasterReader reader, int row, int col) throws IOException{
		int _x1 = col - 1;
		int _x2 = col + 1;
		int _y1 = row - 1;
		int _y2 = row + 1;
		
		if(_x1 < 0)
			_x1 = 0;
		if(_x2 > reader.getColCount() - 1)
			_x2 = reader.getColCount() - 1;
		if(_y1 < 0)
			_y1 = 0;
		if(_y2 > reader.getRowCount() - 1)
			_y2 = reader.getRowCount() - 1;
		
		int _maxVal = 0;
		for(int _y=_y1;_y<=_y2;_y++)
			for(int _x = _x1; _x <= _x2;_x++){
				if((_y != row) || (_x != col)){
					if(reader.cached(_y, _x)){
						int _val = reader.read(_y, _x);
						if(_val == 2){
							return 2;
						}
						if(_maxVal < _val){
							_maxVal = _val;
						}
					}
				}
			}
		
		return _maxVal;
	}
}
