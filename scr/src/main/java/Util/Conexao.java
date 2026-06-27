package Util;

import java.sql.*;

public class Conexao {
    private static final String URL = "jdbc:postgresql://localhost:5432/cenario2";
    private static final String USER = "postgres";
    private static final String PASSWORD = "root";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
