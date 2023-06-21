package org.cars.util;

import org.postgresql.ds.PGPoolingDataSource;

import java.sql.*;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCService {
    //Параметры подключения
    private PGPoolingDataSource ds;
    private Connection connection;
    private Statement statement;
    private ResultSet rs;

    /**
     *Метод : авто коннект
     */
    public String fullLifeConnect(String query) {
        getConnect();
        jdbcQuery(query);
        conClose();
        return "Метод fullGetConnect завершил себя!";
    }

    public String getConnect() {
        try {
            statement = getConnectionTo().createStatement();
            return "Подключение произведено!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * Метод  Connection getConnection() - возвращает условно параметризованный getConnection!
     */
    public Connection getConnectionTo() throws SQLException {
        ds = new PGPoolingDataSource();
        ds.setServerName("localhost");
        ds.setDatabaseName("postgres");
        ds.setUser("postgres");
        ds.setPassword("password");
        ds.setMaxConnections(100);
        ds.setInitialConnections(20);
        return ds.getConnection();
    }

    public void jdbcQuery(String query) {
        try {
          statement.execute(query);
            System.out.println("Запрос : " + query);
            System.out.println("Запрос выполнен!");
        } catch (SQLException | NullPointerException e) {
            System.out.println(e.getMessage());
            System.out.println("Запрос не выполнен!");
        }
    }

    public void conClose() {
        try {
            if (!ds.getConnection().isClosed()) {
                ds.getConnection().close();
                System.out.println("Подключение приостановлено!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ResultSet getRs() {
        return rs;
    }
}