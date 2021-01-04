package ru.netology.diploma.pages.components;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class Notification {
    SelenideElement text = $("[class=notification__content]");
    SelenideElement title = $("[class=notification__title]");
    SelenideElement closeIcon = $("[class=icon-button__content]");

    private Notification() {
        title.waitUntil(visible, 10000);
    }

    public static Notification newInstance() {
        return new Notification();
    }

    public Notification checkSuccessContent() {
        text.shouldHave(text("Операция одобрена банком"));
        title.shouldHave(text("Успешно"));
        return this;
    }

    public Notification checkDeclinedContent() {
        text.shouldHave(text("Ошибка! Банк отказал в проведении операции."));
        title.shouldHave(text("Ошибка"));
        return this;
    }

    public void close() {
        closeIcon.click();
    }
}
