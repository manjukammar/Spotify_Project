package com.spotify.playlist;

import java.util.HashMap;

import org.testng.annotations.Test;

import com.spotify.baseutil.BaseTest;
import com.spotify.dataprovider.DataProviderFactory;
import com.spotify.dataprovider.DataProviderFileRowFilter;
import com.spotify.endpoints.Endpoints;
import com.spotify.utils.ApiActionUtil;

import io.restassured.response.Response;

public class Get_Playlist_Items extends BaseTest{
	
	@DataProviderFileRowFilter(file = "./src/main/resources/data/Data.xlsx", sql = "Select * from SpotifyData where SINO ='playlist'")
	@Test(dataProvider = "data1", dataProviderClass = DataProviderFactory.class, description = "")
	public void playlist(String SINO, String id,String ids,String savedAlbums,String queryparamkey,String pathParam ) {
	
		 ApiActionUtil.getRequest(SINO, prop_constants.getProperty("playlistId"), id, Endpoints.PlaylistItems,prop_constants.getProperty("status_code_200"));

	}
}
