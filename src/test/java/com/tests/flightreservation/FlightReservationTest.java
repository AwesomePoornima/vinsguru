package com.tests.flightreservation;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.pages.flightreservation.FlightConfirmation;
import com.pages.flightreservation.FlightSearch;
import com.pages.flightreservation.Registration;
import com.pages.flightreservation.RegistrationConfirmation;
import com.pages.flightreservation.flightSelection;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlightReservationTest {
	
	private WebDriver driver;
	String nOfPassengers;
	String expectedPrice;
	
	@BeforeTest
	@Parameters({"nOfPassengers","expectedPrice"})
	public void setDriver(String nOfPassengers,String expectedPrice) {
		this.nOfPassengers=nOfPassengers;
		this.expectedPrice=expectedPrice;
		//driver setup
		WebDriverManager.chromedriver().setup();
		this.driver=new ChromeDriver();
		this.driver.manage().window().maximize();
	}
	
	@Test
	public void registrationTest() {
		Registration Rtest=new Registration(driver);
		Rtest.goTo("https://d1uh9e7cu07ukd.cloudfront.net/selenium-docker/reservation-app/index.html");
		Assert.assertTrue(Rtest.isAt());
		Rtest.enterUserDetails("Selenium", "Automation");
		Rtest.loginDetails("poornima18s@gmail.com", "star");
		Rtest.addressDetails("800 Fortmill", "Ayrshire","Alaska", "12345");
		Rtest.register();
		
	}
	@Test(dependsOnMethods="registrationTest")
	public void registrationConfirmationTest() {
		RegistrationConfirmation RConTest=new RegistrationConfirmation(driver);
		AssertJUnit.assertTrue(RConTest.isAt());
		RConTest.searchButton();
		
	}
	 
	@Test(dependsOnMethods="registrationConfirmationTest")
	public void flightSearchTest() {
		FlightSearch FSearch=new FlightSearch(driver);
		AssertJUnit.assertTrue(FSearch.isAt());
		FSearch.roundTrip();
		FSearch.noOfPassengers(nOfPassengers);
		//FSearch.noOfPassengers("2","business");
		FSearch.flightSearchClick();
	}
	
	@Test(dependsOnMethods="flightSearchTest")
	public void flightSelectionTest() {
	 flightSelection fs=new flightSelection(driver);
	 AssertJUnit.assertTrue(fs.isAt());
	 fs.depart("dep-qatar-first");
	 fs.arrive("arr-qatar-first");
	 fs.confirm();
		
		}

	@Test(dependsOnMethods="flightSelectionTest")
	public void FlightConfirmationTest() {
		FlightConfirmation FConfirm=new FlightConfirmation(driver);
		AssertJUnit.assertTrue(FConfirm.isAt());
		String expectedPrice=FConfirm.fconfirm();
		System.out.println(expectedPrice);
		
	}
	
	@AfterTest
	public void Finish() {
		this.driver.quit();
	}
	
	
	
}
