package practicesample;

import org.testng.annotations.Test;

public class dppracticeclass1Test
{
@Test(dataProvider="logindata",dataProviderClass=dppracticeclass2.class)
public void logintest(String name,String email)
{
	System.out.println(name+" "+email);
}

}
