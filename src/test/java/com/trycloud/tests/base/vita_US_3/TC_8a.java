package com.trycloud.tests.base.vita_US_3;

import com.trycloud.tests.utilities.BrowserUtils;
import com.trycloud.tests.utilities.ConfigurationReader;
import com.trycloud.tests.utilities.LoginUtils;
import com.trycloud.tests.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TC_8a {
    static WebDriver driver;

    // Test case #8 - verify users can delete a file/folder.

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
}
/*

2.Click action-icon from any file on the page
3.Choose “delete files” option
4.Click deleted files on the left bottom corner
5.Verify the deleted file is displayed no the page. (Pre-condition: there should be at least 1 file is uploaded inside files page)
 */