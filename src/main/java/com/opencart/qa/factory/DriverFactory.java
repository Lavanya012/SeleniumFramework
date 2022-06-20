package com.opencart.qa.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DriverFactory {

    public WebDriver driver;
    public OptionsManager optionsManager;
    public static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();

    public static final Logger log= Logger.getLogger(DriverFactory.class);


    public WebDriver init_driver(Properties prop) {
        String browserName = prop.getProperty("browser");
        optionsManager = new OptionsManager(prop);

        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            // driver = new ChromeDriver(optionsManager.getChromeOptions());
            threadLocal.set(new ChromeDriver(optionsManager.getChromeOptions()));
        } else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            threadLocal.set(new FirefoxDriver(optionsManager.getFirefocOptions()));
            // driver = new FirefoxDriver(optionsManager.getFirefocOptions());
        }

        openUrl(prop.getProperty("url"));

        return getDriver();//Returning Thread local driver to avoid issues with parellel executions
    }

    /**
     * threadlocal.get() will return the driver we set in init_driver method.
     *
     * @return driver
     */
    public static WebDriver getDriver() {
        return threadLocal.get();
    }

    public void openUrl(String url) {
        getDriver().get(url);
    }


    public Properties readProperty() {
        FileInputStream fis = null;
        Properties prop = new Properties();

        String envName = System.getProperty("env");
        System.out.println("Running on env:" + envName);

        if (envName == null) {
            System.out.println("no env is provided");
            try {
                fis = new FileInputStream("./src/resources/Config/config.properties");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            try {

                switch (envName) {
                    case "qa":
                        fis = new FileInputStream("./src/resources/Config/config_QA.properties");
                        break;

                    case "uat":
                        fis = new FileInputStream("./src/resources/Config/config_UAT.properties");
                        break;
                }
            } catch (FileNotFoundException exc) {
                exc.printStackTrace();
            }

        }
        try {
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return prop;
    }


    /**
     * Execution from local
     * try {
     * fis = new FileInputStream("./src/resources/Config/config.properties");
     * } catch (FileNotFoundException fe) {
     * System.out.println("File path not found");
     * }
     * try {
     * prop.load(fis);
     * } catch (IOException e) {
     * e.printStackTrace();
     * }
     * return prop;
     * }
     */


    public static String getScreenshot() {
        File srcfile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png";
        File destination = new File(path);
        try {
            FileUtils.copyFile(srcfile, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return path;
    }
}
