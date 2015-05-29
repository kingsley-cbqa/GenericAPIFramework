package com.generic.apis.tests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.generic.apis.lib.ExcelReader;
import com.generic.apis.lib.OpenWeatherApi;
import com.generic.apis.pojos.WeatherMap;

public class GenericTest extends BaseTest {
	
	private OpenWeatherApi weatherApi;
	private WeatherMap weatherInfo;
	private String excelFilePath, worksheetName, tableName;
	
	@BeforeClass
	public void setup(){
		// TODO setup code...which can be moved to base test
		weatherApi = new OpenWeatherApi(); // Can be moved to a base test class
		weatherInfo = null;
		
		// file path can be moved to config file
		// This file would make it fail on another machine
		excelFilePath 	=	"C:/Users/Kingsley Onwukwe/workspace/GenericAPIFramework/data_files/GenericAPIFramework.xls"; 
		worksheetName 	= 	"DataPool1";
		tableName 		=	"DataSet";
	}
	
	@DataProvider(name = "getData")
	public Iterator<Object[]> createData() throws Exception{
		
		List<HashMap<String, String>> excelData = ExcelReader.getTableArray(excelFilePath, worksheetName, tableName);
	
		List<Object[]> rows = new ArrayList<Object[]>();
		for (HashMap<String, String> excelRow : excelData){
			rows.add(new Object[] { excelRow } );
		}
		
		return rows.iterator();
		
	}
	
	/* TODO read from data file */
	@Test(priority=1)
	public void verifySeaLevel(){
		weatherInfo = weatherApi.getCurrentWeatherByCityName("London,uk");
		Assert.assertEquals(weatherInfo.getMain().getSeaLevel(), 1013.25);
	}
	
	@Test(priority=2)
	public void verifyName(){
		weatherInfo = weatherApi.getCurrentWeatherByCityName("London,uk"); 
		Assert.assertEquals(weatherInfo.getName(), "London");
	}
	
	@Test(priority=3, dataProvider = "getData")
	public void validateInfoFromSpreadSheet(HashMap<String, String> rowInfo){
		
		String zip 		= rowInfo.get("Zip");
		String city		= rowInfo.get("City");
		String country 	= rowInfo.get("Country");
					
		weatherInfo = weatherApi.getCurrentWeatherByZip(zip + "," + country);
		Assert.assertEquals(weatherInfo.getName(), city);
		
	}
	
}