package com.MiniBank.TestScripts;


import org.openqa.selenium.Alert;
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

	@Test
	public void validateLoginUnsuccessfulWithIncorrectCred() {
		loginPage = new LoginPage(BaseTest.driver);
		loginPage.setUserName(userName);
		loginPage.setPassword(incorrectPass);
		loginPage.clickLogin();

		String alertText = getAlertText();
		Assert.assertEquals(alertText, "User or Password is not valid", "alert text does not match");
	}

	@Test
	public void validateResetLoginCred() {
		loginPage = new LoginPage(BaseTest.driver);
		loginPage.setUserName(userName);
		loginPage.setPassword(password);
		loginPage.clickReset();

		String userId = loginPage.getUserIdTextfieldText();
		String password = loginPage.getPasswordTextfieldText();

		Assert.assertTrue(userId.isEmpty(), "UserId is not reset");
		Assert.assertTrue(password.isEmpty(), "Password is not reset");
	}

	@Test
	public void validateLogout() {
		loginPage = new LoginPage(BaseTest.driver);
		loginPage.setUserName(userName);
		loginPage.setPassword(password);
		loginPage.clickLogin();
		Assert.assertEquals(driver.getTitle(), "Guru99 Bank Manager HomePage", "Test Failed, Home Page title does not match");

		//logout
		loginPage.clickLogout();

		String logoutText = getAlertText();
		Assert.assertEquals(logoutText, "You Have Succesfully Logged Out!!", "Failed to logout from app");

	}
}
