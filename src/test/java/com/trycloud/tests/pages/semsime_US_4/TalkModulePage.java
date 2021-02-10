package com.trycloud.tests.pages.semsime_US_4;

import com.trycloud.tests.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TalkModulePage {

    public TalkModulePage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//input[@type='text']")
    public WebElement searchBox;



    @FindBy(xpath = "//div[@class='new-message-form__advancedinput']")
    public WebElement mesaageBox;





}
