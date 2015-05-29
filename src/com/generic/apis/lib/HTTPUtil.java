package com.generic.apis.lib;

import org.springframework.web.client.RestTemplate;
import org.testng.annotations.Test;

@Test(enabled=false)
public class HTTPUtil {
	
	private static RestTemplate restTemplate;
		
	public static RestTemplate getRestTemplate(){
		if (restTemplate == null){
			restTemplate = new RestTemplate();
		}
		
		return restTemplate;
		
	}
	
}