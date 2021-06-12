package com.MiniBank.TestScripts;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.MiniBank.PageObject.BaseTest;
import com.MiniBank.PageObject.LoginPage;

public class Testlogin extends BaseTest{
	LoginPage loginPage = new LoginPage();
	WebDriver driver;
	
	@Test
	public void loginTest() {
		System.out.println("login test");
		loginPage.setUserName("mngr333727");
		loginPage.setPassword("UqUbypa");
		loginPage.clickLogin();
	}
}
