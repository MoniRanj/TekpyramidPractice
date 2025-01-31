package practicesample;

import org.testng.annotations.Test;

public class invocationcountTest {
	@Test(priority=-1)
	
	public void createcontact()
	{
		System.out.println("execute createcontact");
	}
	@Test(invocationCount=5)
	public void createcontactwithmobileno()
	{
		System.out.println("execute createcontactwithmobileno ");
	}
	//@Test(enabled=false)
	@Test()
	public void createcontactwithaddress()
	{
		System.out.println("execute createcontactwithaddress ");
	}
	@Test(dependsOnMethods="createcontact")
	public void createcontactwithname()
	{
		System.out.println("execute createcontactwithname");
	}
}
