package com.trycloud.tests.base.vita_US_1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Login_PositiveData {
    WebDriver driver;
    @BeforeMethod
    public void tryCloudLogin (){
        // Open chrome browser
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //Navigate to login page http://qa.trycloud.net/index.php/login?clear=12.
        driver.get("http://qa.trycloud.net/index.php/login?clear=1");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    /*
    Enter positive user name and password.
    Usernames: User20, User50, User80, User110
    Password: Userpass123
     */
    @Test
    public void positiveDataLogin() throws InterruptedException {
        ArrayList<String> userNamesPositive = new ArrayList<>(Arrays.asList("User20",
                "User50", "User80", "User110")) ;
    String password = "Userpass123";

    for (String each : userNamesPositive){
        // type User name
        driver.findElement(By.name("user")).sendKeys(each);
        Thread.sleep(1000);
        // type Password
        driver.findElement(By.name("password")).sendKeys(password);
        Thread.sleep(2000);
        // Click login button
        driver.findElement(By.xpath("//input[@id='submit-form']")).click();
        Thread.sleep(2000);
        String expectedTitle = "Files - Trycloud - QA";
        String actualTitle = driver.getTitle();
        if (actualTitle.equals(expectedTitle)){
            System.out.println("Landing page Title verification PASSED");
        } else {
            System.err.println("Landing page Title verification FAILED");
        }
        // Do Log out
        driver.findElement(By.xpath("//div[@id='expand']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//li[@data-id='logout']")).click();
        Thread.sleep(2000);
        // clear user id
        driver.findElement(By.name("user")).clear();


    }
    }
}
