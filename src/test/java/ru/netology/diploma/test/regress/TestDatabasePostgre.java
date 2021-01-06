package ru.netology.diploma.test.regress;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.diploma.db.interactions.DbInteractionUtilsPostgre;
import ru.netology.diploma.domain.CardData;
import ru.netology.diploma.pages.TravelOfDayPage;
import ru.netology.diploma.test.BaseTest;
import ru.netology.diploma.utils.DataGenerator;

import static com.codeborne.selenide.Selenide.open;
import static ru.netology.diploma.utils.CardType.APPROVED;
import static ru.netology.diploma.utils.CardType.UNKNOWN;

public class TestDatabasePostgre extends BaseTest {

    private static DbInteractionUtilsPostgre dbInteractionUtilsPostgre = new DbInteractionUtilsPostgre();

    @BeforeEach
    public void clearDB() {
        dbInteractionUtilsPostgre.clearTables();
    }

    @Test
    public void testSuccessPaymentByCard() {
        open(START_URL);
        CardData cardData = DataGenerator.authInfo(APPROVED);
        TravelOfDayPage.newInstance().openBuyByCardTab().fillCardData(cardData).confirm();
        TravelOfDayPage.newInstance().notification().checkSuccessContent().close();
        TravelOfDayPage.newInstance().checkNotificationHidden();

        dbInteractionUtilsPostgre.checkCardOrderEntity();
        dbInteractionUtilsPostgre.checkPaymentEntity(true);
    }

    @Test
    public void testUnknownPaymentByCard() {
        open(START_URL);
        CardData cardData = DataGenerator.authInfo(UNKNOWN);
        TravelOfDayPage.newInstance().openBuyByCardTab().fillCardData(cardData).confirm();
        TravelOfDayPage.newInstance().notification().checkDeclinedContent().close();
        TravelOfDayPage.newInstance().checkNotificationHidden();

        dbInteractionUtilsPostgre.checkCardOrderEntity();
        dbInteractionUtilsPostgre.checkPaymentEntity(false);
    }

    @Test
    public void testSuccessPaymentByCredit() {
        open(START_URL);
        CardData cardData = DataGenerator.authInfo(APPROVED);
        TravelOfDayPage.newInstance().openBuyByCreditTab().fillCardData(cardData).confirm();
        TravelOfDayPage.newInstance().notification().checkSuccessContent().close();
        TravelOfDayPage.newInstance().checkNotificationHidden();

        dbInteractionUtilsPostgre.checkCreditOrderEntity();
        dbInteractionUtilsPostgre.checkCreditRequestEntity(true);
    }
}
