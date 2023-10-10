package com.pages.flightreservation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.pages.vendorportal.AbstractPage;

public class RegistrationConfirmation extends AbstractPage{
	
	@FindBy(id="go-to-flights-search")
	private WebElement flightSearchBtn;
		
	
	public RegistrationConfirmation(WebDriver driver) {
		super(driver);
	}
	
	public boolean isAt() {
		this.wait.until(ExpectedConditions.visibilityOf(flightSearchBtn));
		return this.flightSearchBtn.isDisplayed();
	}

	 public void searchButton() {
		 this.flightSearchBtn.click();
	 }
}
