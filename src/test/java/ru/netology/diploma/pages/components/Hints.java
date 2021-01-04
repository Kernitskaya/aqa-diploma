package ru.netology.diploma.pages.components;

public enum Hints {
    CARD_NUMBER_WRONG_FORMAT(0, "Неверный формат"),
    MONTH_NUMBER_WRONG_FORMAT(1, "Введите правильный месяц"),
    YEAR_MANDATORY(2, "Поле обязательно для заполнения"),
    OWNER_MANDATORY(3, "Поле обязательно для заполнения"),
    CVV_WRONG_FORMAT(4, "Неверный формат");

    final public int index;
    final public String text;

    Hints(int index, String text) {
        this.index = index;
        this.text = text;
    }
}
