package org.notnaturalselection.softwareTesting3.notAuthorizedTests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.notnaturalselection.softwareTesting3.BasicBrowserTest;
import org.notnaturalselection.softwareTesting3.pageObjects.SupportPage;
import org.openqa.selenium.JavascriptExecutor;

public class UnauthorizedActivityTest extends BasicBrowserTest {
    static SupportPage supportPage;

    @BeforeAll
    public static void init() {
        supportPage = new SupportPage(driver);
    }

    @AfterEach
    public void returnToMain() {
        driver.get("https://wordpress.com/ru/");
        waitUntilDocumentIsLoaded();
    }

    @Test
    public void checkQA() {
        mainPage.resourcesDropdown.click();
        waitUntilVisible(mainPage.supportMenuItem);
        mainPage.supportMenuItem.click();
        waitUntilUrlMatches("wordpress.com/ru/support");
        waitUntilDocumentIsLoaded();
        supportPage.searchBar.sendKeys("П");
        waitUntilVisible(supportPage.firstLink);
        waitUntilClickable(supportPage.firstLink);
        supportPage.firstLink.click();
        waitUntilDocumentIsLoaded();
        assertUrl("wordpress.com/ru/support/deleting-accounts/");
    }

    @Test
    public void checkPrices() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", mainPage.monthPricesButton);
        waitUntilClickable(mainPage.monthPricesButton);
        mainPage.monthPricesButton.click();
        waitUntilVisible(mainPage.monthPersonalDiv);
        assert mainPage.monthPersonalDiv.isDisplayed();
    }

}
