package com.MiniBank.TestScripts;


import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import com.MiniBank.PageObject.LoginPage;

public class TestLogin extends BaseTest{
	LoginPage loginPage; 
	@Test
	public void loginTest() {
		loginPage = new LoginPage(BaseTest.driver);
		loginPage.setUserName("mngr333727");
		loginPage.setPassword("UqUbypa");
		loginPage.clickLogin();
		AssertJUnit.assertEquals("Guru99 Bank Manager HomePage", driver.getTitle(), "Test Failed, Home Page title does not match");
	}
	
	@Test
	public void validateHomePageFields() {
		loginPage = new LoginPage(BaseTest.driver);
		loginPage.setUserName("mngr333727");
		loginPage.setPassword("UqUbypa");
		loginPage.clickLogin();
		AssertJUnit.assertEquals("Guru99 Bank Manager HomePage", driver.getTitle(), "Test Failed, Home Page title does not match");
	}
}
