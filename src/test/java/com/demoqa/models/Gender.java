package com.demoqa.models;

public enum Gender {
    MALE("Male"),
    FEMALE("Female"),
    OTHER("Other");

    public final String gender;

    Gender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }
}
