package com.spotify.albums;

import java.io.File;

import org.testng.annotations.Test;

import com.spotify.baseutil.BaseTest;
import com.spotify.dataprovider.DataProviderFactory;
import com.spotify.dataprovider.DataProviderFileRowFilter;
import com.spotify.endpoints.Endpoints;
import com.spotify.utils.ApiActionUtil;

import io.restassured.response.Response;

public class Tc_01 extends BaseTest {

	@DataProviderFileRowFilter(file = "./src/main/resources/data/Data.xlsx", sql = "Select * from SpotifyData where SINO ='album'")
	@Test(dataProvider = "data1", dataProviderClass = DataProviderFactory.class, description = "")
	public void album(String SINO, String id, String ids, String savedAlbums, String queryparam,
			String pathparam) {

		/* Save Albums for current user */
		File path = new File(prop_constants.getProperty("save_album_user"));
		ApiActionUtil.putMethodWithBody(queryparam, pathparam, id, path, Endpoints.UsersavedAlbum,
				prop_constants.getProperty("status_code_200"));
		
		/* Check user saved albums */
		ApiActionUtil.getRequest(queryparam, pathparam, ids, Endpoints.CheckUsersavedAlbums,prop_constants.getProperty("status_code_200"));

		/* Get User Saved albums */
		ApiActionUtil.getRequest(queryparam, pathparam, ids, Endpoints.UsersavedAlbum,prop_constants.getProperty("status_code_200"));
		
		/* Delete user saved album */
	//	ApiActionUtil.deleteMethod(queryparam, pathparam, ids,Endpoints.UsersavedAlbum,prop_constants.getProperty("status_code_200"));
		
	}
}
