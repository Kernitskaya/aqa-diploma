package ru.netology.diploma.test.smoke;

import org.junit.jupiter.api.Test;
import ru.netology.diploma.pages.TravelOfDayPage;
import ru.netology.diploma.test.BaseTest;

import static com.codeborne.selenide.Selenide.open;

public class TravelOfDayPageTest extends BaseTest {

    @Test
    public void testTravelOfDayPageContent() {
        open(START_URL);
        TravelOfDayPage.newInstance().checkPageContent();
    }
}
