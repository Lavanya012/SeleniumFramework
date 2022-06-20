package com.opencart.qa.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ElementUtility {

    WebDriver driver;
    WebDriverWait wait;

    public ElementUtility(WebDriver driver) {
        this.driver = driver;
    }

    public void doTypeText(By locator, String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.DEFAULT_TIMEOUT));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        driver.findElement(locator).sendKeys(text);
    }

    public void clearAndDoTypeText(By locator, String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.DEFAULT_TIMEOUT));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator)).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public void doClick(By locator) {
        driver.findElement(locator).click();
    }

    public void doClick(By locator,int time)
    {
        wait= new WebDriverWait(driver,Duration.ofSeconds(time));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator)).click();
    }

    public String waitForTitle(int time, String title) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.titleIs(title));
        return driver.getTitle();
    }

    public boolean waitForElementPresent(By locator, int time) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator)).isDisplayed();

    }

    public List<WebElement> getWebelements(By locator) {
        return driver.findElements(locator);
    }


    public WebElement getElementUsingByLocator(By locator) {
        return driver.findElement(locator);
    }

    public void selectElementByVisibleText(By locator, String text) {
        Select select = new Select(getElementUsingByLocator(locator));
        select.selectByVisibleText(text);
    }


}
