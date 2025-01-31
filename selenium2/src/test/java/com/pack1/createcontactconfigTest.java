package com.pack1;

import java.io.IOException;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.cast.baseTest.baseclassTest;
import com.cast.crm.objrepoutility.contactspage;
import com.cast.crm.objrepoutility.createnewcontactspage;
import com.cast.crm.objrepoutility.createneworganizationpage;
import com.cast.crm.objrepoutility.homepage;
import com.cast.crm.objrepoutility.organizationinfopage;
import com.cast.crm.objrepoutility.organizationspage;

public class createcontactconfigTest extends baseclassTest {
	@Test(groups = "smokeTest")
	public void createcontact() throws EncryptedDocumentException, IOException {
		String lastname = eu.getdatafromexcel("Sheet1", 1, 2) + ju.getrandomnumber();

		homepage hp = new homepage(driver);
		hp.getContlink().click();

		// Step 3: Click on the Create Contacts button
		contactspage cp = new contactspage(driver);
		cp.getCreateContactBtn().click();

		// Step 4: Enter all the details & create new contact
		createnewcontactspage cn = new createnewcontactspage(driver);
		cn.getLastName().sendKeys(lastname);
		cn.getSaveBtn().click();

		// Verify last name contact

		String actLastName = cp.getHeadermsg().getText();
		boolean status = actLastName.contains(lastname);
		Assert.assertEquals(status, true);
//	  if(actLastName.equals(lastname)) {
//		  System.out.println(lastname + " name is verified. Test PASS");
//	  }else
//	  {
//		  System.out.println(lastname + " name is not verified. Test FAIL");
//	  }
	}

	@Test(groups = "regressionTest")
	public void createcontactwithsupportdateTest() throws EncryptedDocumentException, IOException {
		String startDate = ju.getSystemDateYYYYDDMM();
		String endDate = ju.getRequiredDataYYYYMMDD(30);
		String lastname = eu.getdatafromexcel("Sheet1", 1, 2) + ju.getrandomnumber();

		homepage hp = new homepage(driver);
		hp.getContlink().click();

		// Step 3: Click on the Create Contacts button
		contactspage cp = new contactspage(driver);
		cp.getCreateContactBtn().click();

		String endDate1 = ju.getSystemDateYYYYDDMM();
		String startDate1 = ju.getrequireddataYYYYDDMM(30);

		createnewcontactspage cNP = new createnewcontactspage(driver);
		cNP.createContactWithSupportDate(lastname, startDate1, endDate1);
		String actStartDate = driver.findElement(By.id("dtlview_Support Start Date")).getText();

		if (actStartDate.equals(startDate1)) {
			System.out.println(startDate1 + " is verified. Test PASS");
		} else {
			System.out.println(startDate1 + " is not verified. Test FAIL");
		}

		String actEndDate = driver.findElement(By.id("dtlview_Support End Date")).getText();
		System.out.println(actEndDate);
		if (actEndDate.equals(endDate1)) {
			System.out.println(endDate1 + " is verified. Test PASS");
		} else {
			System.out.println(endDate1 + " is not verified. Test FAIL");
		}
	}

}
