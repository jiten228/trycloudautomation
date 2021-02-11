package com.trycloud.tests.base.delaram_US_3;

import com.trycloud.tests.base.TestBase;
import com.trycloud.tests.utilities.ConfigurationReader;
import com.trycloud.tests.utilities.LoginUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TC_1_access_file_module extends TestBase {


    @Test
    public void TC_1_access_file_module(){

     String username = ConfigurationReader.getProperty("username2");
        LoginUtils.loginToTryCloud(driver, username);

        WebElement file_module = driver.findElement(By.xpath("(//li[@data-id='files' ])[1]"));
        file_module.click();

      //access_file_module




    }



}
