package practicesample;

import org.testng.annotations.Test;

public class priorityTest {

	@Test
	public void createcontactTest1()
	{
		System.out.println("exe create contact");
	}
	@Test(priority=-1)
	public void modifycontactTest()
	{
		System.out.println("exe modification");
	}
	@Test(priority=0)
	public void deletecontactTest()
	{
		System.out.println("exe delete");
	}
}
