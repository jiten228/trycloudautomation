package com.trycloud.tests.base.Izzatgul_US_2;

import com.trycloud.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MenuBarPOM {

WebDriver driver;

     @BeforeMethod
     public void setUpMethod() {
          // open chrome browser
          driver = WebDriverFactory.getDriver("chrome");

          //go to url: http://qa3.trycloud.net
          driver.get("http://qa3.trycloud.net");
          driver.manage().window().maximize();
          driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


     }

          @Test
          public void LogInSuccessfully() {
             //  1.Login as a user
               //enter UserName/ pass word LogIn
               driver.findElement(By.id("user")).sendKeys("User20");
               driver.findElement(By.id("password")).sendKeys("Userpass123");
               driver.findElement(By.id("submit-form")).click();

          }

        //  @Test
       //   public void AccessFilesModule(){
           /*
           2.Verify the user see the following modules:
           Files
           Galleries
           Activity
           Talk
           Contacts
           Calendar
           Note
            */


               @FindBy(xpath = "//ul[@id='appmenu']/li[1]")
               public WebElement buttonDashboard;

               @FindBy(xpath = "//ul[@id='appmenu']/li[2]")
               public WebElement buttonFile;

               @FindBy(xpath = "//ul[@id='appmenu']/li[3]")
               public WebElement buttonPhoto;

               @FindBy(xpath = "//ul[@id='appmenu']/li[4]")
               public WebElement buttonActivity;

               @FindBy(xpath = "//ul[@id='appmenu']/li[5]")
               public WebElement buttonTalk;

               @FindBy(xpath = "//ul[@id='appmenu']/li[6]")
               public WebElement buttonMail;

               @FindBy(xpath = "//ul[@id='appmenu']/li[7]")
               public WebElement buttonContacts;

               @FindBy(xpath = "//ul[@id='appmenu']/li[8]")
               public WebElement buttonCircles;

               @FindBy(xpath = "//ul[@id='appmenu']/li[9]")
               public WebElement buttonCalendar;

               @FindBy(xpath = "//ul[@id='appmenu']/li[10]")
               public WebElement buttonDeck;

               @FindBy(xpath = "//ul[@id='appmenu']/li[11]")
               public WebElement buttonMagnifyIcon;

              @FindBy(xpath = "//div[@class='notifications-button menutoggle']")
               public WebElement buttonNotification;

                @FindBy(xpath = "//div[@id='contactsmenu']")
               public WebElement buttonContacts2;

                @FindBy(xpath ="//*[@id=\"expand\"]/div[1]/img")
                public WebElement buttonSetting3;


                  @FindBy(xpath="//a[@id='nextcloud']")
                 public WebElement buttonHomeNextCloudLogo;

               public void setButtonDashboardClick(){buttonDashboard.click();}
               public void setButtonFileClick(){buttonFile.click();}
               public void setButtonPhotoClick(){buttonPhoto.click();}
               public void setButtonActivityClick(){buttonActivity.click();}
               public void setButtonTalkClick(){buttonTalk.click();}
               public void setButtonMailClick(){buttonMail.click();}
               public void setButtonContactsClick(){buttonContacts.click();}
               public void setButtonCirclesClick(){buttonCircles.click();}
               public void setButtonCalendarClick(){buttonCalendar.click();}
               public void setButtonDeckClick(){buttonDeck.click();}
               public void setButtonMagnifyIconClick(){buttonMagnifyIcon.click();}
               public void setButtonNotificationClick(){buttonNotification.click();}



          @AfterMethod
          public void teardownMethod() throws InterruptedException {
               Thread.sleep(4000);
               //   driver.close();
          }





     }







    /*

    2.Story:
    As a user, I should be access all the main modules of the app.
    Test case #1 - verify users access to the main modules
    1.Login as a user
    2.Verify the user see the following modules:
    Files
    Galleries
     Activity
     Talk
     Contacts
     Calendar
     Note

     ( Expected module name: Galleries  Actual module name :  Photos )



         //enter UserName/ and password LogIn

               ArrayList<String> verifyUser = new ArrayList<String>(Arrays.asList("User20","User50","User80","User110"));
               String password = "Userpass123";

               for(String each : verifyUser){
                   // type user name
                   driver.findElement(By.name("user")).sendKeys(each);

                   // type password
                    driver.findElement(By.name("password")).sendKeys(password);

                    // click login button
                   driver.findElement(By.id("//input[@id='submit-form']"));

                   String expectedUrl = "http://qa3.trycloud.net";
                   String actualUrl = driver.getCurrentUrl();

     */


//  @Test
//   public void AccessFilesModule(){
           /*
           2.Verify the user see the following modules:
           Files
           Galleries
           Activity
           Talk
           Contacts
           Calendar
           Note
            */