package com.OrangeHRM.TestScripts;

import com.OrangeHRM.PageObject.HomePage;
import com.OrangeHRM.PageObject.LoginPage;
import com.OrangeHRM.Utilities.Common;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestHome extends BaseTest{
    LoginPage loginPage;

    HomePage homePage;

    @Test
    public void validateNewCustomerCanBeAdded(){
        loginPage = new LoginPage(BaseTest.driver);
        loginPage.setUserName(userName);
        loginPage.setPassword(password);
        loginPage.clickLogin();

        homePage = new HomePage(BaseTest.driver);
        homePage.clickAdmin();
        homePage.search("Admin");
        homePage.clickSearch();
        Assert.assertTrue(homePage.verifySearchResult("Admin"), "Search result not matched");

    }
}
