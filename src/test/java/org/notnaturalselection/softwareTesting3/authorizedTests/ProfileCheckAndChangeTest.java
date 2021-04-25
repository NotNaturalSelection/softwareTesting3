package org.notnaturalselection.softwareTesting3.authorizedTests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.notnaturalselection.softwareTesting3.AuthorizedBrowserTest;
import org.notnaturalselection.softwareTesting3.pageObjects.MainLoggedPage;
import org.notnaturalselection.softwareTesting3.pageObjects.ProfilePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfileCheckAndChangeTest extends AuthorizedBrowserTest {
    static MainLoggedPage mainLoggedPage;
    static ProfilePage profilePage;

    @BeforeAll
    public static void init() {
        mainLoggedPage = new MainLoggedPage(driver);
        profilePage = new ProfilePage(driver);
    }

    @Test
    public void editProfileDescription() {
        mainLoggedPage.profileButton.click();
        waitUntilVisible(profilePage.descriptionTextarea);
        waitUntilClickable(profilePage.descriptionTextarea);
        waitUntilDocumentIsLoaded();
        String newDescription = "description" + profilePage.descriptionTextarea.getText();
        profilePage.descriptionTextarea.clear();
        profilePage.descriptionTextarea.sendKeys(newDescription);
        waitUntilClickable(profilePage.submitChangesButton);
        profilePage.submitChangesButton.click();
        waitUntilClickable(profilePage.descriptionTextarea);
        new WebDriverWait(driver, 5).until(ExpectedConditions.textToBePresentInElement(profilePage.descriptionTextarea, newDescription));
        assert profilePage.descriptionTextarea.getText().equals(newDescription);
    }

    @Test
    public void checkComments() {
        mainLoggedPage.commentsSidebarItem.click();
        waitUntilUrlMatches("comments");
        waitUntilDocumentIsLoaded();
    }
}
