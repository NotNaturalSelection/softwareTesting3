package org.notnaturalselection.softwareTesting3.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SiteEditPage extends PageObject{
    public SiteEditPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//textarea[@placeholder='Добавить заголовок']")
    public WebElement headerTextarea;

    @FindBy(xpath = "//button[@type='button'][contains(text(), 'Обновить')]")
    public WebElement uploadModificationsButton;

    @FindBy(xpath = "//a[contains(text(), 'Просмотреть страницу')]")
    public WebElement seeModifiedPageLink;
}
