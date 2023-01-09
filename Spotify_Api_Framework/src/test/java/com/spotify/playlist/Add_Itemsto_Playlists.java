package com.spotify.playlist;

import java.io.File;
import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.spotify.baseutil.BaseTest;
import com.spotify.dataprovider.DataProviderFactory;
import com.spotify.dataprovider.DataProviderFileRowFilter;
import com.spotify.endpoints.Endpoints;
import com.spotify.utils.ApiActionUtil;

public class Add_Itemsto_Playlists extends BaseTest{
	

	@DataProviderFileRowFilter(file = "./src/main/resources/data/Data.xlsx", sql = "Select * from data where Modules ='playlist'")
	@Test(dataProvider = "data1", dataProviderClass = DataProviderFactory.class, description = "")
	public void user(String Module,String Id,String Ids,String QueryParam,String PathParam,String PathParam2) {
			
		/*Add Items to Play list*/
		File path1 =new File(prop_constants.getProperty("additems_to_playlist"));
		ApiActionUtil.postMethodWithBody(QueryParam,PathParam2, Id, path1, Endpoints.PlaylistItems, prop_constants.getProperty("status_code_201"));
		
	}
}
