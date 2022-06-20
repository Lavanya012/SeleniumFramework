package com.opencart.qa.pageobjects;

import com.opencart.qa.utility.Constants;
import com.opencart.qa.utility.ElementUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;
    private ElementUtility elementUtil;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        elementUtil = new ElementUtility(driver);
    }

    private By emailId = By.id("email");
    private By password = By.id("passwd");
    private By loginButton = By.xpath("//button[@id='SubmitLogin']");
    private By forgetPass = By.linkText("Forgot your password?");

    public AccountPage doLogin(String email, String pass) {
        elementUtil.doTypeText(emailId, email);
        elementUtil.doTypeText(password, pass);
        elementUtil.doClick(loginButton);
        return new AccountPage(driver);
    }

    public String getPageTitle() {
        return elementUtil.waitForTitle(5, Constants.LOGIN_PAGE_TITLE);
    }

    public boolean isForgotPasswordLinkExists() {
        return elementUtil.waitForElementPresent(forgetPass,5);

    }

}
