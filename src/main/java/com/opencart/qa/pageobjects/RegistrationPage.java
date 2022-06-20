package com.opencart.qa.pageobjects;

import com.opencart.qa.utility.Constants;
import com.opencart.qa.utility.ElementUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {

    private WebDriver driver;
    private ElementUtility elementUtility;

    private By email_id = By.cssSelector("input#email_create");
    private By SubmitCreateButton=By.id("SubmitCreate");
    private By gender = By.xpath("//input[@id='id_gender1']");
    private By customer_firstname = By.cssSelector("#customer_firstname");
    private By customer_lastname = By.cssSelector("#customer_lastname");
    private By passwd = By.cssSelector("#passwd");
    private By firstname = By.cssSelector("#firstname");
    private By lastname = By.cssSelector("#lastname");
    private By address1 = By.cssSelector("#address1");
    private By city_text = By.cssSelector("#city");
    private By id_state = By.cssSelector("#id_state");
    private By postcode = By.cssSelector("#postcode");
    private By phone_mobile = By.cssSelector("#phone_mobile");
    private By submitAccount = By.cssSelector("#submitAccount");
    private By logout=By.cssSelector("a.logout");


    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        elementUtility = new ElementUtility(driver);
    }


    public void doRegistration(String email,String firstName,String lastName,String pass
                               ,String add1,String city,String state,String postalcode,String mobile )
    {
        elementUtility.doTypeText(email_id,email);
        elementUtility.doClick(SubmitCreateButton);
        elementUtility.doClick(gender, Constants.DEFAULT_TIMEOUT);
        elementUtility.doTypeText(customer_firstname,firstName);
        elementUtility.doTypeText(customer_lastname,lastName);
        elementUtility.doTypeText(passwd,pass);
        elementUtility.doTypeText(firstname,firstName);
        elementUtility.doTypeText(lastname,lastName);
        elementUtility.doTypeText(address1,add1);
        elementUtility.doTypeText(city_text,city);
        elementUtility.selectElementByVisibleText(id_state,state);
        elementUtility.doTypeText(postcode,postalcode);
        elementUtility.doTypeText(phone_mobile,mobile);
        elementUtility.doClick(submitAccount);
    }

    public boolean isLogOutAvailable()
    {
        return elementUtility.waitForElementPresent(logout,Constants.DEFAULT_TIMEOUT);
    }

    public void logOut()
    {
        elementUtility.doClick(logout,Constants.DEFAULT_TIMEOUT);
    }
}
