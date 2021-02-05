package com.trycloud.tests.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginUtils {

    public static void loginToTryCloud(WebDriver driver, String username){
        driver.get(ConfigurationReader.getProperty("webUrl3"));
        // Enter Username
        WebElement inputUsername = driver.findElement(By.id("user"));
        inputUsername.sendKeys(username);

        // Enter Password:
        WebElement inputPassword = driver.findElement(By.id("password"));
        inputPassword.sendKeys(ConfigurationReader.getProperty("password"));

        // Click to Login button
        WebElement loginButton = driver.findElement(By.id("submit-form"));
        loginButton.click();
    }

}
