package com.trycloud.tests.base.jitendra_US_5;

import com.trycloud.tests.utilities.ConfigurationReader;
import com.trycloud.tests.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class TestBase {
    public WebDriver driver;
    public Actions action;

    @BeforeClass
    public void setupClass(){
        Driver.getDriver().get(ConfigurationReader.getProperty("webUrl3"));
        action = new Actions(Driver.getDriver());
        sleep(2);

        // Enter Username
        WebElement inputUsername = Driver.getDriver().findElement(By.id("user"));
        inputUsername.sendKeys(ConfigurationReader.getProperty("username2"));

        // Enter Password:
        WebElement inputPassword = Driver.getDriver().findElement(By.id("password"));
        inputPassword.sendKeys(ConfigurationReader.getProperty("password"));

        // Click to Login button
        WebElement loginButton = Driver.getDriver().findElement(By.id("submit-form"));
        loginButton.click();
    }

    @AfterClass
    public void tearDownClass(){
        sleep(2);
        Driver.closeDriver();
    }

    public void sleep(int second){
        second *= 1000;
        try{
            Thread.sleep(second);
        }catch(InterruptedException e){
            System.out.println("Something happened in sleep method");
        }
    }
}

