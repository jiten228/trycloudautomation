package com.trycloud.tests.base.rosie_US_3;

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

public class TC5_TC6 extends TestBase {

    HomePage homePage = new HomePage();
    AllFilesPage allFilesPage = new AllFilesPage();


    @Test
    public void create_folder()  {


        homePage.filesButton.click();
       // Driver.getDriver().findElement(By.xpath("//*[@id=\"appmenu\"]/li[2]/a")).click();
        BrowserUtils.sleep(2);

        allFilesPage.newButton.click();
        //Driver.getDriver().findElement(By.xpath("//a[@class='button new']")).click();
        BrowserUtils.sleep(3);

        allFilesPage.newFolder.click();
        //Driver.getDriver().findElement(By.xpath("//span[.='New folder']")).click();

        allFilesPage.inputBoxFolder.clear();
        //WebElement inputBox = Driver.getDriver().findElement(By.xpath("//input[@id='view13-input-folder']"));
        BrowserUtils.sleep(3);

        allFilesPage.inputBoxFolder.sendKeys("Ruz");

       // inputBox.sendKeys("Ruz");
        BrowserUtils.sleep(2);


        allFilesPage.confirmButtonFolder.click();
       // Driver.getDriver().findElement(By.xpath("//input[@class='icon-confirm']")).click();


        //WebElement folder = Driver.getDriver().findElement(By.xpath("//span[.='Ruz']"));

        Assert.assertTrue(allFilesPage.createdFolder.isDisplayed());

        BrowserUtils.sleep(1);
        allFilesPage.selectBox.click();
        //Driver.getDriver().findElement(By.xpath("(//label[contains(@for,'select-files')])[1]")).click();
        BrowserUtils.sleep(1);
        allFilesPage.actionsButton.click();
        //Driver.getDriver().findElement(By.xpath("//span[.='Actions']")).click();
        allFilesPage.deleteButton.click();
        //Driver.getDriver().findElement(By.xpath("(//span[.='Delete'])[1]")).click();

    }

    @Test
    public void upload_file() throws AWTException {

        homePage.filesButton.click();
        //Driver.getDriver().findElement(By.xpath("//*[@id=\"appmenu\"]/li[2]/a")).click();
        BrowserUtils.sleep(2);

        allFilesPage.newButton.click();
        //Driver.getDriver().findElement(By.xpath("//a[@class='button new']")).click();
        BrowserUtils.sleep(2);


       // action = new Actions(Driver.getDriver());

        allFilesPage.uploadFile.sendKeys("/Users/rosie/Desktop/Softskill class/Other testings/Other testings.pdf");
       // WebElement upload = Driver.getDriver().findElement(By.xpath("//label[@for='file_upload_start']"));


//        String file = "/Users/rosie/Desktop/Softskill class/Other testings/Other testings.pdf";
//        action.moveToElement(upload).sendKeys(file).release().perform();

        StringSelection ss = new StringSelection("/Users/rosie/Desktop/Softskill class/Other testings/Other testings.pdf");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
        //imitate mouse events like ENTER, CTRL+C, CTRL+V
        Robot robot = new Robot();
        robot.delay(250);
        robot.mouseMove(640,360);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);



    }


}
