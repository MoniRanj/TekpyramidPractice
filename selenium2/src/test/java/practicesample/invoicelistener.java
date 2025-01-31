package practicesample;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.cast.baseTest.baseclassTest;

public class invoicelistener extends baseclassTest{

	@Test
	public void createinvoice()
	{
		System.out.println("test-1");
		System.out.println("test-2");
		String acttitle=driver.getTitle();
		Assert.assertEquals(acttitle,"Login");
		System.out.println("test-3");
	}
	
//	@Test(retryAnalyzer=com.pack.generic.listenerutility.retrylistenerimplementation.class)
//	public void createinvoicewithcontact()
//	{
//		System.out.println("test-1");
//		System.out.println("test-2");
//		String acttitle=driver.getTitle();
//		Assert.assertEquals(" ","Login");
//		System.out.println("test-3");
//	}
}
