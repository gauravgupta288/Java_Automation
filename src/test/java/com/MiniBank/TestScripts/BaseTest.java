package com.MiniBank.TestScripts;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.MiniBank.Utilities.ReadConfig;

public class BaseTest {
	ReadConfig readConfig = new ReadConfig();
	String baseURL = readConfig.getBaseURL();
	
	String userName = readConfig.getBaseUserName();
	String password = readConfig.getBasePassword();

	String incorrectPass = readConfig.getInvalidPassword();
	public static WebDriver  driver;
	static Logger logger = Logger.getLogger(BaseTest.class);

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);
		driver.manage().window().maximize();
		
		Logger.getLogger("Testlog.txt");
		String log4jConfigFile = System.getProperty("user.dir") + File.separator + "log4j.properties";
				PropertyConfigurator.configure(log4jConfigFile);
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
