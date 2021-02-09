package com.trycloud.tests.base.vita_US_3;

import com.google.common.base.Verify;
import com.trycloud.tests.utilities.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC_8 {


    @Test
    public void delete_fileFolder() throws InterruptedException {

        // Test case #8 - verify users can delete a file/folder.
        String url = ConfigurationReader.getProperty("webUrl3");
        Driver.getDriver().get(url);

        // 1.Login as a user
        String username = ConfigurationReader.getProperty("username1");
        LoginUtils.loginToTryCloud(Driver.getDriver(), username);


        WebElement files = Driver.getDriver().findElement(By.xpath("//a[@aria-label='Files']"));
        files.click();
        Thread.sleep(2000);

        //First create file
        WebElement addToFile = Driver.getDriver().findElement(By.xpath("//a[@class='button new']"));
        addToFile.click();
        Thread.sleep(2000);

        WebElement newDocument = Driver.getDriver().findElement(By.xpath("//a[@data-filetype='x-office-document']"));
        newDocument.click();
        WebElement textInput = Driver.getDriver().findElement(By.xpath("//input[@id='view13-input-x-office-document']"));
        textInput.click();
        textInput.clear();
        Thread.sleep(2000);
        textInput.sendKeys("Task1.odt" + Keys.ENTER);
        Thread.sleep(2000);

        // 2.Click action-icon from any file on the page
        WebElement actionIcon = Driver.getDriver().findElement(By.xpath("//a[@class='action action-menu permanent'][1]"));
        actionIcon.click();
        Thread.sleep(2000);

        // 3.Choose “delete files” option
        // 4.Click deleted files on the left bottom corner
        WebElement deleteFiles = Driver.getDriver().findElement(By.xpath("//a[@class='menuitem action action-delete permanent']"));
        deleteFiles.click();
        Thread.sleep(2000);
        //5.Verify the deleted file is displayed no the page. (Pre-condition: there should be at least 1 file is uploaded inside files page)

        WebElement fileName = Driver.getDriver().findElement(By.xpath("//a[@class='recommendation']"));

        Assert.assertTrue(fileName.isDisplayed());
    }

    @Test
    public void writeComments() throws InterruptedException {
        // Test case #8 - verify users can write comments to  files/folders.
        String url = ConfigurationReader.getProperty("webUrl3");
        Driver.getDriver().get(url);

        // 1.Login as a user
        String username = ConfigurationReader.getProperty("username1");
        LoginUtils.loginToTryCloud(Driver.getDriver(), username);

        WebElement files = Driver.getDriver().findElement(By.xpath("//a[@aria-label='Files']"));
        files.click();
        Thread.sleep(2000);

        // 2.Click action-icon from any file on the page

        WebElement actionIcon = Driver.getDriver().findElement(By.xpath("//a[@class='action action-menu permanent'][1]"));
        actionIcon.click();
        Thread.sleep(2000);

        //  3.Click details
        WebElement detailsButton = Driver.getDriver().findElement(By.xpath("//a[@class='menuitem action action-details permanent']"));
        detailsButton.click();
        Thread.sleep(2000);

        //  4.Write a comment inside to the input box
        WebElement commentsButton = Driver.getDriver().findElement(By.xpath("//a[@id='commentsTabView']"));
        commentsButton.click();
        Thread.sleep(2000);

        WebElement textButton = Driver.getDriver().findElement(By.xpath("//div[@class='message']"));
        textButton.click();
        Thread.sleep(2000);
        textButton.sendKeys("New Project created");

        // 5.Click the submit button to post it
        WebElement submitButton = Driver.getDriver().findElement(By.xpath("//input[@class='submit icon-confirm has-tooltip']"));
        submitButton.click();
        Thread.sleep(2000);

        // 6.Verify the comment is displayed in the comment section.
       // (Pre-condition: there should be at least 1 file/foler is uploaded inside files page)

        String commentBefore = Driver.getDriver().findElement(By.xpath("(//div[@class='message'])[3]")).getText();

        String commentAfter = Driver.getDriver().findElement(By.xpath("(//div[@class='message'])[2]")).getText();

        Assert.assertFalse(commentBefore.equals(commentAfter));
    }
}




