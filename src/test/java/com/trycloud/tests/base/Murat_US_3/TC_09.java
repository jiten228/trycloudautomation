package com.trycloud.tests.base.Murat_US_3;

import com.github.javafaker.Faker;
import com.trycloud.tests.base.TestBase;
import com.trycloud.tests.utilities.BrowserUtils;
import com.trycloud.tests.utilities.ConfigurationReader;
import com.trycloud.tests.utilities.LoginUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_09 extends TestBase {

    @Test
    public void validloginFunctionality() {

        driver.get(ConfigurationReader.getProperty("webUrl1"));

        String[] userNames = {"User20", "User50", "User80", "User110"};

        for (String each : userNames) {
            driver.findElement(By.id("user")).sendKeys(each);
            driver.findElement(By.id("password")).sendKeys(ConfigurationReader.getProperty("password"));
            driver.findElement(By.id("submit-form")).click();

            String expectedTitle = "Files - Trycloud - QA";
            String actualTitle = driver.getTitle();

            Assert.assertEquals(expectedTitle, actualTitle, "Title verification failed");

            driver.findElement(By.xpath("//img[@height='32']")).click();
            driver.findElement(By.xpath("//img[@src='/core/img/actions/logout.svg?v=9251f518']")).click();

        }
    }

    @Test
    public void invalidloginFunctionality() {

        driver.get(ConfigurationReader.getProperty("webUrl1"));

        Faker faker = new Faker();
        driver.findElement(By.id("user")).sendKeys(faker.name().username());
        driver.findElement(By.id("password")).sendKeys(faker.internet().password());
        driver.findElement(By.id("submit-form")).click();

        WebElement errorMessage = driver.findElement(By.xpath("//p[@class='warning wrongPasswordMsg']"));
        System.out.println(errorMessage.getText());
        Assert.assertTrue(errorMessage.isDisplayed(), "Wrong username or password message not displayed");


    }

    @Test
    public void testCase_9(){
        //Test case #9 - verify users can change the app Settings
        LoginUtils.loginToTryCloud(driver, ConfigurationReader.getProperty("username1"));

        //access to files module
        driver.findElement(By.cssSelector("li[data-id='files']>a>svg>image")).click();
        //setting button
        driver.findElement(By.className("settings-button")).click();
        BrowserUtils.sleep(1);

        WebElement button1 = driver.findElement(By.xpath("//label[@for='showRichWorkspacesToggle']"));
        button1.click();
        BrowserUtils.sleep(1);
        WebElement button2 = driver.findElement(By.xpath("//label[@for='recommendationsEnabledToggle']"));
        button2.click();
        BrowserUtils.sleep(1);
        WebElement button3 = driver.findElement(By.xpath("//label[@for='showhiddenfilesToggle']"));
        button3.click();
        BrowserUtils.sleep(2);

        Assert.assertTrue(button1.isEnabled(), "The button1 is clickable");
        Assert.assertTrue(button2.isEnabled(), "The button2 is clickable");
        Assert.assertTrue(button3.isEnabled(), "The button3 is clickable");


    }




}

