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

    @FindBy (xpath = "//*[@id=\"fileList\"]/tr/td[2]")
    public WebElement folder;

    @FindBy (xpath = "//*[@id=\"controls\"]/div[2]/a")
    public WebElement uploadIcon;

    @FindBy (xpath = "//*[@id=\"controls\"]/div[2]/div[2]/ul/li[1]/label")
    public WebElement uploadFileButton;

    @FindBy (xpath = "//a[@class='button new']")
    public WebElement addToFile;

    @FindBy (xpath = "//a[@data-filetype='x-office-document']")
    public WebElement newDocument;

    @FindBy (xpath = "//a[@class='action action-menu permanent'][1]")
    public WebElement actionIcon;

    @FindBy (xpath = "//a[@class='menuitem action action-delete permanent']")
    public WebElement deleteFiles;

    @FindBy (xpath = "//a[@class='recommendation']")
    public WebElement fileName;

    @FindBy (xpath = "//a[@class='menuitem action action-details permanent']")
    public WebElement detailsButton;

    @FindBy (xpath = "//a[@id='commentsTabView']")
    public WebElement commentsButton;

    @FindBy (xpath = "//div[@class='message']")
    public WebElement textButton ;

    @FindBy (xpath = "//input[@class='submit icon-confirm has-tooltip']")
    public WebElement submitCommentsButton;

    @FindBy (xpath = "//*[@id=\"commentsTabView\"]/ul/li[1]")
    public WebElement commentAfter;
}
