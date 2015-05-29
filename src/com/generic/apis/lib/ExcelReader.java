package com.generic.apis.lib;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import org.apache.log4j.Logger;
import org.testng.asserts.SoftAssert;

/**
 * 
 * Read a specific spreadsheet -> specific worksheet -> specific/multiple tables
 * 
 * 
 * @author Kingsley Onwukwe
 *
 */
public class ExcelReader {
	
	//private static final Logger logger = Logger.getLogger(ExcelReader.class.getName());
	
	public static List<HashMap<String, String>> getTableArray(String xlFilePath, 
			String sheetName, String tableName) throws Exception {
    
		List<HashMap<String, String>> tableList = new ArrayList<HashMap<String, String>>();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(new File(xlFilePath).exists(), "Excel File " + xlFilePath + " does not exist");
		
		//LogMF.debug(logger,"Table name: {0}" , tableName);
		System.out.println("Table name: " + tableName);
		
	    Workbook workbook = Workbook.getWorkbook(new File(xlFilePath));
	    Sheet sheet = workbook.getSheet(sheetName);
	    int startRow,startCol, endRow, endCol, ci, cj;
	    Cell tableStart=sheet.findCell(tableName);
	    startRow=tableStart.getRow();
	    startCol=tableStart.getColumn();
	
	    Cell tableEnd= sheet.findCell(tableName, startCol+1,startRow+1, 100, 64000,  false);                               
	
	    endRow=tableEnd.getRow();
	    endCol=tableEnd.getColumn();
	     
	    //LogMF.debug(logger, "startRow={0}, endRow={1}, startCol={2}, endCol={3}",
	    //        		 startRow, endRow, startCol, endCol);
	 
	    System.out.println("startRow=" + startRow + "endRow=" + endRow + "startCol=" + startCol + "endCol=" + endCol);
	    HashMap<String, String> excelMap = null; 
	      
	    for (int i = startRow+1; i < endRow; i++){ 
	    	
	    	excelMap = new HashMap<String, String>();
	                 
	        // get each cell in a row and store in a hashmap
	        for (int j = startCol + 1; j < endCol; j++){
	        	if (!sheet.getCell(j, i).getContents().isEmpty()){   
	      			
	        		excelMap.put(sheet.getCell(j, startRow).getContents(), sheet.getCell(j,i).getContents());
	        	}
	        }
	         
	        tableList.add(excelMap);
	       
	    }

        //LogMF.debug(logger, "Length of Excel Data: {0}", tableList.size());
	    System.out.println("Length of Excel Data: " + tableList.size());
        return tableList;
    }
	
}