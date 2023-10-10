package com.pages.vendorportal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends AbstractPage{
	
	
	
	@FindBy(id="username")
	private WebElement usernameInput;
	
	@FindBy(id="password")
	private WebElement passwordInput;
	
	@FindBy(id="login")
	private WebElement loginBtn;
	

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public boolean isAt() {
		this.wait.until(ExpectedConditions.visibilityOf(loginBtn));
		return this.loginBtn.isDisplayed();
	}
	
	public void goTo(String url) {
		this.driver.get(url);
	}
	
	public void enterdetails(String username,String password) {
		this.usernameInput.sendKeys(username);
		this.passwordInput.sendKeys(password);
		this.loginBtn.click();
	}
	
	
}

	


