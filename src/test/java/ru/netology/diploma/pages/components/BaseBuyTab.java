package ru.netology.diploma.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public abstract class BaseBuyTab {
    private SelenideElement cardNumberInputField = $(byText("Номер карты"));
    private SelenideElement monthOfCardInputField = $(byText("Месяц"));
    private SelenideElement yearOfCardInputField = $(byText("Год"));
    private SelenideElement ownerNameInputField = $(byText("Владелец"));
    private SelenideElement cvvCodeInputField = $(byText("CVC/CVV"));
    private SelenideElement continueButton = $(withText("Продолжить"));
}
