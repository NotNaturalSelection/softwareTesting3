package org.notnaturalselection.softwareTesting3;

import org.junit.jupiter.api.BeforeAll;

public class AuthorizedBrowserTest extends BasicBrowserTest {
    @BeforeAll
    public static void authorize() {
        authorizeWith("rtlbiathlon@gmail.com", "ScAk9aFpI1");
    }

    public static void authorizeWith(String email, String password) {
        mainPage.loginButton.click();
        loginPage.loginField.sendKeys(email);
        loginPage.next.click();
        waitUntilClickable(loginPage.passwordField);
        loginPage.passwordField.sendKeys(password);
        loginPage.login.click();
        waitUntilUrlMatches("wordpress.com\\/home");
        waitUntilDocumentIsLoaded();
    }
}
