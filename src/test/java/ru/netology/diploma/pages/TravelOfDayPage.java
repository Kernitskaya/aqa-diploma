package ru.netology.diploma.pages;

import com.codeborne.selenide.SelenideElement;
import ru.netology.diploma.pages.components.BuyByCardTab;
import ru.netology.diploma.pages.components.BuyByCreditTab;
import ru.netology.diploma.pages.components.SuccessNotification;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.visible;

public class TravelOfDayPage {

    private SelenideElement pageTitle = $(byText("Путешествие дня"));
    private SelenideElement travelCardTitle = $(byText("Марракэш"));
    private SelenideElement bonusMilesItem = $(byText("33 360 миль на карту"));
    private SelenideElement cashBackItem = $(byText("До 7% на остаток по счёту"));
    private SelenideElement costItem = $(byText("Всего 45 000 руб.!"));
    private SelenideElement buyByCard = $(byText("Купить"));
    private SelenideElement buyByCredit = $(byText("Купить в кредит"));
    private SelenideElement notificationTitle = $("[class=notification__title]");

    private TravelOfDayPage() {}

    public static TravelOfDayPage newInstance() {
        return new TravelOfDayPage();
    }

    public BuyByCardTab openBuyByCardTab() {
        buyByCard.click();
        return new BuyByCardTab();
    }

    public BuyByCreditTab openBuyByCreditTab() {
        return new BuyByCreditTab();
    }

    public void checkPageContent() {
        pageTitle.shouldBe(visible);
        travelCardTitle.shouldBe(visible);
        bonusMilesItem.shouldBe(visible);
        cashBackItem.shouldBe(visible);
        costItem.shouldBe(visible);
        buyByCard.shouldBe(visible);
        buyByCredit.shouldBe(visible);
    }

    public SuccessNotification successNotification() {
        return SuccessNotification.newInstance();
    }

    public void checkNotificationHidden() {
        notificationTitle.shouldNot(visible);
    }
}
