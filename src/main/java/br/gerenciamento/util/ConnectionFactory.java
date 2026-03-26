package br.gerenciamento.util;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class ConnectionFactory {
    
    private static final Dotenv dotenv = Dotenv.load();
    
    private static final String URL = "jdbc:mysql://localhost:" 
            + dotenv.get("DB_PORT")
            + "/"
            + dotenv.get("DB_NAME");
    
    private static final String USER = dotenv.get("DB_USER");
    private static final String PASSWORD = dotenv.get("DB_PASSWORD");
    
    private ConnectionFactory(){}
    
    public static Connection getConnection() throws SQLException
    {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    
}
