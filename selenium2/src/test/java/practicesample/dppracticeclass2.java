package practicesample;

import org.testng.annotations.DataProvider;

public class dppracticeclass2 {
@DataProvider(name="logindata")
public Object[][] getdata()
{
	Object[][]	data= {{"monica","monica@gmail.com"},{"ranjith","ranjith@gmail.com"}};
	return data;
	
}
}
