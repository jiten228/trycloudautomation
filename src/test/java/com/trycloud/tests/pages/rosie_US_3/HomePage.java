package com.trycloud.tests.pages.rosie_US_3;

import com.trycloud.tests.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@id=\"appmenu\"]/li[2]/a")
    public WebElement filesButton;

    @FindBy(id = "nextcloud")
    public WebElement tryCloudButton;

    @FindBy(xpath = "(//a[@class='active'])[1]")
    public WebElement dashboardButton;

    @FindBy(xpath = "//*[@id=\"appmenu\"]/li[3]")
    public WebElement photosButton;

    @FindBy(xpath = "//*[@id=\"appmenu\"]/li[4]")
    public WebElement activityButton;

    @FindBy(xpath = "//*[@id=\"appmenu\"]/li[5]")
    public WebElement talkButton;

    @FindBy(xpath = "//*[@id=\"appmenu\"]/li[6]")
    public WebElement mailButton;

    @FindBy(xpath = "//*[@id=\"appmenu\"]/li[7]")
    public WebElement contactsButton;

    @FindBy(xpath = "//*[@id=\"appmenu\"]/li[8]")
    public WebElement circlesButton;

    @FindBy(xpath = "//*[@id=\"appmenu\"]/li[9]")
    public WebElement calendarButton;

    @FindBy(xpath = "//*[@id=\"appmenu\"]/li[10]")
    public WebElement deckButton;

    @FindBy(xpath = "//div[@class='header-menu unified-search'")
    public WebElement searchButton;

    @FindBy(xpath = "//div[@class='notifications']")
    public WebElement notificationsButton;

    @FindBy(xpath = "//div[@class='icon-contacts menutoggle']")
    public WebElement searchContactsButton;

    @FindBy(xpath = "//div[@id='expand']")
    public WebElement userButton;

    @FindBy(id = "expand")
    public WebElement settingsButton;

    @FindBy(xpath = "//*[@id=\"expanddiv\"]/ul/li[2]")
    public WebElement helpButton;

    @FindBy(xpath = "//li[@data-id='logout']")
    public WebElement logoutButton;

    @FindBy(xpath = "//a[@class='user-status-menu-item__toggle']")
    public WebElement setStatusButton;

    @FindBy(xpath = "//*[@id=\"weather-status-menu-item\"]/div/div/div/button")
    public WebElement setWeatherButton;

    @FindBy(xpath = "//*[@id=\"app-dashboard\"]/div[2]/a")
    public WebElement customizeButton;

}
