package com.spotify.markets;

import org.testng.annotations.Test;

import com.spotify.baseutil.BaseTest;
import com.spotify.endpoints.Endpoints;
import com.spotify.utils.ApiActionUtil;

public class Markets extends BaseTest{
	
	@Test
	
	public void market() {
		
		ApiActionUtil.getMethod(Endpoints.Markets, prop_constants.getProperty("status_code_200"), prop_constants.getProperty("content_type_json"));
	}

}
