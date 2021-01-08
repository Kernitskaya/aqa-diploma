package ru.netology.diploma.db.interactions;

import ru.netology.diploma.db.DbInteractionDbUtils;
import ru.netology.diploma.domain.CreditRequestEntity;
import ru.netology.diploma.domain.OrderEntity;
import ru.netology.diploma.domain.PaymentEntity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class AssertionChecker {

    private AssertionChecker(){}

    public static void checkCardOrderEntity(DbInteractionDbUtils dbInteractionDbUtils) {
        OrderEntity orderEntity = dbInteractionDbUtils.getLastOrderEntity();
        assertNotEquals(orderEntity.getId(), null);
        assertTrue(orderEntity.getCreated().contains(currentFormattedDate()));
        assertNull(orderEntity.getCredit_id());
        assertFalse(orderEntity.getPayment_id().isEmpty());
    }

    public static void checkPaymentEntity(DbInteractionDbUtils dbInteractionDbUtils, boolean mustApproved) {
        OrderEntity orderEntity = dbInteractionDbUtils.getLastOrderEntity();
        PaymentEntity paymentEntity = dbInteractionDbUtils.getPaymentEntity(orderEntity.getPayment_id());
        assertFalse(paymentEntity.getId().isEmpty());
        assertEquals(paymentEntity.getStatus(), mustApproved ? "APPROVED" : "DECLINED");
        assertEquals(paymentEntity.getTransaction_id(), orderEntity.getPayment_id());
        assertEquals(paymentEntity.getAmount(), "450000");
    }

    public static void checkCreditOrderEntity(DbInteractionDbUtils dbInteractionDbUtils) {
        OrderEntity orderEntity = dbInteractionDbUtils.getLastOrderEntity();
        assertNotEquals(orderEntity.getId(), null);
        assertTrue(orderEntity.getCreated().contains(currentFormattedDate()));
        assertNotNull(orderEntity.getPayment_id());
        assertNotNull(orderEntity.getCredit_id());
    }

    public static void checkCreditRequestEntity(DbInteractionDbUtils dbInteractionDbUtils, boolean mustApproved) {
        OrderEntity orderEntity = dbInteractionDbUtils.getLastOrderEntity();
        CreditRequestEntity creditRequestEntity = dbInteractionDbUtils.getCreditRequestEntity(orderEntity.getPayment_id());
        assertEquals(creditRequestEntity.getBank_id(), orderEntity.getPayment_id());
        assertEquals(creditRequestEntity.getStatus(), mustApproved ? "APPROVED" : "DECLINED");
        assertTrue(creditRequestEntity.getCreated().contains(currentFormattedDate()));
        assertEquals(creditRequestEntity.getId(), orderEntity.getCredit_id());
    }

    private static String currentFormattedDate() {
        LocalDate date = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return date.format(dateTimeFormatter);
    }
}
