package com.trycloud.tests.base.userstory4;


import com.trycloud.tests.utilities.BrowserUtils;
import com.trycloud.tests.utilities.ConfigurationReader;
import com.trycloud.tests.utilities.LoginUtils;
import com.trycloud.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TalksModule_Qa3 {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://qa3.trycloud.net");
        String username = ConfigurationReader.getProperty("username");
        BrowserUtils.sleep(1);

        // 1.Login as a user
        LoginUtils.loginToTryCloud(driver, username);

        String expectedTitle = "Dashboard - Trycloud";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle,expectedTitle);

    }


    @Test
    public void TalksModule_1() throws InterruptedException {

        WebElement talksModuleButton = driver.findElement(By.xpath("//a[@aria-label='Talk' and @href='http://qa3.trycloud.net/index.php/apps/spreed/']"));
        talksModuleButton.click();
        BrowserUtils.sleep(1);

        String expectedResult = "Talk - Trycloud";
        String actualResult = driver.getTitle();
        Assert.assertEquals(actualResult,expectedResult);
        System.out.println("PASSED! Talks module’s tile match with current title");

    }

    @Test
    public void TalksModule_2() throws InterruptedException {

        WebElement talksModuleButton = driver.findElement(By.xpath("//a[@aria-label='Talk' and @href='http://qa3.trycloud.net/index.php/apps/spreed/']"));
        talksModuleButton.click();
        BrowserUtils.sleep(1);

        //Search a user from search box on the left
        WebElement searchBox = driver.findElement(By.xpath("//input[@type='text']"));
        searchBox.click();
        Thread.sleep(1000);
        searchBox.sendKeys("User100");
        searchBox.sendKeys(Keys.ENTER);
        BrowserUtils.sleep(1);
        Thread.sleep(1000);

        WebElement user100 = driver.findElement(By.xpath("//a[@class='acli' and @aria-label='Conversation, User100']"));
        user100.click();
        BrowserUtils.sleep(1);
        Thread.sleep(1000);

        //Verify the message is displayed on the conversation log
        WebElement messageBox = driver.findElement(By.xpath("//div[@class='new-message-form__advancedinput']"));
        messageBox.click();
        messageBox.sendKeys("Hi! How are you doing man ?");
        messageBox.sendKeys(Keys.ENTER);
        BrowserUtils.sleep(1);
        System.out.println("PASSED! I send a message to User100 !");


    }




}
