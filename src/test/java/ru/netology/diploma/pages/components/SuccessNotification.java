package ru.netology.diploma.pages.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class SuccessNotification {
    SelenideElement text = $("[class=notification__content]");
    SelenideElement title = $("[class=notification__title]");
    SelenideElement closeIcon = $("[class=icon-button__content]");

    private SuccessNotification() {
        title.waitUntil(visible, 8000);
    }

    public static SuccessNotification newInstance() {
        return new SuccessNotification();
    }

    public SuccessNotification checkContent() {
        text.shouldHave(text("Операция одобрена банком"));
        title.shouldHave(text("Успешно"));
        return this;
    }

    public void close() {
        closeIcon.click();
    }
}
