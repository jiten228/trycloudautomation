package com.trycloud.tests.base.userstory3;

import com.trycloud.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestCase1_2 {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {

        //Open chrome browser
        driver = WebDriverFactory.getDriver("chrome");

        //go to website
        driver.get(" http://qa2.trycloud.net/index.php/login?clear=1");

        //maximize window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);


    }

    @Test
    public void LogInSuccessfully() {
        //enter username
        driver.findElement(By.id("user")).sendKeys("User20");
        //enter password
        driver.findElement(By.id("password")).sendKeys("Userpass123");
        driver.findElement(By.id("submit-form")).click();
    }
}

