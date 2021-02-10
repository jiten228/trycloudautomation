package com.trycloud.tests.base.Murat_US_3;

import com.github.javafaker.Faker;
import com.trycloud.tests.pages.Murat_US_3.LoginPage;
import com.trycloud.tests.utilities.BrowserUtils;
import com.trycloud.tests.utilities.ConfigurationReader;
import com.trycloud.tests.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class LoginFunctionality {


    @Test
    public void ValidLoginFunctionality() {

        Driver.getDriver().get(ConfigurationReader.getProperty("webUrl1"));

        String[] userNames = {ConfigurationReader.getProperty("username1"), ConfigurationReader.getProperty("username2"),
                ConfigurationReader.getProperty("username3"), ConfigurationReader.getProperty("username4")
        };

        LoginPage loginPage = new LoginPage();

        for (String each : userNames) {

            loginPage.loginUsername.sendKeys(each);
            loginPage.loginPassword.sendKeys(ConfigurationReader.getProperty("password"));
            loginPage.loginButton.click();

            String expectedTitle = "Dashboard - Trycloud QA";
            String actualTitle = Driver.getDriver().getTitle();

            Assert.assertEquals(expectedTitle, actualTitle, "Title verification failed");

            Driver.getDriver().findElement(By.xpath("//img[@height='32']")).click();
            loginPage.logOut.click();

        }

    }

        @Test
        public void InvalidLoginFunctionality() {

            Driver.getDriver().get(ConfigurationReader.getProperty("webUrl1"));

            Faker faker = new Faker();

            LoginPage loginPage = new LoginPage();

            loginPage.loginUsername.sendKeys(faker.name().username());
            loginPage.loginPassword.sendKeys(faker.internet().password());
            loginPage.loginButton.click();

            WebElement errorMessage = loginPage.errorMessage;
            System.out.println(errorMessage.getText());
            Assert.assertTrue(errorMessage.isDisplayed(), "Wrong username or password message not displayed");


        }



        @AfterMethod
        public void tearDownMethod(){
            BrowserUtils.sleep(1);
            Driver.closeDriver();

    }
}
