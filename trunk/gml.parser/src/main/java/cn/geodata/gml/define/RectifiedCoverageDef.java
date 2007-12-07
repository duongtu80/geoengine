package cn.geodata.gml.define;

import java.awt.image.Raster;
import java.awt.image.RenderedImage;
import java.awt.image.SampleModel;
import java.io.IOException;
import java.util.logging.Logger;

import org.geotools.coverage.grid.GridCoverage2D;
import org.geotools.geometry.Envelope2D;
import org.jdom.Element;
import org.opengis.coverage.grid.GridGeometry;

import cn.geodata.gml.ParserUtil;
import cn.geodata.gml.UnsupportedType;



/**
 * Encode and parse rectified coverages between GML and geotools.Coverage2D
 * 
 * @author mfeng
 *
 */
public class RectifiedCoverageDef extends AbstractParser {
	private static Logger log = ParserUtil.getLogger();
	
	@Override
	public boolean canEncode(Object obj) {
		if (obj instanceof GridCoverage2D) {
			return true;
		}
		return false;
	}

	@Override
	public boolean canParse(Element ele) {
		if(ele.getNamespace().equals(this.config.getUriGML())
				&& ele.getName().equals("RectifiedCoverage")
				){
			return true;
		}
		return false;
	}
	
	protected String encodeValueList(int[] list){
		StringBuilder _txt = new StringBuilder();
		for(int _v : list){
			if(_txt.length() > 0){
				_txt.append(" ");
			}
			_txt.append(_v);
		}
		
		return _txt.toString();
	}
	
	protected Element encodeRectifiedGrid(GridCoverage2D coverage) throws IOException {
		GridGeometry _grid = coverage.getGridGeometry();
		
		Element _low = new Element("low", this.config.getUriGML());
		_low.setText(this.encodeValueList(_grid.getGridRange().getLower().getCoordinateValues()));
		
		Element _high = new Element("high", this.config.getUriGML());
		_high.setText(this.encodeValueList(_grid.getGridRange().getUpper().getCoordinateValues()));
		
		Element _gridEnvelope = new Element("GridEnvelope", this.config.getUriGML());
		_gridEnvelope.addContent(_low);
		_gridEnvelope.addContent(_high);
		
		Element _limits = new Element("limits", this.config.getUriGML());
		_limits.addContent(_gridEnvelope);
		
		Element _axisNameX = new Element("axisName", this.config.getUriGML());
		_axisNameX.setText("x");
		
		Element _axisNameY = new Element("axisName", this.config.getUriGML());
		_axisNameY.setText("y");
		
		Envelope2D _envelope = coverage.getEnvelope2D();
		
		Element _origin = new Element("origin", this.config.getUriGML());
		_origin.setText(_envelope.getMinX() + "," + _envelope.getMinY());
		
		Element _offsetVector = new Element("offsetVector", this.config.getUriGML());
		_offsetVector.setText(_envelope.getWidth() / _grid.getGridRange().getLength(0) + "," + _envelope.getHeight() / _grid.getGridRange().getLength(1));
		
		Element _rectifiedGrid = new Element("RectifiedGrid", this.config.getUriGML());
		_rectifiedGrid.addContent(_limits);
		_rectifiedGrid.addContent(_axisNameX);
		_rectifiedGrid.addContent(_axisNameY);
		_rectifiedGrid.addContent(_origin);
		_rectifiedGrid.addContent(_offsetVector);
		
		Element _rectifiedGridDomain = new Element("rectifiedGridDomain", this.config.getUriGML());
		_rectifiedGridDomain.addContent(_rectifiedGrid);
		
		return _rectifiedGridDomain;
	}
	
	protected Element encodeRangeSet(GridCoverage2D coverage) throws IOException {
		RenderedImage _image = coverage.getRenderedImage();
		SampleModel _sampleModel = _image.getSampleModel();
//		log.info("Band number:" + _sampleModel.getNumBands());
		
		Element _bandInfo = new Element("rangeParameters", this.config.getUriGML());
		//Add parameters of bands
		for(int _i=0;_i < _sampleModel.getNumBands(); _i++){
			Element _band = new Element("Category", this.config.getUriGML());
			_band.setText("band" + _i);
			
			_bandInfo.addContent(_band);
		}
	
		//Add datablock
		StringBuilder _txt = new StringBuilder();
		for(int _tileX=0;_tileX < _image.getNumXTiles();_tileX++){
			for(int _tileY=0;_tileY < _image.getNumYTiles();_tileY++){
				Raster _raster = _image.getTile(_tileX, _tileY);
				for(int _x=_raster.getMinX();_x<_raster.getMinX() + _raster.getWidth();_x++){
					for(int _y=_raster.getMinY();_y<_raster.getMinY() + _raster.getHeight();_y++){
						StringBuilder _txt2 = new StringBuilder();
						for(int _b=0;_b<_raster.getNumBands();_b++){
							if(_txt2.length() > 0){
								_txt2.append(",");
							}
							_txt2.append(_raster.getSampleFloat(_x, _y, _b));
						}
						
						if(_txt.length() > 0){
							_txt.append(" ");
						}
						_txt.append(_txt2);
					}
				}
			}
		}
		Element _tupleList = new Element("tupleList", this.config.getUriGML());
		_tupleList.setText(_txt.toString());
		
		Element _dataBlock = new Element("DataBlock", this.config.getUriGML());
		_dataBlock.addContent(_tupleList);
		
		Element _rangeSet = new Element("rangeSet", this.config.getUriGML());

		_rangeSet.addContent(_bandInfo);
		_rangeSet.addContent(_dataBlock);
		
		return _rangeSet;
	}

	@Override
	public Element encode(Object obj) throws IOException {
		if(this.canEncode(obj) == false){
			throw new UnsupportedType(obj.toString());
		}
		
		GridCoverage2D _coverage = (GridCoverage2D) obj;
		
		Element _ele = new Element("RectifiedGridCoverage", this.config.getUriGML());
		_ele.addContent(this.encodeRectifiedGrid(_coverage));
		_ele.addContent(this.encodeRangeSet(_coverage));
		
		return _ele;
	}

	@Override
	public Object parse(Element ele) throws IOException {
		if(this.canParse(ele) == false){
			throw new UnsupportedType("Element " + ele.getName());
		}
		
		throw new UnsupportedOperationException("RectifiedCoverage");
//		ArrayList<Coordinate> _list = new ArrayList<Coordinate>();
//		Element _posList = ele.getChild("posList", this.config.getUriGML());
//		int _count = Integer.parseInt(_posList.getAttributeValue("dimension"));
//		
//		String[] _items = _posList.getTextTrim().split("\\s+");
//		for (int i = 0; i < _items.length / _count; i++) {
//			double _x = Double.parseDouble(_items[0]);
//			double _y = Double.parseDouble(_items[1]);
//
//			double _z = 0;
//			if(_items.length > 2){
//				_z = Double.parseDouble(_items[2]);
//			}
//			
//			_list.add(new Coordinate(_x, _y, _z));
//		}
//		
//		GeometryFactory _factory = new GeometryFactory();
//		return _factory.createLineString((Coordinate[])_list.toArray(new Coordinate[0]));
	}
}
