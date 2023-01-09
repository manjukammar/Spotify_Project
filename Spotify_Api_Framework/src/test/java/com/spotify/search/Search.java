package com.spotify.search;

import org.testng.annotations.Test;

import com.spotify.baseutil.BaseTest;
import com.spotify.dataprovider.DataProviderFactory;
import com.spotify.dataprovider.DataProviderFileRowFilter;
import com.spotify.endpoints.Endpoints;
import com.spotify.utils.ApiActionUtil;

public class Search extends BaseTest{

	@DataProviderFileRowFilter(file = "./src/main/resources/data/Data.xlsx", sql = "Select * from SpotifyData where SINO ='4)search'")
	@Test(dataProvider = "data1", dataProviderClass = DataProviderFactory.class, description = "")
	public void search(String SINO, String id,String ids,String savedAlbums,String queryparamkey,String pathParam ) {
		
		ApiActionUtil.getRequest(queryparamkey, pathParam, savedAlbums, Endpoints.Search,
				prop_constants.getProperty("status_code_200"));
		
	}
	
}
