package com.opencart.qa.pageobjects;

import com.opencart.qa.utility.Constants;
import com.opencart.qa.utility.ElementUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class SearchResultPage {

    private WebDriver driver;
    private ElementUtility elementutil;
    private WebDriverWait wait;

    private By searchNavButton = By.xpath("//span[@class=\'navigation_page\' and text()=\'Search\']");
    private By searchResult = By.cssSelector("#center_column>ul>li a.product-name");

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
        elementutil = new ElementUtility(driver);
    }

    public boolean isSearchNavBarAvailable() {
        return elementutil.waitForElementPresent(searchNavButton, Constants.DEFAULT_TIMEOUT);
    }

    public int getProductListCount() {
        elementutil.waitForElementPresent(searchNavButton, Constants.DEFAULT_TIMEOUT);
        return elementutil.getWebelements(searchResult).size();
    }

    public List<String> getProductList() {
        elementutil.waitForElementPresent(searchNavButton, Constants.DEFAULT_TIMEOUT);
        List<WebElement> products;
        List<String> productNames = new ArrayList<>();
        products = elementutil.getWebelements(searchResult);

        for (WebElement product : products) {
            productNames.add(product.getText());
        }

        return productNames;
    }

}
