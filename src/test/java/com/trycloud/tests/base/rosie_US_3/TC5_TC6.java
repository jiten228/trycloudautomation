package com.trycloud.tests.base.rosie_US_3;

import com.trycloud.tests.base.jitendra_US_5.TestBase;
import com.trycloud.tests.utilities.BrowserUtils;
import com.trycloud.tests.utilities.ConfigurationReader;
import com.trycloud.tests.utilities.Driver;
import com.trycloud.tests.utilities.LoginUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC5_TC6 extends TestBase {


    @Test
    public void create_folder()  {


        Driver.getDriver().findElement(By.xpath("//*[@id=\"appmenu\"]/li[2]/a")).click();
        BrowserUtils.sleep(2);

        Driver.getDriver().findElement(By.xpath("//a[@class='button new']")).click();
        BrowserUtils.sleep(3);

        Driver.getDriver().findElement(By.xpath("//span[.='New folder']")).click();

        WebElement inputBox = Driver.getDriver().findElement(By.xpath("//input[@id='view13-input-folder']"));
        BrowserUtils.sleep(3);
        inputBox.clear();

        inputBox.sendKeys("Ruz");
        BrowserUtils.sleep(2);


        Driver.getDriver().findElement(By.xpath("//input[@class='icon-confirm']")).click();


        WebElement folder = Driver.getDriver().findElement(By.xpath("//span[.='Ruz']"));

        Assert.assertTrue(folder.isDisplayed());

        BrowserUtils.sleep(1);
        Driver.getDriver().findElement(By.xpath("(//label[contains(@for,'select-files')])[1]")).click();
        BrowserUtils.sleep(1);
        Driver.getDriver().findElement(By.xpath("//span[.='Actions']")).click();
        Driver.getDriver().findElement(By.xpath("(//span[.='Delete'])[1]")).click();

    }

    @Test
    public void upload_file() {


        Driver.getDriver().findElement(By.xpath("//*[@id=\"appmenu\"]/li[2]/a")).click();
        BrowserUtils.sleep(2);

        Driver.getDriver().findElement(By.xpath("//a[@class='button new']")).click();
        BrowserUtils.sleep(2);


        action = new Actions(Driver.getDriver());

//        String filename = "/Users/rosie/Desktop/Softskill class/Other testings/Other testings.pdf";
//        File file = new File(filename);
//        String path = file.getAbsolutePath();
        WebElement upload = Driver.getDriver().findElement(By.xpath("//label[@for='file_upload_start']"));

        action.moveToElement(upload).sendKeys("/Users/rosie/Desktop/Softskill class/Other testings/Other testings.pdf").perform();


        // file.sendKeys("/Users/rosie/Desktop/my notes/Something");

    }


}
