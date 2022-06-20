package com.opencart.qa.tests;


import com.opencart.qa.utility.Constants;
import com.opencart.qa.core.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {


    @Test(priority = 1)
    public void loginPageTitleTest() {
        Assert.assertEquals(loginPage.getPageTitle(), Constants.LOGIN_PAGE_TITLE);
    }

    @Test(priority = 2)
    public void forgetPassLinkTest() {
        Assert.assertTrue(loginPage.isForgotPasswordLinkExists());
    }

    @Test(priority = 3)
    public void loginTest() {
        accountPage=  loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
        Assert.assertTrue(accountPage.isMyAccountNavBarAvailable());
    }


}
