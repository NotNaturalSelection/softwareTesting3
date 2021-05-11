package org.notnaturalselection.softwareTesting3;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.notnaturalselection.softwareTesting3.pageObjects.LoginPage;
import org.notnaturalselection.softwareTesting3.pageObjects.MainPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasicBrowserTest  {
    public static MainPage mainPage;
    public static LoginPage loginPage;
    public static WebDriver driver;
    public static final Long TO_WAIT = 20L;

    @BeforeAll
    public static void setupBrowser() {
        System.setProperty("webdriver.gecko.driver", "/home/notnaturalselection/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(TO_WAIT, TimeUnit.SECONDS);
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        driver.get("https://wordpress.com/ru/");
    }

    @AfterAll
    public static void closeBrowser() {
        driver.quit();
    }

    public static void waitUntilVisible(WebElement element) {
        waitUntilVisible(element, TO_WAIT);
    }

    public static void waitUntilVisible(WebElement element, long toWait) {
        if (element != null) {
            new WebDriverWait(driver, toWait).until(ExpectedConditions.visibilityOf(element));
        }
    }

    public static void waitUntilClickable(WebElement element) {
        waitUntilClickable(element, TO_WAIT);
    }

    public static void waitUntilClickable(WebElement element, long toWait) {
        if (element != null) {
            new WebDriverWait(driver, toWait).until(ExpectedConditions.elementToBeClickable(element));
        }
    }

    public static void waitUntilDocumentIsLoaded() {
        new WebDriverWait(driver, TO_WAIT).until(webDriver -> ((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState")
                .equals("complete"));
    }

    public static void waitUntilUrlMatches(String url) {
        new WebDriverWait(driver, TO_WAIT).until(ExpectedConditions.urlMatches(url));
    }

    public static void assertUrl(String expected) {
        System.out.println(driver.getCurrentUrl());
        assert driver.getCurrentUrl().contains(expected);
    }
}
