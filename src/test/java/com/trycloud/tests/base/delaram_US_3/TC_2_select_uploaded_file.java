package com.trycloud.tests.base.delaram_US_3;

import com.trycloud.tests.base.TestBase;
import com.trycloud.tests.utilities.ConfigurationReader;
import com.trycloud.tests.utilities.LoginUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class TC_2_select_uploaded_file<list> extends TestBase {

    @Test
    public void SelectAllCheckBoxes() {

        //#1===>login as a user
        String username = ConfigurationReader.getProperty("username2");
        LoginUtils.loginToTryCloud(driver, username);

        //#2===>click the top left checkbox for the table
        WebElement file_module = driver.findElement(By.xpath("(//li[@data-id='files' ])[1]"));
        file_module.click();

        //#3===>all files are selected



        List<WebElement>checkBox = driver.findElements(By.xpath("//*[@id=\"select_all_files\"]"));

        }

}



