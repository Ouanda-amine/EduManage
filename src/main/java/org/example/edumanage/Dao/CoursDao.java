package org.example.edumanage.Dao;

import org.example.edumanage.bean.Cours;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CoursDao {
    private Connection con ;
    public CoursDao() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/courses","root","");
            System.out.println("Connected to the database successfully");


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public  void CreateCours(Cours cours) {
        String sql = "insert into courses (nom_cours, description) values (?,?)";
        try (PreparedStatement pr = con.prepareStatement(sql)){
            pr.setString(1,cours.getCoursname());
            pr.setString(2,cours.getDescription());
            pr.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
