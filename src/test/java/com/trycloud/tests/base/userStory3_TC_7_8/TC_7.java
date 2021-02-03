package com.trycloud.tests.base.userStory3_TC_7_8;

import com.trycloud.tests.utilities.BrowserUtils;
import com.trycloud.tests.utilities.ConfigurationReader;
import com.trycloud.tests.utilities.LoginUtils;
import com.trycloud.tests.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC_7 {
    static WebDriver driver;
    // Test case #7 - verify users can upload a file inside a folder
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

        String expectedTitle = "Files - Trycloud - QA";
        String actualTitle = driver.getTitle();
        if (actualTitle.equals(expectedTitle)){
            System.out.println("Landing page Title verification PASSED");
        } else {
            System.err.println("Landing page Title verification FAILED");
        }
    }

    // 2.Choose a folder from the page
    @Test
    public static void uploadFileInsideFolder(){

    }

}
/*

3.Click the “+” icon on top
4.Click “upload file”
5.Upload a file
6.Verify the file is displayed on the page
(Pre-condition: there should be at least 1 folder is created on the filers page)


 */