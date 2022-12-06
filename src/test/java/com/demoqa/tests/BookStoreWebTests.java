package com.demoqa.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BookStoreWebTests {
    @BeforeAll
    static void setUp() {
        //Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    public static Stream<Arguments> bookDetailsTest() {
        return Stream.of(
                Arguments.of(
                        "Git Pocket Guide",
                        Map.of(
                            "ISBN", "9781449325862",
                            "Title", "Git Pocket Guide",
                            "Sub Title", "A Working Introduction",
                            "Author", "Richard E. Silverman",
                            "Publisher", "O'Reilly Media",
                            "Total Pages", "234")
                ),
                Arguments.of(
                        "Learning JavaScript Design Patterns",
                        Map.of(
                            "ISBN", "9781449331818",
                            "Title", "Learning JavaScript Design Patterns",
                            "Sub Title", "A JavaScript and jQuery Developer's Guide",
                            "Author", "Addy Osmani",
                            "Publisher", "O'Reilly Media",
                            "Total Pages", "254")
                )
        );
    }

    @ParameterizedTest(name = "Check details for {1}.")
    @MethodSource("bookDetailsTest")
    void checkBookDetails(String bookName, Map<String, String> bookDetails) {
        open("/books");
        chooseBook(bookName);
        checkDetails(bookDetails);
    }

    private void chooseBook(String bookName) {
        $(byText(bookName)).click();
    }

    private void checkDetails(Map<String, String> details) {
        for (Map.Entry<String, String> entry : details.entrySet()) {
            $(".books-wrapper").$(withText(entry.getKey()))
                    .parent().parent().shouldHave(Condition.text(entry.getValue()));
        }
    }
}
