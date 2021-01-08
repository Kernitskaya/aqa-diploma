package ru.netology.diploma.test.db;

import org.junit.jupiter.api.Test;
import ru.netology.diploma.db.interactions.AssertionChecker;
import ru.netology.diploma.db.interactions.DbInteractionUtilsMySql;
import ru.netology.diploma.domain.CardData;
import ru.netology.diploma.pages.TravelOfDayPage;
import ru.netology.diploma.test.DatabaseTest;
import ru.netology.diploma.utils.DataGenerator;

import static com.codeborne.selenide.Selenide.open;
import static ru.netology.diploma.utils.CardType.APPROVED;
import static ru.netology.diploma.utils.CardType.UNKNOWN;

public class TestDatabaseMySql extends DatabaseTest {

    @Test
    public void testSuccessPaymentByCard() {
        open(START_URL);
        CardData cardData = DataGenerator.authInfo(APPROVED);
        TravelOfDayPage.newInstance().openBuyByCardTab().fillCardData(cardData).confirm();
        TravelOfDayPage.newInstance().notification().checkSuccessContent().close();
        TravelOfDayPage.newInstance().checkNotificationHidden();

        AssertionChecker.checkCardOrderEntity(dbInteractionDbUtils);
        AssertionChecker.checkPaymentEntity(dbInteractionDbUtils,true);
    }

    @Test
    public void testUnknownPaymentByCard() {
        open(START_URL);
        CardData cardData = DataGenerator.authInfo(UNKNOWN);
        TravelOfDayPage.newInstance().openBuyByCardTab().fillCardData(cardData).confirm();
        TravelOfDayPage.newInstance().notification().checkDeclinedContent().close();
        TravelOfDayPage.newInstance().checkNotificationHidden();

        AssertionChecker.checkCardOrderEntity(dbInteractionDbUtils);
        AssertionChecker.checkPaymentEntity(dbInteractionDbUtils,false);
    }

    @Test
    public void testSuccessPaymentByCredit() {
        open(START_URL);
        CardData cardData = DataGenerator.authInfo(APPROVED);
        TravelOfDayPage.newInstance().openBuyByCreditTab().fillCardData(cardData).confirm();
        TravelOfDayPage.newInstance().notification().checkSuccessContent().close();
        TravelOfDayPage.newInstance().checkNotificationHidden();

        AssertionChecker.checkCreditOrderEntity(dbInteractionDbUtils);
        AssertionChecker.checkCreditRequestEntity(dbInteractionDbUtils,true);
    }

    @Test
    public void testUnknownPaymentByCredit() {
        open(START_URL);
        CardData cardData = DataGenerator.authInfo(UNKNOWN);
        TravelOfDayPage.newInstance().openBuyByCreditTab().fillCardData(cardData).confirm();
        TravelOfDayPage.newInstance().notification().checkDeclinedContent().close();
        TravelOfDayPage.newInstance().checkNotificationHidden();

        AssertionChecker.checkCreditOrderEntity(dbInteractionDbUtils);
        AssertionChecker.checkCreditRequestEntity(dbInteractionDbUtils,false);
    }

    @Override
    public void setUpUtils() {
        if (dbInteractionDbUtils == null) {
            dbInteractionDbUtils = new DbInteractionUtilsMySql();
        }
    }
}
