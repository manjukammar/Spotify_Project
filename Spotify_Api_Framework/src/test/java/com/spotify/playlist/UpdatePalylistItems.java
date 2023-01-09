package com.spotify.playlist;

import java.io.File;
import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.spotify.baseutil.BaseTest;
import com.spotify.dataprovider.DataProviderFactory;
import com.spotify.dataprovider.DataProviderFileRowFilter;
import com.spotify.endpoints.Endpoints;
import com.spotify.utils.ApiActionUtil;

public class UpdatePalylistItems extends BaseTest{

	
	@DataProviderFileRowFilter(file = "./src/main/resources/data/Data.xlsx", sql = "Select * from SpotifyData where SINO ='playlist'")
	@Test(dataProvider = "data1", dataProviderClass = DataProviderFactory.class, description = "")
	public void playlist(String SINO, String id,String ids,String savedAlbums,String queryparamkey,String pathParam ) {
	
		File path = new File(prop_constants.getProperty("update_playlist_items"));
		
		ApiActionUtil.putMethodWithBody(queryparamkey, prop_constants.getProperty("playlistId"), id, path,Endpoints.PlaylistItems, prop_constants.getProperty("status_code_201"));

	}
}
