package ru.netology.diploma.db.interactions;

import ru.netology.diploma.db.DbInteractionDbUtils;

public class DbInteractionUtilsPostgre extends DbInteractionDbUtils {
    @Override
    public String getUrl() {
        return "jdbc:postgresql://localhost:5432/app";
    }
}
