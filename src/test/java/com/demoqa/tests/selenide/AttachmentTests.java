package com.demoqa.tests.selenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.attachment;
import static io.qameta.allure.Allure.step;

public class AttachmentTests {
    private final static String REPOSITORY = "eroshenkoam/allure-example";
    private final static int ISSUE = 80;


    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com/";
    }

    @Test
    public void searchIssueTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем стартовую страницу", () -> {
            open("");
            attachment("Source", webdriver().driver().source());
        });
    }

    @Test
    void testAnnotatedStep() {
        WebSteps steps = new WebSteps();
        steps.openMainPage();
        steps.takeScreenshot();
    }
}
