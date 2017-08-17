package com.hand.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by LiuSijia on 2017/8/10.
 */
public class ConnectionFactory {

    private static final ConnectionFactory connectionFactory = new ConnectionFactory();

    private Connection connection;

    private static String driver;
    private static String dburl;
    private static String user;
    private static String password;

    static {
        Properties prop = new Properties();
        try {
        InputStream is = ConnectionFactory.class.getClassLoader()
                    .getResourceAsStream("dbconfig.properties");
//            ClassLoader classLoader = ConnectionFactory.class.getClassLoader();
//            InputStream resourceAsStream = classLoader.getResourceAsStream("dbconfig.properties");
//
            prop.load(is);

        } catch (IOException e) {
            System.out.println("配置文件有错");
        }
        driver = prop.getProperty("driver");
        dburl = prop.getProperty("dburl");
        user = prop.getProperty("user");
        password = prop.getProperty("password");
    }

    private ConnectionFactory(){
    }

    public static ConnectionFactory getInstance(){
        return connectionFactory;
    }

    public Connection makeConnection(){
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(dburl,user,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

}
