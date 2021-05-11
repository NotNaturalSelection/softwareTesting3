package org.notnaturalselection.softwareTesting3.notAuthorizedTests;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.notnaturalselection.softwareTesting3.BasicBrowserTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginFromMainPageTest extends BasicBrowserTest {

    @BeforeEach
    public void toMainPage() {
        driver.get("https://wordpress.com/ru/");
    }

    @Test
    public void loginWithGoogle()
            throws InterruptedException {
        mainPage.loginButton.click();
        TimeUnit.SECONDS.sleep(5);
        loginPage.loginWithGoogle.click();
        assert ExpectedConditions.numberOfWindowsToBe(2).apply(driver);
        String[] windows = new String[2];
        windows = driver.getWindowHandles().toArray(windows);
        System.out.println(Arrays.toString(windows));
        driver.switchTo().window(windows[1]);
        driver.close();
        driver.switchTo().window(windows[0]);
    }

    @Test
    public void login()
            throws InterruptedException {
        mainPage.loginButton.click();
        loginPage.loginField.sendKeys("rtlbiathlon@gmail.com");
        loginPage.next.click();
        waitUntilVisible(loginPage.passwordField);
        waitUntilClickable(loginPage.passwordField);
        loginPage.passwordField.sendKeys("ScAk9aFpI2");//wrong one
        loginPage.login.click();
        TimeUnit.SECONDS.sleep(2);
        assert ExpectedConditions.attributeContains(By.xpath("//input[@type='password']"), "class", "is-error").apply(driver);
        loginPage.passwordField.clear();
        loginPage.passwordField.sendKeys("ScAk9aFpI1");//right one
        loginPage.login.click();
        TimeUnit.SECONDS.sleep(5);
        waitUntilDocumentIsLoaded();
        assertUrl("wordpress.com/home");
    }
}
