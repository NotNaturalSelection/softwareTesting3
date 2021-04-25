package org.notnaturalselection.softwareTesting3.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SitePage extends PageObject{
    public SitePage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//p[contains(text(), '')]")
    public WebElement content;
}
