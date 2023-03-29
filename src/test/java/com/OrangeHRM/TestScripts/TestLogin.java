package com.OrangeHRM.TestScripts;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.OrangeHRM.PageObject.HomePage;
import com.OrangeHRM.PageObject.LoginPage;

public class TestLogin extends BaseTest{
	LoginPage loginPage; 
	HomePage homePage;
	
	@Test
	public void loginTest() {
		loginPage = new LoginPage(BaseTest.driver);
		loginPage.setUserName(userName);
		loginPage.setPassword(password);
		loginPage.clickLogin();
		Assert.assertEquals(driver.getTitle(), "OrangeHRM", "Test Failed, Home Page title does not match");
	}
	
	@Test
	public void validateHomePageFields() {
		loginPage = new LoginPage(BaseTest.driver);
		loginPage.setUserName(userName);
		loginPage.setPassword(password);
		loginPage.clickLogin();
		
		//Validate below links are present
		homePage = new HomePage(BaseTest.driver);
		homePage.leaveLinkIsPresent();
		homePage.adminLinkPresent();
	}

	@Test
	public void validateLoginUnsuccessfulWithIncorrectCred() {
		loginPage = new LoginPage(BaseTest.driver);
		loginPage.setUserName(userName);
		loginPage.setPassword(incorrectPass);
		loginPage.clickLogin();

		Assert.assertTrue(loginPage.isErrorMessagePresent(), "User or Password is not valid");
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

		//logout
		loginPage.clickuserDropDown();
		loginPage.clickLogout();

		Assert.assertTrue(loginPage.passwordFieldPresent(), "Failed to logout");
		Assert.assertTrue(loginPage.userNameFieldPresent(), "Failed to logout");
	}

}
