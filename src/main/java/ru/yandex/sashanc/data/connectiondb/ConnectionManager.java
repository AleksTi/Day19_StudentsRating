package ru.yandex.sashanc.data.connectiondb;

import java.sql.Connection;

public interface ConnectionManager {
    public Connection getConnection();
}
