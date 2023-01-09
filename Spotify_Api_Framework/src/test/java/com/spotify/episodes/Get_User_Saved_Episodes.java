package com.spotify.episodes;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.spotify.baseutil.BaseTest;
import com.spotify.endpoints.Endpoints;
import com.spotify.utils.ApiActionUtil;

import io.restassured.response.Response;

public class Get_User_Saved_Episodes extends BaseTest{
	
	@Test
	
	public void episode() {
		
		Response response = ApiActionUtil.getMethod(Endpoints.SavedEpisode, prop_constants.getProperty("status_code_200"), prop_constants.getProperty("content_type_json"));
		
		String savedEpisode = ApiActionUtil.getResponseBodyValue(response, "items[0].episode.name");
	    System.out.println(savedEpisode);
	    Assert.assertEquals(savedEpisode, prop_constants.getProperty("savedEpisodes"));
		
	}

}
