package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.models.Gender;
import com.demoqa.models.PracticeFormTestData;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class AutomationPracticeForm {

    @BeforeAll
    static void setUp() {
        //Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest() {
        PracticeFormTestData testData = new PracticeFormTestData()
                .withName("Natalia")
                .withLastName("LastName")
                .withEmail("email@test.ru")
                .withPhone("8005553535")
                .withBirthYear("1990")
                .withBirthMonth("June")
                .withBirthDay("26")
                .withGender(Gender.FEMALE)
                .withHobby("Music")
                .withSubject("English")
                .withAddress("Nestora Zuchnogo, 19, 18")
                .withState("NCR")
                .withCity("Delhi");

        open("/automation-practice-form");

        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("#firstName").setValue(testData.getName());
        $("#lastName").setValue(testData.getLastName());
        $("#userEmail").setValue(testData.getEmail()).pressEnter();
        $("#genterWrapper").$(byText(testData.getGender())).click();
        $("#userNumber").setValue(testData.getPhone());
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-container").shouldBe(visible);
        $(".react-datepicker__month-select").selectOption(testData.getBirthMonth());
        $(".react-datepicker__year-select").selectOption(testData.getBirthYear());
        $x("//div[@class = 'react-datepicker__month']//div[text() = '" + testData.getBirthDay() + "']").click();
        $("#subjectsInput").setValue(testData.getSubject()).pressEnter();
        $("#hobbiesWrapper").$(byText(testData.getHobby())).click();
        $("#uploadPicture").uploadFile(new File("src//test//resources//test.png"));
        $("#currentAddress").setValue(testData.getAddress());
        $("#state").click();
        $("#stateCity-wrapper").$(byText(testData.getState())).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(testData.getCity())).click();
        $("#submit").click();

        //assertions
        $(".modal-content").shouldBe(visible);
        $(".table").shouldHave(
                text(testData.getName() + " " + testData.getLastName()),
                text(testData.getEmail()),
                text(testData.getBirthDay() + " " + testData.getBirthMonth() + "," + testData.getBirthYear()),
                text(testData.getGender()),
                text(testData.getPhone()),
                text(testData.getSubject()),
                text(testData.getHobby()),
                text(testData.getState() + " " + testData.getCity())
        );
    }
}
