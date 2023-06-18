package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.data.RegistrationTestData;
import com.demoqa.pages.RegistrationPage;
import com.demoqa.pages.TextboxPage;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    TextboxPage textboxPage = new TextboxPage();
    RegistrationTestData registrationTestData = new RegistrationTestData();

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

}
