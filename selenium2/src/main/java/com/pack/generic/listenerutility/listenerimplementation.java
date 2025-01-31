package com.pack.generic.listenerutility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.internal.BaseClassFinder;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.cast.baseTest.baseclassTest;
import com.pack.generic.baseutility.Utilityclassobject;

public class listenerimplementation implements ITestListener,	ISuiteListener {
	public static ExtentReports report;
	public static ExtentTest test;
	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("Report backup");
		String time=new Date().toString().replace(" ","_").replace(":","_");
		//configure the report
		ExtentSparkReporter spark=new ExtentSparkReporter("./advancereport/report_"+time+".html");
		spark.config().setDocumentTitle("CRM Test Report");
		spark.config().setReportName("CRM REPORT");
		spark.config().setTheme(Theme.DARK);
		
		//add env info & create test
		 report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("BROWSER", "Chrome");
	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("==============="+result.getMethod().getMethodName()+"=====START=====");
		 test=report.createTest(result.getMethod().getMethodName());
		 Utilityclassobject.setTest(test);
		 test.log(Status.INFO,result.getMethod().getMethodName()+"==========STARTED==========");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("==============="+result.getMethod().getMethodName()+"=====END=====");
		test.log(Status.PASS,result.getMethod().getMethodName()+"==========COMPLETED==========");
	}
	

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String testname=result.getMethod().getMethodName();		
	
		TakesScreenshot tss=(TakesScreenshot)baseclassTest.sdriver;
		String srcfile=tss.getScreenshotAs(OutputType.BASE64);
		
		String time=new Date().toString().replace(" ","_").replace(":","_");
		
		test.addScreenCaptureFromBase64String(srcfile,testname+"_"+time);
		test.log(Status.FAIL,result.getMethod().getMethodName()+"==========FAILED==========");

		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		report.flush();
	}
	
	

}
