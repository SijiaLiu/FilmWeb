package com.hand.Service;

import com.hand.Dao.Dao;
import com.hand.Entity.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by LiuSijia on 2017/8/15.
 */
@Service("updateService")
public class UpdateService {
    @Autowired
    private Dao dao;

    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;

    public void Update(Film film){
        Connection connection = null;
        //connection = ConnectionFactory.getInstance().makeConnection();

        try {
            connection = dataSource.getConnection();
            dao.update(connection, film);

        } catch (SQLException e) {
            e.printStackTrace();
            try {
                System.out.println("三事务回调");
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
    }
}
