package com.trycloud.tests.base.Christina;

import com.trycloud.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class UserStory3TC34 {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        //Open Chrome browser
        driver = WebDriverFactory.getDriver("chrome");

        // go to http://qa.trycloud.net/index.php/login?clear=1
        driver.get("http://qa.trycloud.net/index.php/login?clear=1");

        //maximize window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //c
    }

    @Test
public void LogInSuccessfully() {
        //enter UserName/LogIn
        driver.findElement(By.id("user")).sendKeys("User20");
        driver.findElement(By.id("password")).sendKeys("Userpass123");
        driver.findElement(By.id("submit-form")).click();

    }

  @Test
  public void AccessFilesModule(){
      


        }







    @AfterMethod
    public void teardownMethod() throws InterruptedException {
        Thread.sleep(5000);
     //   driver.close();
    }







    
}
