package com.trycloud.tests.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

    //TASK: NEW METHOD CREATION
    //   Method name: getDriver
    //   Static method
    //   Accepts string argument: browserType --> will determine what browser opens
    //       -> if "chrome" opens chrome browser
    //       -> if "firefox" opens firefox browser
    //   return type: WebDriver

    public static WebDriver getDriver(String browserType) {
        if ("chrome".equalsIgnoreCase(browserType)) {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        } else if ("firefox".equalsIgnoreCase(browserType)) {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        } else {
            return null;
        }


    }
}
