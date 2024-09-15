package com.automation.base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.automation.resources.ExtendReporterNG;
import com.automation.test.HomeTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;



public class Listeners extends BaseTest implements  ITestListener{
	
	ExtentTest test;
	ExtentReports extent = ExtendReporterNG.getReportObject();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>(); 
	
	protected static Logger logger = LoggerFactory.getLogger(HomeTest.class);
	
	@Override
	public void onTestStart(ITestResult result) {
		
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
		
		logger.info("***LOG from REPORT *** Started TEST in ITestListener " +test);
		
		//unique thread id(ErrorValidationTest)->test
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		extentTest.get().log(Status.PASS, "Test Passed");
		logger.info("***LOG from REPORT ***  " + test +"is *** PASS ***");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.get().fail(result.getThrowable());
		
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver")
					.get(result.getInstance());
			
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
		
		
		
		String filePath = null;
		try {
			
			filePath = takeScreenShot(result.getMethod().getMethodName(),driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extentTest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
		
		
		//Screenshot, Attach to report
		logger.info("***LOG from REPORT ***  " + test +"is *** FAILLED ***");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		logger.info("***LOG from REPORT ***  " + test +"is *** SKIPPED ***");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	@Override
	public void onStart(ITestContext context) {
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
		extent.flush();
		
	}
	
	
	

}
