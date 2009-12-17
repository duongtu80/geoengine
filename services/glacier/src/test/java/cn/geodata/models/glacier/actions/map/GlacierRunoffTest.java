package cn.geodata.models.glacier.actions.map;

import junit.framework.TestCase;

public class GlacierRunoffTest extends TestCase {
	public void testTest1() throws Exception {
		GlacierRunoff
				.main(new String[] {
						"c:\\mfeng\\tools\\DropboxPortable\\Dropbox\\data\\glacier\\data\\basin.shp",
						"站点", "1995", "2000",
						"c:\\mfeng\\test\\glacier\\091119" });
	}
}
