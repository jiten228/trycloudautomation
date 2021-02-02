package com.trycloud.tests.base.userstory6;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class object {


    WebDriver driver;

    @BeforeMethod
    public void tryCloudLogin() {
        // Open chrome browser
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //Navigate to login page of TryCloud
        driver.get("https://app.trycloud.net/index.php/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    /*
    Usernames: User20, User50, User80, User110
    Password: UserPassword: 123
     */
    @Test
    public void DataLogin() {

        String userName = "User20";
        String password = "Userpass123";


    }


}