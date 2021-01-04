package ru.netology.diploma.pages.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import ru.netology.diploma.domain.CardData;

import static com.codeborne.selenide.Condition.text;
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

    private ElementsCollection fieldContainers = $$("[class=input__inner]");

    private BuyByCardTab() {
        tabTitle.shouldBe(visible);
    }

    public static BuyByCardTab newInstance() {
        return new BuyByCardTab();
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

    public BuyByCardTab fillCardNumber(String cardNumber) {
        cardNumberInput.sendKeys(Keys.CONTROL + "A");
        cardNumberInput.sendKeys(Keys.BACK_SPACE);
        cardNumberInput.setValue(cardNumber);
        return this;
    }

    public BuyByCardTab fillMonth(String month) {
        monthOfCardInput.sendKeys(Keys.CONTROL + "A");
        monthOfCardInput.sendKeys(Keys.BACK_SPACE);
        monthOfCardInput.setValue(month);
        return this;
    }

    public BuyByCardTab fillYear(String year) {
        yearOfCardInput.sendKeys(Keys.CONTROL + "A");
        yearOfCardInput.sendKeys(Keys.BACK_SPACE);
        yearOfCardInput.setValue(year);
        return this;
    }

    public BuyByCardTab fillOwner(String owner) {
        ownerCardInput.sendKeys(Keys.CONTROL + "A");
        ownerCardInput.sendKeys(Keys.BACK_SPACE);
        ownerCardInput.setValue(owner);
        return this;
    }

    public BuyByCardTab fillCVV(String cvvCode) {
        cvvCardInput.sendKeys(Keys.CONTROL + "A");
        cvvCardInput.sendKeys(Keys.BACK_SPACE);
        cvvCardInput.setValue(cvvCode);
        return this;
    }


    public BuyByCardTab checkHintField(Hints hint) {
        getHintFromContainerByIndex(hint.index).shouldHave(text(hint.text));
        return this;
    }

    public void checkHintHidden(Hints hint) {
        getHintFromContainerByIndex(hint.index).shouldNot(visible);
    }

    public void confirm() {
        continueButton.click();
    }

    private SelenideElement getHintFromContainerByIndex(int index) {
        return fieldContainers.get(index).$("[class=input__sub]");
    }
}
