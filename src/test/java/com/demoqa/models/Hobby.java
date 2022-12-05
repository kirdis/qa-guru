package com.demoqa.models;

import java.util.Random;

public enum Hobby {
    SPORT("Sports"),
    READING("Reading"),
    MUSIC("Music");

    public final String hobby;

    Hobby(String hobby) {
        this.hobby = hobby;
    }

    public String getHobby() {
        return hobby;
    }

    public static Hobby getRandomHobby() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}
