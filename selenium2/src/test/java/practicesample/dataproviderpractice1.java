package practicesample;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataproviderpractice1 {
	@Test(dataProvider="getData")
	public void create_contact(String fname,String lname,Long phno)
	{
		System.out.println("FirstName "+fname+" LastName "+lname+" PhoneNo "+phno);
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] objarr=new Object[3][3];
		
		objarr[0][0]="Ram";
		objarr[0][1]="mr";
		objarr[0][2]=5675656899L;
				
		objarr[1][0]="sita";
		objarr[1][1]="sri";
		objarr[1][2]=5675450899L;
				
		objarr[2][0]="jaya";
		objarr[2][1]="mrs";
		objarr[2][2]=567896769L;
		
		return objarr;
	}
}
