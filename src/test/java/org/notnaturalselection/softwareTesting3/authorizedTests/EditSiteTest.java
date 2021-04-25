package org.notnaturalselection.softwareTesting3.authorizedTests;

import java.util.Random;
import java.util.regex.Pattern;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.notnaturalselection.softwareTesting3.AuthorizedBrowserTest;
import org.notnaturalselection.softwareTesting3.pageObjects.MainLoggedPage;
import org.notnaturalselection.softwareTesting3.pageObjects.SiteEditPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EditSiteTest extends AuthorizedBrowserTest {
    static MainLoggedPage mainLoggedPage;
    static SiteEditPage siteEditPage;

    @BeforeAll
    public static void init() {
        mainLoggedPage = new MainLoggedPage(driver);
        siteEditPage = new SiteEditPage(driver);
    }

    @Test
    public void editSiteTest() {
        waitUntilVisible(mainLoggedPage.editMainPageHeader);
        waitUntilClickable(mainLoggedPage.editMainPageHeader);
        mainLoggedPage.editMainPageHeader.click();
        waitUntilUrlMatches("page");
        waitUntilDocumentIsLoaded();
        waitUntilVisible(siteEditPage.headerTextarea);
        waitUntilClickable(siteEditPage.headerTextarea);
        siteEditPage.headerTextarea.click();
        String text = "new testing block" + new Random().nextInt();
        siteEditPage.headerTextarea.clear();
        siteEditPage.headerTextarea.sendKeys(text);
        waitUntilClickable(siteEditPage.uploadModificationsButton);
        waitUntilVisible(siteEditPage.uploadModificationsButton);
        siteEditPage.uploadModificationsButton.click();
        waitUntilVisible(siteEditPage.seeModifiedPageLink);
        waitUntilClickable(siteEditPage.seeModifiedPageLink);
        siteEditPage.seeModifiedPageLink.click();
        waitUntilUrlMatches(".*wordpress\\.com[\\/]?$");
        waitUntilDocumentIsLoaded();
        assert ExpectedConditions.textMatches(By.xpath("//a[contains(text(), '"+text+"')]"), Pattern.compile(text)).apply(driver);
    }
}
