package org.notnaturalselection.softwareTesting3.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewPostPage extends PageObject {

    public NewPostPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//textarea[@placeholder='Добавить заголовок']")
    public WebElement headerTextarea;

    @FindBy(xpath = "//textarea[@role='button']")
    public WebElement bodyTextarea;

    @FindBy(xpath = "//p[@data-type='core/paragraph']")
    public WebElement bodyP;

    @FindBy(xpath = "//button[@type='button'][contains(text(), 'Опубликовать')][@class='components-button editor-post-publish-panel__toggle editor-post-publish-button__button is-primary']")
    public WebElement submitPostButton;

    @FindBy(xpath = "//button[@type='button'][contains(text(), 'Опубликовать')][@class='components-button editor-post-publish-button editor-post-publish-button__button is-primary']")
    public WebElement confirmSubmitPostButton;

    @FindBy(xpath = "//a[contains(text(), 'Просмотреть запись')]")
    public WebElement seeSubmittedPost;

    @FindBy(xpath = "//button[contains(text(), 'Обсуждение')]")
    public WebElement discussionsTab;

    @FindBy(xpath = "//label[contains(text(), 'Разрешить комментарии')]")
    public WebElement forbidCommentsLabel;

    @FindBy(xpath = "//button[@type='button'][@data-label='Запись']")
    public WebElement postTabButton;
}
