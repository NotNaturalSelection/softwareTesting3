package org.notnaturalselection.softwareTesting3.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PostPage extends PageObject {
    public PostPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1[@class='entry-title']")
    public WebElement title;

    @FindBy(xpath = "//div[@class='entry-content']/p")
    public WebElement contentP;
}
