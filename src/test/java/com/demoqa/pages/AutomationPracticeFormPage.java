package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.models.UserData;
import com.demoqa.pages.components.*;

import java.util.*;
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

    public AutomationPracticeFormPage setFirstName(UserData testData) {
        firstNameInput.setValue(testData.getName());
        return this;
    }

    public AutomationPracticeFormPage setLastName(UserData testData) {
        lastNameInput.setValue(testData.getLastName());
        return this;
    }

    public AutomationPracticeFormPage setEmail(UserData testData) {
        emailInput.setValue(testData.getEmail()).pressEnter();
        return this;
    }

    public AutomationPracticeFormPage setGenderInput(UserData testData) {
        genderInput.$(byText(testData.getGender())).click();
        return this;
    }

    public AutomationPracticeFormPage setPhoneInput(UserData testData) {
        phoneInput.setValue(testData.getPhone());
        return this;
    }

    public AutomationPracticeFormPage setBirthDate(UserData testData) {
        Calendar birthDate = Calendar.getInstance();
        birthDate.setTime(testData.getBirthDay());

        int year = birthDate.get(Calendar.YEAR);
        String month  = birthDate.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH );
        int day = birthDate.get(Calendar.DAY_OF_MONTH);


        dateOfBirthInput.click();
        calendarComponent.setDay(Integer.toString(day), month, Integer.toString(year));
        return this;
    }

    public AutomationPracticeFormPage setSubject(UserData testData) {
        tagsInputComponent.setValues(subjectsInput, testData.getSubject());
        return this;
    }

    public AutomationPracticeFormPage setHobby(UserData testData) {
        checkBoxComponent.setValue(hobbyInput, testData.getHobby());
        return this;
    }

    public AutomationPracticeFormPage submitForm() {
        submitButton.click();
        return this;
    }

    public AutomationPracticeFormPage setCity(UserData testData) {
        cityInput.click();
        dropDownComponent.chooseValue(testData.getCity());
        return this;
    }

    public AutomationPracticeFormPage setState(UserData testData) {
        stateInput.click();
        dropDownComponent.chooseValue(testData.getState());
        return this;
    }

    public AutomationPracticeFormPage setAddressInput(UserData testData) {
        addressInput.setValue(testData.getAddress());
        return this;
    }

    public AutomationPracticeFormPage setPhoto(UserData testData) {
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
        resultsTableComponent.checkResult(title, String.join(", ", values));
        return this;
    }

    public AutomationPracticeFormPage fillForm(UserData testData) {
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
