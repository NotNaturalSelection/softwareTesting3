package org.notnaturalselection.softwareTesting3.authorizedTests;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.notnaturalselection.softwareTesting3.AuthorizedBrowserTest;
import org.notnaturalselection.softwareTesting3.pageObjects.MainLoggedPage;
import org.notnaturalselection.softwareTesting3.pageObjects.SelectDomainPage;

public class CreateNewSiteTest extends AuthorizedBrowserTest {
    static MainLoggedPage mainLoggedPage;
    static SelectDomainPage selectDomainPage;

    @BeforeAll
    public static void init() {
        mainLoggedPage = new MainLoggedPage(driver);
        selectDomainPage = new SelectDomainPage(driver);
    }

    @Test
    public void createNewSite() throws InterruptedException{
        waitUntilDocumentIsLoaded();
        waitUntilVisible(mainLoggedPage.createNewSite);
        waitUntilClickable(mainLoggedPage.createNewSite);
        mainLoggedPage.createNewSite.click();
        waitUntilVisible(selectDomainPage.searchInput);
        waitUntilClickable(selectDomainPage.searchInput);
        waitUntilDocumentIsLoaded();
        TimeUnit.SECONDS.sleep(1);
        selectDomainPage.searchInput.sendKeys("testdomainalexanderokishor"+new Random().nextInt());
        TimeUnit.SECONDS.sleep(1);
        waitUntilVisible(selectDomainPage.freeDomainButton);
        selectDomainPage.freeDomainButton.click();
        waitUntilDocumentIsLoaded();
        waitUntilClickable(selectDomainPage.freeSiteButton);
        selectDomainPage.freeSiteButton.click();
        waitUntilDocumentIsLoaded();
        waitUntilUrlMatches("wordpress.com\\/home");
        waitUntilClickable(mainLoggedPage.startWithSiteTab);
        mainLoggedPage.startWithSiteTab.click();
        waitUntilVisible(mainLoggedPage.startWithSiteButton);
        waitUntilClickable(mainLoggedPage.startWithSiteButton);
        mainLoggedPage.startWithSiteButton.click();
        waitUntilDocumentIsLoaded();
        waitUntilVisible(selectDomainPage.skipPurchaseButton);
        waitUntilClickable(selectDomainPage.skipPurchaseButton);
        selectDomainPage.skipPurchaseButton.click();
        waitUntilDocumentIsLoaded();
        waitUntilVisible(selectDomainPage.freeSiteButton);
        waitUntilClickable(selectDomainPage.freeSiteButton);
        selectDomainPage.freeSiteButton.click();
        waitUntilDocumentIsLoaded();
        waitUntilClickable(selectDomainPage.noThanksButton);
        waitUntilVisible(selectDomainPage.noThanksButton);
        selectDomainPage.noThanksButton.click();
        waitUntilUrlMatches("wordpress.com\\/home");
    }
}
