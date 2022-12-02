package com.demoqa.pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ResultsTableComponent {
    public ResultsTableComponent checkVisible() {
        $(".modal-content").shouldBe(visible);
        return this;
    }

    public ResultsTableComponent checkResult(String title, String value) {
        $(".table-responsive").$(byText(title)).parent()
                .shouldHave(text(value));
        return this;
    }
}
