package ru.netology.diploma.db.interactions;

import ru.netology.diploma.db.DbInteractionDbUtils;
import ru.netology.diploma.domain.OrderEntity;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

public class DbInteractionUtilsMySql extends DbInteractionDbUtils {
    @Override
    public String getUrl() {
        return "jdbc:mysql://localhost:3306/app";
    }

    public void checkOrderEntity() {
        OrderEntity orderEntity = getLastOrderEntity();
        assertFalse(orderEntity.getId().isEmpty());
        assertFalse(orderEntity.getCreated().isEmpty());
        assertNull(orderEntity.getCredit_id());
        assertFalse(orderEntity.getPayment_id().isEmpty());
    }
}
