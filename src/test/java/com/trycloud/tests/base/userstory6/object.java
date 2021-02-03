package com.trycloud.tests.base.userstory6;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.util.concurrent.TimeUnit;

public class object {


    WebDriver driver;

    @BeforeMethod
    public void tryCloudLogin() throws InterruptedException {
        // Open chrome browser
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //Navigate to login page of TryCloud
        driver.get("http://qa.trycloud.net/index.php/login?clear=1");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    /*
    Usernames: User20, User50, User80, User110
    Password: UserPass123
     */

    @Test
    public void NotesModule() throws InterruptedException {
//1.Login
        String userName = "User20";
        String password = "Userpass123";
        //1.Login as a user
        driver.findElement(By.xpath("//input[@name='user']")).sendKeys(userName);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Thread.sleep(3000);

        //2.Click "Notes" module
        driver.findElement(By.xpath("//a[@href='/index.php/apps/notes/']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"notes_new_note\"]")).click();
        //3.Verify the page title is "Notes" modules title.
        System.out.println(driver.getTitle());
//write "Note"
        driver.findElement(By.xpath("//*[@id=\"note-container\"]/div/div[2]/div/div[1]/div[6]")).sendKeys("Note #1");
//
    }


}

