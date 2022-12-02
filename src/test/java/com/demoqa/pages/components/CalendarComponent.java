package com.demoqa.pages.components;

import com.demoqa.models.AutomationPracticeFormData;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CalendarComponent {
    public CalendarComponent setDay(String day, String month, String year) {
        $(".react-datepicker__month-container").shouldBe(visible);
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $x("//div[@class = 'react-datepicker__month']//div[text() = '" + day + "']").click();
        return this;
    }
}
