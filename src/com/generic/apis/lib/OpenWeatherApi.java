package com.generic.apis.lib;

import org.apache.log4j.LogMF;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.generic.apis.pojos.WeatherMap;


/**
 * Using JSON format only http://openweathermap.org/api
 * 
 * 		TODO Add logger
 * 		TODO This API does not have or require authentication
 * 
 * @author Kingsley Onwukwe
 *
 */
public class OpenWeatherApi {
	
	/**
	 * RestTemplate can handle headers, body params, etc
	 * 
	 * @param cityName
	 * @return
	 */
	public WeatherMap getCurrentWeatherByCityName(String cityName){
		String url = "http://api.openweathermap.org/data/2.5/weather?q=" + cityName;        		
        WeatherMap response = HTTPUtil.getRestTemplate().getForObject(url, WeatherMap.class);
        return response;
		
	}
	
	public WeatherMap getCurrentWeatherByZip(String zipcode){
		String url = "http://api.openweathermap.org/data/2.5/weather?zip=" + zipcode;  		
        WeatherMap response = HTTPUtil.getRestTemplate().getForObject(url, WeatherMap.class);
        return response;
	}
	
}