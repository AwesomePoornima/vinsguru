package com.pages.flightreservation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.pages.vendorportal.AbstractPage;

public class flightSelection extends AbstractPage{
	
	@FindBy(id="dep-emirates-business")//not used
	private WebElement depFlights;
	
	@FindBy(id="arr-qatar-business")//not used
	private WebElement arrFlights;
	
	@FindBy(id="confirm-flights")
	private WebElement confirmFights;


	public flightSelection(WebDriver driver) {
		super(driver);
		
	}

	@Override
	public boolean isAt() {
	this.wait.until(ExpectedConditions.visibilityOf(arrFlights));
	return this.arrFlights.isDisplayed();
	}
	
	
		public void depart(String dFlight) {
			this.driver.findElement(By.id(dFlight)).click();
			
		}
	
		public void arrive(String aFlight) {
			this.driver.findElement(By.id(aFlight)).click();
			
		}

	public void arrival() {
		this.arrFlights.click();
	}
	
	public void confirm() {
		this.confirmFights.click();
	}
}
