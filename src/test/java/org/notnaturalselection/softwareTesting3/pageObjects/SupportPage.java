package org.notnaturalselection.softwareTesting3.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SupportPage extends PageObject {
    public SupportPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@type='text']")
    public WebElement searchBar;

    @FindBy(xpath = "//input[@type='submit'][@value='Поиск']")
    public WebElement acceptButton;

    @FindBy(xpath = "//div[@aria-hidden][@role='dialog']")
    public WebElement dialogDiv;

    @FindBy(xpath = "//ol/li/h3/a[contains(text(), 'Удаление учётной записи')]")
    public WebElement firstLink;
}
