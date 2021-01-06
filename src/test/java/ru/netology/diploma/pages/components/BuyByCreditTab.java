package ru.netology.diploma.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class BuyByCreditTab extends BaseBuyTab {

    private SelenideElement tabTitle = $(byText("Кредит по данным карты"));

    private BuyByCreditTab() {
        tabTitle.shouldBe(visible);
    }

    public static BuyByCreditTab newInstance() {
        return new BuyByCreditTab();
    }
}
