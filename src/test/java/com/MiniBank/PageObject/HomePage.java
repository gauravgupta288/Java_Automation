package com.MiniBank.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	public HomePage(WebDriver driver) {
		super(driver);
	} 
	@FindBy(xpath = "//a[text()='New Customer']") WebElement newCustomer;
	@FindBy(xpath = "//a[text()='Edit Customer']") WebElement editCustomer;
	@FindBy(xpath = "//a[text()='Delete Customer']") WebElement deleteCustomer;
	
	public void newCustomerLinkIsPresent() {
		newCustomer.isDisplayed();
	}
	public void editCustomerLinkIsPresent() {
		editCustomer.isDisplayed();
	}
	public void deleteCustomerLinkIsPresent() {
		deleteCustomer.isDisplayed();
	}
}
