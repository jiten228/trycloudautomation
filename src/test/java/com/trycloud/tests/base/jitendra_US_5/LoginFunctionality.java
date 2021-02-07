package com.trycloud.tests.base.jitendra_US_5;

import com.github.javafaker.Faker;
import com.trycloud.tests.base.TestBase;
import com.trycloud.tests.utilities.ConfigurationReader;
import com.trycloud.tests.utilities.LoginUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginFunctionality extends TestBase {
    String expectedTitle;

    @Test
    public void ValidLogin() {
        String username = ConfigurationReader.getProperty("username1");
        LoginUtils.loginToTryCloud(driver, username);
        expectedTitle = "Dashboard - Trycloud";
        Assert.assertTrue(driver.getTitle().contains(expectedTitle), "Invalid Url, Web page not found");
    }

    @Test
    public void InvalidLogin() {
        Faker faker = new Faker();
        String username = faker.name().username();
        LoginUtils.loginToTryCloud(driver, username);
        WebElement locate = driver.findElement(By.xpath("//p[@class='warning wrongPasswordMsg']"));
        expectedTitle = "Wrong username or password.";
        Assert.assertEquals(expectedTitle, locate.getText(), "Invalid Username, Web page not found");

    }
}
