package com.trycloud.tests.base.semsime_US_4;



import com.trycloud.tests.pages.semsime_US_4.HomePage;
import com.trycloud.tests.pages.semsime_US_4.TalkModulePage;
import com.trycloud.tests.utilities.BrowserUtils;
import com.trycloud.tests.utilities.ConfigurationReader;
import com.trycloud.tests.utilities.Driver;
import com.trycloud.tests.utilities.LoginUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TalksModule {
    @Test
    public static void TalkModuleTest()throws InterruptedException{

        TalkModulePage talkModule = new TalkModulePage();
        HomePage homePage = new HomePage();

        String url = ConfigurationReader.getProperty("webUrl3");
        Driver.getDriver().get(url);

        //1.Login as a user
        String username = ConfigurationReader.getProperty("username1");
        LoginUtils.loginToTryCloud(Driver.getDriver(),username);

        //2.Click to TalkModule on home page
        homePage.talkModule.click();
        BrowserUtils.sleep(2);

        //3.Click to search box on Talk module page and search a user and write a message and submit it
        talkModule.searchBox.click();
        BrowserUtils.sleep(2);

        talkModule.searchBox.sendKeys("User100");
        talkModule.searchBox.sendKeys(Keys.ENTER);
        BrowserUtils.sleep(2);


        WebElement user100 = Driver.getDriver().findElement(By.xpath("//a[@class='acli' and @aria-label='Conversation, User100']"));
        user100.click();
        BrowserUtils.sleep(2);

        talkModule.mesaageBox.click();
        talkModule.mesaageBox.sendKeys("Hi! How are you doing man ?");
        talkModule.mesaageBox.sendKeys(Keys.ENTER);
        BrowserUtils.sleep(1);
        System.out.println("PASSED! I send a message to User100 !");


        // How can I use Java Faker here for find a user name ?


    }



}
