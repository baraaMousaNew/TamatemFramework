package org.example.com.webpages;

import org.example.com.actions.WebActions;
import org.example.com.pageobjects.GamePO;
import org.example.com.services.Navigate;
import org.example.com.synchronization.SynchronizationWrapper;
import org.openqa.selenium.WebDriver;

public class Homepage implements Navigate {

    protected WebDriver webDriver;
    protected WebActions webActions = new WebActions();

    protected final String HOMEPAGE = "//div[@routerlink='/home']//span";

    protected final String GAME_TAB = "div[routerlink='/games/details']";

    public Homepage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Override
    public Homepage navigate(){
        webDriver.get("https://store.tamatem.co/home");
        SynchronizationWrapper.waitForJStoLoad(webDriver);
        return this;
    }

    public Homepage selectRandomGame (){
        webActions.click(GAME_TAB,webDriver);
        return this;
    }

    @Override
    public Navigate navigateByTab() {
        webActions.clickXpath(HOMEPAGE,webDriver);
        SynchronizationWrapper.waitForJStoLoad(webDriver);
        return this;
    }

}
