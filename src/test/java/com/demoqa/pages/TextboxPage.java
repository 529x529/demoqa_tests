package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class TextboxPage {

    SelenideElement
            userNameInput = $("#userName"),
            userEmailInput = $("#userEmail"),
            currentAddressInput = $("#currentAddress"),
            permanentAddressInput = $("#permanentAddress"),
            submitBtn = $("#submit"),
            outputName = $("#output #name"),
            outputEmail = $("#output #email"),
            outputCurrentAddress = $("#output #currentAddress"),
            outputPermanentAddress = $("#output #permanentAddress");

    public TextboxPage openPage() {
        open("/text-box");
        $(".main-header").shouldHave(text("Text Box"));

        return this;
    }

    public TextboxPage removeJsElements() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public TextboxPage setUserName(String value) {
        userNameInput.setValue(value);

        return this;
    }

    public TextboxPage setUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public TextboxPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    public TextboxPage setPermanentAddress(String value) {
        permanentAddressInput.setValue(value);

        return this;
    }

    public TextboxPage clickSubmitBtn() {
        submitBtn.click();

        return this;
    }

    public TextboxPage checkOutputName(String value) {
        outputName.shouldHave(text(value));

        return this;
    }

    public TextboxPage checkOutputEmail(String value) {
        outputEmail.shouldHave(text(value));

        return this;
    }

    public TextboxPage checkOutputCurrentAddress(String value) {
        outputCurrentAddress.shouldHave(text(value));

        return this;
    }

    public TextboxPage checkOutputPermanentAddress(String value) {
        outputPermanentAddress.shouldHave(text(value));

        return this;
    }
}
