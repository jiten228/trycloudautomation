package com.trycloud.tests.base.userStory3_TC_7_8;

import com.trycloud.tests.utilities.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC_7 {

    // Test case #7 - verify users can upload a file inside a folder


    // 2.Choose a folder from the page
    @Test
    public static void uploadFileInsideFolder(){
        Driver.getDriver().get("http://qa3.trycloud.net");

        WebElement folder = Driver.getDriver().findElement(By.xpath("//a[@aria-label='Files']"));
        folder.click();
        WebElement buttonNew = Driver.getDriver().findElement(By.xpath("//a[@class='button new']"));
        buttonNew.click();
        WebElement uploadFileButton = Driver.getDriver().findElement(By.xpath("//label[@data-action='upload']"));
        uploadFileButton.click();

        String path = "/Users/vita/Desktop/Selenium/Dec 22nd.pdf";



    }

}
/*

3.Click the “+” icon on top
4.Click “upload file”
5.Upload a file
6.Verify the file is displayed on the page
(Pre-condition: there should be at least 1 folder is created on the filers page)


 */