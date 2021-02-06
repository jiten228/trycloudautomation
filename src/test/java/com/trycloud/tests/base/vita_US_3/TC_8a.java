package com.trycloud.tests.base.vita_US_3;

import com.trycloud.tests.utilities.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC_8a {


    // Test case #8 - verify users can delete a file/folder.
    @Test
    public void delete_fileFolder() {
    String url = ConfigurationReader.getProperty("webUrl3");
        Driver.getDriver().get(url);

    // 1.Login as a user
    String username = ConfigurationReader.getProperty("username1");
        LoginUtils.loginToTryCloud(Driver.getDriver(), username);


    // 1.Login as a user
        LoginUtils.loginToTryCloud(Driver.getDriver(), username);

        String expectedTitle = "Files - Trycloud - QA";
        String actualTitle = Driver.getDriver().getTitle();
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