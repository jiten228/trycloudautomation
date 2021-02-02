package com.trycloud.tests.base.userStory7;

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

    @BeforeMethod
    public void setupMethod(){

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://qa.trycloud.net/index.php/login?clear=1");
        String username = ConfigurationReader.getProperty("username");
        LoginUtils.loginToTryCloud(driver, username);
    }
    @Test
    public static void accesToSearch() throws InterruptedException {
        ArrayList<String> positiveData = new ArrayList<>(Arrays.asList("Notes","Talk","Dec 22nd"));

        for (String each : positiveData){
            WebElement searchBox = driver.findElement(By.xpath("//div[@class='header-menu unified-search']"));
            searchBox.sendKeys(each);
            Thread.sleep(2000);
            searchBox.sendKeys(Keys.ENTER);
        }
        //

    }
}
