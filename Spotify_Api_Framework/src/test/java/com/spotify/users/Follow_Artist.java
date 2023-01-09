package com.spotify.users;

import java.io.File;

import org.testng.annotations.Test;

import com.spotify.baseutil.BaseTest;
import com.spotify.dataprovider.DataProviderFactory;
import com.spotify.dataprovider.DataProviderFileRowFilter;
import com.spotify.endpoints.Endpoints;
import com.spotify.utils.ApiActionUtil;

public class Follow_Artist extends BaseTest{
	
	@DataProviderFileRowFilter(file = "./src/main/resources/data/Data.xlsx", sql = "Select * from SpotifyData where SINO ='8)users'")
	@Test(dataProvider = "data1", dataProviderClass = DataProviderFactory.class, description = "")
	public void user(String SINO, String id,String albumids,String savedAlbums,String queryparamkey,String pathParam ) {

		File path = new File(prop_constants.getProperty("follow_artis"));
		ApiActionUtil.putMethodWithBody(queryparamkey, pathParam, albumids, path,  Endpoints.UserFollowing, prop_constants.getProperty("status_code_200"));
		
	}
}
