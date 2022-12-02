package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.models.AutomationPracticeFormData;
import com.demoqa.pages.components.*;

import java.util.ArrayList;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeFormPage {

    //Elements

    private CalendarComponent calendarComponent = new CalendarComponent();
    private ResultsTableComponent resultsTableComponent = new ResultsTableComponent();
    private DropDownComponent dropDownComponent = new DropDownComponent();
    private CheckBoxComponent checkBoxComponent = new CheckBoxComponent();
    private TagsInputComponent tagsInputComponent = new TagsInputComponent();


    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderInput = $("#genterWrapper"),
            phoneInput = $("#userNumber"),
            subjectsInput = $("#subjectsInput"),
            hobbyInput = $("#hobbiesWrapper"),
            submitButton = $("#submit"),
            cityInput = $("#city"),
            stateInput = $("#state"),
            addressInput = $("#currentAddress"),
            pictureLoader = $("#uploadPicture"),
            dateOfBirthInput = $("#dateOfBirthInput");

    //Actions

    public AutomationPracticeFormPage openPage(String s) {
        open(s);
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    public AutomationPracticeFormPage setFirstName(AutomationPracticeFormData testData) {
        firstNameInput.setValue(testData.getName());
        return this;
    }

    public AutomationPracticeFormPage setLastName(AutomationPracticeFormData testData) {
        lastNameInput.setValue(testData.getLastName());
        return this;
    }

    public AutomationPracticeFormPage setEmail(AutomationPracticeFormData testData) {
        emailInput.setValue(testData.getEmail()).pressEnter();
        return this;
    }

    public AutomationPracticeFormPage setGenderInput(AutomationPracticeFormData testData) {
        genderInput.$(byText(testData.getGender())).click();
        return this;
    }

    public AutomationPracticeFormPage setPhoneInput(AutomationPracticeFormData testData) {
        phoneInput.setValue(testData.getPhone());
        return this;
    }

    public AutomationPracticeFormPage setBirthDate(AutomationPracticeFormData testData) {
        dateOfBirthInput.click();
        calendarComponent.setDay(testData.getBirthDay(), testData.getBirthMonth(), testData.getBirthYear());
        return this;
    }

    public AutomationPracticeFormPage setSubject(AutomationPracticeFormData testData) {
        tagsInputComponent.setValues(subjectsInput, testData.getSubjects());
        return this;
    }

    public AutomationPracticeFormPage setHobby(AutomationPracticeFormData testData) {
        checkBoxComponent.setValues(hobbyInput, testData.getHobbies());
        return this;
    }

    public AutomationPracticeFormPage submitForm() {
        submitButton.click();
        return this;
    }

    public AutomationPracticeFormPage setCity(AutomationPracticeFormData testData) {
        cityInput.click();
        dropDownComponent.chooseValue(testData.getCity());
        return this;
    }

    public AutomationPracticeFormPage setState(AutomationPracticeFormData testData) {
        stateInput.click();
        dropDownComponent.chooseValue(testData.getState());
        return this;
    }

    public AutomationPracticeFormPage setAddressInput(AutomationPracticeFormData testData) {
        addressInput.setValue(testData.getAddress());
        return this;
    }

    public AutomationPracticeFormPage setPhoto(AutomationPracticeFormData testData) {
        pictureLoader.uploadFile(testData.getPhoto());
        return this;
    }

    public AutomationPracticeFormPage checkResultsVisible() {
        resultsTableComponent.checkVisible();
        return this;
    }

    public AutomationPracticeFormPage checkResult(String title, String value) {
        resultsTableComponent.checkResult(title, value);
        return this;
    }

    public AutomationPracticeFormPage checkMultipleResults(String title, ArrayList<String> values) {
        resultsTableComponent.checkResult(title, values.stream().collect(Collectors.joining(", ")).toString());
        return this;
    }

    public AutomationPracticeFormPage fillForm(AutomationPracticeFormData testData) {
        setFirstName(testData);
        setLastName(testData);
        setEmail(testData);
        setGenderInput(testData);
        setPhoneInput(testData);
        setBirthDate(testData);
        setSubject(testData);
        setHobby(testData);
        setPhoto(testData);
        setAddressInput(testData);
        setState(testData);
        setCity(testData);
        return this;
    }
}
