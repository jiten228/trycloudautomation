package com.trycloud.tests.base.jitendra;

import com.github.javafaker.Faker;
import com.trycloud.tests.base.TestBase;
import com.trycloud.tests.utilities.BrowserUtils;
import com.trycloud.tests.utilities.LoginUtils;
import com.trycloud.tests.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ContactModule extends TestBase {
    String expectedTitle, actualTitle;

    @Test
    public void Access_Contact_Module_TC1() {
        String username = ConfigurationReader.getProperty("username1");
        LoginUtils.loginToTryCloud(driver, username);
        WebElement locateContact = driver.findElement(By.xpath("//*[@id=\"appmenu\"]/li[7]/a"));
        locateContact.click();
        BrowserUtils.sleep(5);
        actualTitle = driver.getTitle();
        expectedTitle = "Contacts - Trycloud";
        Assert.assertTrue(actualTitle.contains(expectedTitle), "Verification of Title FAILED!11");
    }

    @Test
    public void Add_Contact_TC2() {
        String username = ConfigurationReader.getProperty("username1");
        LoginUtils.loginToTryCloud(driver, username);
        WebElement locateContact = driver.findElement(By.xpath("//*[@id=\"appmenu\"]/li[7]/a"));
        locateContact.click();
        BrowserUtils.sleep(5);
        WebElement newContactButton = driver.findElement(By.id("new-contact-button"));
        newContactButton.click();
        Assert.assertTrue(actualTitle.contains(expectedTitle), "Verification of Title FAILED!11");

        Faker faker = new Faker();

        WebElement company = driver.findElement(By.id("contact-org"));
        String companyName = faker.company().name();
        company.sendKeys(companyName);

        WebElement findTitleText = driver.findElement(By.id("contact-title"));
        findTitleText.sendKeys(faker.name().title());

        WebElement phoneText = driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/div[1]/div/div/input"));
        phoneText.sendKeys(faker.phoneNumber().phoneNumber());

        WebElement email = driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/div[2]/div/div/input"));
        email.sendKeys(faker.internet().emailAddress());

        WebElement poBox = driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/div[3]/div/div[2]/input"));
        poBox.sendKeys("" + faker.number().numberBetween(1, 500));

        WebElement address = driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/div[3]/div/div[3]/input"));
        address.sendKeys(faker.address().streetAddress());

        WebElement secondaryAddress = driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/div[3]/div/div[4]/input"));
        secondaryAddress.sendKeys(faker.address().secondaryAddress());

        WebElement postalCode = driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/div[3]/div/div[5]/input"));
        postalCode.sendKeys(faker.address().zipCode());

        WebElement city = driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/div[3]/div/div[6]/input"));
        city.sendKeys(faker.address().city());

        WebElement state = driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/div[3]/div/div[7]/input"));
        state.sendKeys(faker.address().state());

        WebElement country = driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/div[3]/div/div[8]/input"));
        country.sendKeys(faker.address().country());

        BrowserUtils.sleep(5);
        // Create a locator that is returning us all of the lists in the table
        List<WebElement> contactList = driver.findElements(By.xpath("//*[@class='app-content-list-item-line-one']"));
        //we need to loop through 'allContacts' List of WebElement and make sure 'expectedName' is in there
        for (WebElement each : contactList) {
            System.out.println(each.getText());
            if (each.getText().contains(companyName)) {
                Assert.assertEquals(companyName, each.getText());
                return;
            }
        }
        //The only condition where the Assert.fail() line below executed is if 'expectedName' is not in the list.
        //Assert.fail(); method will FAIL THE TEST NO MATTER WHAT.
        Assert.fail("The Expected Contact is not in the List.");
    }

    @Test
    public void verify_Contacts_List_TC3() {
        String username = ConfigurationReader.getProperty("username1");
        LoginUtils.loginToTryCloud(driver, username);
        WebElement locateContact = driver.findElement(By.xpath("//*[@id=\"appmenu\"]/li[7]/a"));
        locateContact.click();
        BrowserUtils.sleep(5);
        actualTitle = driver.getTitle();
        expectedTitle = "Contacts - Trycloud";
        Assert.assertTrue(actualTitle.contains(expectedTitle), "Verification of Title FAILED!11");
        WebElement countContacts = driver.findElement(By.xpath("//*[@id=\"notgrouped\"]/div/div[1]"));
        System.out.println(countContacts.getText());
        int count = Integer.parseInt(countContacts.getText());

        if (count < 2) {
            System.out.println("At least two contacts should be there in the list");
        } else {
            List<WebElement> contactList = driver.findElements(By.xpath("//*[@class='app-content-list-item-line-one']"));
            for (WebElement each : contactList) {
                System.out.println(each.getText());
            }
        }
    }
}
