package com.trycloud.tests.base.userstory3;

import com.trycloud.tests.base.TestBase;
import com.trycloud.tests.utilities.BrowserUtils;
import com.trycloud.tests.utilities.ConfigurationReader;
import com.trycloud.tests.utilities.LoginUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TC_10 extends TestBase {

    @Test
    public void testCase_10(){
        //Test case #10 - verify users see the app storage usage
        LoginUtils.loginToTryCloud(driver, ConfigurationReader.getProperty("username"));

        WebElement currentStorage = driver.findElement(By.xpath("//li[@id='quota']/a/p"));
        System.out.println(currentStorage.getText());

        String path = "/Users/computer/Desktop/untitled folder/1.pdf";

        driver.findElement(By.xpath("//span[@class='icon icon-add']")).click();
        BrowserUtils.sleep(1);
        WebElement uploadFileButton = driver.findElement(By.xpath("//span[@class='svg icon icon-upload']"));
        uploadFileButton.click();
        uploadFileButton.sendKeys(path);
        uploadFileButton.submit();
        BrowserUtils.sleep(1);


        //driver.refresh
        WebElement newStorage = driver.findElement(By.xpath(""));
        System.out.println(newStorage.getText());

        //Assert.assertNotEquals(currentStorage, newStorage,"");
    }
}
