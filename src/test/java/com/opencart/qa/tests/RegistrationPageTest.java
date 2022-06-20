package com.opencart.qa.tests;

import com.opencart.qa.utility.Constants;
import com.opencart.qa.utility.EmailGenerator;
import com.opencart.qa.utility.ExcelReader;
import com.opencart.qa.core.BaseTest;
import com.opencart.qa.pageobjects.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegistrationPageTest extends BaseTest {

    EmailGenerator emailgen;

    @BeforeClass
    public void setupRegistration() {
        registrationPage = new RegistrationPage(driver);
        emailgen = new EmailGenerator();

    }

    @Test(dataProvider = "getRegistrationDataFromExcel")
    public void registrationTest(String firstName, String lastName,
                                 String add1, String city, String state, String postalcode, String mobile) {
        registrationPage.doRegistration(emailgen.getRandomEmail(), firstName, lastName, "Welcome@123"
                , add1, city, state, postalcode, mobile);
        Assert.assertTrue(registrationPage.isLogOutAvailable());
        registrationPage.logOut();
    }
/*
    @DataProvider(name = "registrationData1")
    public Object[][] getRegistrationDate() {
        return new Object[][]
                {
                        {"Test", "user", "Welcome@123", "street 1", "mtv", "Hawaii", "94086", "3245678901"}
                };
    }
*/

    @DataProvider
    public Object[][] getRegistrationDataFromExcel() {
        System.out.println("inside registration data");
        Object[][] data=ExcelReader.getTestData(Constants.REGISTRATION_TEST_DATA);
        return data;
    }

}
