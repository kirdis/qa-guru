package com.demoqa.models;

import java.io.File;
import java.util.ArrayList;

public class AutomationPracticeFormData {
    private String name;
    private String lastName;
    private Gender gender;
    private String email;
    private String phone;
    private String birthDay;
    private String birthMonth;
    private String birthYear;
    private ArrayList<String> subjects;
    private ArrayList<String> hobbies;
    private String address;
    private String city;
    private String state;
    private File photo;

    public String getName() {
        return name;
    }

    public AutomationPracticeFormData withName(String name) {
        this.name = name;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public AutomationPracticeFormData withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public AutomationPracticeFormData withEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public AutomationPracticeFormData withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public AutomationPracticeFormData withBirthDay(String userBirthDay) {
        this.birthDay = userBirthDay;
        return this;
    }

    public String getBirthMonth() {
        return birthMonth;
    }

    public AutomationPracticeFormData withBirthMonth(String userBirthMonth) {
        this.birthMonth = userBirthMonth;
        return this;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public AutomationPracticeFormData withBirthYear(String birthYear) {
        this.birthYear = birthYear;
        return this;
    }

    public String getGender() {
        return gender.getGender();
    }

    public AutomationPracticeFormData withGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public ArrayList<String> getSubjects() {
        return subjects;
    }

    public AutomationPracticeFormData withSubject(ArrayList<String> subjects) {
        this.subjects = subjects;
        return this;
    }

    public ArrayList<String> getHobbies() {
        return hobbies;
    }

    public AutomationPracticeFormData withHobbes(ArrayList<String> hobbies) {
        this.hobbies = hobbies;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public AutomationPracticeFormData withAddress(String address) {
        this.address = address;
        return this;
    }

    public String getCity() {
        return city;
    }

    public AutomationPracticeFormData withCity(String city) {
        this.city = city;
        return this;
    }

    public String getState() {
        return state;
    }

    public AutomationPracticeFormData withState(String state) {
        this.state = state;
        return this;
    }

    public File getPhoto() {
        return photo;
    }

    public AutomationPracticeFormData withPhoto(File photo) {
        this.photo = photo;
        return this;
    }
}
