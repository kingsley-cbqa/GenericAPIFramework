package com.generic.apis.tests;

import java.io.IOException;
import org.apache.log4j.LogMF;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;


// order of execution - http://www.tutorialspoint.com/testng/testng_execution_procedure.htm
public abstract class BaseTest {
	
	//protected static final Logger logger = Logger.getLogger(BaseTest.class.getName());
	
	/** Property foo is set once per Suite */
    protected String foo;

    /** Property bar is set once per Test */
    protected String bar;

    /**
     * As this method is executed only once for all inheriting instances before the test suite starts this method puts
     * any configuration/resources needed by test implementations into the test context.
     *
     * @param context test context for storing test conf data
     * @throws IOException 
     */
    @BeforeSuite(groups = {"grouptest"})
    public void beforeSuite(ITestContext context) throws Exception {
		//PropertyConfigurator.configure("log4j.properties");
        //LogMF.debug(logger, "@BeforeSuite called on {0}", getClass().getName());
        context.setAttribute("foo", "I was set in @BeforeSuite");
    }

    @AfterSuite(groups = {"grouptest"})
    public void afterSuite(ITestContext context) {
        //LogMF.debug(logger,"@AfterSuite called on {0}", getClass().getName());
    }

    /**
     * As this method is executed only once for all inheriting instances before the test starts this method puts any
     * configuration/resources needed by test implementations into the test context.
     *
     * The annotated method will be run before any test method belonging to the classes inside the <test> tag is run
     *
     * @param context test context for storing test conf data
     * @throws IOException 
     */
    @BeforeTest(alwaysRun = true, groups = {"grouptest"})
    public void beforeTest(ITestContext context) {
        //LogMF.debug(logger, "@BeforeTest called on {0}", getClass().getName());
        context.setAttribute("bar", "I was set in @BeforeTest");
		
    }

    @AfterTest(groups = {"grouptest"})
    public void afterTest(ITestContext context) {
        //LogMF.debug(logger,"@AfterTest called on {0}", getClass().getName());
    }
    
    /**
     * This method executes before each method for all inheriting instances
     * assuming dependencies don't fail
     * 
     */
    @BeforeMethod(groups = {"grouptest"})
    //public void beforeMethod(Method method){
    public void beforeMethod(){
    	//LogMF.debug(logger, "@BeforeMethod called on {0}", getClass().getName());
    }

    /**
     * This method executes after each method for all inheriting instances
     * assuming dependencies don't fail
     * 
     * @param result result of method
     */
    @AfterMethod(groups = {"grouptest"})
    public void afterMethod(ITestResult result){
    	//LogMF.debug(logger, "@AfterMethod called on {0}", getClass().getName() + "." + result.getMethod().getMethodName());
    }
    
    /**
     * This method is run before the first method of a test instance is started and gets all required configuration from
     * the test context.
     *
     * @param context test context to retrieve conf data from.
     */
    @BeforeClass(groups = {"grouptest"})
    public void beforeClass(ITestContext context) throws Exception {
    	
        //LogMF.debug(logger, "@BeforeClass called on {0}", getClass().getName());
        foo = (String) context.getAttribute("foo");
        bar = (String) context.getAttribute("bar");

    }

    /**
     * This method is run after the first method of a test instance is started and gets all required configuration from
     * the test context.
     *
     * @param context test context to retrieve conf data from.
     */
	@AfterClass(alwaysRun = true, groups = {"grouptest"})
    public void afterClass(ITestContext context) throws Exception {
		
    }
    

	
}