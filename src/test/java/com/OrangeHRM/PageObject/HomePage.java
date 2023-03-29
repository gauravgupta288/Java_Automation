package com.OrangeHRM.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage extends BasePage{
	
	public HomePage(WebDriver driver) {
		super(driver);
	} 
	@FindBy(xpath = "//span[text()= 'Admin']") WebElement adminLink;
	@FindBy(xpath = "//span[text()= 'Leave']") WebElement leaveLink;
	@FindBy(name = "name']") WebElement customerName;

	@FindBy(xpath = "//input[@name = 'rad1' and @value = 'f']']") WebElement gender;

	@FindBy(id = "dob") WebElement dob;

	@FindBy(name = "addr") WebElement address;

	@FindBy(name = "city") WebElement city;

	@FindBy(name = "state") WebElement state;

	@FindBy(name = "pinno") WebElement pinno;

	@FindBy(name = "telephoneno") WebElement telephoneno;

	@FindBy(name = "emailid") WebElement emailid;

	@FindBy(name = "password") WebElement password;

	@FindBy(name = "sub") WebElement submit;

	@FindBy(xpath = "//button[@type= 'submit']") WebElement submitBtn;
	@FindBy(id = "dismiss-button") WebElement dismissAd;

	@FindBy(xpath = "//*[@class = 'oxd-table-body']//div//div//div[2]")
	List<WebElement> searchResults;

	@FindBy(xpath = "(//*[@class = 'oxd-input oxd-input--active'])[2]") WebElement searchBox;

	@FindBy(xpath = "//*[@class = 'oxd-icon bi-trash']") WebElement deleteBtn;


	public void adminLinkPresent() {
		adminLink.isDisplayed();
	}
	public void leaveLinkIsPresent() {
		leaveLink.isDisplayed();
	}

	public void enterCustomerName(String name){
		customerName.sendKeys(name);
	}

	public void selectGender(){
		gender.click();
	}
	public void enterDateOfBirth(String date){
		dob.sendKeys(date);
	}
	public void setAddress(String addr){
		address.sendKeys(addr);
	}public void enterEmail(String email){
		emailid.sendKeys(email);
	}
	public void enterPassword(String pass){
		password.sendKeys(pass);
	}public void enterCity(String cityName){
		city.sendKeys(cityName);
	}public void enterState(String stateName){
		state.sendKeys(stateName);
	}
	public void enterTelephone(String tele){
		telephoneno.sendKeys(tele);
	}
	public void enterPin(String pin){
		pinno.sendKeys(pin);
	}

	public void submitRequest(){
		submit.click();
	}

	public void dismissAd(){
		dismissAd.click();
		driver.switchTo().defaultContent();
	}

	public void switchToIFrame(){
		driver.switchTo().frame("ad_iframe");
	}

	public boolean verifySearchResult(String result){
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class = 'oxd-icon bi-trash']")));
		for(WebElement res : searchResults){
			if(!result.equals(res.getText())){
				return false;
			}
		}
		return searchResults.size() == 0 ? false : true;
	}

	public void clickAdmin(){
		adminLink.click();
	}
	public void search(String name){
		searchBox.sendKeys(name);
	}

	public void clickSearch(){
		submitBtn.click();
	}
}
