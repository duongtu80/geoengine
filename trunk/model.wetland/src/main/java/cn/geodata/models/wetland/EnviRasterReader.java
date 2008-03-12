package cn.geodata.models.wetland;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.geotools.geometry.DirectPosition2D;
import org.geotools.geometry.Envelope2D;

import com.vividsolutions.jts.geom.Coordinate;

public class EnviRasterReader {
	private static Logger log = Logger.getAnonymousLogger();
	
	private Envelope2D envelope;
	private int rowCount;
	private int colCount;
	private double cellSize;
	private int dataType;
	private byte[] buffer;
	private long bufferPos;
	private int bufferLen;
	
	private File input;
	private Map<String, String> params;
	
	public EnviRasterReader(File input, int bufferSize) throws IOException{
		this.input = input;
		this.params = this.readHeader(new File(input.getAbsolutePath() + ".hdr"));
		
		this.rowCount = Integer.parseInt(this.params.get("lines"));
		this.colCount = Integer.parseInt(this.params.get("samples"));
		this.dataType = Integer.parseInt(this.params.get("data type"));
		String[] _mapParts = this.params.get("map info").split(",");
		this.cellSize = Double.parseDouble(_mapParts[5]);
		
		double _xmin = Double.parseDouble(_mapParts[3]);
		double _xmax = _xmin + colCount * cellSize; 
		double _ymax = Double.parseDouble(_mapParts[4]);
		double _ymin = _ymax - rowCount * cellSize;
		
		this.envelope = new Envelope2D(new DirectPosition2D(_xmin, _ymin), new DirectPosition2D(_xmax, _ymax));
		this.buffer = new byte[bufferSize];
		this.bufferPos = 0;
		this.bufferLen = 0;
	}
	
	public int readInt(int row, int col) throws IOException{
		int _byteSize = this.getByteSize();
		byte[] _buffer = new byte[_byteSize];
		long _pos = (row * this.colCount + col) * _byteSize;
		
		if(_pos < this.bufferPos || (_pos + _byteSize) > (this.bufferPos + this.bufferLen)){
//			throw new IOException("error:" + row + "," + col);
			this.initBuffer(_pos);
		}
		
		int _iPos = (int) (_pos - this.bufferPos);
		for(int i=0;i<_byteSize;i++){
			_buffer[i] = this.buffer[_iPos + i];
		}
		
		return this.getValueFromBufferInt(_buffer);
	}

	public float readFloat(int row, int col) throws IOException{
		int _byteSize = this.getByteSize();
		
		if(_byteSize != 4){
			throw new IOException("Call readInt(...) function");
		}
		
		byte[] _buffer = new byte[_byteSize];
		long _pos = (row * this.colCount + col) * _byteSize;
		
		if(_pos < this.bufferPos || (_pos + _byteSize) > (this.bufferPos + this.bufferLen)){
//			throw new IOException("error:" + row + "," + col);
			this.initBuffer(_pos);
		}
		
		int _iPos = (int) (_pos - this.bufferPos);
		for(int i=0;i<_byteSize;i++){
			_buffer[i] = this.buffer[_iPos + i];
		}
		
		if(this.dataType == 4){
			byte[] _tmp = new byte[]{_buffer[3], _buffer[2], _buffer[1], _buffer[0]};
//			byte[] _tmp = new byte[]{buffer[0], buffer[1], buffer[2], buffer[3]};

			ByteBuffer _bytes = ByteBuffer.allocate(4);
			_bytes.put(_tmp);
			
			return _bytes.getFloat(0);
		}
		else{
			throw new IOException("Unsupported data type");
		}
	}
	
	public double getLongitude(int col){
		return this.getEnvelope().getMinX() + col * this.getCellSize() + this.getCellSize() / 2;
	}
	
	public double getLatitude(int row){
		return this.getEnvelope().getMaxY() - row * this.getCellSize() - this.getCellSize() / 2;
	}
	
	public Coordinate getLocation(int row, int col){
		return new Coordinate(this.getLongitude(col), this.getLatitude(row));
	}

	public void setValue(int row, int col) throws IOException{
		long _pos = (row * this.colCount + col);		
		if(_pos >= this.bufferPos && (_pos + this.cellSize ) <= (this.bufferPos + this.bufferLen)){
			int _iPos = (int) (_pos - this.bufferPos);
			this.buffer[_iPos] = 2;
		}
	}

	public boolean cached(int row, int col) throws IOException{
		long _pos = (row * this.colCount + col);		
		if(_pos >= this.bufferPos && (_pos + this.cellSize ) <= (this.bufferPos + this.bufferLen)){
			return true;
		}
		else{
			return false;
		}
	}

	public void initBuffer(long pos) throws IOException{
		FileInputStream _stream = FileUtils.openInputStream(this.input);
		try{
			long _pos = pos;// - this.buffer.length / 2;
			if(_pos < 0)
				_pos = 0;
			
			long _len = this.buffer.length;
			long _gridLen = this.colCount * this.rowCount * this.getByteSize();
			if(_pos + _len > _gridLen){
				_len = _gridLen - _pos;
			}
			
			_stream.skip(_pos);
			this.bufferLen = _stream.read(this.buffer, 0, (int)_len);
			if(this.bufferLen != _len){
				throw new IOException("Buffer len error:" + this.bufferLen + "," + _len);
			}
			
			this.bufferPos = _pos;
		}
		finally{
			_stream.close();
		}
	}
	
	protected int getValueFromBufferInt(byte[] buffer) throws IOException{
		if(this.dataType == 1){
			return buffer[0];
		}
		else if(this.dataType == 12){
			byte[] _tmp = new byte[]{buffer[1], buffer[0]};
			BigInteger _byte = new BigInteger(_tmp);
			
			return _byte.intValue();
//			return buffer[0] + (buffer[1] << 8);
		}
		else if(this.dataType == 2){
//			byte[] _tmp = new byte[]{buffer[1], buffer[0]};
//			DataInputStream _stream = new DataInputStream(new ByteArrayInputStream(_tmp));
//
//			return _stream.readShort();
			byte[] _tmp = new byte[]{buffer[1], buffer[0]};
			BigInteger _byte = new BigInteger(_tmp);
			
			return _byte.intValue();
		}
		else{
			throw new IOException("Unsupported data type");
		}
	}
	
	protected int getByteSize() throws IOException{
		if(this.dataType == 1){
			return 1;
		}
		else if(this.dataType == 2 || this.dataType == 12){
			return 2;
		}
		else if(this.dataType == 4){
			return 4;
		}
		else{
			throw new IOException("Unsupported data type");
		}
	}
	
	protected Map<String, String> readHeader(File input) throws IOException{
		Map<String, String> _params = new HashMap<String, String>();
		List<String> _list = FileUtils.readLines(input);
		
		Pattern _p1 = Pattern.compile("\\s*([^=]+)=\\s*\\{\\s*(.*)");
		Pattern _p2 = Pattern.compile("\\s*([^=]+)=\\s*(.*)");
		
		String _key = null;
		StringBuilder _txt = null;
		for(int i=0;i<_list.size();i++){
			String _line = _list.get(i).trim();
			if(_txt == null){
				if(_line.contains("{")){
					Matcher _m = _p1.matcher(_line);
					if(_m.matches()){
						_key = _m.group(1).trim().toLowerCase();
						_txt = new StringBuilder(_m.group(2).trim());
					}
					else{
						throw new IOException("Failed to parse the parameter");
					}
				}
				else{
					Matcher _m = _p2.matcher(_line);
					if(_m.matches()){
						_params.put(_m.group(1).trim().toLowerCase(), _m.group(2).trim());
					}
					else{
						log.info("skip " + _line);
//						throw new IOException("Failed to parse the parameter");
					}
				}
			}
			else{
				_txt.append(" " + _line);
			}
			if(_line.endsWith("}")){
				_txt.deleteCharAt(_txt.length() - 1);
				
				_params.put(_key, _txt.toString());
				_txt = null;
				_key = null;
			}
		}
		
		return _params;
	}

	public Envelope2D getEnvelope() {
		return envelope;
	}

	public int getRowCount() {
		return rowCount;
	}

	public int getColCount() {
		return colCount;
	}

	public double getCellSize() {
		return cellSize;
	}

	public File getInput() {
		return input;
	}

	public Map<String, String> getParams() {
		return params;
	}

	public byte[] getBuffer() {
		return buffer;
	}

	public long getBufferPos() {
		return bufferPos;
	}

	public int getBufferLen() {
		return bufferLen;
	}
}
