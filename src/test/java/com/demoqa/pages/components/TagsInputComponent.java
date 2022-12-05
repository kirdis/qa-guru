package com.demoqa.pages.components;

import com.codeborne.selenide.SelenideElement;

import java.util.ArrayList;

import static com.codeborne.selenide.Selectors.byText;

public class TagsInputComponent {
    public TagsInputComponent setValues(SelenideElement input, String value) {
        input.setValue(value).pressEnter();
        return this;
    }
}
