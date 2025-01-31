package com.pack2;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.cast.baseTest.baseclassTest;
import com.cast.crm.objrepoutility.createneworganizationpage;
import com.cast.crm.objrepoutility.homepage;
import com.cast.crm.objrepoutility.organizationinfopage;
import com.cast.crm.objrepoutility.organizationspage;
import com.pack.generic.baseutility.Utilityclassobject;
import com.pack.generic.listenerutility.listenerimplementation;
@Listeners(com.pack.generic.listenerutility.listenerimplementation.class)
public class createorgconfigTest extends baseclassTest {
 @Test
	public void createorg() throws EncryptedDocumentException, IOException
 {
	 Utilityclassobject.getTest().log(Status.INFO, "read data from excel");
	 String lastname=eu.getdatafromexcel("Sheet1",1,2)+ju.getrandomnumber();
	 
	 Utilityclassobject.getTest().log(Status.INFO, "nav to org page");
	homepage hp=new homepage(driver);
	  hp.getOrglink().click();
	  
	  //Step 3: Click on the Create Organization button
	  Utilityclassobject.getTest().log(Status.INFO, "nav to create org page");
	  organizationspage op=new organizationspage(driver);
	  op.getCreateneworgbtn().click();
	  
	  //Step 4: Enter all the details & create new organization
	  Utilityclassobject.getTest().log(Status.INFO, "create org");
	  createneworganizationpage cnop=new createneworganizationpage(driver);
	  cnop.createorgg(lastname);
	  Utilityclassobject.getTest().log(Status.INFO,lastname+ "org created");
	  
	  
	  //Verify header msg expected result
	 
	  organizationinfopage oip= new organizationinfopage(driver);
	  String headerInfo= oip.getHeadermsg().getText();
	  
	  if(headerInfo.contains(lastname)) {
		  System.out.println(lastname + "  is created and header verified. Test case PASS");
	  }else
	  {
		  System.out.println(lastname + " is not created. Test case FAIL");
	  }
	  
	  
 }
}
