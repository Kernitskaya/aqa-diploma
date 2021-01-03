package ru.netology.diploma.test.regress;

import org.junit.jupiter.api.Test;
import ru.netology.diploma.test.BaseTest;
import ru.netology.diploma.utils.DataGenerator;

import static com.codeborne.selenide.Selenide.open;

public class TestBuyByCard extends BaseTest {

    @Test
    public void testCheckBuyByCardTabContent() {
        open(START_URL);
        DataGenerator.authInfo(true);
    }
}
