package com.trycloud.tests.base.Christina_US_3;

import com.trycloud.tests.base.TestBase;
import com.trycloud.tests.utilities.BrowserUtils;
import com.trycloud.tests.utilities.ConfigurationReader;
import com.trycloud.tests.utilities.Driver;
import com.trycloud.tests.utilities.LoginUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;


public class FilesModuleTC34 extends TestBase{


  @Test
  public void Test_Case3_Add_Files_to_Favorites () throws InterruptedException {

      String expectedTitle, actualTitle;

      String username = ConfigurationReader.getProperty("username3");
      LoginUtils.loginToTryCloud(driver, username);

       WebElement files = driver.findElement(By.xpath("//a[@href='/index.php/apps/files/']"));
        files.click();
      BrowserUtils.sleep(2);

      actualTitle = driver.getTitle();
      expectedTitle = "Files - Trycloud QA";
      Assert.assertTrue(actualTitle.contains(expectedTitle), "Verification of Title Passed!");


        //Click action-icon from any file on the page
      WebElement actionIcon = driver.findElement(By.xpath("//a[@class='action action-menu permanent'][1]"));
      //System.out.println("actionIcon = " + actionIcon);
      actionIcon.click();

      //Choose “Add to Favorites” option
      WebElement addtoFavorites =driver.findElement(By.xpath("//a[@class='menuitem action action-favorite permanent']"));
      addtoFavorites.click();
     // Select dropdown= new Select(driver.findElement(By.xpath("//*[@class='icon icon-starred']")));
      //dropdown.getFirstSelectedOption();
      Thread.sleep(3000);

      //4. Click “Favorites” sub-module on the left side
      //finding all locators for sub-module( or sub-menu)
      WebElement files2= driver.findElement(By.xpath("//a[@class='active']"));

      WebElement allFiles= driver.findElement(By.xpath("//a[@class='nav-icon-files svg active']"));

      WebElement favorites= driver.findElement(By.xpath("//a[@class='nav-icon-favorites svg']"));

      //in order to select an item from sub-menu of a menu used mouse over action
      Actions action= new Actions(driver);
      action.moveToElement(files2).perform();
      action.moveToElement(allFiles).perform();
      action.moveToElement(favorites).click().perform();
      Thread.sleep(2000);

      //5. Verify the chosen file is listed on the table


        }



    }







    

