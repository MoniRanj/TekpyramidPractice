package practicesample;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataproviderpracticeTest {

	
	@Test(dataProvider="getData")
	public void create_contact(String fname,String lname)
	{
		System.out.println("FirstName "+fname+" LastName "+lname);
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] objarr=new Object[3][2];
		objarr[0][0]="Ram";
		objarr[0][1]="mr";
		
		objarr[1][0]="sita";
		objarr[1][1]="sri";
				
		objarr[2][0]="jaya";
		objarr[2][1]="mrs";
		
		return objarr;
	}
}
	

