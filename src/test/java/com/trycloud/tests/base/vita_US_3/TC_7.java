package com.trycloud.tests.base.vita_US_3;

import com.trycloud.tests.utilities.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TC_7 {

    // Test case #7 - verify users can upload a file inside a folder

    @Test
    public static void uploadFileInsideFolder() throws InterruptedException {
        String url = ConfigurationReader.getProperty("webUrl3");
        Driver.getDriver().get(url);

        // 1.Login as a user
        String username = ConfigurationReader.getProperty("username1");
        LoginUtils.loginToTryCloud(Driver.getDriver(), username);

        // 2.Choose a folder from the page
        WebElement files = Driver.getDriver().findElement(By.xpath("//a[@aria-label='Files']"));
        BrowserUtils.sleep(2);
        files.click();
        WebElement folder = Driver.getDriver().findElement(By.xpath("//*[@id=\"fileList\"]/tr[6]/td[2]/a/span[1]"));
        folder.click();
        //3.Click the “+” icon on top
        WebElement uploadIcon = Driver.getDriver().findElement(By.xpath("//*[@id=\"controls\"]/div[2]/a"));
        Thread.sleep(2000);
        uploadIcon.click();

        Actions actions = new Actions(Driver.getDriver());

        WebElement uploadFileButton = Driver.getDriver().findElement(By.xpath("//*[@id=\"controls\"]/div[2]/div[2]/ul/li[1]/label"));
        uploadFileButton.click();
        String path = "/Users/vita/Desktop/Day1/file1.txt";
        actions.moveToElement(uploadFileButton).sendKeys(path).perform();









    }

}
/*


4.Click “upload file”
5.Upload a file
6.Verify the file is displayed on the page
(Pre-condition: there should be at least 1 folder is created on the filers page)


 */