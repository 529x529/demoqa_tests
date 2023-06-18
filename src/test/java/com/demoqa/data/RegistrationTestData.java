package com.demoqa.data;

import com.github.javafaker.Faker;

public class RegistrationTestData {
    Faker faker = new Faker();
    public String randomFirstName = faker.name().firstName(),
            randomLastName = faker.name().lastName(),
            randomEmailAddress = faker.internet().emailAddress(),
            randomGender = faker.options().option("Male", "Female", "Other"),
            randomUserNumber = faker.number().digits(10),
            randomSubject = faker.options().option("Maths", "Accounting", "Arts", "Social Studies"),
            randomHobbie = faker.options().option("Sports", "Reading", "Music"),
            picture = "file.pdf",
            randomCurrentAdress = faker.address().fullAddress(),
            randomYearOfBirth = String.valueOf(faker.number().numberBetween(1900, 2023)),
            randomMonthOfBirth = faker.options().option("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"),
            randomDayOfBirth = String.format("%02d", faker.number().numberBetween(1, 28)),
            randomState = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan"),
            randomCity = getRandomCity(randomState);

    public String getRandomCity(String state) {
        if (state.equals("NCR")) {
            return faker.options().option("Delhi", "Gurgaon", "Noida");
        }
        else if (state.equals("Uttar Pradesh")) {
            return faker.options().option("Agra", "Lucknow", "Merrut");
        }
        else if (state.equals("Haryana")) {
            return faker.options().option("Karnal", "Panipat");
        }
        else if (state.equals("Rajasthan")) {
            return faker.options().option("Jaipur", "Jaiselmer");
        }
        return null;
    }
}
