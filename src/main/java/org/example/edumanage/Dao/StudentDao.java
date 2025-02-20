package org.example.edumanage.Dao;

import org.example.edumanage.bean.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class StudentDao {
    private Connection conn;

    public StudentDao() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","");
            System.out.println("Connected to the database successfully");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to connect to database");;
        }
    }
    public void CreateStudent(Student student) {
        String sql = "insert into students(name , prenom , email , dateNaissance) values(?,?,?,?)";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)){
            preparedStatement.setString(1,student.getName());
            preparedStatement.setString(2,student.getPrenom());
            preparedStatement.setString(3,student.getEmail());
            preparedStatement.setString(4,student.getDateNaissance());
            preparedStatement.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}
