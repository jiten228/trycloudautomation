package com.trycloud.tests.pages.Murat_US_3;

import com.trycloud.tests.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "user")
    public WebElement loginUsername;

    @FindBy(id = "password")
    public WebElement loginPassword;

    @FindBy(id = "submit-form")
    public WebElement loginButton;

    @FindBy(xpath = "//img[@src='/core/img/actions/logout.svg?v=38a61ebf']")
    public WebElement logOut;

    @FindBy(xpath = "//p[@class='warning wrongPasswordMsg']")
    public WebElement errorMessage;






}
