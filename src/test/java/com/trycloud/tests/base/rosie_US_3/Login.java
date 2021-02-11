package com.trycloud.tests.base.rosie_US_3;

import com.github.javafaker.Faker;
import com.trycloud.tests.pages.rosie_US_3.HomePage;
import com.trycloud.tests.pages.rosie_US_3.LoginPage;
import com.trycloud.tests.utilities.BrowserUtils;
import com.trycloud.tests.utilities.ConfigurationReader;
import com.trycloud.tests.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.Arrays;

public class Login {

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    String expectedTitle;


    @BeforeMethod
    public void setup() {


        Driver.getDriver().get(ConfigurationReader.getProperty("webUrl3"));

    }

    @Test
    public void login_functionality() {

        // Driver.getDriver().get(ConfigurationReader.getProperty("webUrl3"));

        String username = ConfigurationReader.getProperty("username1");
        loginPage.username.sendKeys(username);
        String password = ConfigurationReader.getProperty("password");
        loginPage.password.sendKeys(password);
        loginPage.loginButton.click();
        expectedTitle = "Dashboard - Trycloud QA";
        Assert.assertEquals(Driver.getDriver().getTitle(), expectedTitle);

        homePage.userButton.click();
        BrowserUtils.sleep(2);
        homePage.logoutButton.click();
        BrowserUtils.sleep(2);


    }

    @Test
    public void login_with_negative_data() {

        // Driver.getDriver().get(ConfigurationReader.getProperty("webUrl3"));

        Faker faker = new Faker();

        String username = faker.name().username();
        loginPage.username.sendKeys(username);
        String password = faker.internet().password();
        loginPage.password.sendKeys(password);
        loginPage.loginButton.click();
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());

        loginPage.username.clear();


    }

    @Test
    public void test_with_all_data() {


        ArrayList<String> list = new ArrayList<>(Arrays.asList("user20", "user50", "user80", "user110"));
        String password = "Userpass123";

        for (String each : list) {
            loginPage.username.sendKeys(each);
            BrowserUtils.sleep(2);
            loginPage.password.sendKeys(password);
            BrowserUtils.sleep(2);
            loginPage.loginButton.click();
            expectedTitle = "Dashboard - Trycloud QA";
            Assert.assertEquals(Driver.getDriver().getTitle(), expectedTitle);

            homePage.userButton.click();
            BrowserUtils.sleep(2);
            homePage.logoutButton.click();
            BrowserUtils.sleep(2);


        }


    }

    @AfterClass
    public void close() {

        BrowserUtils.sleep(3);
        Driver.closeDriver();

    }

}
