package com.cast.crm.objrepoutility;

import java.time.Duration;
/**
 * Contains Loginpage elements & business lib like login
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpage {

	WebDriver driver;

	public loginpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	//step1-create separate class for each page
	//step2-obj creation
	@FindBy(name="user_name")
	private WebElement usernameedit;
	
	@FindBy(name="user_password")
	private WebElement passwordedit;
	
	@FindBy(id="submitButton")
	private WebElement loginbtn;
	
	//step3-object init
		//step4-encapsulation
		

	public WebElement getUsernameedit() {
		return usernameedit;
	}

	public WebElement getPasswordedit() {
		return passwordedit;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}
	/**
	 * 
	 * @param username
	 * @param password
	 */
		//step5-provide action
	public void logintoapp(String username,String password)
	{
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.get(url);
		//driver.manage().window().maximize();
		usernameedit.sendKeys(username);
		passwordedit.sendKeys(password);
		loginbtn.click();
		
	}
		
	
	
}
