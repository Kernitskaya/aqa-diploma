package ru.netology.diploma.test;

import org.junit.jupiter.api.BeforeEach;
import ru.netology.diploma.db.DbInteractionDbUtils;

public abstract class DatabaseTest extends BaseTest {

    public static DbInteractionDbUtils dbInteractionDbUtils;

    @BeforeEach
    public void clearDB() {
        setUpUtils();
        dbInteractionDbUtils.clearTables();
    }

    public abstract void setUpUtils();
}
