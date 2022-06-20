package com.opencart.qa.utility;

import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

public class Constants {

    public static final String LOGIN_PAGE_TITLE = "Login - My Store";
    public static final String ACCOUNT_PAGE_TITLE = "My account - My Store";
    public static final int DRESSES_SEARCH_RESULT_COUNT = 7;
    public static final int TSHIRTS_SEARCH_RESULT_COUNT = 1;
    public static final String REGISTRATION_TEST_DATA = "Registration";
    public static final String TEST_DATA_SHEET_PATH = "./src/resources/TestData/TestData.xlsx";
    public static int DEFAULT_TIMEOUT = 5;
    public static final List<String> ACCOUNT_PAGE_OPTIONS= Arrays.asList("ORDER HISTORY AND DETAILS","MY CREDIT SLIPS","MY ADDRESSES","MY PERSONAL INFORMATION","MY WISHLISTS");
    public static final List<String> AVAIALABLE_DRESSES_NAMES=Arrays.asList("Printed Summer Dress", "Printed Dress", "Printed Summer Dress", "Printed Chiffon Dress", "Printed Dress", "Faded Short Sleeve T-shirts", "Blouse");

}
