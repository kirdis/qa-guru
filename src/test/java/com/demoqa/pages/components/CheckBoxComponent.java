package com.demoqa.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;

public class CheckBoxComponent {
    public CheckBoxComponent setValue(SelenideElement input, String value) {
        input.$(byText(value)).click();
        return this;
    }
}
