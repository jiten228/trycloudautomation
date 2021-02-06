package com.trycloud.tests.base.rosie_US_3;

import com.trycloud.tests.base.TestBase;
import com.trycloud.tests.utilities.BrowserUtils;
import com.trycloud.tests.utilities.ConfigurationReader;
import com.trycloud.tests.utilities.LoginUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC5_TC6 extends TestBase {

    @Test
    public void upload_file() {

        String userName = ConfigurationReader.getProperty("username1");
        LoginUtils.loginToTryCloud(driver,userName);

        driver.findElement(By.xpath("//*[@id=\"appmenu\"]/li[2]/a")).click();
        BrowserUtils.sleep(2);

        driver.findElement(By.xpath("//a[@class='button new']")).click();
        BrowserUtils.sleep(2);


        Actions actions = new Actions(driver);

//        String filename = "/Users/rosie/Desktop/Softskill class/Other testings/Other testings.pdf";
//        File file = new File(filename);
//        String path = file.getAbsolutePath();
        WebElement upload = driver.findElement(By.xpath("//label[@for='file_upload_start']"));

        actions.moveToElement(upload).sendKeys("/Users/rosie/Desktop/Softskill class/Other testings/Other testings.pdf").perform();


       // file.sendKeys("/Users/rosie/Desktop/my notes/Something");

    }

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
