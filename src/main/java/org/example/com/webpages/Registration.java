package org.example.com.webpages;

import org.example.com.actions.WebActions;
import org.example.com.services.Navigate;
import org.example.com.synchronization.SynchronizationWrapper;
import org.openqa.selenium.WebDriver;

public class Registration implements Navigate {

    protected WebDriver webDriver;

    protected final String MOBILE_NUMBER = "input[id='phone']";

    protected final String  PASSWORD = "input[formcontrolname='password']";

    protected final String  FULL_NAME = "input[formcontrolname='first_name']";

    protected final String EMAIL_ADDRESS = "input[formcontrolname='email']";

    protected final String  SIGN_UP = "button[type='submit']";

    protected final String REGISTER = "div[routerlink='/sign-up/by/phone']";


    public WebActions actions = new WebActions();

    public Registration (WebDriver webDriver){
        this.webDriver = webDriver;
    }

    @Override
    public Registration navigate() {
        webDriver.get("https://store.tamatem.co/sign-up/by/phone");
        SynchronizationWrapper.waitForJStoLoad(webDriver);
        return this;
    }

    @Override
    public Navigate navigateByTab() {
        actions.click(REGISTER,webDriver);
        SynchronizationWrapper.waitForJStoLoad(webDriver);
        return this;
    }

    public Registration fillForm (String countryCode, String mobileNumber, String password, String fullName,
                                  String email){
        actions.selectFromDropDownToggle(countryCode,webDriver);
        actions.sendKeys(MOBILE_NUMBER,mobileNumber,webDriver);
        actions.sendKeys(PASSWORD,password,webDriver);
        actions.sendKeys(FULL_NAME,fullName,webDriver);
        actions.sendKeys(EMAIL_ADDRESS,email,webDriver);
        return this;
    }

    public Registration clickSignUp (){
        actions.click(SIGN_UP,webDriver);
        return this;
    }


}
