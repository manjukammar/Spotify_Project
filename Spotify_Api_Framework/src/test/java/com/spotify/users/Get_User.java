package com.spotify.users;

import org.testng.annotations.Test;

import com.spotify.baseutil.BaseTest;
import com.spotify.dataprovider.DataProviderFactory;
import com.spotify.dataprovider.DataProviderFileRowFilter;
import com.spotify.endpoints.Endpoints;
import com.spotify.utils.ApiActionUtil;

public class Get_User extends BaseTest{
	
	@DataProviderFileRowFilter(file = "./src/main/resources/data/Data.xlsx", sql = "Select * from SpotifyData where SINO ='2'")
	@Test(dataProvider = "data1", dataProviderClass = DataProviderFactory.class, description = "")
	public void user(String SINO, String id,String albumids,String savedAlbums,String queryparamkey,String pathParam ) {

		
		ApiActionUtil.getMethod(Endpoints.User, prop_constants.getProperty("status_code_200"), prop_constants.getProperty("content_type_json"));
	
	}

}
