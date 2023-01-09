package com.spotify.playlist;

import java.io.File;

import org.testng.annotations.Test;

import com.spotify.baseutil.BaseTest;
import com.spotify.dataprovider.DataProviderFactory;
import com.spotify.dataprovider.DataProviderFileRowFilter;
import com.spotify.endpoints.Endpoints;
import com.spotify.utils.ApiActionUtil;

import io.restassured.response.Response;

public class Tc_01 extends BaseTest{
	
	@DataProviderFileRowFilter(file = "./src/main/resources/data/Data.xlsx", sql = "Select * from data where Modules ='playlist'")
	@Test(dataProvider = "data1", dataProviderClass = DataProviderFactory.class, description = "")
	public void user(String Module,String Id,String Ids,String QueryParam,String PathParam,String PathParam2) {
		
	   /*Create Play list*/	
		File path =new File(prop_constants.getProperty("create_play_list"));
		Response resonse = ApiActionUtil.postMethodWithBody(QueryParam,PathParam, Id, path, Endpoints.CreatePlaylist, prop_constants.getProperty("status_code_201"));
		String playlistId = ApiActionUtil.getResponseBodyValue(resonse, "id");
		System.out.println(playlistId+"playList");
		
		/*Add Items to Play list*/
		File path1 =new File(prop_constants.getProperty("additems_to_playlist"));
		ApiActionUtil.postMethodWithBody(QueryParam,PathParam2, playlistId, path1, Endpoints.PlaylistItems, prop_constants.getProperty("status_code_201"));
		
		/* Update Play list */
//		File path2 =new File(prop_constants.getProperty("update_playlist_items"));
//		ApiActionUtil.putMethodWithBody(QueryParam,PathParam2, Ids, path2, Endpoints.PlaylistItems, prop_constants.getProperty("status_code_200"));
		
	}
}
