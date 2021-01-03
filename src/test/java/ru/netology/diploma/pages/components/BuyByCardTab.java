package ru.netology.diploma.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.visible;

public class BuyByCardTab extends BaseBuyTab {

    private SelenideElement tabTitle = $(byText("Оплата по карте"));

    public BuyByCardTab() {
        tabTitle.shouldBe(visible);
    }
}
