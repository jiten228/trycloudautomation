package com.trycloud.tests.pages.Jitendra_US_5;

import com.trycloud.tests.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@id=\"appmenu\"]/li[7]/a")
    public WebElement locateContact;


    // More codes in this Homepage, I will add later...
    // More codes in this Homepage, I will add later...
    // More codes in this Homepage, I will add later...
    // More codes in this Homepage, I will add later...
    // More codes in this Homepage, I will add later...
}
