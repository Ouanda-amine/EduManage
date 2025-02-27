package org.example.edumanage.Dao;

import org.example.edumanage.bean.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {

    private Connection connn;

    public UserDao() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connn= DriverManager.getConnection("jdbc:mysql://localhost:3306/Management","root","");
            System.out.println("Connected to the database successfully");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to connect to database");
        }


    }
    public User getUser(String username  , String password) {
        User user = null;
        String sql = "select * from acces where username=? and password=?";
        try (PreparedStatement pes = connn.prepareStatement(sql)){
            pes.setString(1, username);
            pes.setString(2, password);

            try (ResultSet rs = pes.executeQuery()){
                if (rs.next()){
                    user.setId(rs.getInt("idAdmin"));
                    user.setName(rs.getString("nomadmine"));
                    user.setPassword(rs.getString("password"));
                    user.setUsername(rs.getString("username"));
                    user.setRole(rs.getString("role"));
                }

            }

        }catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
