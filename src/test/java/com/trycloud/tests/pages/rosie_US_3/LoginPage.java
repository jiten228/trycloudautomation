package com.trycloud.tests.pages.rosie_US_3;

import com.trycloud.tests.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(name = "user")
    public WebElement username;

    @FindBy(name = "password")
    public WebElement password;

    @FindBy(id = "submit-form")
    public WebElement loginButton;

    @FindBy(xpath ="//p[@class='warning wrongPasswordMsg']" )
    public WebElement errorMessage;

    @FindBy(xpath = "//a[@class='toggle-password']")
    public WebElement eyeButton;

    @FindBy(id = "lost-password")
    public WebElement forgotPasswordButton;

    @FindBy(xpath = "(//a)[3]")
    public WebElement loginDeviceButton;





}
