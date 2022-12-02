package com.demoqa.pages.components;

import com.codeborne.selenide.SelenideElement;

import java.util.ArrayList;

import static com.codeborne.selenide.Selectors.byText;

public class CheckBoxComponent {
    public CheckBoxComponent setValues(SelenideElement input, ArrayList<String> values) {
        values.forEach(value -> input.$(byText(value)).click());
        return this;
    }
}
