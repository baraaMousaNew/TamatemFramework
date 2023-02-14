package org.example.com.actions;

import org.example.com.synchronization.SynchronizationWrapper;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class WebActions {

    private WebElement highlightElement(WebElement element, WebDriver driver){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].style.border='2px solid red'", element);
        return element;
    }
    public WebElement sendKeys (String fieldLocator, String value, WebDriver driver){
        WebElement textField = driver.findElement(By.cssSelector(fieldLocator));
        SynchronizationWrapper.waitForVisibility(textField, driver, 10);
        highlightElement(textField, driver).sendKeys(value);
        return textField;
    }

    public WebElement click(String buttonLocator, WebDriver driver){
        WebElement button = driver.findElement(By.cssSelector(buttonLocator));
        SynchronizationWrapper.waitForClickable(button,driver,10);
        highlightElement(button,driver).click();
        return button;
    }

    public WebElement clickXpath (String buttonLocator, WebDriver driver){
        WebElement button = driver.findElement(By.xpath(buttonLocator));
        SynchronizationWrapper.waitForClickable(button,driver,10);
        highlightElement(button,driver);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
        return button;
    }

    public void selectFromDropDownToggle (String value, WebDriver driver){
        click("div[class='iti__arrow']",driver);
        sendKeys("input[id='country-search-box']", value,driver);
        clickXpath("//span[@class='iti__dial-code'][text()='" + value + "']//parent::li", driver);
    }


}
