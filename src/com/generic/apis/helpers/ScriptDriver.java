package com.generic.apis.helpers;

import java.util.ArrayList;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.uncommons.reportng.HTMLReporter;

import com.generic.apis.tests.GenericTest;

/**
 * 
 * TODO
 * 	Logging
 *  Libraries
 *  Utilities
 *  Reporting
 *	Config files
 *	Sending email, etc 
 * 
 * @author Kingsley Onwukwe
 *
 */

public class ScriptDriver {
		
	//protected static final Logger logger = Logger.getLogger(ScriptDriver.class.getName());
	
	public static void main(String[] args) throws ClassNotFoundException {
		
		// initialize logger by log4j
		//PropertyConfigurator.configure("log4j.properties");	
		String classesFromCommandLine = System.getProperty("classes");	
		ArrayList<Class<?>> testClasses = new ArrayList<Class<?>>();
		
		//String[] classesArr = classesFromCommandLine.split(",");
		//for (String aClassName : classesArr){
			//testClasses.add(Class.forName(aClassName));
			testClasses.add(GenericTest.class);
		//}

		TestListenerAdapter tla_ = new TestListenerAdapter();
		CustomTestListener tla = new CustomTestListener();
		TestNG testng = new TestNG();
		testng.setTestClasses(testClasses.toArray(new Class<?>[testClasses.size()]));
		testng.setParallel("true");
		testng.setPreserveOrder(true);	
		testng.addListener(tla_);
		testng.addListener(tla); // used to get stack trace of the actual error that occured
		testng.setUseDefaultListeners(false);
		testng.addListener(new HTMLReporter());
		System.setProperty("org.uncommons.reportng.title", "Generic Test Report");
		testng.run();
	
		System.out.println("Failed tests: " + tla_.getFailedTests().toString());
		System.out.println("Passed tests: " + tla_.getPassedTests().toString());
				
	}
}