package ru.netology.diploma.domain;

public class AuthInfo {
    private String cardNumber;
    private String monthOfCard;
    private String yearOfCard;
    private String ownerName;
    private String cvvCode;

    public String getMonthOfCard() {
        return monthOfCard;
    }

    public void setMonthOfCard(String monthOfCard) {
        this.monthOfCard = monthOfCard;
    }

    public String getYearOfCard() {
        return yearOfCard;
    }

    public void setYearOfCard(String yearOfCard) {
        this.yearOfCard = yearOfCard;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getCvvCode() {
        return cvvCode;
    }

    public void setCvvCode(String cvvCode) {
        this.cvvCode = cvvCode;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public String toString() {
        return "AuthInfo{" +
                "cardNumber='" + cardNumber + '\'' +
                ", monthOfCard='" + monthOfCard + '\'' +
                ", yearOfCard='" + yearOfCard + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", cvvCode='" + cvvCode + '\'' +
                '}';
    }
}
