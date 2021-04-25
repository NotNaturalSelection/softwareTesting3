package org.notnaturalselection.softwareTesting3.authorizedTests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.notnaturalselection.softwareTesting3.AuthorizedBrowserTest;
import org.notnaturalselection.softwareTesting3.pageObjects.MainLoggedPage;

public class DeleteSiteTest extends AuthorizedBrowserTest {
    static MainLoggedPage mainLoggedPage;

    @BeforeAll
    public static void init() {
        mainLoggedPage = new MainLoggedPage(driver);
    }

    @Test
    public void deleteSite() {
        waitUntilClickable(mainLoggedPage.settingsMenuBarItem);
        waitUntilVisible(mainLoggedPage.settingsMenuBarItem);
        mainLoggedPage.settingsMenuBarItem.click();
        waitUntilUrlMatches("settings");
        waitUntilDocumentIsLoaded();
        waitUntilVisible(mainLoggedPage.deleteSiteButton);
        waitUntilClickable(mainLoggedPage.deleteSiteButton);
        mainLoggedPage.deleteSiteButton.click();
        waitUntilDocumentIsLoaded();
        waitUntilVisible(mainLoggedPage.deleteSiteButton2);
        waitUntilClickable(mainLoggedPage.deleteSiteButton2);
        mainLoggedPage.deleteSiteButton2.click();
        waitUntilVisible(mainLoggedPage.deleteSiteInput);
        waitUntilClickable(mainLoggedPage.deleteSiteInput);
        waitUntilVisible(mainLoggedPage.deleteSiteName);
        mainLoggedPage.deleteSiteInput.sendKeys(mainLoggedPage.deleteSiteName.getText());
        waitUntilClickable(mainLoggedPage.deleteSiteButton3);
        waitUntilVisible(mainLoggedPage.deleteSiteButton3);
        mainLoggedPage.deleteSiteButton3.click();
        waitUntilUrlMatches("stats");
    }
}
