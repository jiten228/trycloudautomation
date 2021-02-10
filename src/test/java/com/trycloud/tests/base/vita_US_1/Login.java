package com.trycloud.tests.base.vita_US_1;

import com.github.javafaker.Faker;
import com.trycloud.tests.base.TestBase;
import com.trycloud.tests.pages.Vita_US_1.LoginPage;
import com.trycloud.tests.utilities.ConfigurationReader;
import com.trycloud.tests.utilities.Driver;
import com.trycloud.tests.utilities.LoginUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Login {

    /*
    Enter positive user name and password.
    Usernames: User20, User50, User80, User110
    Password: Userpass123
     */
    String expectedTitle;
    @Test
    public void login1Positive() throws InterruptedException {
        String url = ConfigurationReader.getProperty("webUrl2");
        Driver.getDriver().get(url);

        //Creating the object of the class to be able to reach web elements from that class
        LoginPage loginPage = new LoginPage();
        ArrayList<String> userNamesPositive = new ArrayList<>(Arrays.asList("User20",
                "User50", "User80", "User110")) ;
    String password = "Userpass123";

    for (String each : userNamesPositive){
        // type User name
       loginPage.inputUsername.sendKeys(each);
        Thread.sleep(1000);
        // type Password
        loginPage.inputPassword.sendKeys(password);
        Thread.sleep(1000);
        // Click login button
        loginPage.loginButton.click();
        Thread.sleep(2000);

        expectedTitle = "Dashboard - Trycloud QA";
        Assert.assertTrue(Driver.getDriver().getTitle().contains(expectedTitle), "Landing page verification FAILED!!!");
    }
        // Do Log out
       loginPage.settingsButton.click();
        Thread.sleep(1000);
        loginPage.logoutButton.click();
        Thread.sleep(1000);
        // clear user id
        loginPage.inputUsername.clear();
    }

        @Test
        public void login2Negative() {
            LoginPage loginPage = new LoginPage();
            Faker faker = new Faker();
            String username = faker.name().username();
            LoginUtils.loginToTryCloud(Driver.getDriver(), username);
            WebElement message = loginPage.warningMessage;
            expectedTitle = "Wrong username or password.";
            Assert.assertEquals(expectedTitle, message.getText(), "Invalid Username, Web page not found");

        }
    }

