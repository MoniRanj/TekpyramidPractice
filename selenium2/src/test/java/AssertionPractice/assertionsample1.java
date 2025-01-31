package AssertionPractice;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class assertionsample1 {

	@Test
	public void homepageT(Method mtd)
	{
		SoftAssert sa=new SoftAssert();
		Reporter.log(mtd.getName()+"Test start");
		
		
		Reporter.log("step-1",true);
		Reporter.log("step-2",true);
		Assert.assertEquals("Home","Home");
		Reporter.log("step-3",true);
		sa.assertEquals("title","title");
		Reporter.log("step-4",true);
		sa.assertAll();
		Reporter.log(mtd.getName()+"Test End");
	}
	
	@Test
	public void VerifylogoT(Method mtd)
	{
		SoftAssert sa=new SoftAssert();
		Reporter.log(mtd.getName()+"Test start");
		Reporter.log("step-1",true);
		Reporter.log("step-2",true);
		sa.assertTrue(true);
		Reporter.log("step-3",true);
		Reporter.log("step-4",true);
		sa.assertAll();
		Reporter.log(mtd.getName()+"Test End");
	}
}
