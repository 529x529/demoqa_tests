package com.demoqa.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class RegistrationRemoteTests extends RemoteTestBase {

    @Test
    @Tag("remote")
    @DisplayName("Проверка успешной регистрации")
    void successfulRegistrationTest() {
        step("Заполнение формы регистрации", () -> {
            registrationPage.openPage()
                    .removeJsElements()
                    .setFirstName(registrationTestData.randomFirstName)
                    .setLastName(registrationTestData.randomLastName)
                    .setUserEmail(registrationTestData.randomEmailAddress)
                    .setGender(registrationTestData.randomGender)
                    .setUserNumber(registrationTestData.randomUserNumber)
                    .setBirthDay(registrationTestData.randomYearOfBirth, registrationTestData.randomMonthOfBirth, registrationTestData.randomDayOfBirth)
                    .setSubject(registrationTestData.randomSubject)
                    .setHobbies(registrationTestData.randomHobbie)
                    .uploadPicture(registrationTestData.picture)
                    .setCurrentAdress(registrationTestData.randomCurrentAdress)
                    .setState(registrationTestData.randomState)
                    .setCity(registrationTestData.randomCity)
                    .clickSubmitBtn();
        });
        step("Проверка корректности заполнения формы регистрации", () -> {
            registrationPage
                    .checkEnteredResult("Student Name", String.format("%s %s", registrationTestData.randomFirstName, registrationTestData.randomLastName))
                    .checkEnteredResult("Student Email", registrationTestData.randomEmailAddress)
                    .checkEnteredResult("Gender", registrationTestData.randomGender)
                    .checkEnteredResult("Mobile", registrationTestData.randomUserNumber)
                    .checkEnteredResult("Date of Birth", String.format("%s %s,%s", registrationTestData.randomDayOfBirth, registrationTestData.randomMonthOfBirth, registrationTestData.randomYearOfBirth))
                    .checkEnteredResult("Subjects", registrationTestData.randomSubject)
                    .checkEnteredResult("Hobbies", registrationTestData.randomHobbie)
                    .checkEnteredResult("Picture", registrationTestData.picture)
                    .checkEnteredResult("Address", registrationTestData.randomCurrentAdress)
                    .checkEnteredResult("State and City", String.format("%s %s", registrationTestData.randomState, registrationTestData.randomCity));
        });
    }
}
