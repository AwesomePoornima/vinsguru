package com.pages.flightreservation;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.pages.vendorportal.AbstractPage;

public class Registration extends AbstractPage {
	
	
	
	

	@FindBy(id="firstName")
	private WebElement firsttNameInput;
	
	@FindBy(id="lastName")
	private WebElement lasttNameInput;
	
	@FindBy(id="email")
	private WebElement emailInput;
	
	@FindBy(id="password")
	private WebElement passwordInput;
	
	@FindBy(name="street")
	private WebElement streetInput;
	
	@FindBy(name="city")
	private WebElement cityInput;
	
	@FindBy(id="inputState")
	private WebElement stateInput;
	
	@FindBy(name="zip")
	private WebElement zipInput;
	
	@FindBy(id="register-btn")
	private WebElement registerbtn;
	
	public Registration(WebDriver driver) {
		super(driver);
		
	}
	
	public void goTo(String URL) {
		this.driver.get(URL);
	}
	
	public  boolean isAt() {
		this.wait.until(ExpectedConditions.visibilityOf(firsttNameInput));
		return this.firsttNameInput.isDisplayed();
		
	}
	
	

	public void enterUserDetails(String fName,String lName) {
	this.firsttNameInput.sendKeys(fName);
	this.lasttNameInput.sendKeys(lName);
	}
	
	public void loginDetails(String email,String password) {
	this.emailInput.sendKeys(email);
	this.passwordInput.sendKeys(password);	
	}
	
	public void addressDetails(String street,String city,String state,String zip) {
	this.streetInput.sendKeys(street);
	this.cityInput.sendKeys(city);
	Select s=new Select(this.stateInput);
	s.selectByValue(state);
	this.zipInput.sendKeys(zip);
	}
	
	public void register() {
	this.registerbtn.click();
}
	
	

}
