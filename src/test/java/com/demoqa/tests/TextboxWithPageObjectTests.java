package com.demoqa.tests;

import org.junit.jupiter.api.Test;

public class TextboxWithPageObjectTests extends TestBase{

    @Test
    void successTest() {

        textboxPage.openPage()
                .removeJsElements()
                .setUserName("Mikhail Rezchikov")
                .setUserEmail("test@test.com")
                .setCurrentAddress("Some address 1")
                .setPermanentAddress("Another address 1")
                .clickSubmitBtn();

        textboxPage
                .checkOutputName("Mikhail Rezchikov")
                .checkOutputEmail("test@test.com")
                .checkOutputCurrentAddress("Some address 1")
                .checkOutputPermanentAddress("Another address 1");
    }

}