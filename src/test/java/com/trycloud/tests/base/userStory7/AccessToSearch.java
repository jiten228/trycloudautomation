package com.trycloud.tests.base.userStory7;

import com.google.common.base.Verify;
import com.trycloud.tests.utilities.BrowserUtils;
import com.trycloud.tests.utilities.ConfigurationReader;
import com.trycloud.tests.utilities.LoginUtils;
import com.trycloud.tests.utilities.WebDriverFactory;
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
    static WebDriver driver;
    // Test case #1 - Verify users can search any files/folder/users from the search box.

    @BeforeMethod
    public void setupMethod(){

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://qa3.trycloud.net");
        String username = ConfigurationReader.getProperty("username");
        BrowserUtils.sleep(2);

        // 1.Login as a user
        LoginUtils.loginToTryCloud(driver, username);

        String expectedTitle = "Dashboard - Trycloud";
        String actualTitle = driver.getTitle();
        if (actualTitle.equals(expectedTitle)){
            System.out.println("Landing page Title verification PASSED");
        } else {
            System.err.println("Landing page Title verification FAILED");
        }
    }

    @Test
    public static void accesToSearch() throws InterruptedException {
        // 2.Click magnifier icon  on the right top
        ArrayList<String> positiveData = new ArrayList<>(Arrays.asList("Files","Talk","Contacts"));

        // 3.Search any existing file/folder/user name
        for (String each : positiveData){
            driver.findElement(By.xpath("//a[@class='header-menu__trigger']")).click();

            WebElement searchField = driver.findElement(By.xpath("//input[@type='search']"));
            searchField.click();
            searchField.sendKeys(each);
            BrowserUtils.sleep(1);
            searchField.sendKeys(Keys.ENTER);
            BrowserUtils.sleep(1);
            WebElement result = driver.findElement(By.xpath("//span[@class='unified-search__result-content']"));
            result.click();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

            // 4. Verify the app displays the expected result option

            String actualTitle = driver.getTitle();

            if (actualTitle.toLowerCase().contains(each.toLowerCase())){
                System.out.println("Expected result option: " + each +"- PASSED!!!");
            }else {
                System.out.println("Expected result option: " + each +"- FAILED!!!");
            }
        }


    }


}