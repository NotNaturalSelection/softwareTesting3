package org.notnaturalselection.softwareTesting3.authorizedTests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.notnaturalselection.softwareTesting3.AuthorizedBrowserTest;
import org.notnaturalselection.softwareTesting3.pageObjects.MainLoggedPage;

public class CheckPostsTest extends AuthorizedBrowserTest {
    static MainLoggedPage mainLoggedPage;

    @BeforeAll
    public static void init() {
        mainLoggedPage = new MainLoggedPage(driver);
    }

    @Test
    public void checkPosts() {
        mainLoggedPage.postsSidebarItem.click();
        waitUntilClickable(mainLoggedPage.addPostSidebarItem);
        waitUntilVisible(mainLoggedPage.addPostSidebarItem);
        waitUntilDocumentIsLoaded();
        assertUrl("wordpress.com/posts");
    }
}
