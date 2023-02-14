package org.example.com.synchronization;

import org.example.com.driver.CreateDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SynchronizationWrapper {

    public static WebElement waitForVisibility (WebElement webElement, WebDriver webDriver, int timeout){
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, timeout);
        webDriverWait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(webElement)));
        return webElement;
    }

    public static WebElement waitForClickable (WebElement webElement, WebDriver webDriver, int timeout){
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, timeout);
        webDriverWait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(webElement)));
        return webElement;
    }

    public static void waitForURL(WebDriver driver, String desiredUrl){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.urlContains(desiredUrl));
    }

    public static boolean waitForJStoLoad(WebDriver driver) {

        WebDriverWait wait = new WebDriverWait(driver, 30);

        // wait for jQuery to load
        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                     return ((long)((JavascriptExecutor)driver).executeScript("return jQuery.active") == 0);
                }
                catch (Exception e) {
                    return true;
                }
            }
        };

        // wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor)driver).executeScript("return document.readyState")
                        .toString().equals("complete");
            }
        };

        return wait.until(jQueryLoad) && wait.until(jsLoad);
    }
}
