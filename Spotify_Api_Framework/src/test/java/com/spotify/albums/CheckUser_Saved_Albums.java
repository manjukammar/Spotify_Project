package com.spotify.albums;

import java.util.HashMap;

import org.testng.annotations.Test;

import com.spotify.baseutil.BaseTest;
import com.spotify.dataprovider.DataProviderFactory;
import com.spotify.dataprovider.DataProviderFileRowFilter;
import com.spotify.endpoints.Endpoints;
import com.spotify.utils.ApiActionUtil;

public class CheckUser_Saved_Albums extends BaseTest{
	
	@DataProviderFileRowFilter(file = "./src/main/resources/data/Data.xlsx", sql = "Select * from SpotifyData where SINO ='album'")
	@Test(dataProvider = "data1", dataProviderClass = DataProviderFactory.class, description = "")
	public void album(String SINO, String id,String ids,String savedAlbums,String queryparamkey,String pathParam ) {
	
        ApiActionUtil.getRequest(queryparamkey, pathParam, ids, Endpoints.CheckUsersavedAlbums,prop_constants.getProperty("status_code_200"));
	}

}
