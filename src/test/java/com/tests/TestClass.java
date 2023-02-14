package com.tests;

import com.dataprovider.DataProviderClass;
import org.example.com.driver.CreateDriver;
import org.example.com.pageobjects.GamePO;
import org.example.com.webpages.Homepage;
import org.example.com.webpages.Registration;
import org.example.com.synchronization.SynchronizationWrapper;
import org.example.com.utilities.Utility;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestClass {

    WebDriver webDriver;

    @BeforeTest
    public void beforeTest()throws Exception{
        CreateDriver createDriver = new CreateDriver();
        createDriver.setWebDriver();
        webDriver = CreateDriver.getWebDriver();
    }
    @Test(dataProvider = "registrationCredentials", dataProviderClass = DataProviderClass.class)
    public void testCase (JSONObject object) throws InterruptedException {
        Registration registration = new Registration(webDriver);
        registration.navigate();
        registration.fillForm(object.get("countryCode").toString(),Utility.generateRandomJordanianNumber(),
                object.get("password").toString(), object.get("fullName").toString(), Utility.generateRandomEmail()).
                clickSignUp();
        SynchronizationWrapper.waitForURL(webDriver,"sign-up/otp");
        Homepage homepage = new Homepage(webDriver);
        homepage.navigateByTab();
        homepage.selectRandomGame();
    }


}
