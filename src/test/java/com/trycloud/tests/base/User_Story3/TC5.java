package com.trycloud.tests.base.User_Story3;

import com.trycloud.tests.base.TestBase;
import com.trycloud.tests.utilities.BrowserUtils;
import com.trycloud.tests.utilities.ConfigurationReader;
import com.trycloud.tests.utilities.LoginUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TC5 extends TestBase {

    @Test
    public void upload_file() {

        String userName = ConfigurationReader.getProperty("username");
        LoginUtils.loginToTryCloud(driver,userName);

        driver.findElement(By.xpath("//a[@class='button new']")).click();
        BrowserUtils.sleep(2);

        WebElement file = driver.findElement(By.xpath("//label[@for='file_upload_start']"));
        BrowserUtils.sleep(2);

        file.sendKeys("/Users/rosie/Desktop/Collections Framework Hierarchy (1).png");


    }


}
