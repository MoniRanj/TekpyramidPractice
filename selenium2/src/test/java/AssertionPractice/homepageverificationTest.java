package AssertionPractice;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class homepageverificationTest {

	@Test
	public void homepageTest(Method mtd)
	{
		System.out.println(mtd.getName()+"Test start");
		String expectedtitle="Home";
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://49.249.28.218:8888/");
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		String acttitle=driver.findElement(By.xpath("//a[contains(text(),'Home')]")).getText();
		
		
		Assert.assertEquals(acttitle, expectedtitle);
//		if(acttitle.trim().equals(expectedtitle))
//		{
//			System.out.println(expectedtitle+"page is verified==PASS");
//		}else
//		{
//			System.out.println(expectedtitle+"page is not verified==FAIL");
//		}
		driver.close();
		System.out.println(mtd.getName()+"Test End");
	}
	
	@Test
	public void verifylogoTest(Method mtd)
	{
		System.out.println(mtd.getName()+"Test start");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://49.249.28.218:8888/");
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		boolean status=driver.findElement(By.xpath("//img[@title='vtiger-crm-logo.gif']")).isEnabled();
		
		Assert.assertTrue(status);
		
//		if(status)
//		{
//			System.out.println("logo is verified==PASS");
//		}else
//		{
//			System.out.println("logo is not verified==FAIL");
//		}
		driver.close();
		System.out.println(mtd.getName()+"Test End");
	}
	
}
