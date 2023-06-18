package com.demoqa.tests;

import org.junit.jupiter.api.Test;

public class RegistrationWithFakerTests extends TestBase {

    @Test
    void successfulRegistrationTest() {
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
                .checkEnteredResult("State and City", String.format("%s %s", registrationTestData.randomState, registrationTestData.randomCity))
                .closeTableResponsive();
    }
}
