package com.cast.baseTest;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.cast.crm.objrepoutility.homepage;
import com.cast.crm.objrepoutility.loginpage;
import com.pack.generic.baseutility.Utilityclassobject;
import com.pack.generic.baseutility.databaseutility;
import com.pack.generic.baseutility.excelutility;
import com.pack.generic.baseutility.fileutility;
import com.pack.generic.baseutility.javautility;
import com.pack.generic.baseutility.utility;



/**
 * Monica KJ
 */

public class baseclassTest {
	public databaseutility dbu = new databaseutility();
	public fileutility fu = new fileutility();
	public excelutility eu = new excelutility();
	public javautility ju = new javautility();
	public utility wu = new utility();
	public WebDriver driver = null;
	public static WebDriver sdriver = null;

	@BeforeSuite(groups = { "smokeTest", "regressionTest" })
	public void configBS() throws SQLException {
		System.out.println("=========connect to DB, Report config========");
		dbu.getDbconnection();

	}

//@Parameters("BROWSER")
	@BeforeClass(groups = { "smokeTest", "regressionTest" })
	public void configBC() throws Throwable {
		System.out.println("============launch browser=============");

		// String BROWSER=browser;
		// fu.getdatafromfile("browser");
		
		//String BROWSER = fu.getdatafromfile("browser");
		//String URL = fu.getdatafromfile("url");
String BROWSER=System.getProperty("browser");
String URL=System.getProperty("url");

		if (BROWSER.equals("chrome")) {

			driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equals("edge")) {

			driver = new EdgeDriver();
		}
		sdriver = driver;
		driver.get(URL);
		wu.waitForpageToload(driver);
		Utilityclassobject.setDriver(driver);

	}

	@BeforeMethod(groups = { "smokeTest", "regressionTest" })
	public void configBM() throws Throwable {
		System.out.println("============login=============");

//		String USERNAME = fu.getdatafromfile("username");
//		String PASSWORD = fu.getdatafromfile("password");
		
		String USERNAME=System.getProperty("username");
		String PASSWORD=System.getProperty("password");
		
		loginpage lp = new loginpage(driver);
		lp.logintoapp(USERNAME, PASSWORD);

	}

	@AfterMethod(groups = { "smokeTest", "regressionTest" })
	public void configAM() {
		System.out.println("============logout=============");
		homepage hp = new homepage(driver);
		hp.logout(driver);
	}

	@AfterClass(groups = { "smokeTest", "regressionTest" })
	public void configAC() {
		System.out.println("============close Browser=============");
		driver.quit();
	}

	@AfterSuite(groups = { "smokeTest", "regressionTest" })
	public void configAS() throws SQLException {
		System.out.println("========close DB, Report backup========");
		dbu.closeDbconnection();

		//

	}

	@BeforeTest
	public void BT() {
		System.out.println("========exe BT========");

	}

	@AfterTest
	public void AT() {
		System.out.println("========exe AT========");

	}

}
