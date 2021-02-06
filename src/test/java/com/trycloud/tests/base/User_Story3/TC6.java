package com.trycloud.tests.base.User_Story3;

import com.trycloud.tests.base.TestBase;
import com.trycloud.tests.utilities.BrowserUtils;
import com.trycloud.tests.utilities.ConfigurationReader;
import com.trycloud.tests.utilities.LoginUtils;
import com.trycloud.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC6 extends TestBase {


    @Test
    public void create_folder()  {

        String userName = ConfigurationReader.getProperty("username2");
        LoginUtils.loginToTryCloud(driver,userName);

        BrowserUtils.sleep(3);

        driver.findElement(By.xpath("//*[@id=\"appmenu\"]/li[2]/a")).click();
        BrowserUtils.sleep(2);

        driver.findElement(By.xpath("//a[@class='button new']")).click();
        BrowserUtils.sleep(3);

        driver.findElement(By.xpath("//span[.='New folder']")).click();

        WebElement inputBox = driver.findElement(By.xpath("//input[@id='view13-input-folder']"));
        BrowserUtils.sleep(3);
        inputBox.clear();

        inputBox.sendKeys("Ruz");
        BrowserUtils.sleep(2);


        driver.findElement(By.xpath("//input[@class='icon-confirm']")).click();


        WebElement folder = driver.findElement(By.xpath("//span[.='Ruz']"));

        Assert.assertTrue(folder.isDisplayed());

    }

}
