package com.demoqa.models;

public class PracticeFormTestData {
    private String name;
    private String lastName;
    private Gender gender;
    private String email;
    private String phone;
    private String birthDay;
    private String birthMonth;
    private String birthYear;
    private String subject;
    private String hobby;
    private String address;
    private String city;
    private String state;

    public String getName() {
        return name;
    }

    public PracticeFormTestData withName(String name) {
        this.name = name;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public PracticeFormTestData withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public PracticeFormTestData withEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public PracticeFormTestData withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public PracticeFormTestData withBirthDay(String userBirthDay) {
        this.birthDay = userBirthDay;
        return this;
    }

    public String getBirthMonth() {
        return birthMonth;
    }

    public PracticeFormTestData withBirthMonth(String userBirthMonth) {
        this.birthMonth = userBirthMonth;
        return this;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public PracticeFormTestData withBirthYear(String birthYear) {
        this.birthYear = birthYear;
        return this;
    }

    public String getGender() {
        return gender.getGender();
    }

    public PracticeFormTestData withGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public String getSubject() {
        return subject;
    }

    public PracticeFormTestData withSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public String getHobby() {
        return hobby;
    }

    public PracticeFormTestData withHobby(String hobby) {
        this.hobby = hobby;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public PracticeFormTestData withAddress(String address) {
        this.address = address;
        return this;
    }

    public String getCity() {
        return city;
    }

    public PracticeFormTestData withCity(String city) {
        this.city = city;
        return this;
    }

    public String getState() {
        return state;
    }

    public PracticeFormTestData withState(String state) {
        this.state = state;
        return this;
    }
}
