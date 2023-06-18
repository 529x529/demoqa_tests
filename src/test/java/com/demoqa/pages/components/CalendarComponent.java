package com.demoqa.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    SelenideElement
            dateOfBirthWrapper = $("#dateOfBirth-wrapper");

    public void setDate(String year, String month, String day) {
        dateOfBirthWrapper.$(byText(year)).click();
        dateOfBirthWrapper.$(byText(month)).click();
        dateOfBirthWrapper.$(".react-datepicker__day--0" + day + ":not(.react-datepicker__day--outside-month)").click();
    }
}