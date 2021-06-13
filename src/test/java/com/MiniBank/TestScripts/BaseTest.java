package com.MiniBank.TestScripts;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	String baseURL = "http://demo.guru99.com/v4/index.php";
	String userName = "";
	String password = "";
	public static WebDriver  driver;
	public BaseTest() {
		
	}
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "/Users/gaurav.gupta/Downloads/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);
		
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
		
	}
}
