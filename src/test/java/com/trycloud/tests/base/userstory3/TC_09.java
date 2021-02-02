package com.trycloud.tests.base.userstory3;

import com.github.javafaker.Faker;
import com.trycloud.tests.utilities.BrowserUtils;
import com.trycloud.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC_09 {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://qa.trycloud.net/index.php/login?clear=1");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void validloginFunctionality() {

        String[] userNames = {"User20", "User50", "User80", "User110"};

        for (String each : userNames) {
            driver.findElement(By.id("user")).sendKeys(each);
            driver.findElement(By.id("password")).sendKeys("Userpass123");
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

        Faker faker = new Faker();

        driver.findElement(By.id("user")).sendKeys(faker.name().username());
        driver.findElement(By.id("password")).sendKeys(faker.internet().password());
        driver.findElement(By.id("submit-form")).click();

        WebElement errorMessage = driver.findElement(By.xpath("//p[@class='warning wrongPasswordMsg']"));
        Assert.assertTrue(errorMessage.isDisplayed(), "Wrong username or password message not displayed");

        //String expectedTitle = "Files - Trycloud - QA";
        //String actualTitle = driver.getTitle();
        //Assert.assertEquals(expectedTitle, actualTitle, "Title verification failed");


    }


    //@AfterMethod
    public void teardownMethod() throws InterruptedException {
        BrowserUtils.sleep(2);
        driver.quit();
    }


}

