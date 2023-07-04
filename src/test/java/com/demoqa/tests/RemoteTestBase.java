package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.data.RegistrationTestData;
import com.demoqa.pages.RegistrationPage;
import com.demoqa.pages.TextboxPage;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class RemoteTestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    RegistrationTestData registrationTestData = new RegistrationTestData();

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));

        Configuration.browserCapabilities = capabilities;
    }
}
