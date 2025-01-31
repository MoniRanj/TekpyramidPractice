package reporter;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class extentreportpractice {
	public ExtentReports report;
	@BeforeSuite
	public void configBS()
	{
		ExtentSparkReporter spark=new ExtentSparkReporter("./advancereport/report.html");
		spark.config().setDocumentTitle("CRM Test Report");
		spark.config().setReportName("CRM REPORT");
		spark.config().setTheme(Theme.DARK);
		
		//add env info & create test
		 report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("BROWSER", "Chrome");
	}
	
	@AfterSuite
	public void configAS()
	{
		report.flush();
	}
	@Test
	public void createcontactTest()
	{
		//spark rep config
		WebDriver driver=new ChromeDriver();
		driver.get("http://49.249.28.218:8081/AppServer/domain.html#HealthCare");
		
		TakesScreenshot tss=(TakesScreenshot)driver;
		String srcfile=tss.getScreenshotAs(OutputType.BASE64);
		
			
		ExtentTest test=report.createTest("createcontactTest");
	test.log(Status.INFO, "login to app");
	test.log(Status.INFO, "nav to contact page");
	test.log(Status.INFO, "create contact ");
	
	if("HjjjFC".equals("HDFC"))
	{
		test.log(Status.PASS, "contact is created");
	}
	else
	{
		test.addScreenCaptureFromBase64String(srcfile, "ErrorFile");
	}
	driver.close();
	
	}
//	@Test
//	public void createphoneTest()
//	{
//		//spark rep config
//		
//		ExtentTest test=report.createTest("createphoneTest");
//	test.log(Status.INFO, "login to app");
//	test.log(Status.INFO, "nav to contact page");
//	test.log(Status.INFO, "create contact ");
//	
//	if("123".equals("123"))
//	{
//		test.log(Status.PASS, "contact is created");
//	}
//	else
//	{
//		test.log(Status.FAIL, "contact is not created");
//	}
	
	
//	}
}
