package com.hand.Service;

import com.hand.Dao.Dao;
import com.hand.Entity.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by LiuSijia on 2017/8/15.
 */
@Service("findLanService")
public class FindLanService {
    @Autowired
    private Dao dao;

    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;

    List<Film> list = new ArrayList<Film>();

    public List<Film> findLan(){

        Connection connection = null;

        //connection = ConnectionFactory.getInstance().makeConnection();

        try {
            connection = dataSource.getConnection();
            list = dao.findLanguage(connection);

        } catch (SQLException e) {
            e.printStackTrace();
            try {
                System.out.println("五事务回调");
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
        return list;
    }
}