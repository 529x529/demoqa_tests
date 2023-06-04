package com.demoqa.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TableResponsiveComponent {

    SelenideElement
            tableResponsive = $(".table-responsive"),
            closeTableResponsiveBtn = $("#closeLargeModal");

    public void verifyEnteredResult(String label, String value) {
        tableResponsive.$(byText(label)).sibling(0).shouldHave(text(value));
    }

    public void clickCloseBtn() {
        closeTableResponsiveBtn.click();
    }
}
