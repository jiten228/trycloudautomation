package com.trycloud.tests.pages.rosie_US_3;

import com.trycloud.tests.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AllFilesPage {

    public AllFilesPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@class='button new']")
    public WebElement newButton;

    @FindBy(xpath = "//span[.='New folder']")
    public WebElement newFolder;

    @FindBy(xpath = "//label[@for='file_upload_start']")
    public WebElement uploadFile;

    @FindBy(xpath = "//input[@id='view13-input-folder']")
    public WebElement inputBoxFolder;

    @FindBy(xpath = "//input[@class='icon-confirm']")
    public WebElement confirmButtonFolder;

    @FindBy(xpath = "(//label[contains(@for,'select-files')])[1]")
    public WebElement selectBox;

    @FindBy(xpath = "//span[.='Actions']")
    public WebElement actionsButton;

    @FindBy(xpath = "(//span[.='Delete'])[1]")
    public WebElement deleteButton;

    @FindBy(id = "app-navigation-toggle")
    public WebElement menuButton;

//    @FindBy()
//    public WebElement
//
//    @FindBy()
//    public WebElement
//
//    @FindBy()
//    public WebElement
//
//    @FindBy()
//    public WebElement
//
//    @FindBy()
//    public WebElement
//
//    @FindBy()
//    public WebElement
//
//    @FindBy()
//    public WebElement
//
//    @FindBy()
//    public WebElement
//
//    @FindBy()
//    public WebElement
//
//    @FindBy()
//    public WebElement
//
//    @FindBy()
//    public WebElement
//
//    @FindBy()
//    public WebElement
//
//    @FindBy()
//    public WebElement
//
//    @FindBy()
//    public WebElement
//
//    @FindBy()
//    public WebElement
//
//    @FindBy()
//    public WebElement
//
//    @FindBy()
//    public WebElement
//
//    @FindBy()
//    public WebElement
//
//    @FindBy()
//    public WebElement
//
//    @FindBy()
//    public WebElement
//
//    @FindBy()
//    public WebElement
//
//    @FindBy()
//    public WebElement
//
//    @FindBy()
//    public WebElement
//
//    @FindBy()
//    public WebElement
//
//    @FindBy()
//    public WebElement
//
//    @FindBy()
//    public WebElement
//
//    @FindBy()
//    public WebElement
//
//    @FindBy()
//    public WebElement
//
//    @FindBy()
//    public WebElement




}
