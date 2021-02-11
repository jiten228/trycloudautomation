package com.trycloud.tests.base.jitendra_US_5;

import com.trycloud.tests.base.TestBase;
import com.trycloud.tests.utilities.BrowserUtils;
import com.trycloud.tests.utilities.ConfigurationReader;
import com.trycloud.tests.utilities.LoginUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class US_3_TC34 extends TestBase {

    String expectedTitle, actualTitle;

    @Test
    public void Test_Case3_Add_Files_to_Favorites() {

        /*
    Test case #3 - verify users can add a file to favorites.
    1.Login as a user
    2.Click action-icon from any file on the page
    3.Choose “Add to Favorites” option
    4.Click “Favorites” sub-module on the lest side
    5.Verify the chosen file is listed on the table
    (Pre-condition: there should be at least 1 file is uploaded)
    */

        String username = ConfigurationReader.getProperty("username3");
        LoginUtils.loginToTryCloud(driver, username);

        WebElement files = driver.findElement(By.xpath("//a[@href='/index.php/apps/files/']"));
        files.click();
        BrowserUtils.sleep(2);

        actualTitle = driver.getTitle();
        expectedTitle = "Files - Trycloud QA";
        Assert.assertTrue(actualTitle.contains(expectedTitle), "Verification of Title FAILED!");


        //Click action-icon from any file on the page
        WebElement actionIcon = driver.findElement(By.xpath("//a[@class='action action-menu permanent'][1]"));
        actionIcon.click();

        //Choose “Add to Favorites” option
        try {
            WebElement addToFavourite = driver.findElement(By.xpath("//a/span[@class='icon icon-starred']"));
            BrowserUtils.sleep(3);
            addToFavourite.click();
        } catch (NoSuchElementException e) {
            System.out.println("Such a File or Folder already added to favorites!!!!!");
            e.getMessage();
        }

        //4. Click “Favorites” sub-module on the left side
        WebElement file = driver.findElement(By.xpath("(//table)[1]/tbody//tr"));
        String verifyFile = file.getAttribute("data-file");

        WebElement favoritesButton = driver.findElement(By.xpath("//a[.='Favorites']"));

        favoritesButton.click();

        BrowserUtils.sleep(3);

        List<WebElement> favoritesList = driver.findElements(By.xpath("//*[@id=\"fileList\"]/tr/td[1]/a/span[1]/span[1][@class='innernametext']"));

        for (WebElement element : favoritesList) {
            if (verifyFile.contains(element.getText())) {
//                Assert.assertEquals(verifyFile, element.getText());
                return;
            }
            System.out.println(element.getText());
        }
        Assert.fail("The Expected Contact is not in the List.");

    }

    @Test(dependsOnMethods = "Test_Case3_Add_Files_to_Favorites")
    public void Test_Case4_Remove_Files_from_Favorites() {

    /*
    Test case #4 - verify users can remove a file from favorites.
    1.Login as a user
    2.Click action-icon from any file on the page
    3.Click “Remove from Favorites” option
    4.Verify that the file is removed from Favorites sub-module’s table.
    (Pre-condition: there should be at least 1 file is added to favorites table)
    */

        String username = ConfigurationReader.getProperty("username3");
        LoginUtils.loginToTryCloud(driver, username);

        WebElement files = driver.findElement(By.xpath("//a[@href='/index.php/apps/files/']"));
        files.click();
        BrowserUtils.sleep(2);

        actualTitle = driver.getTitle();
        expectedTitle = "Files - Trycloud QA";
        Assert.assertTrue(actualTitle.contains(expectedTitle), "Verification of Title FAILED!");


        //Click action-icon from any file on the page
        WebElement actionIcon = driver.findElement(By.xpath("//a[@class='action action-menu permanent'][1]"));
        actionIcon.click();

        //Choose “Add to Favorites” option
        try {
            WebElement addToFavourite = driver.findElement(By.xpath("//a/span[@class='icon icon-star-dark']"));
            BrowserUtils.sleep(2);
            addToFavourite.click();
        } catch (NoSuchElementException e) {
            System.out.println("Such a File or Folder already removed from favorites!!!!!");
            e.getMessage();
        }
        WebElement favoritesButton = driver.findElement(By.xpath("//a[.='Favorites']"));

        favoritesButton.click();

        BrowserUtils.sleep(3);

        List<WebElement> favoritesList = driver.findElements(By.xpath("//*[@id=\"fileList\"]/tr/td[1]/a/span[1]/span[1][@class='innernametext']"));
        System.out.println("favoritesList.size() = " + favoritesList.size());

    }
}