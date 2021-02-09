package com.trycloud.tests.base.ariz_US_7;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class SearchItem {


    WebDriver driver;

    @BeforeMethod
    public void tryCloudLogin() {
        // Open chrome browser
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //Navigate to login page of TryCloud
        driver.get("http://qa.trycloud.net/index.php/login?clear=1");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    /*
    Usernames:User50, User80, User110
    Password: UserPass123
     */


    @Test
    public void SearchItem() throws InterruptedException, IOException {
        //1.Login
        String userName = "User20";
        String password = "Userpass123";
        //1.Login as a user
        driver.findElement(By.xpath("//input[@name='user']")).sendKeys(userName);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@type='submit']")).click();


        //2.Title Verification
        String actualTitle = driver.getTitle();
        String expectedTitle = "Dashboard - Trycloud QA";

        Assert.assertEquals(actualTitle, expectedTitle, "Title verification is Failed!!!");
        System.out.println("actualTitle = " + actualTitle);
        System.out.println("expectedTitle = " + expectedTitle);
        Thread.sleep(1000);

        //3.Click "Search" module

        driver.findElement(By.xpath("//*[@id='header']/div[2]/div[1]")).click();

        //4.Search any existing file/module

        driver.findElement(By.xpath("//*[@id='header-menu-unified-search']/div[2]/div[1]/form/input")).sendKeys("talk");
        driver.findElement(By.xpath("//div[@id='header-menu-unified-search']/div[2]/ul[1]/li[1]/a/div")).click();
        Thread.sleep(1000);

        //2.Title Verification

        String actualTitleOfLandingPage = driver.getTitle();
        String expectedTitleOfLandingPage = "Talk - Trycloud QA";

        Assert.assertEquals(actualTitle, expectedTitle, "Title verification is Failed!!!");
        System.out.println("actualTitle = " + actualTitle);
        System.out.println("expectedTitle = " + expectedTitle);




    }

    @AfterMethod
    public void closing(){
        driver.close();
    }
}