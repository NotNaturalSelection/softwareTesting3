package org.notnaturalselection.softwareTesting3.authorizedTests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.notnaturalselection.softwareTesting3.AuthorizedBrowserTest;
import org.notnaturalselection.softwareTesting3.pageObjects.MainLoggedPage;
import org.notnaturalselection.softwareTesting3.pageObjects.ProfilePage;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.not;

public class AddUserTest extends AuthorizedBrowserTest {
    static ProfilePage profilePage;
    static MainLoggedPage mainLoggedPage;

    @BeforeAll
    public static void init() {
        profilePage = new ProfilePage(driver);
        mainLoggedPage = new MainLoggedPage(driver);
    }

    @Test
    public void sendInvitationToUserAndCancelIt() {
        mainLoggedPage.usersSidebarItem.click();
        waitUntilClickable(mainLoggedPage.addUsersSidebarItem);
        mainLoggedPage.addUsersSidebarItem.click();
        waitUntilVisible(mainLoggedPage.usernamesInput);
        waitUntilClickable(mainLoggedPage.usernamesInput);
        String login = "4m3vgorodegorod";
        mainLoggedPage.usernamesInput.sendKeys(login+"\n");
        waitUntilClickable(mainLoggedPage.sendInvitationsButton);
        mainLoggedPage.sendInvitationsButton.click();
        new WebDriverWait(driver, 10).until(not(elementToBeClickable(mainLoggedPage.sendInvitationsButton)));
        mainLoggedPage.usersSidebarItem.click();
        waitUntilVisible(mainLoggedPage.invitationsTab);
        waitUntilClickable(mainLoggedPage.invitationsTab);
        mainLoggedPage.invitationsTab.click();
        waitUntilVisible(mainLoggedPage.firstInvitation);
        waitUntilClickable(mainLoggedPage.firstInvitation);
        assert mainLoggedPage.firstInvitationLogin.getAttribute("data-e2e-login").equals(login);
        mainLoggedPage.firstInvitation.click();
        waitUntilDocumentIsLoaded();
        waitUntilClickable(mainLoggedPage.declineInvitationButton);
        mainLoggedPage.declineInvitationButton.click();
        waitUntilDocumentIsLoaded();
    }
}
