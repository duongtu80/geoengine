import java.util.Arrays;


public class VePoint {
	private double minX = -180;
	private double maxX = 180;
	private double minY = -85.05112878;
	private double maxY = 85.05112878;
	private int tileSize = 256;	
	
	public static void main(String[] args) {
		double longitude = -80.77467;
		double latitude = 26.07560;
		
//		double longitude = -115.13779163360595;
//		double latitude = 36.11354072045737;
		int level = 8;
		
		VePoint _ve = new VePoint();
		System.out.println("Tile:" + Arrays.toString(_ve.getTileNum(longitude, latitude, level)));
		System.out.println("Pixel Position:" + Arrays.toString(_ve.getPixelInTile(longitude, latitude, level)));		
		System.out.println("Virtual Earth Tile:" + _ve.getTileUrl(_ve.getTileNum(longitude, latitude, level), level));	
	}
	
	/**
	 * Project latitude to map distance from top to there
	 *  
	 * @param latitude
	 * @return
	 */
	public double projectLatitude(double latitude){		
		return Math.PI - Math.log(
				Math.tan(
					Math.PI / 4 + 
					Math.toRadians(latitude) / 2
				)
			);
	}
	
	/**
	 * Get the tile num for given location and level
	 * 
	 * @param longitude
	 * @param latitude
	 * @param level
	 * @return
	 */
	public int[] getTileNum(double longitude, double latitude, int level){
		double _x = (longitude - minX) / getResolutionX(level);
		double _y = this.projectLatitude(latitude) / this.getResolutionY(level);
		
		int _cellX = (int) Math.floor(_x);
		int _cellY = (int) Math.floor(_y);
		
		return new int[] {_cellX, _cellY};
	}
	
	/**
	 * Get pixel location in the tile
	 * 
	 * @param longitude
	 * @param latitude
	 * @param level
	 * @return
	 */
	public int[] getPixelInTile(double longitude, double latitude, int level){
		int[] _tileLoc = this.getTileNum(longitude, latitude, level);
		
		int _pixelX = (int) Math.floor((longitude - minX) * tileSize / this.getResolutionX(level));
		int _pixelY = (int) Math.floor(tileSize * this.projectLatitude(latitude) / this.getResolutionY(level));
		
		int _tileX = _pixelX - (_tileLoc[0] * tileSize);
		int _tileY = _pixelY - (_tileLoc[1] * tileSize);
		
		return new int[] {_tileX, _tileY};
	}

	/**
	 * Get the tile image url
	 * 
	 * @param tileLoc
	 * @param level
	 * @return
	 */
	public String getTileUrl(int[] tileLoc, int level) {
		int _tileX = tileLoc[0];
		int _tileY = tileLoc[1];
		
		StringBuilder _txt = new StringBuilder();
		for(int i=level;i >= 0;i--){
			int _offsetX = _tileX % 2;
			int _offsetY = _tileY % 2;
			
			_txt.append(_offsetX + _offsetY * 2);
			
			_tileX = (_tileX - _offsetX) / 2;
			_tileY = (_tileY - _offsetY) / 2;
		}
		
		String _url = "http://r0.ortho.tiles.virtualearth.net/tiles/r" + _txt.reverse().toString() + "?g=104&shading=hill";
		return _url;
	}

	private double getResolutionX(int level){
		return (maxX - minX) / Math.pow(2, level + 1); 
	}
	
	private double getResolutionY(int level){
		return Math.PI / Math.pow(2, level);
	}

}
