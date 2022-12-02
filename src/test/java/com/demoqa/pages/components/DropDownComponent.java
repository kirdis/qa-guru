package com.demoqa.pages.components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class DropDownComponent {
    public DropDownComponent chooseValue(String value) {
        $("#stateCity-wrapper").$(byText(value)).click();
        return this;
    }
}
