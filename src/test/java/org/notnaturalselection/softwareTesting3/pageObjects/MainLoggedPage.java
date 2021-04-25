package org.notnaturalselection.softwareTesting3.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainLoggedPage extends PageObject {
    @FindBy(xpath = "//header/a[@href='/me']")
    public WebElement profileButton;

    @FindBy(xpath = "//li/a/span[contains(text(), 'Комментарии')]")
    public WebElement commentsSidebarItem;

    @FindBy(xpath = "//span[contains(text(), 'Пользователи')]")
    public WebElement usersSidebarItem;

    @FindBy(xpath = "//span[contains(text(), 'Записи')]")
    public WebElement postsSidebarItem;

    @FindBy(xpath = "//span[@data-e2e-sidebar='Добавить новую']")
    public WebElement addPostSidebarItem;

    @FindBy(xpath = "//span[@data-e2e-sidebar='Добавить']")
    public WebElement addUsersSidebarItem;

    @FindBy(xpath = "//input[@type='text'][@class='form-text-input token-field__input']")
    public WebElement usernamesInput;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement sendInvitationsButton;

    @FindBy(xpath = "//span[contains(text(), 'Приглашения')]")
    public WebElement invitationsTab;

    @FindBy(xpath = "//a[@class='card people-list-item is-invite is-card-link is-compact']")
    public WebElement firstInvitation;

    @FindBy(xpath = "//div[@class='people-profile__login'][@data-e2e-login]")
    public WebElement firstInvitationLogin;

    @FindBy(xpath = "//button[@type='button'][contains(text(), 'Отозвать приглашение')]")
    public WebElement declineInvitationButton;

    @FindBy(xpath = "//span[contains(text(), 'Добавить новый сайт')]")
    public WebElement createNewSite;

    @FindBy(xpath = "//h6[contains(text(), 'Запустите свой сайт')]")
    public WebElement startWithSiteTab;

    @FindBy(xpath = "//button[contains(text(), 'Запустить сайт')]")
    public WebElement startWithSiteButton;

    @FindBy(xpath = "//span[contains(text(), 'Настройки')]")
    public WebElement settingsMenuBarItem;

    @FindBy(xpath = "//p[contains(text(), 'Удалите свой сайт навсегда')]")
    public WebElement deleteSiteButton;

    @FindBy(xpath = "//button[contains(text(), 'Удалить сайт')]")
    public WebElement deleteSiteButton2;

    @FindBy(xpath = "//input[@type='text'][@class='form-text-input delete-site__confirm-input']")
    public WebElement deleteSiteInput;

    @FindBy(xpath = "//span[@class='delete-site__target-domain']")
    public WebElement deleteSiteName;

    @FindBy(xpath = "//button[contains(text(), 'Удалить этот сайт')]")
    public WebElement deleteSiteButton3;

    @FindBy(xpath = "//h6[contains(text(), 'Редактировать главную страницу')]")
    public WebElement editMainPageHeader;

    public MainLoggedPage(WebDriver driver) {
        super(driver);
    }
}
