package com.trycloud.tests.pages.Vita_US_1;

import com.trycloud.tests.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    // 1. Initialize driver and object of current class by using
    //PageFactory.initElements(driver,this)

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    // 2. We use @FindBy Annotation

    @FindBy(id = "user")
    public WebElement inputUsername;

    @FindBy(id = "password")
    public WebElement inputPassword;

    @FindBy(id = "submit-form")
    public WebElement loginButton;

    @FindBy(xpath = "//div[@id='expand']")
    public WebElement settingsButton;

    @FindBy(xpath = "//li[@data-id='logout']")
    public WebElement logoutButton;

    @FindBy(xpath = "//p[@class='warning wrongPasswordMsg']")
    public WebElement warningMessage;

}
