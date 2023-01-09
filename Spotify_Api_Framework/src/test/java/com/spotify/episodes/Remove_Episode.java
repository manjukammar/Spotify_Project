package com.spotify.episodes;

import org.testng.annotations.Test;

import com.spotify.baseutil.BaseTest;
import com.spotify.dataprovider.DataProviderFactory;
import com.spotify.dataprovider.DataProviderFileRowFilter;
import com.spotify.endpoints.Endpoints;
import com.spotify.utils.ApiActionUtil;

public class Remove_Episode extends BaseTest{
	
	@DataProviderFileRowFilter(file = "./src/main/resources/data/Data.xlsx", sql = "Select * from SpotifyData where SINO ='6)episode'")
	@Test(dataProvider = "data1", dataProviderClass = DataProviderFactory.class, description = "")
	public void episodes(String SINO, String id,String ids,String savedAlbums,String queryparamkey,String pathParam ) {

//		HashMap<String, String> query_Param_Map = new HashMap<String, String>();
//		query_Param_Map.put("ids", ids);
//		ApiActionUtil.deleteMethodWithQueryParamwithoutContent(query_Param_Map, Endpoints.SavedShow, prop_constants.getProperty("status_code_200"));

		ApiActionUtil.deleteMethod(queryparamkey, pathParam, ids,Endpoints.SavedShow, prop_constants.getProperty("status_code_200"));
	}

}
