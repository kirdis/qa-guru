package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.models.Gender;
import com.demoqa.models.AutomationPracticeFormData;
import com.demoqa.pages.AutomationPracticeFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AutomationPracticeFormTest {

    AutomationPracticeFormPage automationPracticeFormPage = new AutomationPracticeFormPage();

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest() {
        AutomationPracticeFormData testData = new AutomationPracticeFormData()
                .withName("Natalia")
                .withLastName("LastName")
                .withEmail("email@test.ru")
                .withPhone("8005553535")
                .withBirthYear("1990")
                .withBirthMonth("June")
                .withBirthDay("26")
                .withGender(Gender.FEMALE)
                .withHobbes(new ArrayList<>(List.of("Music")))
                .withSubject(new ArrayList<>(List.of("English", "Maths")))
                .withAddress("Nestora Zuchnogo, 19, 18")
                .withState("NCR")
                .withPhoto(new File("src//test//resources//test.png"))
                .withCity("Delhi");

        automationPracticeFormPage.openPage("/automation-practice-form")
                .fillForm(testData)
                .submitForm()

        //Assertions
                .checkResultsVisible()
                .checkResult("Student Name", testData.getName() + " " + testData.getLastName())
                .checkResult("Student Email", testData.getEmail())
                .checkResult("Gender", testData.getGender())
                .checkResult("Mobile", testData.getPhone())
                .checkResult("Date of Birth", testData.getBirthDay() + " " + testData.getBirthMonth() + "," + testData.getBirthYear())
                .checkMultipleResults("Subjects", testData.getSubjects())
                .checkMultipleResults("Hobbies", testData.getHobbies())
                .checkResult("Picture", "test.png")
                .checkResult("Address", testData.getAddress())
                .checkResult("State and City", testData.getState() + " " + testData.getCity());
    }
}
