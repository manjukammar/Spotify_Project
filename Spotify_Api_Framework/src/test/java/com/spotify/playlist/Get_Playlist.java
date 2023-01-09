package com.spotify.playlist;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.spotify.baseutil.BaseTest;
import com.spotify.dataprovider.DataProviderFactory;
import com.spotify.dataprovider.DataProviderFileRowFilter;
import com.spotify.endpoints.Endpoints;
import com.spotify.utils.ApiActionUtil;

import io.restassured.response.Response;

public class Get_Playlist extends BaseTest{


	@DataProviderFileRowFilter(file = "./src/main/resources/data/Data.xlsx", sql = "Select * from SpotifyData where SINO ='playlist'")
	@Test(dataProvider = "data1", dataProviderClass = DataProviderFactory.class, description = "")
	public void playlist(String SINO, String id,String ids,String savedAlbums,String queryparamkey,String pathParam ) {
		
		Response response = ApiActionUtil.getRequest(queryparamkey, prop_constants.getProperty("playlistId"), id, Endpoints.Playlist,prop_constants.getProperty("status_code_200"));
		
		/* Validate json data */
		String actualName = ApiActionUtil.getResponseBodyValue(response, "tracks.items[0].track.album.artists[0].name");
		System.out.println(actualName);
		Assert.assertEquals("Sona Shaboyan", actualName,"List is created with given name");

	}
	
}
