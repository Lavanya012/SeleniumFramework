package com.opencart.qa.pageobjects;

import com.opencart.qa.utility.Constants;
import com.opencart.qa.utility.ElementUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AccountPage {

    private WebDriver driver;
    private ElementUtility elementutil;

    private By myAccountNav = By.xpath("//span[text()='My account']");
    private By accountOptions = By.xpath("//div[@id='center_column']//ul[@class='myaccount-link-list']/li");
    private By searchBox = By.cssSelector("#search_query_top");
    private By searchButton=By.cssSelector("button[name='submit_search']");


    public AccountPage(WebDriver driver) {
        this.driver = driver;
        elementutil = new ElementUtility(driver);
    }

    public String getPageTitle() {
        return elementutil.waitForTitle(Constants.DEFAULT_TIMEOUT, Constants.ACCOUNT_PAGE_TITLE);
    }

    public boolean isMyAccountNavBarAvailable() {
        return elementutil.waitForElementPresent(myAccountNav, Constants.DEFAULT_TIMEOUT);
    }

    public List<String> getOptionsTextAvailableOnAccount() {
        List<WebElement> options = elementutil.getWebelements(accountOptions);
        System.out.println("Account options got after login:" + options.size());

        List<String> optionsText = new ArrayList<>();
        for (WebElement element : options) {
            optionsText.add(element.getText().toUpperCase());
        }
        System.out.println(optionsText);
        return optionsText;
    }

    public boolean isSearchBoxAvailable() {
        return elementutil.waitForElementPresent(searchBox, Constants.DEFAULT_TIMEOUT);
    }

    public SearchResultPage doSearch(String ProductName) {
        if (isSearchBoxAvailable()) {
            System.out.println("Search Box found");
            elementutil.clearAndDoTypeText(searchBox, ProductName);
            elementutil.doClick(searchButton);
            return new SearchResultPage(driver);
        }
        return null;
    }


}
