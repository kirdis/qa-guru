package com.demoqa.models;

import java.util.Random;

public enum Subject {
    MATH("Math"),
    ENGLISH("English"),
    ARTS("Arts"),
    BIOLOGY("Biology"),
    HINDI("Hindi");

    public final String subject;

    Subject(String subject) {
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public static Subject getRandomSubject() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}
