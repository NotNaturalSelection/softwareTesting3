package org.notnaturalselection.softwareTesting3.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends PageObject {
    @FindBy(xpath = "//*[contains(text(), 'Войти')]")
    public WebElement loginButton;

    @FindBy(xpath = "//button[@data-dropdown-trigger='resources']")
    public WebElement resourcesDropdown;

    @FindBy(xpath = "//a[@title='Поддержка']")
    public WebElement supportMenuItem;

    @FindBy(xpath = "//a[@option='month']")
    public WebElement monthPricesButton;

    @FindBy(xpath = "//div[@class='lpc lpc-plan lpc-plan-personal plan card plan-personal price-monthly']")
    public WebElement monthPersonalDiv;

    public MainPage(WebDriver driver) {
        super(driver);
    }
}
