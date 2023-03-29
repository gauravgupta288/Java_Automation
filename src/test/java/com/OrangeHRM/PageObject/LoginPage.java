package com.OrangeHRM.PageObject;


import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.OrangeHRM.Utilities.ReadXMLFile;

public class LoginPage extends BasePage{
	ReadXMLFile readXML;
	HashMap<String, String> hMap;
	
	
	public LoginPage(WebDriver driver) {
		super(driver);
		readXML = new ReadXMLFile();
		hMap = readXML.parseXML("LoginPage.xml");
	}
	@FindBy(name= "username") WebElement txtUserName;
	@FindBy(name="password") WebElement txtPassword;
	@FindBy(xpath="//button[text()= ' Login ']") WebElement btnLogin;

	@FindBy(xpath="//p[text()= 'Invalid credentials']") WebElement invalidCredErrorMessage;

	@FindBy(name="btnReset") WebElement btnReset;

	@FindBy(className="oxd-userdropdown-name") WebElement userDropDown;

	@FindBy(xpath="//*[text()= 'Logout']") WebElement logout;

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

	public void clickuserDropDown() {
		userDropDown.click();
	}

	public boolean isErrorMessagePresent(){
		return invalidCredErrorMessage.isDisplayed();
	}

	public void clickLogout(){
		logout.click();
	}

	public boolean userNameFieldPresent(){
		return txtUserName.isDisplayed();
	}

	public boolean passwordFieldPresent(){
		return txtPassword.isDisplayed();
	}
}
