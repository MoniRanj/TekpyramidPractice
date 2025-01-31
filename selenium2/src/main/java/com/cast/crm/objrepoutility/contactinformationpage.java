package com.cast.crm.objrepoutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pack.generic.baseutility.javautility;



public class contactinformationpage {
	//WebDriver driver;
		public contactinformationpage(WebDriver driver) {
			//this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath=("//span[@id='dtlview_Last Name']"))
		private WebElement actLastName;
		
		public WebElement getActLastName() {
			return actLastName;
		}
		
		public void verifyStartEndDates() {
			javautility jLib=new javautility();
			String startDate = jLib.getSystemDateYYYYDDMM();
			String endDate = jLib.getRequiredDataYYYYMMDD(30);
		
		}	
}
