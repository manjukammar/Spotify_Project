package com.spotify.albums;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.spotify.baseutil.BaseTest;
import com.spotify.dataprovider.DataProviderFactory;
import com.spotify.dataprovider.DataProviderFileRowFilter;
import com.spotify.endpoints.Endpoints;
import com.spotify.utils.ApiActionUtil;

import io.restassured.response.Response;

public class Get_A_Album extends BaseTest {

	@DataProviderFileRowFilter(file = "./src/main/resources/data/Data.xlsx", sql = "Select * from SpotifyData where SINO ='album'")
	@Test(dataProvider = "data1", dataProviderClass = DataProviderFactory.class, description = "")
	public void album(String SINO, String id, String ids, String savedAlbums, String queryparamkey, String pathParam) {

//		HashMap<String, String> path_Param_Map = new HashMap<String, String>();
//		path_Param_Map.put("id", id);

		// Response response = ApiActionUtil.getMethodWithPathParam(path_Param_Map,
		// Endpoints.Album,
		// prop_constants.getProperty("status_code_200"),
		// prop_constants.getProperty("content_type_json"));
		

		Response response = ApiActionUtil.getRequest(queryparamkey, prop_constants.getProperty("id"), id, Endpoints.Album,
				prop_constants.getProperty("status_code_200"));

		/* Validate json data */
		String actualName = ApiActionUtil.getResponseBodyValue(response, "name");
		System.out.println(actualName);
		Assert.assertEquals(prop_constants.getProperty("album_song"), actualName,"List is created with given name");
	}

}
