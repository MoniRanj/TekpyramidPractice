package com.cast.crm.objrepoutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class contactspage {
	//WebDriver driver;

			public contactspage(WebDriver driver) {

				//this.driver=driver;

				PageFactory.initElements(driver, this);

			}

			public WebElement getHeadermsg() {
				return headermsg;
			}

			@FindBy(className="dtlview_Last Name")
			private WebElement headermsg;

			@FindBy(xpath=("//img[@title='Create Contact...']"))

			private WebElement createContactBtn;

			

			public WebElement getCreateContactBtn() {

				return createContactBtn;

			}

		}

