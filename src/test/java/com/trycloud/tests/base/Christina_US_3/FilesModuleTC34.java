package com.trycloud.tests.base.Christina_US_3;

import com.trycloud.tests.base.TestBase;
import com.trycloud.tests.utilities.BrowserUtils;
import com.trycloud.tests.utilities.ConfigurationReader;
import com.trycloud.tests.utilities.Driver;
import com.trycloud.tests.utilities.LoginUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;


public class FilesModuleTC34 extends TestBase {
    String expectedTitle, actualTitle;

  @Test
  public void Test_Case3_Add_Files_to_Favorites(){

      String username = ConfigurationReader.getProperty("username3");
      LoginUtils.loginToTryCloud(driver, username);

       WebElement files = driver.findElement(By.xpath("//a[@href='/index.php/apps/files/']"));
        files.click();
      BrowserUtils.sleep(2);

      actualTitle = driver.getTitle();
      expectedTitle = "Files - Trycloud QA";
      Assert.assertTrue(actualTitle.contains(expectedTitle), "Verification of Title FAILED!");


        //Click action-icon from any file on the page
      WebElement actionIcon = Driver.getDriver().findElement(By.xpath("//a[@class='action action-menu permanent'][1]"));
      actionIcon.click();

      //Choose “Add to Favorites” option
      Select dropdown= new Select(driver.findElement(By.xpath("//*[@class='icon icon-starred']")));
      dropdown.selectByVisibleText("Add to favorites");


      //4. Click “Favorites” sub-module on the left side
      WebElement favorites= driver.findElement(By.xpath("//*[@class='nav-icon-favorites svg']"));



      //5. Verify the chosen file is listed on the table

        }



    }







    

