package com.tests.vendorportal;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.pages.vendorportal.DashBoardPage;
import com.pages.vendorportal.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VendorPortalTest {
	
	private WebDriver driver;
	@BeforeTest
	
	public void setDriver() {
		
		//driver setup
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		this.driver=new ChromeDriver();
		this.driver.manage().window().maximize();
	}
	
	@Test
	public void loginPageTest() {
		LoginPage login=new LoginPage(driver);
		login.goTo("https://d1uh9e7cu07ukd.cloudfront.net/selenium-docker/vendor-app/index.html");
		Assert.assertTrue(login.isAt());
		login.enterdetails("sam", "sam");
	}
	   @Test(dependsOnMethods = "loginPageTest")
		public void dashBoardTest() {
			DashBoardPage DBoard=new DashBoardPage(driver);
			Assert.assertTrue(DBoard.isAt());
			
			
			//finance metrics validation
			Assert.assertEquals(DBoard.getMonthlyEarnings(), "$40,000");
			Assert.assertEquals(DBoard.getAnnualEarnings(),"$215,000");
			Assert.assertEquals(DBoard.getProfitMargin(),"50%");
			Assert.assertEquals(DBoard.getAvailableInventory(),"18");
			
			
			DBoard.searchInput("Adams");
			Assert.assertEquals(DBoard.getInfo(), 8);
			
			DBoard.logout();
			
			
		}
	    
	    @AfterTest()
		public void finish() {
			this.driver.quit();
		}
		
	}
	


