package cn.geodata.models.glacier.actions.map;

import junit.framework.TestCase;

public class GlacierAreaTest extends TestCase {
	public void testTest1() throws Exception {
		GlacierArea
			.main(new String[] {
					"c:\\mfeng\\tools\\DropboxPortable\\Dropbox\\data\\glacier\\data\\basin.shp",
					"站点", "c:\\mfeng\\tools\\DropboxPortable\\Dropbox\\data\\glacier\\data\\shulehe_Project.shp",
					"c:\\mfeng\\test\\glacier\\area-091031", "100"});
	}
}
