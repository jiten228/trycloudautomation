package com.trycloud.tests.base.User_Story3;

import com.trycloud.tests.base.TestBase;
import com.trycloud.tests.utilities.BrowserUtils;
import com.trycloud.tests.utilities.ConfigurationReader;
import com.trycloud.tests.utilities.LoginUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TC5 extends TestBase {

    @Test
    public void upload_file() {

        String userName = ConfigurationReader.getProperty("username1");
        LoginUtils.loginToTryCloud(driver,userName);

        driver.findElement(By.xpath("//*[@id=\"appmenu\"]/li[2]/a")).click();
        BrowserUtils.sleep(2);

        driver.findElement(By.xpath("//a[@class='button new']")).click();
        BrowserUtils.sleep(2);


        Actions actions = new Actions(driver);

        WebElement file = driver.findElement(By.xpath("//label[@for='file_upload_start']"));

        actions.moveToElement(file).sendKeys("/Users/rosie/Desktop/Softskill class/Other testings/Other testings.pdf").perform();


       // file.sendKeys("/Users/rosie/Desktop/my notes/Something");



    }


}
