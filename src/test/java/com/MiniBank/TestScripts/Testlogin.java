package com.MiniBank.TestScripts;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.MiniBank.PageObject.HomePage;
import com.MiniBank.PageObject.LoginPage;

public class TestLogin extends BaseTest{
	LoginPage loginPage; 
	HomePage homePage;
	
	@Test
	public void loginTest() {
		loginPage = new LoginPage(BaseTest.driver);
		loginPage.setUserName(userName);
		loginPage.setPassword(password);
		loginPage.clickLogin();
		Assert.assertEquals(driver.getTitle(), "Guru99 Bank Manager HomePage", "Test Failed, Home Page title does not match");
	}
	
	@Test
	public void validateHomePageFields() {
		loginPage = new LoginPage(BaseTest.driver);
		loginPage.setUserName(userName);
		loginPage.setPassword(password);
		loginPage.clickLogin();
		
		//Validate below links are present
		homePage = new HomePage(BaseTest.driver);
		homePage.deleteCustomerLinkIsPresent();
		homePage.editCustomerLinkIsPresent();
		homePage.newCustomerLinkIsPresent();
	}
}
