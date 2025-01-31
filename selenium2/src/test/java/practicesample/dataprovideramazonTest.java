package practicesample;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class dataprovideramazonTest {

	
	@Test
	public void getproductinfoTest()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://amazon.in");
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone",Keys.ENTER);
		String x="//span[.='Apple iPhone 15 (128 GB) - Black']/../../../../div[3]/div[1]/div[1]/div[1]/div[2]/div/a/span[1]";
		String price=driver.findElement(By.xpath(x)).getText();
		System.out.println(price);
	}
	
}
