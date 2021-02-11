package com.trycloud.tests.base.vita_US_3;

import com.google.common.base.Verify;
import com.trycloud.tests.pages.Vita_US_3.FilesPage;
import com.trycloud.tests.pages.Vita_US_7.HomePage;
import com.trycloud.tests.utilities.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class TC_7_8 {


    // Test case #7 - verify users can upload a file inside a folder
    @Test
    public static void uploadFileInsideFolder() throws AWTException {

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

        // 4.Click “upload file”
        filesPage.uploadFileButton.click();
        //  5.Upload a file
        String path = "/Users/vita/Desktop/Day1/file1.txt";
        File file = new File(path);
        StringSelection stringSelection = new StringSelection(file.getAbsolutePath());

        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

        Robot robot = new Robot();

        // Cmd + Tab is needed since it launches a Java app and the browser looses focus

        try {
            robot.keyPress(KeyEvent.VK_META);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_META);
            robot.keyRelease(KeyEvent.VK_TAB);
            robot.delay(500);
            //Open Goto window
            robot.keyPress(KeyEvent.VK_META);
            robot.keyPress(KeyEvent.VK_SHIFT);
            robot.keyPress(KeyEvent.VK_G);
            robot.keyRelease(KeyEvent.VK_META);
            robot.keyRelease(KeyEvent.VK_SHIFT);
            robot.keyRelease(KeyEvent.VK_G);
            //Paste the clipboard value
            robot.keyPress(KeyEvent.VK_META);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_META);
            robot.keyRelease(KeyEvent.VK_V);
            //Press Enter key to close the Goto window and Upload window
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.delay(500);
            robot.keyPress(KeyEvent.VK_S);
            robot.keyRelease(KeyEvent.VK_S);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (IllegalArgumentException e) {
            robot.setAutoDelay(3000);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            //Release
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_V);
            //Enter
            robot.setAutoDelay(3000);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.setAutoDelay(2000);
        }
        // 6. Verify the file is displayed on the page
        //  (Pre-condition: there should be at least 1 folder is created on the filers page)

        List<WebElement> list = new ArrayList<>();
        list.addAll(Driver.getDriver().findElements(By.id("fileList")));


        for (WebElement each : list) {
            if (each.getText().contains(path)) {
                Assert.assertEquals(each.getText(), path);
                return;
            }
        }
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
        String actualResult = filesPage.comment.getText();

        Assert.assertTrue(actualResult.contains(expectedResult));
    }
}
