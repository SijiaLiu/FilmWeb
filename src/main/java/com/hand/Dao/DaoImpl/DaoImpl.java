package com.hand.Dao.DaoImpl;

import com.hand.Dao.Dao;
import com.hand.Entity.Customer;
import com.hand.Entity.Film;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by LiuSijia on 2017/8/15.
 */
@Component
public class DaoImpl implements Dao{

    public ResultSet findUserByName(Connection connection, Customer customer) throws SQLException {

        PreparedStatement ps = connection.prepareStatement("SELECT * FROM customer WHERE first_name = ? ");
        ps.setString(1, customer.getFirst_name());
        return ps.executeQuery();
    }

    public List<Film> findAll(Connection connection) throws SQLException{
        List<Film> list = new ArrayList<Film>();
        String sql = "SELECT film_id,title,description,name FROM film,language WHERE film.language_id = language.language_id ORDER By film_id";
        ResultSet rs = connection.prepareStatement(sql).executeQuery();
        while (rs.next()){
            Film film = new Film();
            film.setFilm_id(rs.getInt("film_id"));
            film.setTitle(rs.getString("title"));
            film.setDescription(rs.getString("description"));
            film.setLanguage(rs.getString("name"));
            list.add(film);
        }
        return list;
    }

    @Override
    public void delete(Connection connection, Film film) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("DELETE FROM film WHERE film_id = ?");
        ps.setInt(1, film.getFilm_id());
        ps.execute();
    }

    @Override
    public void add(Connection connection, Film film) throws SQLException {
        String sql = "INSERT INTO film (title, description, language_id) VALUES(?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, film.getTitle());
        ps.setString(2, film.getDescription());
        ps.setInt(3, film.getLanguage_id());
        ps.execute();
    }

    @Override
    public void update(Connection connection, Film film) throws SQLException {

        String sql = "UPDATE film set title = ?, description = ?, language_id = ? WHERE film_id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, film.getTitle());
        ps.setString(2, film.getDescription());
        ps.setInt(3, film.getLanguage_id());
        ps.setInt(4, film.getFilm_id());
        ps.executeUpdate();
    }

    @Override
    public List<Film> findOneById(Connection connection, int id) throws SQLException {
        List<Film> list = new ArrayList<>();
        String sql = "SELECT title,description,LANGUAGE_id FROM film WHERE film_id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            Film film = new Film();
            film.setFilm_id(id);
            film.setTitle(rs.getString("title"));
            film.setDescription(rs.getString("description"));
            film.setLanguage_id(rs.getInt("LANGUAGE_id"));
            list.add(film);
        }
        return list;
    }

    @Override
    public List<Film> findLanguage(Connection connection) throws SQLException {
        List<Film> list = new ArrayList<>();
        String sql = "SELECT language_id, name from language";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            Film film = new Film();
            film.setLanguage_id(rs.getInt("language_id"));
            film.setLanguage(rs.getString("name"));
            list.add(film);
        }
        return list;
    }
}
