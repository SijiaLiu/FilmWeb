package com.hand.Service;

import com.hand.Dao.Dao;
import com.hand.Entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by LiuSijia on 2017/8/15.
 */
@Service("loginService")
public class LoginService {
    @Autowired
    private Dao dao;

    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;

    private static ThreadLocal<Connection>
            connections=new ThreadLocal<>();

    public boolean checkUser(Customer customer){
        Connection connection = null;
        try {
            //ConnectionFactory cf = ConnectionFactory.getInstance();

            //connection = cf.makeConnection();
            connection = dataSource.getConnection();
            //connections.set(connection);

            ResultSet rs = dao.findUserByName(connection, customer);
            while (rs.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();

            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }finally {
                try {
                    connection.close();
                } catch (SQLException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return false;
    }
}
