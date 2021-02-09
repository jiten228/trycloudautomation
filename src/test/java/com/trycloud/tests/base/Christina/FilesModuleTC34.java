package com.trycloud.tests.base.Christina;

import com.github.javafaker.Faker;
import com.trycloud.tests.base.TestBase;
import com.trycloud.tests.utilities.BrowserUtils;
import com.trycloud.tests.utilities.ConfigurationReader;
import com.trycloud.tests.utilities.LoginUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Arrays;


public class FilesModuleTC34 extends TestBase {
    String expectedTitle, actualTitle;

  @Test
  public void Test_Case3_Add_Files_to_Favorites(){

      String username = ConfigurationReader.getProperty("username3");
      LoginUtils.loginToTryCloud(driver, username);

       WebElement files = driver.findElement(By.xpath("//a[@href='/index.php/apps/files/']"));
        files.click();

        //Click action-icon from any file on the page
       WebElement actionIcon= driver.findElement(By.xpath("//*[@class='icon icon-more']")); //* is used for attributes and value only
      Select select = new Select(actionIcon);

      //Choose “Add to Favorites” option
      select.selectByVisibleText("Add to favorites");

      //4. Click “Favorites” sub-module on the left side
      //*[@class='nav-favorites       ui-droppable'] or //*[@class='nav-icon-favorites svg active']


      //5. Verify the chosen file is listed on the table

        }



    }







    

