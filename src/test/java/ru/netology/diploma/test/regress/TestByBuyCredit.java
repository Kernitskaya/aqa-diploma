package ru.netology.diploma.test.regress;

import org.junit.jupiter.api.Test;
import ru.netology.diploma.domain.CardData;
import ru.netology.diploma.pages.TravelOfDayPage;
import ru.netology.diploma.pages.components.BuyByCardTab;
import ru.netology.diploma.test.BaseTest;
import ru.netology.diploma.utils.DataGenerator;

import static com.codeborne.selenide.Selenide.open;
import static ru.netology.diploma.pages.components.Hints.*;
import static ru.netology.diploma.pages.components.Hints.CVV_WRONG_FORMAT;
import static ru.netology.diploma.utils.CardType.*;
import static ru.netology.diploma.utils.CardType.APPROVED;

public class TestByBuyCredit extends BaseTest {

    @Test
    public void testCheckBuyByCreditTabContent() {
        open(START_URL);
        TravelOfDayPage.newInstance().openBuyByCreditTab().checkTabContent();
    }

    @Test
    public void testSuccessPaymentByCredit() {
        open(START_URL);
        CardData cardData = DataGenerator.authInfo(APPROVED);
        TravelOfDayPage.newInstance().openBuyByCreditTab().fillCardData(cardData).confirm();
        TravelOfDayPage.newInstance().notification().checkSuccessContent().close();
        TravelOfDayPage.newInstance().checkNotificationHidden();
    }

    @Test
    public void testDeclinedPaymentByCredit() {
        open(START_URL);
        CardData cardData = DataGenerator.authInfo(DECLINED);
        TravelOfDayPage.newInstance().openBuyByCreditTab().fillCardData(cardData).confirm();
        TravelOfDayPage.newInstance().notification().checkDeclinedContent().close();
        TravelOfDayPage.newInstance().checkNotificationHidden();
    }

    @Test
    public void testUnknownPaymentByCredit() {
        open(START_URL);
        CardData cardData = DataGenerator.authInfo(UNKNOWN);
        TravelOfDayPage.newInstance().openBuyByCreditTab().fillCardData(cardData).confirm();
        TravelOfDayPage.newInstance().notification().checkDeclinedContent().close();
        TravelOfDayPage.newInstance().checkNotificationHidden();
    }

    @Test
    public void testFillCardNumber() {
        open(START_URL);
        CardData cardData = DataGenerator.authInfo(APPROVED);
        TravelOfDayPage.newInstance().openBuyByCreditTab().fillCardNumber("4444").confirm();
        BuyByCardTab.newInstance().checkHintField(CARD_NUMBER_WRONG_FORMAT)
                .fillCardNumber(cardData.getCardNumber()).confirm();
        BuyByCardTab.newInstance().checkHintHidden(CARD_NUMBER_WRONG_FORMAT);
    }

    @Test
    public void testFillMonth() {
        open(START_URL);
        CardData cardData = DataGenerator.authInfo(APPROVED);
        TravelOfDayPage.newInstance().openBuyByCreditTab().fillMonth("13").confirm();
        BuyByCardTab.newInstance().checkHintField(MONTH_NUMBER_WRONG_FORMAT)
                .fillMonth(cardData.getMonthOfCard()).confirm();
        BuyByCardTab.newInstance().checkHintHidden(MONTH_NUMBER_WRONG_FORMAT);
    }

    @Test
    public void testFillYear() {
        open(START_URL);
        CardData cardData = DataGenerator.authInfo(APPROVED);
        TravelOfDayPage.newInstance().openBuyByCreditTab().fillYear("").confirm();
        BuyByCardTab.newInstance().checkHintField(YEAR_MANDATORY)
                .fillYear(cardData.getYearOfCard()).confirm();
        BuyByCardTab.newInstance().checkHintHidden(YEAR_MANDATORY);
    }

    @Test
    public void testFillOwner() {
        open(START_URL);
        CardData cardData = DataGenerator.authInfo(APPROVED);
        TravelOfDayPage.newInstance().openBuyByCreditTab().fillOwner("").confirm();
        BuyByCardTab.newInstance().checkHintField(OWNER_MANDATORY)
                .fillOwner(cardData.getOwnerName()).confirm();
        BuyByCardTab.newInstance().checkHintHidden(OWNER_MANDATORY);
    }

    @Test
    public void testFillCVV() {
        open(START_URL);
        CardData cardData = DataGenerator.authInfo(APPROVED);
        TravelOfDayPage.newInstance().openBuyByCreditTab().fillCVV(DataGenerator.getRandomFirstNumber()).confirm();
        BuyByCardTab.newInstance().checkHintField(CVV_WRONG_FORMAT)
                .fillCVV(cardData.getCvvCode()).confirm();
        BuyByCardTab.newInstance().checkHintHidden(CVV_WRONG_FORMAT);
    }
}
