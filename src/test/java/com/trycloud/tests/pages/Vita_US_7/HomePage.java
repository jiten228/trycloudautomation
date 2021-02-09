package com.trycloud.tests.pages.Vita_US_7;

import com.trycloud.tests.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    // 1. Initialize driver and object of current class by using
    //PageFactory.initElements(driver,this)

    public HomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    // 2. We use @FindBy Annotation

    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div[1]/a")
    public WebElement searchButton;

    @FindBy(xpath = "//input[@type='search']")
    public WebElement searchField;

    @FindBy(xpath = "//span[@class='unified-search__result-content']")
    public WebElement searchResult;

    }

