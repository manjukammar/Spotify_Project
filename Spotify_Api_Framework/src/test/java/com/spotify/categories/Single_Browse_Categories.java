package com.spotify.categories;

import org.testng.annotations.Test;

import com.spotify.baseutil.BaseTest;
import com.spotify.endpoints.Endpoints;
import com.spotify.utils.ApiActionUtil;

public class Single_Browse_Categories extends BaseTest{

@Test
	
	public void categories() {
		
		ApiActionUtil.getMethod(Endpoints.SingleBrowsecategories, prop_constants.getProperty("status_code_200"), prop_constants.getProperty("content_type_json"));
	}
}
