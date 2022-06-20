package com.opencart.qa.utility;

import java.util.Random;

public class EmailGenerator {

    public String getRandomEmail()
    {
        Random random= new Random();
        return "tesEmail"+random.nextInt(100000)+"@yopmail.com";
    }
}
