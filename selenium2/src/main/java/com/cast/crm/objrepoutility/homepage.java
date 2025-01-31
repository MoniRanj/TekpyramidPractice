package com.cast.crm.objrepoutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homepage {

	
	public homepage(WebDriver driver)
	{
		
		PageFactory.initElements(driver,this);
	}
	
//	@FindBy(linkText="Organizations")
//	private WebElement orglink;
	@FindBy(linkText="Products")
	private WebElement productlink;
	
	public WebElement getProductlink() {
		return productlink;
	}

	@FindBy(linkText="Contacts")
	private WebElement contlink;
	
	@FindBy(linkText="Campaigns")
	private WebElement camplink;
	
	@FindBy(linkText="More")
	private WebElement morelink;
	
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminimg;
	
	@FindBy(linkText="Sign Out")
	private WebElement signoutlink;
	
	
	
//	public WebElement getOrglink() {
//		return orglink;
//	}
	public WebElement getOrglink() {
		return orglink;
	}

	public WebElement getContlink() {
		return contlink;
	}
	public WebElement getMoreLink() {
		return morelink;
	}

	
	public void navigatetocampaignpage()
	{
	
		WebDriver driver = null;
		Actions a=new Actions(driver);
		a.moveToElement(morelink).perform();
		camplink.click();	
	}

	

	
	public void logout(WebDriver driver)
	{
		Actions a=new Actions(driver);
		a.moveToElement(adminimg).perform();
		signoutlink.click();
	}
	
	
}
