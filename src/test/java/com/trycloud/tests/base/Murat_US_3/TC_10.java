package com.trycloud.tests.base.Murat_US_3;

import com.trycloud.tests.base.TestBase;
import com.trycloud.tests.pages.Murat_US_3.HomePage;
import com.trycloud.tests.pages.Murat_US_3.LoginPage;
import com.trycloud.tests.utilities.BrowserUtils;
import com.trycloud.tests.utilities.ConfigurationReader;
import com.trycloud.tests.utilities.Driver;
import com.trycloud.tests.utilities.LoginUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_10 {

    @Test
    public void testCase_10(){
        //Test case #10 - verify users see the app storage usage
        Driver.getDriver().get(ConfigurationReader.getProperty("webUrl1"));

        LoginPage loginPage = new LoginPage();
        HomePage homePage = new HomePage();

        loginPage.loginUsername.sendKeys(ConfigurationReader.getProperty("username1"));
        loginPage.loginPassword.sendKeys(ConfigurationReader.getProperty("password"));
        loginPage.loginButton.click();

        //access to files module
        homePage.filesModule.click();

        WebElement currentStorage = homePage.currentStorage;
        System.out.println("Current Storage: "+currentStorage.getText());

        String path = "/Users/computer/Desktop/14.pdf";

        WebElement plusButton = homePage.plusButton;
        plusButton.click();
        BrowserUtils.sleep(1);

        WebElement uploadFileButton = homePage.uploadFileButton;
        uploadFileButton.click();

        try {
            uploadFileButton.sendKeys(path);// code cannot see path
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        WebElement newStorage = homePage.currentStorage;
        System.out.println("New Storage: "+newStorage.getText());
        

        Assert.assertNotEquals(currentStorage, newStorage,"Upload not successfully");
    }
}
