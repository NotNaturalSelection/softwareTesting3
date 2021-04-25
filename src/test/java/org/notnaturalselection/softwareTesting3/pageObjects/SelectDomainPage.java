package org.notnaturalselection.softwareTesting3.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelectDomainPage extends PageObject {

    public SelectDomainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@type='search']")
    public WebElement searchInput;

    @FindBy(xpath = "//span[contains(text(),'Бесплатно')]")
    public WebElement freeDomainButton;

    @FindBy(xpath = "//button[contains(text(),'вы можете начать с бесплатного')]")
    public WebElement freeSiteButton;

    @FindBy(xpath = "//button[contains(text(),'Пропустить покупку')]")
    public WebElement skipPurchaseButton;

    @FindBy(xpath = "//button[contains(text(),'Нет, спасибо')]")
    public WebElement noThanksButton;
}
