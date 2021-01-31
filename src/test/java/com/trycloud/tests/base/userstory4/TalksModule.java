package com.trycloud.tests.base.userstory4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TalksModule {
    public static void main(String[] args) throws InterruptedException {


        // Setup webdriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://qa.trycloud.net/index.php/login?clear=1");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        // Home page Verification
        String expectedTitle ="Trycloud - QA";
        String actualTitle = driver.getTitle();

        if (expectedTitle.equals(actualTitle)){
            System.out.println("Title verification has PASSED. STEP 1 COMPLETE!");
            System.out.println("actualTitle = " + actualTitle);
            System.out.println("expectedTitle = " + expectedTitle);

        }else{
            System.out.println("actualTitle = " + actualTitle);
            System.out.println("expectedTitle = " + expectedTitle);
        }

        // Login with UserName = "User20, User50, User80, User110" & Password = "Userpass123"

        String userName = "User20";
        String passWord = "Userpass123";


        driver.findElement(By.name("user")).sendKeys(userName);    // username
        driver.findElement(By.name("password")).sendKeys(passWord); // password
        driver.findElement(By.id("submit-form")).click();           // click to the login button
        Thread.sleep(2000);

        String expectedURL = "http://qa.trycloud.net/index.php/apps/files/?dir=/&fileid=3146";
        String actualURL = driver.getCurrentUrl();
        if (expectedURL.equals(actualURL)) {
            System.out.println("URL HAS PASSED! For username: " + userName);
        } else {
            System.out.println("FAILED! For username: " + userName);
            System.out.println("actualURL = " + actualURL);
            System.out.println("expectedURL = " + expectedURL);
            throw new RuntimeException();
        }

        // Search Talks module value and press Enter Key
        WebElement talksModuleButton = driver.findElement(By.xpath("//a[@href='http://qa.trycloud.net/index.php/apps/spreed/']"));
        talksModuleButton.click();
        Thread.sleep(3000);






    }
}
