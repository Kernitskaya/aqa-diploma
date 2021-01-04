package ru.netology.diploma.test.regress;

import org.junit.jupiter.api.Test;
import ru.netology.diploma.domain.CardData;
import ru.netology.diploma.pages.TravelOfDayPage;
import ru.netology.diploma.test.BaseTest;
import ru.netology.diploma.utils.DataGenerator;

import static com.codeborne.selenide.Selenide.open;

public class TestBuyByCard extends BaseTest {

    @Test
    public void testCheckBuyByCardTabContent() {
        open(START_URL);
        TravelOfDayPage.newInstance().openBuyByCardTab().checkTabContent();
    }

    @Test
    public void testSuccessPaymentByCard() {
        open(START_URL);
        CardData cardData = DataGenerator.authInfo(true);
        TravelOfDayPage.newInstance().openBuyByCardTab().fillCardData(cardData).confirm();
        TravelOfDayPage.newInstance().successNotification().checkContent().close();
        TravelOfDayPage.newInstance().checkNotificationHidden();
    }
}
