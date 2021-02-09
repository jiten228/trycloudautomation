package com.trycloud.tests.base.Murat_US_3;

import com.trycloud.tests.base.TestBase;
import com.trycloud.tests.utilities.BrowserUtils;
import com.trycloud.tests.utilities.ConfigurationReader;
import com.trycloud.tests.utilities.LoginUtils;
import org.openqa.selenium.*;
import org.testng.annotations.Test;

public class TC_10 extends TestBase {

    @Test
    public void testCase_10(){
        //Test case #10 - verify users see the app storage usage
        LoginUtils.loginToTryCloud(driver, ConfigurationReader.getProperty("username1"));

        //access to files module
        driver.findElement(By.cssSelector("li[data-id='files']>a>svg>image")).click();

        WebElement currentStorage = driver.findElement(By.xpath("//li[@id='quota']/a/p"));
        System.out.println("Current Storage: "+currentStorage.getText());

        String path = "/Users/computer/Downloads/14.pdf";



        WebElement upload = driver.findElement(By.xpath("//span[@class='icon icon-add']"));
        upload.click();
        BrowserUtils.sleep(1);
        WebElement uploadFileButton = driver.findElement(By.xpath("//span[@class='displayname']"));
        uploadFileButton.click();
        uploadFileButton.sendKeys(path);
        //Actions actions = new Actions(driver);
        //actions.moveToElement(smallCircle).clickAndHold(smallCircle).moveToElement(bigCircle).release().perform();
        //actions.perform();

        WebElement newStorage = driver.findElement(By.xpath("//li[@id='quota']/a/p"));
        System.out.println("New Storage: "+newStorage.getText());
        

        //Assert.assertNotEquals(currentStorage, newStorage,"Upload not successfully");
    }
}
