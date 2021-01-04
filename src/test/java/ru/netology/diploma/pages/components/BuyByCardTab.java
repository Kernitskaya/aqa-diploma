package ru.netology.diploma.pages.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ru.netology.diploma.domain.CardData;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Condition.visible;

public class BuyByCardTab extends BaseBuyTab {

    private SelenideElement tabTitle = $(byText("Оплата по карте"));
    private SelenideElement cardNumberInput = $("[placeholder='0000 0000 0000 0000']");
    private SelenideElement monthOfCardInput = $("[placeholder='08']");
    private SelenideElement yearOfCardInput = $("[placeholder='22']");
    private SelenideElement ownerCardInput = $$("[class='input__control']").get(3);
    private SelenideElement cvvCardInput = $("[placeholder='999']");
    private SelenideElement continueButton = $(byText("Продолжить"));

    public BuyByCardTab() {
        tabTitle.shouldBe(visible);
    }

    public void checkTabContent() {
        cardNumberInput.shouldBe(visible);
        monthOfCardInput.shouldBe(visible);
        yearOfCardInput.shouldBe(visible);
        ownerCardInput.shouldBe(visible);
        cvvCardInput.shouldBe(visible);
    }

    public BuyByCardTab fillCardData(CardData cardData) {
        cardNumberInput.setValue(cardData.getCardNumber());
        monthOfCardInput.setValue(cardData.getMonthOfCard());
        yearOfCardInput.setValue(cardData.getYearOfCard());
        ownerCardInput.setValue(cardData.getOwnerName());
        cvvCardInput.setValue(cardData.getCvvCode());
        return this;
    }

    public void confirm() {
        continueButton.click();
    }
}
