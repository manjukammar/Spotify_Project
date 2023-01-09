package com.spotify.shows;

import org.testng.annotations.Test;

import com.spotify.baseutil.BaseTest;
import com.spotify.endpoints.Endpoints;
import com.spotify.utils.ApiActionUtil;

import io.restassured.response.Response;

public class Get_User_Saved_Shows extends BaseTest{
	
	@Test
	
	public void shows() {
		
	Response response = ApiActionUtil.getMethod(Endpoints.SavedShow, prop_constants.getProperty("status_code_200"), prop_constants.getProperty("content_type_json"));
		System.out.println(response);
	}

}
