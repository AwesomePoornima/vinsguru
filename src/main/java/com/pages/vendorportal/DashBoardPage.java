package com.pages.vendorportal;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DashBoardPage extends AbstractPage{
	
	private static final Logger log=LoggerFactory.getLogger(DashBoardPage.class);
	
	
	@FindBy(id="monthly-earning")
	//@FindBy(css="div[id='monthly-earning']")
	private WebElement monthlyEarningElement;
	
	@FindBy(id="annual-earning")
	//@FindBy(xpath="//div[id='annual-earning']")
	private WebElement annualEarningElement;
	
	@FindBy(id="profit-margin")
	private WebElement profitMarginElement;
	
	@FindBy(id="available-inventory")
	private WebElement availableInventoryElement;
	
	@FindBy(css="#dataTable_filter input")
	private WebElement searchBtn;	
	
	@FindBy(id="dataTable_info")
	private WebElement dataTableInfo;
	
	@FindBy(css="img.img-profile")
	private WebElement imgProfile;
	
	@FindBy(linkText="Logout")
	private WebElement firstLogout;
	
	@FindBy(css="#logoutModal a")
	private WebElement secondLogout;
	
	

	public DashBoardPage(WebDriver driver) {
		super(driver);
		
	}

	@Override
	public boolean isAt() {
		this.wait.until(ExpectedConditions.visibilityOf(searchBtn));
		return this.searchBtn.isDisplayed();
	}
	
	public String getMonthlyEarnings() {
		return this.monthlyEarningElement.getText();
	}
	
	public String getAnnualEarnings() {
		return this.annualEarningElement.getText();
	} 
	
	public String getProfitMargin() {
		return this.profitMarginElement.getText();
	}
	
	public String getAvailableInventory() {
		return this.availableInventoryElement.getText();
	}
	
	public void searchInput(String keyword) {
		this.searchBtn.sendKeys(keyword);
	}

	public int getInfo() {
		String results=this.dataTableInfo.getText();
		System.out.println("Results : " +results);
		String[] arr=results.split(" ");
		int count=Integer.parseInt(arr[5]);
		System.out.println("count :"+ count);
		log.info("Results Count : {}",count);
		return count;
		
	}
	
	public void logout() {
		this.imgProfile.click();
		this.wait.until(ExpectedConditions.visibilityOf(firstLogout));
		this.firstLogout.click();
		this.wait.until(ExpectedConditions.visibilityOf(secondLogout));
		this.secondLogout.click();
	}
}

