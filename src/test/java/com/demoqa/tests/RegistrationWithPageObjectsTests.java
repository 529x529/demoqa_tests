package com.demoqa.tests;

import org.junit.jupiter.api.Test;

public class RegistrationWithPageObjectsTests extends TestBase {

    @Test
    void successfulRegistrationTest() {
        registrationPage.openPage()
                .setFirstName("Mikhail")
                .setLastName("Rezchikov")
                .setUserEmail("test@test.com")
                .setGender("Male")
                .setUserNumber("0123456789")
                .setBirthDay("1997", "July", "31")
                .setSubject("Maths")
                .setHobbies("Sports")
                .uploadPicture("file.pdf")
                .setCurrentAdress("Test address")
                .setState("NCR")
                .setCity("Delhi")
                .clickSubmitBtn();

        registrationPage
                .checkEnteredResult("Student Name","Mikhail Rezchikov")
                .checkEnteredResult("Student Email", "test@test.com")
                .checkEnteredResult("Gender", "Male")
                .checkEnteredResult("Mobile", "0123456789")
                .checkEnteredResult("Date of Birth", "31 July,1997")
                .checkEnteredResult("Subjects", "Maths")
                .checkEnteredResult("Hobbies", "Sports")
                .checkEnteredResult("Picture", "file.pdf")
                .checkEnteredResult("Address", "Test address")
                .checkEnteredResult("State and City", "NCR Delhi")
                .closeTableResponsive();
    }
}
