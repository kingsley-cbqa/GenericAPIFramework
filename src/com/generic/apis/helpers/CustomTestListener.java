package com.generic.apis.helpers;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;
@Test(enabled=false)
public class CustomTestListener implements ITestListener {
	
	@Override 
    public void onTestFailure(ITestResult arg0) { 
		
	    System.out.println(arg0.getThrowable().getMessage()); 
	
	    StringWriter sw = new StringWriter(); 
	
	    arg0.getThrowable().printStackTrace(new PrintWriter(sw)); 
	
	    String stacktrace = sw.toString(); 
	
	    System.out.println(stacktrace); 
	    
	    //Assert.assertTrue(stacktrace.isEmpty());
	    
	    arg0.setStatus(arg0.getStatus());
    }

	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
	} 

	
	
}