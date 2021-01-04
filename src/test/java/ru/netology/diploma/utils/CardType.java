package ru.netology.diploma.utils;

public enum CardType {
    APPROVED("4444 4444 4444 4441"),
    DECLINED("4444 4444 4444 4442"),
    UNKNOWN("4444 4444 4444 0000");

    public final String label;

    CardType(String label) {
        this.label = label;
    }
}
