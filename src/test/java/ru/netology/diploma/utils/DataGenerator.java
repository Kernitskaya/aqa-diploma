package ru.netology.diploma.utils;

import com.github.javafaker.Faker;
import ru.netology.diploma.domain.AuthInfo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DataGenerator {

    private static String approvedCardNumber = "4444 4444 4444 4441";
    private static String declinedCardNumber = "4444 4444 4444 4442";

    private static Faker faker = new Faker();

    private DataGenerator() {}

    public static AuthInfo authInfo(boolean approved) {
        AuthInfo authInfo = new AuthInfo();
        LocalDate parsedDate = getParseData();

        authInfo.setCardNumber(approved ? approvedCardNumber : declinedCardNumber);
        authInfo.setMonthOfCard(getFormattedMoth(parsedDate));
        authInfo.setYearOfCard(getFormattedYear(parsedDate));
        authInfo.setOwnerName(faker.name().firstName());
        authInfo.setCvvCode(String.valueOf(faker.random().nextInt(100, 999)));

        return authInfo;
    }

    private static LocalDate getParseData() {
        LocalDate date = LocalDate.now().plusDays(faker.random().nextInt(0, 30)).plusYears(faker.random().nextInt(0, 10));
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy MM dd");
        String text = date.format(dateTimeFormatter);
        return LocalDate.parse(text, dateTimeFormatter);
    }

    private static String getFormattedYear(LocalDate date) {
        String year = String.valueOf(date.getYear());
        System.out.println(year);
        return year.substring(year.length() - 2);
    }

    private static String getFormattedMoth(LocalDate date) {
        return date.getMonth().getValue() >= 10 ? String.valueOf(date.getMonth().getValue())
                : "0" + date.getMonth().getValue();
    }
}
