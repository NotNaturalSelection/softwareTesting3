package org.notnaturalselection.softwareTesting3.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends PageObject{
    @FindBy(xpath = "//textarea[@name='description']")
    public WebElement descriptionTextarea;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitChangesButton;

    @FindBy(xpath = "//button[@type='button'][contains(text(), 'Выйти')]")
    public WebElement exitButton;

    public ProfilePage(WebDriver driver) {
        super(driver);
    }
}
