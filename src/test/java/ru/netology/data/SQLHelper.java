package ru.netology.data;

import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLHelper {

    private static final String DBSQLUrl = System.getProperty("datasource.url");
    private static final String username = System.getProperty("username");
    private static final String password = System.getProperty("password");

    private static QueryRunner runner = new QueryRunner();


    private static Connection getConnMySql() throws SQLException {
        return DriverManager.getConnection(DBSQLUrl, username, password);
    }


    @SneakyThrows
    public static String getLastPayUserStatusMySQL() {
        Thread.sleep(10000);
        var conn = getConnMySql();
        var payStatus = "SELECT status FROM payment_entity order by created desc LIMIT 1";
        var result = runner.query(conn, payStatus, new ScalarHandler<String>());
        return result;

    }
}