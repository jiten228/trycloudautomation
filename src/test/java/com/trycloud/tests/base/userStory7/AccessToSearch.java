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
        driver.get("http://qa.trycloud.net/index.php/login?clear=1");
        String username = ConfigurationReader.getProperty("username");
        BrowserUtils.sleep(2);

        // 1.Login as a user
        LoginUtils.loginToTryCloud(driver, username);
    }

    @Test
    public static void accesToSearch() throws InterruptedException {
        // 2.Click magnifier icon  on the right top
        ArrayList<String> positiveData = new ArrayList<>(Arrays.asList("Notes","Talk","Dec 22nd"));
        BrowserUtils.sleep(2);

       // 3.Search any existing file/folder/user name
        for (String each : positiveData){
            WebElement searchBox = driver.findElement(By.xpath("//a[@aria-controls]"));
            searchBox.sendKeys(each);
            Thread.sleep(2000);
            searchBox.sendKeys(Keys.ENTER);
            BrowserUtils.sleep(2);

         // 4. Verify the app displays the expected result option
            boolean isLocate = driver.findElement(By.xpath("//h3[@class='unified-search__result-line-one']")).isDisplayed();


        }


    }
}
