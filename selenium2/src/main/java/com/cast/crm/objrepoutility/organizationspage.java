package com.cast.crm.objrepoutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class organizationspage {
	// driver;

	public organizationspage(WebDriver driver)
	{
		//this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(name="search_text")
	private WebElement searchedit;
	
	@FindBy(name="search_field")
	private WebElement searchdd;
	
	@FindBy(name="submit")
	private WebElement submitbtn;
	
	public WebElement getSubmitbtn() {
		return submitbtn;
	}

	public WebElement getSearchedit() {
		return searchedit;
	}

	public WebElement getSearchdd() {
		return searchdd;
	}
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement createneworgbtn;

	public WebElement getCreateneworgbtn() {
		return createneworgbtn;
	}
	
}
