package com.opencart.qa.tests;

import com.opencart.qa.utility.Constants;
import com.opencart.qa.core.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class SearchResultPageTest extends BaseTest {

    @BeforeClass
    public void searchResultPageSetup() {
        accountPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));

    }

    @Test(dataProvider = "searchData")
    public void searchResultCountTest( String productName) {
        searchResultPage = accountPage.doSearch(productName);

        int count = 0;
        if (productName.equalsIgnoreCase("Dresses")) {
            count = searchResultPage.getProductListCount();
            Assert.assertEquals(count, Constants.DRESSES_SEARCH_RESULT_COUNT);
        } else if (productName.equalsIgnoreCase("T-Shirts")) {
            count = searchResultPage.getProductListCount();
            Assert.assertEquals(count, Constants.TSHIRTS_SEARCH_RESULT_COUNT);
        }

    }

    @Test(dataProvider = "searchData")
    public void searchResultsTest(String productName) {
        searchResultPage = accountPage.doSearch(productName);
        List<String> productNames=new ArrayList<>();
        productNames= searchResultPage.getProductList();
        Assert.assertEquals(productNames,Constants.AVAIALABLE_DRESSES_NAMES);
    }

    @DataProvider(name="searchData")
    public Object[][] getSearchData()
    {
        return new Object[][]
        {
            {"Dresses"}
        };
    }

}
