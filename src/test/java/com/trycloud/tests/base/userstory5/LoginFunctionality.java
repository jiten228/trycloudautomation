package com.trycloud.tests.base.userstory5;

import com.github.javafaker.Faker;
import com.trycloud.tests.base.TestBase;
import com.trycloud.tests.utilities.BrowserUtils;
import com.trycloud.tests.utilities.LoginUtils;
import com.trycloud.tests.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginFunctionality extends TestBase {


    @Test
    public void validLogin(){
        String username = ConfigurationReader.getProperty("username");
        LoginUtils.loginToTryCloud(driver, username);
        String expectedTitle = "Files - Trycloud - QA";
        Assert.assertEquals(expectedTitle,driver.getTitle(),"Invalid Url, Web page not found");
        WebElement locateContact = driver.findElement(By.xpath("//*[@id=\"appmenu\"]/li[5]/a"));
        locateContact.click();
        BrowserUtils.sleep(5);
        String actualTitle = driver.getTitle();
        System.out.println("actualTitle = " + actualTitle);
        expectedTitle = "";
        WebElement newContactButton = driver.findElement(By.id("new-contact-button"));
        newContactButton.click();
    }

    @Test
    public void invalidLogin(){
        Faker faker = new Faker();
        String username = faker.name().username();
        LoginUtils.loginToTryCloud(driver, username);
        WebElement locate = driver.findElement(By.xpath("//p[@class='warning wrongPasswordMsg']"));
        String expectedTitle = "Wrong username or password.";
        Assert.assertEquals(expectedTitle,locate.getText(),"Invalid Username, Web page not found");

    }
}
