package com.trycloud.tests.base.vita_US_3;

import com.trycloud.tests.pages.Vita_US_3.FilesPage;
import com.trycloud.tests.pages.Vita_US_7.HomePage;
import com.trycloud.tests.utilities.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_7_8 {


    // Test case #7 - verify users can upload a file inside a folder
    @Test
    public static void uploadFileInsideFolder() throws InterruptedException {

        //Creating the object of the class to be able to reach web elements from that class
        FilesPage filesPage = new FilesPage();

        String url = ConfigurationReader.getProperty("webUrl3");
        Driver.getDriver().get(url);

        // 1.Login as a user
        String username = ConfigurationReader.getProperty("username1");
        LoginUtils.loginToTryCloud(Driver.getDriver(), username);

        filesPage.files.click();
        BrowserUtils.sleep(2);

        // 2.Choose a folder from the page
        filesPage.folder.click();
        //3.Click the “+” icon on top
        filesPage.uploadIcon.click();

        Actions actions = new Actions(Driver.getDriver());

        filesPage.uploadFileButton.click();
        String path = "/Users/vita/Desktop/Day1/file1.txt";
        actions.moveToElement(filesPage.uploadFileButton).sendKeys(path).perform();
        /*
        4.Click “upload file”
        5.Upload a file
        6.Verify the file is displayed on the page
        (Pre-condition: there should be at least 1 folder is created on the filers page)
         */
    }

    // Test case #8a - verify users can delete a file/folder.
    @Test
    public void delete_fileFolder() throws InterruptedException {

        //Creating the object of the class to be able to reach web elements from that class
        FilesPage filesPage = new FilesPage();

        String url = ConfigurationReader.getProperty("webUrl3");
        Driver.getDriver().get(url);

        // 1.Login as a user
        String username = ConfigurationReader.getProperty("username1");
        LoginUtils.loginToTryCloud(Driver.getDriver(), username);

        filesPage.files.click();
        Thread.sleep(2000);

        //First create file
        filesPage.addToFile.click();
        Thread.sleep(2000);

        filesPage.newDocument.click();
        WebElement textInput = Driver.getDriver().findElement(By.xpath("//input[@id='view13-input-x-office-document']"));
        textInput.click();
        textInput.clear();
        Thread.sleep(2000);
        textInput.sendKeys("Task1.odt" + Keys.ENTER);
        Thread.sleep(2000);

        // 2.Click action-icon from any file on the page
        filesPage.actionIcon.click();
        Thread.sleep(2000);

        // 3.Choose “delete files” option
        // 4.Click deleted files on the left bottom corner
        filesPage.deleteFiles.click();
        Thread.sleep(2000);

        //5.Verify the deleted file is displayed no the page. (Pre-condition: there should be at least 1 file is uploaded inside files page)
        WebElement fileName = filesPage.fileName;
        Assert.assertTrue(fileName.isDisplayed());
    }


    // Test case #8b - verify users can write comments to  files/folders.
    @Test
    public void writeComments() throws InterruptedException {
        //Creating the object of the class to be able to reach web elements from that class
        FilesPage filesPage = new FilesPage();

        String url = ConfigurationReader.getProperty("webUrl3");
        Driver.getDriver().get(url);

        // 1.Login as a user
        String username = ConfigurationReader.getProperty("username1");
        LoginUtils.loginToTryCloud(Driver.getDriver(), username);

        filesPage.files.click();
        Thread.sleep(2000);

        // 2.Click action-icon from any file on the page
        filesPage.actionIcon.click();
        Thread.sleep(2000);

        //  3.Click details
        filesPage.detailsButton.click();
        Thread.sleep(2000);

        //  4.Write a comment inside to the input box
        filesPage.commentsButton.click();
        Thread.sleep(2000);

        filesPage.textButton.click();
        Thread.sleep(2000);
        filesPage.textButton.sendKeys("New Project created");

        // 5.Click the submit button to post it
        filesPage.submitCommentsButton.click();
        Thread.sleep(2000);

        // 6.Verify the comment is displayed in the comment section.
        // (Pre-condition: there should be at least 1 file/foler is uploaded inside files page)

        String expectedResult = "New Project created";
        String actualResult = filesPage.commentAfter.getText();


        Assert.assertFalse(actualResult.equals(expectedResult));
    }
}
