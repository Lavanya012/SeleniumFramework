package com.opencart.qa.factory;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Properties;

public class OptionsManager {

    private Properties prop;
    private ChromeOptions chromeoptions;
    private FirefoxOptions firefoxoptions;

    public OptionsManager(Properties prop) {
        this.prop = prop;
    }

    public ChromeOptions getChromeOptions() {
        chromeoptions = new ChromeOptions();

        if (Boolean.parseBoolean(prop.getProperty("headless"))) {
            // co.setHeadless(true);
            chromeoptions.addArguments("--headless");
        }

        if (Boolean.parseBoolean(prop.getProperty("incognito"))) {
            chromeoptions.addArguments("--inconito");
        }

        return chromeoptions;
    }

    public FirefoxOptions getFirefocOptions() {
        firefoxoptions = new FirefoxOptions();

        if (Boolean.parseBoolean(prop.getProperty("headless"))) {
            // co.setHeadless(true);
            firefoxoptions.addArguments("--headless");
        }

        if (Boolean.parseBoolean(prop.getProperty("incognito"))) {
            firefoxoptions.addArguments("--inconito");
        }

        return firefoxoptions;
    }


}
