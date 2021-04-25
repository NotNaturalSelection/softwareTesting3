package org.notnaturalselection.softwareTesting3.authorizedTests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.notnaturalselection.softwareTesting3.AuthorizedBrowserTest;
import org.notnaturalselection.softwareTesting3.pageObjects.MainLoggedPage;
import org.notnaturalselection.softwareTesting3.pageObjects.ProfilePage;

public class LogoutTest extends AuthorizedBrowserTest {
    static MainLoggedPage mainLoggedPage;
    static ProfilePage profilePage;

    @BeforeAll
    public static void init() {
        mainLoggedPage = new MainLoggedPage(driver);
        profilePage = new ProfilePage(driver);
    }

    @Test
    public void logout() {
        mainLoggedPage.profileButton.click();
        waitUntilDocumentIsLoaded();
        profilePage.exitButton.click();
        waitUntilDocumentIsLoaded();
        waitUntilUrlMatches("wordpress.com");
    }
}
