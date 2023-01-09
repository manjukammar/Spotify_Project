package com.spotify.tracks;

import org.testng.annotations.Test;

import com.spotify.baseutil.BaseTest;
import com.spotify.dataprovider.DataProviderFactory;
import com.spotify.dataprovider.DataProviderFileRowFilter;
import com.spotify.endpoints.Endpoints;
import com.spotify.utils.ApiActionUtil;

public class Remove_user_Saved_track extends BaseTest {
	
	@DataProviderFileRowFilter(file = "./src/main/resources/data/Data.xlsx", sql = "Select * from SpotifyData where SINO ='7)tracks'")
	@Test(dataProvider = "data1", dataProviderClass = DataProviderFactory.class, description = "")
	public void tracks(String SINO, String id,String ids,String savedAlbums,String queryparamkey,String pathParam ) {

		 ApiActionUtil.deleteMethod(queryparamkey, pathParam, ids,Endpoints.SavedTracks, prop_constants.getProperty("status_code_200"));
	}
}
