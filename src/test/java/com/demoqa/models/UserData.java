package com.demoqa.models;

import java.io.File;
import java.util.Date;

public class UserData {
    private String name;
    private String lastName;
    private Gender gender;
    private String email;
    private String phone;
    private Date birthDay;
    private Subject subject;
    private Hobby hobby;
    private String address;
    private String city;
    private String state;
    private File photo;

    public String getName() {
        return name;
    }

    public UserData withName(String name) {
        this.name = name;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserData withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserData withEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public UserData withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getGender() {
        return gender.getGender();
    }

    public UserData withGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public String getSubject() {
        return subject.getSubject();
    }

    public UserData withSubject(Subject subject) {
        this.subject = subject;
        return this;
    }

    public String getHobby() {
        return hobby.getHobby();
    }

    public UserData withHobbes(Hobby hobbies) {
        this.hobby = hobbies;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public UserData withAddress(String address) {
        this.address = address;
        return this;
    }

    public String getCity() {
        return city;
    }

    public UserData withCity(String city) {
        this.city = city;
        return this;
    }

    public String getState() {
        return state;
    }

    public UserData withState(String state) {
        this.state = state;
        return this;
    }

    public File getPhoto() {
        return photo;
    }

    public UserData withPhoto(File photo) {
        this.photo = photo;
        return this;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public UserData withBirthDay(Date birthDay) {
        this.birthDay = birthDay;
        return this;
    }
}
