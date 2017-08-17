package com.hand.Dao;

import com.hand.Entity.Customer;
import com.hand.Entity.Film;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by LiuSijia on 2017/8/15.
 */
public interface Dao {
    public ResultSet findUserByName(Connection connection, Customer customer)throws SQLException;

    public List<Film> findAll(Connection connection) throws SQLException;

    public void delete(Connection connection, Film film)throws SQLException;

    public void add(Connection connection, Film film)throws SQLException;

    public void update(Connection connection, Film film)throws SQLException;

    public List<Film> findOneById(Connection connection, int id)throws SQLException;

    public List<Film> findLanguage(Connection connection)throws SQLException;
}
