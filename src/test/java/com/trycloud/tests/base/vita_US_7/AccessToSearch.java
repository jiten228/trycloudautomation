package com.trycloud.tests.base.vita_US_7;

import com.trycloud.tests.utilities.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class AccessToSearch {

    // Test case #1 - Verify users can search any files/folder/users from the search box.

    @Test
    public static void accesToSearch() throws InterruptedException {
        String url = ConfigurationReader.getProperty("webUrl3");
        Driver.getDriver().get(url);

        // 1.Login as a user
        String username = ConfigurationReader.getProperty("username1");
        LoginUtils.loginToTryCloud(Driver.getDriver(), username);
        // 2.Click magnifier icon  on the right top
        ArrayList<String> positiveData = new ArrayList<>(Arrays.asList("Talk","Files","Contacts"));

        // 3.Search any existing file/folder/user name
        for (String each : positiveData){
            Driver.getDriver().findElement(By.xpath("//*[@id=\"header\"]/div[2]/div[1]/a")).click();
            Thread.sleep(2000);
            WebElement searchField = Driver.getDriver().findElement(By.xpath("//input[@type='search']"));
            BrowserUtils.sleep(1);
            searchField.click();
            searchField.sendKeys(each);
            BrowserUtils.sleep(1);
            searchField.sendKeys(Keys.ENTER);
            Driver.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            WebElement searchResult = Driver.getDriver().findElement(By.xpath("//span[@class='unified-search__result-content']"));
            searchResult.click();
            Thread.sleep(5);

            // 4. Verify the app displays the expected result option

            String actualTitle = Driver.getDriver().getTitle();
            Driver.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

            if (actualTitle.toLowerCase().contains(each.toLowerCase())){
                System.out.println("Expected result option: " + each +"- PASSED!!!");
            }else {
                System.out.println("Expected result option: " + each +"- FAILED!!!");
            }
            Driver.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        }


    }


}