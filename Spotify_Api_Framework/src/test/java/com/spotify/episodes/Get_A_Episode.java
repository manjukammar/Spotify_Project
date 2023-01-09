package com.spotify.episodes;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.spotify.baseutil.BaseTest;
import com.spotify.dataprovider.DataProviderFactory;
import com.spotify.dataprovider.DataProviderFileRowFilter;
import com.spotify.endpoints.Endpoints;
import com.spotify.utils.ApiActionUtil;

import io.restassured.response.Response;

public class Get_A_Episode extends BaseTest{
	
	@DataProviderFileRowFilter(file = "./src/main/resources/data/Data.xlsx", sql = "Select * from SpotifyData where SINO ='6)episode'")
	@Test(dataProvider = "data1", dataProviderClass = DataProviderFactory.class, description = "")
	public void shows(String SINO, String id,String ids,String savedAlbums,String queryparamkey,String pathParam ) {
		
		Response response = ApiActionUtil.getRequest(queryparamkey, prop_constants.getProperty("id"), id, Endpoints.Episode,prop_constants.getProperty("status_code_200"));
		
		String episodeName = ApiActionUtil.getResponseBodyValue(response, "name");
		System.out.println(episodeName);
		Assert.assertEquals(episodeName, prop_constants.getProperty("episodeName"));
		
	}
}
