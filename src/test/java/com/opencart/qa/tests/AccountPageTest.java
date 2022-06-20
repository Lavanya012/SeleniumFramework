package com.opencart.qa.tests;


import com.opencart.qa.utility.Constants;
import com.opencart.qa.core.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AccountPageTest extends BaseTest {


    @BeforeClass
    public void accountPageSetup() {
        accountPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
    }


    @Test(priority = 1)
    public void accountPageTitleTest() {
        Assert.assertEquals(accountPage.getPageTitle(), Constants.ACCOUNT_PAGE_TITLE);
    }


    @Test(priority = 2)
    public void accountOptionsAvailabilityTest() {
        Assert.assertEquals(accountPage.getOptionsTextAvailableOnAccount(), Constants.ACCOUNT_PAGE_OPTIONS);
    }

    @Test(priority = 3)
    public void searchTextBoxAvailabilityTest() {
        Assert.assertTrue(accountPage.isSearchBoxAvailable());
    }



}
