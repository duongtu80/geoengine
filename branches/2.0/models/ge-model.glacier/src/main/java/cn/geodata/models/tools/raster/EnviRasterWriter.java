package cn.geodata.models.tools.raster;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.apache.commons.io.IOUtils;
import org.geotools.geometry.Envelope2D;


public class EnviRasterWriter {
	private static Logger log = Logger.getAnonymousLogger();
	
	private String id;
	
	private Envelope2D envelope;
	private int rowCount;
	private int colCount;
	private double cellSize;
	
	private File output;
	private FileOutputStream fileStream;
	private byte[] buffer;
	private int bufferPos;
	private int bufferSize;
	private int dataType;
	
	public EnviRasterWriter(String id, int dataType, Envelope2D envelope, int rowCount, int colCount, double cellSize, File out) throws IOException{
		this.id = id;
		
		this.cellSize = cellSize;
		this.envelope = envelope;
		this.rowCount = rowCount;
		this.colCount = colCount;
		this.output = out;

		this.bufferSize = 1024 * 1024 * 10;
		this.buffer = new byte[bufferSize];
		this.bufferPos = 0;
		this.dataType = dataType;
	}

	public Envelope2D getEnvelope() {
		return envelope;
	}

	public int getRow() {
		return rowCount;
	}

	public int getCol() {
		return colCount;
	}
	
	public String generateId(String layer, int path, int row){
		DecimalFormat _format = new DecimalFormat("000");
		return layer + _format.format(path) + _format.format(row);
	}

	protected void flush() throws IOException{
		if(this.bufferPos > 0){
			this.fileStream.write(this.buffer, 0, this.bufferPos);
			this.bufferPos = 0;
		}
	}
	
	public void outputByte(byte b) throws IOException{
		if(this.bufferPos >= this.bufferSize - 1){
			this.flush();
		}
		
		this.buffer[this.bufferPos++] = b;
	}
	
	public void outputEnvi(int val) throws IOException{
		if(this.bufferPos >= this.bufferSize - 1){
			this.flush();
		}
		
		if(this.dataType == 12){
			this.buffer[this.bufferPos++] = (byte)(val & 0xFF);
			this.buffer[this.bufferPos++] = (byte)((val & 0xFF00) >> 8);
		}
		else if(this.dataType == 1){
			this.buffer[this.bufferPos++] = (byte)(val & 0xFF);
		}
		else{
			throw new IOException("Unsupport data type " + this.dataType);
		}
//		this.buffer[this.bufferPos++] = (byte)((val & 0xFF00) >> 8);
//		IOUtils.write(new byte[]{(byte)(val & 0xFF), (byte)((val & 0xFF00) >> 8)}
//			, this.fileStream);
//		short _v = (short) val;
//		
//		ByteArrayOutputStream _stream = new ByteArrayOutputStream();
//		DataOutputStream _ss = new DataOutputStream(_stream);
//		
//		_ss.writeShort(val);
//		byte[] _bs = _stream.toByteArray();
//		
//		log.info((val & 0xFF) + "," + ((val & 0xFF00) >> 8));
//		log.info(_bs[0] + "," + _bs[1]);
//		byte _t = _bs[0];
//		_bs[0] = _bs[1];
//		_bs[1] = _t;
//		
//		_ss.close();
//		_stream.close();
//		
//		IOUtils.write(_bs, this.fileStream);
	}

	public void outputEnvi(float val) throws IOException{
		if(this.bufferPos >= this.bufferSize - 1){
			this.flush();
		}
		
		if(this.dataType == 4){
			ByteBuffer _bytes = ByteBuffer.allocate(4);
			_bytes.putFloat(val);
			
			byte[] _array = _bytes.array();
			for(int i=0;i<4;i++){
				this.buffer[this.bufferPos++] = _array[4-i-1]; 				
			}
		}
		else{
			throw new IOException("Unsupport data type " + this.dataType);
		}
	}
	
	public void writeHeader() throws IOException {
		log.info("Write header file");

		File _header = new File(this.output, this.id + ".hdr");
		
		List<String> _lines = new ArrayList<String>();
		_lines.add("ENVI");
		_lines.add("description = {");
		_lines.add(this.id + "}");
		_lines.add("samples = " + this.colCount);
		_lines.add("lines = " + this.rowCount);
		_lines.add("bands = " + 1);
		_lines.add("header offset = " + 0);
		_lines.add("file type = ENVI Standard");
		_lines.add("data type = " + this.dataType);
		_lines.add("interleave = BIL");
		_lines.add("sensor type = Unknown");
		if(this.envelope != null){
			_lines.add("map info = {Geographic Lat/Lon, 1.0000, 1.0000, " + this.envelope.getMinX() + ", " + this.envelope.getMaxY() + 
					", " + cellSize + ", " + cellSize + ", WGS-84, units=Degrees}");
		}
//		_lines.add("projection info = {9, 6378137.0, 6356752.3, 23.000000, -96.000000, " +
//				"0.0, 0.0, 29.500000, 45.500000, North America 1983, Albers Conical Equal Area, units=Meters}");
		_lines.add("wavelength units = Unknown");
		_lines.add("byte order = 0");
		_lines.add("band names = {" + "dem" + "}");
		
		FileOutputStream _stream = new FileOutputStream(_header);
		IOUtils.writeLines(_lines, "\n", _stream);
		_stream.close();
	}
	
	public void close() throws IOException{
		if(this.fileStream != null){
			this.flush();
			
			this.fileStream.flush();
			this.fileStream.close();
		}
	}

	public File start() throws IOException {
		this.close();
		File _f = new File(this.output, this.id);
		fileStream = new FileOutputStream(_f);
		
		return _f;
	}
	
	
}
