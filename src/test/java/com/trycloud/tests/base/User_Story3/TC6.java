package com.trycloud.tests.base.User_Story3;

import com.trycloud.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC6 {

    public WebDriver driver;

    @BeforeMethod
    public void setupMethod(){

        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://qa.trycloud.net/index.php/login?clear=1");


    }

    @Test
    public void create_folder() throws InterruptedException {

        WebElement inputUserName = driver.findElement(By.id("user"));
        inputUserName.sendKeys("User20");

        WebElement inputPassword = driver.findElement(By.id("password"));
        inputPassword.sendKeys("Userpass123");

        WebElement loginButton = driver.findElement(By.xpath("//input[@id='submit-form']"));
        loginButton.click();

        String expectedTitle = "Files - Trycloud - QA";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(expectedTitle,actualTitle);


        Thread.sleep(3000);

        driver.findElement(By.xpath("//a[@class='button new']")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//span[.='New folder']")).click();

        WebElement inputBox = driver.findElement(By.xpath("//input[@id='view13-input-folder']"));
        Thread.sleep(3000);
        inputBox.clear();

        inputBox.sendKeys("Ruz");

        driver.findElement(By.xpath("//input[@class='icon-confirm']")).click();


        WebElement folder = driver.findElement(By.xpath("//span[.='Ruz']"));

        Assert.assertTrue(folder.isDisplayed());

    }

    @AfterMethod
    public void tearDownMethod() throws InterruptedException {

        Thread.sleep(3000);
         driver.close();
         // r
    }
}
