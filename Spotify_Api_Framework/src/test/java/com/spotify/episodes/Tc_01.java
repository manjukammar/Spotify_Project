package com.spotify.episodes;

import org.testng.annotations.Test;

import com.spotify.baseutil.BaseTest;
import com.spotify.dataprovider.DataProviderFactory;
import com.spotify.dataprovider.DataProviderFileRowFilter;
import com.spotify.endpoints.Endpoints;
import com.spotify.utils.ApiActionUtil;

import io.restassured.response.Response;

public class Tc_01 extends BaseTest {
	
	@DataProviderFileRowFilter(file = "./src/main/resources/data/Data.xlsx", sql = "Select * from SpotifyData where SINO ='6)episode'")
	@Test(dataProvider = "data1", dataProviderClass = DataProviderFactory.class, description = "")
	public void episodes(String SINO, String id,String ids,String savedAlbums,String queryparamkey,String pathParam ) {

		/* Save episode */
		Response response = ApiActionUtil.putMethod(queryparamkey, pathParam, ids, Endpoints.SavedEpisode, prop_constants.getProperty("status_code_200"));
		
		/* Check user saved episode */
		ApiActionUtil.getRequest(queryparamkey, pathParam, ids, Endpoints.CheckSavedEpisode,prop_constants.getProperty("status_code_200"));
		
		/*Get user saved episode*/
	    ApiActionUtil.getMethod(Endpoints.SavedEpisode, prop_constants.getProperty("status_code_200"), prop_constants.getProperty("content_type_json"));
	
	    /* Remove user saved episode*/
	    ApiActionUtil.deleteMethod(queryparamkey, pathParam, ids,Endpoints.SavedEpisode, prop_constants.getProperty("status_code_200"));
	    
	}
}
