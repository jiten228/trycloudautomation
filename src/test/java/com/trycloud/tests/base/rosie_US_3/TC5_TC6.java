package com.trycloud.tests.base.rosie_US_3;

import com.github.javafaker.Faker;

import com.trycloud.tests.base.jitendra_US_5.TestBase;
import com.trycloud.tests.pages.rosie_US_3.AllFilesPage;
import com.trycloud.tests.pages.rosie_US_3.HomePage;
import com.trycloud.tests.utilities.BrowserUtils;
import com.trycloud.tests.utilities.ConfigurationReader;
import com.trycloud.tests.utilities.Driver;
import com.trycloud.tests.utilities.LoginUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.*;
import java.util.List;

public class TC5_TC6 extends TestBase {

    HomePage homePage = new HomePage();
    AllFilesPage allFilesPage = new AllFilesPage();


    @Test
    public void create_folder() {


        homePage.filesButton.click();
        BrowserUtils.sleep(2);
        allFilesPage.newButton.click();
        BrowserUtils.sleep(3);
        allFilesPage.newFolder.click();
        allFilesPage.inputBoxFolder.clear();
        BrowserUtils.sleep(3);

        Faker faker = new Faker();

        String name = faker.name().name();

        allFilesPage.inputBoxFolder.sendKeys(name);

        BrowserUtils.sleep(2);

        allFilesPage.confirmButtonFolder.click();

        List<WebElement> list = new ArrayList<>();
        list.addAll(Driver.getDriver().findElements(By.id("fileList")));

        for (WebElement each : list) {
            if (each.getText().contains(name)) {
                Assert.assertEquals(name, each.getText());
                return;
            }
        }


//        BrowserUtils.sleep(1);
//        allFilesPage.selectBox.click();
//        //Driver.getDriver().findElement(By.xpath("(//label[contains(@for,'select-files')])[1]")).click();
//        BrowserUtils.sleep(1);
//        allFilesPage.actionsButton.click();
//        //Driver.getDriver().findElement(By.xpath("//span[.='Actions']")).click();
//        allFilesPage.deleteButton.click();
//        //Driver.getDriver().findElement(By.xpath("(//span[.='Delete'])[1]")).click();

    }

    @Test
    public void upload_file() throws AWTException {

        homePage.filesButton.click();
        BrowserUtils.sleep(2);

        allFilesPage.newButton.click();
        BrowserUtils.sleep(2);

        allFilesPage.uploadFile.click();

        String name = "/Users/rosie/Desktop/Screen Shot 2021-02-08 at 3.17.51 PM.png";

        File file = new File(name);
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
        } catch (IllegalArgumentException e){
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

        List<WebElement> list = new ArrayList<>();
        list.addAll(Driver.getDriver().findElements(By.id("fileList")));


        for (WebElement each : list) {
            if (each.getText().contains(name)) {
                Assert.assertEquals(each.getText(),name);
                return;
            }


        }

    }
}
