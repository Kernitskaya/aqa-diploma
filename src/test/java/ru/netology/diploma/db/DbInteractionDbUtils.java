package ru.netology.diploma.db;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import ru.netology.diploma.domain.CreditRequestEntity;
import ru.netology.diploma.domain.OrderEntity;
import ru.netology.diploma.domain.PaymentEntity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DbInteractionDbUtils {

    private String USER = "app";
    private String PASSWORD = "pass";

    public OrderEntity getLastOrderEntity() {
        OrderEntity orderEntity = new OrderEntity();
        try {
            String getLastOrderEntity = "SELECT * FROM order_entity ORDER BY created DESC";
            QueryRunner runner = new QueryRunner();
            try (
                    Connection conn = DriverManager.getConnection(getUrl(), USER, PASSWORD))
            {
                orderEntity = runner.query(conn, getLastOrderEntity, new BeanHandler<>(OrderEntity.class));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return orderEntity;
    }

    public PaymentEntity getPaymentEntity(String transactionId) {
        PaymentEntity paymentEntity = new PaymentEntity();
        try {
            String getPaymentByTransaction = String.format("SELECT * FROM payment_entity WHERE transaction_id='%s'", transactionId);
            QueryRunner runner = new QueryRunner();
            try (
                    Connection conn = DriverManager.getConnection(getUrl(), USER, PASSWORD))
            {
                paymentEntity = runner.query(conn, getPaymentByTransaction, new BeanHandler<>(PaymentEntity.class));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return paymentEntity;
    }

    public CreditRequestEntity getCreditRequestEntity(String transactionId) {
        CreditRequestEntity creditRequestEntity = new CreditRequestEntity();
        try {
            String getPaymentByTransaction = String.format("SELECT * FROM payment_entity WHERE transaction_id='%s'", transactionId);
            QueryRunner runner = new QueryRunner();
            try (
                    Connection conn = DriverManager.getConnection(getUrl(), USER, PASSWORD))
            {
                creditRequestEntity = runner.query(conn, getPaymentByTransaction, new BeanHandler<>(CreditRequestEntity.class));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return creditRequestEntity;
    }

    public void clearTables() {
        clearOrderEntity();
        clearPaymentEntity();
        clearCreditRequestEntity();
    }

    private void clearOrderEntity() {
        try {
            String clearUserTable = "DELETE FROM order_entity";
            QueryRunner runner = new QueryRunner();

            try (
                    Connection conn = DriverManager.getConnection(getUrl(), USER, PASSWORD);
            ) {
                runner.update(conn, clearUserTable);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void clearPaymentEntity() {
        try {
            String clearUserTable = "DELETE FROM payment_entity";
            QueryRunner runner = new QueryRunner();

            try (
                    Connection conn = DriverManager.getConnection(getUrl(), USER, PASSWORD);
            ) {
                runner.update(conn, clearUserTable);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void clearCreditRequestEntity() {
        try {
            String clearUserTable = "DELETE FROM credit_request_entity";
            QueryRunner runner = new QueryRunner();

            try (
                    Connection conn = DriverManager.getConnection(getUrl(), USER, PASSWORD);
            ) {
                runner.update(conn, clearUserTable);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public abstract String getUrl();
}
