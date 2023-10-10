package com.pages.flightreservation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.pages.vendorportal.AbstractPage;

public class FlightSearch extends AbstractPage{
	
	@FindBy(id="twoway")
	private WebElement roundTripSelect;
	
	@FindBy(id="passengers")
	private WebElement passengersSelect;
	
	@FindBy(id="depart-from")
	private WebElement departFrom;
	
	@FindBy(id="arrive-in")
	private WebElement arriveIn;
	
	
	@FindBy(id="search-flights")
	private WebElement searchFlightsBtn;
	
	

	public FlightSearch(WebDriver driver) {
		super(driver);
		
	}

	@Override
	public boolean isAt() {
    this.wait.until(ExpectedConditions.visibilityOf(searchFlightsBtn));
	return this.searchFlightsBtn.isDisplayed();
	}
	
	public void roundTrip() {
		this.roundTripSelect.click();	
	}
	public void noOfPassengers(String number) {
	//public void noOfPassengers(String number,String serviceClass) {
		Select p=new Select(this.passengersSelect);
		p.selectByValue(number);
		//this.driver.findElement(By.xpath("//input[@value='"+ serviceClass + "']")).click();//to choose random value
	}
	
	
	public void flightSearchClick() {
		this.searchFlightsBtn.click();
	}
	
	
	

}
