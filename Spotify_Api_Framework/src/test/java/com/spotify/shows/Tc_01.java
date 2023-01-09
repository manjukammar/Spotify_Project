package com.spotify.shows;

import java.io.File;

import org.testng.annotations.Test;

import com.spotify.baseutil.BaseTest;
import com.spotify.dataprovider.DataProviderFactory;
import com.spotify.dataprovider.DataProviderFileRowFilter;
import com.spotify.endpoints.Endpoints;
import com.spotify.utils.ApiActionUtil;

import io.restassured.response.Response;

public class Tc_01 extends BaseTest{
	
	@DataProviderFileRowFilter(file = "./src/main/resources/data/Data.xlsx", sql = "Select * from SpotifyData where SINO ='Shows'")
	@Test(dataProvider = "data1", dataProviderClass = DataProviderFactory.class, description = "")
	public void shows(String SINO, String id,String ids,String savedAlbums,String queryparamkey,String pathParam ) {

		/* Save shows */
		Response response = ApiActionUtil.putMethod(queryparamkey, pathParam, ids, Endpoints.SavedShow, prop_constants.getProperty("status_code_200"));
		
		/* Check user saved shows */
		ApiActionUtil.getRequest(queryparamkey, pathParam, ids, Endpoints.CheckSavedShow,prop_constants.getProperty("status_code_200"));
		
		/*Get user saved shows*/
	    ApiActionUtil.getMethod(Endpoints.SavedShow, prop_constants.getProperty("status_code_200"), prop_constants.getProperty("content_type_json"));
	
	    /* Remove user saved shows*/
	    ApiActionUtil.deleteMethod(queryparamkey, pathParam, ids,Endpoints.SavedShow, prop_constants.getProperty("status_code_200"));
	    
	}
}
