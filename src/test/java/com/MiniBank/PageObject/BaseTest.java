package com.MiniBank.PageObject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
	String baseURL = "http://demo.guru99.com/v4/index.php";
	String userName = "";
	String password = "";
	public static WebDriver  driver;
	public BaseTest() {
	}
	@BeforeClass
	public void setup() {
		System.out.println("before class");
		driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);
		
	}
	@AfterClass
	public void teardown() {
		System.out.print("after class");
		driver.quit();
		
	}
}
