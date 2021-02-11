package com.trycloud.tests.base.Murat_US_3;

import com.github.javafaker.Faker;
import com.trycloud.tests.base.TestBase;
import com.trycloud.tests.pages.Murat_US_3.HomePage;
import com.trycloud.tests.pages.Murat_US_3.LoginPage;
import com.trycloud.tests.utilities.BrowserUtils;
import com.trycloud.tests.utilities.ConfigurationReader;
import com.trycloud.tests.utilities.Driver;
import com.trycloud.tests.utilities.LoginUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TC_09 {


    @Test
    public void testCase_9() {
        //Test case #9 - verify users can change the app Settings
        Driver.getDriver().get(ConfigurationReader.getProperty("webUrl1"));

        LoginPage loginPage = new LoginPage();
        HomePage homePage = new HomePage();

        loginPage.loginUsername.sendKeys(ConfigurationReader.getProperty("username1"));
        loginPage.loginPassword.sendKeys(ConfigurationReader.getProperty("password"));
        loginPage.loginButton.click();

        //access to files module
        homePage.filesModule.click();

        //setting buttons
        homePage.settingButton.click();
        BrowserUtils.sleep(1);

        WebElement button1 = homePage.button1;
        button1.click();
        BrowserUtils.sleep(1);

        WebElement button2 = homePage.button2;
        button2.click();
        BrowserUtils.sleep(1);

        WebElement button3 = homePage.button3;
        button3.click();
        BrowserUtils.sleep(2);

        Assert.assertTrue(button1.isEnabled(), "The button1 is clickable");
        Assert.assertTrue(button2.isEnabled(), "The button2 is clickable");
        Assert.assertTrue(button3.isEnabled(), "The button3 is clickable");


    }

    @AfterMethod
    public void tearDownMethod() {
        BrowserUtils.sleep(1);
        Driver.closeDriver();


    }

}