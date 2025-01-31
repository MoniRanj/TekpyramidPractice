package practicesample;

import org.testng.annotations.Test;

public class dependsonpracticeTest {

	@Test
	public void createorderTest()
	{
		System.out.println("exe createorderTest");
//		String s=null;
//		System.out.println(s.equals("hi"));
	}
	@Test(dependsOnMethods="createorderTest")
	public void BillingorderTest()
	{
		System.out.println("exe billingorderTest");
	}
	
	@Test(dependsOnMethods="BillingorderTest")
	public void packingTest()
	{
		System.out.println("exe packingTest");
	}
	
}
