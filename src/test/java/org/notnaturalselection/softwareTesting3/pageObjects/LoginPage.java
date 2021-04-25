package org.notnaturalselection.softwareTesting3.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObject {
    @FindBy(xpath = "//*[contains(text(), 'Продолжить работу с Google')]")
    public WebElement loginWithGoogle;

    @FindBy(xpath = "//div/button[contains(text(),'Продолжить')][@type='submit']")
    public WebElement next;

    @FindBy(xpath = "//input[@name='usernameOrEmail']")
    public WebElement loginField;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement passwordField;

    @FindBy(xpath = "//div/button[contains(text(),'Войти')][@type='submit']")
    public WebElement login;

    public LoginPage(WebDriver driver) {
        super(driver);
    }
}
