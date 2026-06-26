package org.trabalho.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    public static final String URL = "jdbc:postgresql://localhost:5432/cenario3_database";
    public static final String USER = "postgres";
    public static final String PASSWORD = "postgres";


    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao conectar no banco", e);
        }
    }

}
