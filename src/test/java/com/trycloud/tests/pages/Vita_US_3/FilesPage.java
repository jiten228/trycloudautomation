package com.trycloud.tests.pages.Vita_US_3;

import com.trycloud.tests.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FilesPage {
    // 1. Initialize driver and object of current class by using
    //PageFactory.initElements(driver,this)

    public FilesPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    // 2. We use @FindBy Annotation
    @FindBy (xpath = "//a[@aria-label='Files']")
    public WebElement files;

    @FindBy (xpath = "//*[@id=\"fileList\"]/tr[6]/td[2]/a/span[1]")
    public WebElement folder;

    @FindBy (xpath = "//*[@id=\"controls\"]/div[2]/a")
    public WebElement uploadIcon;

    @FindBy (xpath = "//*[@id=\"controls\"]/div[2]/div[2]/ul/li[1]/label")
    public WebElement uploadFileButton;

}
