package com.trycloud.tests.pages.Murat_US_3;

import com.trycloud.tests.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage(){

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "li[data-id='files']>a>svg>image")
    public WebElement filesModule;

    @FindBy(className = "settings-button")
    public WebElement settingButton;

    @FindBy(xpath = "//label[@for='showRichWorkspacesToggle']")
    public WebElement button1;

    @FindBy(xpath = "//label[@for='recommendationsEnabledToggle']")
    public WebElement button2;

    @FindBy(xpath = "//label[@for='showhiddenfilesToggle']")
    public WebElement button3;

    @FindBy(xpath = "//li[@id='quota']/a/p")
    public WebElement currentStorage;

    @FindBy(xpath = "//span[@class='icon icon-add']")
    public WebElement plusButton;

    @FindBy(xpath = "//span[@class='svg icon icon-upload']")
    public WebElement uploadFileButton;


}
