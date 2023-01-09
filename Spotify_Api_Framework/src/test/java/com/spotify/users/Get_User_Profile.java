package com.spotify.users;

import org.testng.annotations.Test;

import com.spotify.baseutil.BaseTest;
import com.spotify.dataprovider.DataProviderFactory;
import com.spotify.dataprovider.DataProviderFileRowFilter;
import com.spotify.endpoints.Endpoints;
import com.spotify.utils.ApiActionUtil;

import io.restassured.response.Response;

public class Get_User_Profile extends BaseTest{
	
	@DataProviderFileRowFilter(file = "./src/main/resources/data/Data.xlsx", sql = "Select * from SpotifyData where SINO ='8)users'")
	@Test(dataProvider = "data1", dataProviderClass = DataProviderFactory.class, description = "")
	public void user(String SINO, String id,String ids,String savedAlbums,String queryparamkey,String pathParam ) {
		
		Response response = ApiActionUtil.getRequest(queryparamkey, prop_constants.getProperty("userid"), id,   Endpoints.UserProfile, prop_constants.getProperty("status_code_200"));
		ApiActionUtil.validateContentType(response, prop_constants.getProperty("content_type_json"));
	
	}

}
