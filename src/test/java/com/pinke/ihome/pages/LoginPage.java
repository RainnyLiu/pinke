package com.pinke.ihome.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy(name="username")
	private WebElement username_input;
	
	@FindBy(name="password")
	private WebElement password_input;	

	@FindBy(id="login-ent-btn")
	private WebElement submit_btn;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void doLogin(String username,String password) {
		username_input.sendKeys(username);
		password_input.sendKeys(password);
		submit_btn.click();
	}
	
	

}
