package com.opencart.qa.core;

import com.opencart.qa.factory.DriverFactory;
import com.opencart.qa.pageobjects.AccountPage;
import com.opencart.qa.pageobjects.LoginPage;
import com.opencart.qa.pageobjects.RegistrationPage;
import com.opencart.qa.pageobjects.SearchResultPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.Properties;

public class BaseTest {
    public LoginPage loginPage;
    public WebDriver driver;
    public DriverFactory driverFactory;
    public Properties prop;
    public AccountPage accountPage;
    public SearchResultPage searchResultPage;
    public RegistrationPage registrationPage;


    @BeforeTest
    public void setup() {
        driverFactory = new DriverFactory();
        prop = driverFactory.readProperty();
        driver = driverFactory.init_driver(prop);
        loginPage = new LoginPage(driver);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
