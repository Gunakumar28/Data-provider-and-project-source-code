package data.provider;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseclass.libglobal.LibGlobal;

public  class AcdatinParameter extends LibGlobal{
	
	public AcdatinParameter() {
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath ="//*[@id='username']")
	private WebElement username;
	
	
	@FindBy(id = "password")
	private WebElement password;
	
	@FindBy(xpath="//*[@id='login']")
	private WebElement signIn;

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getSignIn() {
		return signIn;
	}
	
	
	
	
	
	
	
	
	
}
