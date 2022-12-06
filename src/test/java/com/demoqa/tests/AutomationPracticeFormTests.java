package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.models.Gender;
import com.demoqa.models.UserData;
import com.demoqa.models.Hobby;
import com.demoqa.models.Subject;
import com.demoqa.pages.AutomationPracticeFormPage;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.*;

import static com.demoqa.utils.RandomUtils.getRandomCity;
import static com.demoqa.utils.RandomUtils.getRandomState;

public class AutomationPracticeFormTests {

    AutomationPracticeFormPage automationPracticeFormPage = new AutomationPracticeFormPage();

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest() {
        Faker faker = new Faker();
        String randomState = getRandomState(),
               randomCity =getRandomCity(randomState);

        UserData testData = new UserData()
                .withName(faker.name().firstName())
                .withLastName(faker.name().lastName())
                .withEmail(faker.internet().emailAddress())
                .withPhone(faker.number().digits(10))
                .withBirthDay(faker.date().birthday(18, 90))
                .withGender(Gender.getRandomGender())
                .withHobbes(Hobby.getRandomHobby())
                .withSubject(Subject.getRandomSubject())
                .withAddress(faker.address().streetAddress())
                .withState(randomState)
                .withCity(randomCity)
                .withPhoto(new File("src//test//resources//test.png"));

        Calendar birthDate = Calendar.getInstance();
        birthDate.setTime(testData.getBirthDay());

        int year = birthDate.get(Calendar.YEAR);
        String month  = birthDate.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH );
        int day = birthDate.get(Calendar.DAY_OF_MONTH);

        automationPracticeFormPage.openPage("/automation-practice-form")
                .fillForm(testData)
                .submitForm()

        //Assertions
                .checkResultsVisible()
                .checkResult("Student Name", testData.getName() + " " + testData.getLastName())
                .checkResult("Student Email", testData.getEmail())
                .checkResult("Gender", testData.getGender())
                .checkResult("Mobile", testData.getPhone())
                .checkResult("Date of Birth", day + " " + month + "," + year)
                .checkResult("Subjects", testData.getSubject())
                .checkResult("Hobbies", testData.getHobby())
                .checkResult("Picture", "test.png")
                .checkResult("Address", testData.getAddress())
                .checkResult("State and City", testData.getState() + " " + testData.getCity());
    }
}
