package ru.netology.diploma.db.interactions;

import ru.netology.diploma.db.DbInteractionDbUtils;
import ru.netology.diploma.domain.OrderEntity;
import ru.netology.diploma.domain.PaymentEntity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

public class DbInteractionUtilsPostgre extends DbInteractionDbUtils {
    @Override
    public String getUrl() {
        return "jdbc:postgresql://localhost:5432/app";
    }

    public void checkCardOrderEntity() {
        OrderEntity orderEntity = getLastOrderEntity();
        assertNotEquals(orderEntity.getId(), null);
        assertTrue(orderEntity.getCreated().contains(currentFormattedDate()));
        assertNull(orderEntity.getCredit_id());
        assertFalse(orderEntity.getPayment_id().isEmpty());
    }

    public void checkPaymentEntity(boolean mustApproved) {
        OrderEntity orderEntity = getLastOrderEntity();
        PaymentEntity paymentEntity = getPaymentEntity(orderEntity.getPayment_id());
        assertFalse(paymentEntity.getId().isEmpty());
        assertEquals(paymentEntity.getStatus(), mustApproved ? "APPROVED" : "DECLINED");
        assertEquals(paymentEntity.getTransaction_id(), orderEntity.getPayment_id());
        assertEquals(paymentEntity.getAmount(), "450000");
    }

    public void checkCreditOrderEntity() {
        OrderEntity orderEntity = getLastOrderEntity();
        assertNotEquals(orderEntity.getId(), null);
        assertTrue(orderEntity.getCreated().contains(currentFormattedDate()));
        assertNull(orderEntity.getPayment_id());
        assertFalse(orderEntity.getCredit_id().isEmpty());
    }

    public void checkCreditRequestEntity(boolean mustApproved) {
        OrderEntity orderEntity = getLastOrderEntity();
        PaymentEntity paymentEntity = getPaymentEntity(orderEntity.getPayment_id());
        assertFalse(paymentEntity.getId().isEmpty());
        assertEquals(paymentEntity.getStatus(), mustApproved ? "APPROVED" : "DECLINED");
        assertEquals(paymentEntity.getTransaction_id(), orderEntity.getPayment_id());
        assertEquals(paymentEntity.getAmount(), "450000");
    }

    private String currentFormattedDate() {
        LocalDate date = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return date.format(dateTimeFormatter);
    }
}
