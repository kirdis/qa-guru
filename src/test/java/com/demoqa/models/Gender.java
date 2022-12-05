package com.demoqa.models;

import java.util.Random;

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

    public static Gender getRandomGender() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}
