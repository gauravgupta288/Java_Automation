package com.MiniBank.PageObject;


import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.MiniBank.Utilities.ReadXMLFile;

public class LoginPage extends BasePage{
	ReadXMLFile readXML;
	HashMap<String, String> hMap;
	
	
	public LoginPage(WebDriver driver) {
		super(driver);
		readXML = new ReadXMLFile();
		hMap = readXML.parseXML("LoginPage.xml");
	}
	@FindBy(name= "uid") WebElement txtUserName;
	@FindBy(name="password") WebElement txtPassword;
	@FindBy(name="btnLogin") WebElement btnLogin;

	@FindBy(name="btnReset") WebElement btnReset;

	@FindBy(xpath="//a[text()='Log out']") WebElement logOut;

	public void setUserName(String username) {
		txtUserName.clear();
		txtUserName.sendKeys(username);
	}
	public void setPassword(String password) {
		txtPassword.clear();
		txtPassword.sendKeys(password);
	}
	public void clickLogin() {
		btnLogin.click();
	}

	public void clickReset() {
		btnReset.click();
	}

	public String getUserIdTextfieldText() {
		return txtUserName.getText();
	}

	public String getPasswordTextfieldText() {
		return txtPassword.getText();
	}

	public void clickLogout() {
		logOut.click();
	}
}
