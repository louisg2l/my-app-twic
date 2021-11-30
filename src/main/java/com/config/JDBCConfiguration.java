package com.config;

import java.sql.SQLException;
import java.sql.DriverManager;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import java.sql.Connection;

public class JDBCConfiguration
{
    private Connection co;
    private Logger logger;
    
    public JDBCConfiguration() {
        this.logger = LoggerFactory.getLogger((Class)JDBCConfiguration.class);
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            this.logger.error("La classe Driver n'existe pas.", (Throwable)e);
        }
        try {
            final String user = Configuration.getString("user");
            final String mdp = Configuration.getString("mdp");
            this.co = DriverManager.getConnection("jdbc:mysql://localhost/Projet_Maven?user=" + user + "&password=" + mdp);
        }
        catch (SQLException e2) {
            this.logger.error("Impossible de se connecter \u00e0 la base de donn\u00e9es.", (Throwable)e2);
        }
    }
    
    public Connection getCo() {
        return this.co;
    }
}