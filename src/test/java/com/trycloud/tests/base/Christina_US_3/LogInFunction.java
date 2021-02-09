package com.trycloud.tests.base.Christina_US_3;

import com.github.javafaker.Faker;
import com.trycloud.tests.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Arrays;


public class LogInFunction  {
     WebDriver driver;
    @BeforeMethod
    public void tryCloudLogin () {
        // Open chrome browser
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://qa.trycloud.net/index.php/login?clear=1");
        driver.manage().window().maximize();
        BrowserUtils.sleep(2);
    }
    @Test
    public void LogInSuccessfully(){
        //enter UserName/LogIn
        // userNames = "User20", "User50", "User80", "User110"
        // Password = "Userpass123

        ArrayList<String> usernames = new ArrayList<>(Arrays.asList("User20",
                "User50", "User80", "User110")) ;
        String password = "Userpass123";

        for (String each : usernames){
            // type User name
            driver.findElement(By.name("user")).sendKeys(each);

            // type Password
            driver.findElement(By.name("password")).sendKeys(password);
            // driver.findElement(By.id("user")).sendKeys("User20");
            // driver.findElement(By.id("password")).sendKeys("Userpass123");

            driver.findElement(By.id("submit-form")).click();
            BrowserUtils.sleep(2);
            //checking actual vs expected title
            String expectedTitle = "Dashboard - Trycloud";
            String actualTitle = driver.getTitle();

            Assert.assertEquals(expectedTitle, actualTitle, "Title verification failed");
            BrowserUtils.sleep(2);
            driver.close();

        }
    }

    @Test
    public void invalidloginFunctionality() {

        Faker faker = new Faker();
        //generating fake userName/password with Data Faker
        driver.findElement(By.id("user")).sendKeys(faker.name().username());
        driver.findElement(By.id("password")).sendKeys(faker.internet().password());
        driver.findElement(By.id("submit-form")).click();

        //checking if error message is displayed
        WebElement errorMessage = driver.findElement(By.xpath("//p[@class='warning wrongPasswordMsg']"));
        Assert.assertTrue(errorMessage.isDisplayed(), "Wrong username or password message not displayed");
        BrowserUtils.sleep(2);
        driver.close();
    }
}
