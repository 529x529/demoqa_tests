package com.demoqa.tests;

import org.junit.jupiter.api.Test;
import static com.demoqa.data.RegistrationTestData.*;

public class RegistrationWithFakerTests extends TestBase {

    @Test
    void successfulRegistrationTest() {
        registrationPage.openPage()
                .removeJsElements()
                .setFirstName(randomFirstName)
                .setLastName(randomLastName)
                .setUserEmail(randomEmailAddress)
                .setGender(randomGender)
                .setUserNumber(randomUserNumber)
                .setBirthDay(randomYearOfBirth, randomMonthOfBirth, randomDayOfBirth)
                .setSubject(randomSubject)
                .setHobbies(randomHobbie)
                .uploadPicture(picture)
                .setCurrentAdress(randomCurrentAdress)
                .setState(randomState)
                .setCity(randomCity)
                .clickSubmitBtn();

        registrationPage
                .checkEnteredResult("Student Name", String.format("%s %s", randomFirstName, randomLastName))
                .checkEnteredResult("Student Email", randomEmailAddress)
                .checkEnteredResult("Gender", randomGender)
                .checkEnteredResult("Mobile", randomUserNumber)
                .checkEnteredResult("Date of Birth", String.format("%s %s,%s", randomDayOfBirth, randomMonthOfBirth, randomYearOfBirth))
                .checkEnteredResult("Subjects", randomSubject)
                .checkEnteredResult("Hobbies", randomHobbie)
                .checkEnteredResult("Picture", picture)
                .checkEnteredResult("Address", randomCurrentAdress)
                .checkEnteredResult("State and City", String.format("%s %s", randomState, randomCity))
                .closeTableResponsive();
    }
}
