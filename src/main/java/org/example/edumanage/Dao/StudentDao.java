package org.example.edumanage.Dao;

import org.example.edumanage.bean.Cours;
import org.example.edumanage.bean.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    private Connection conn;

    public StudentDao() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/Management","root","");
            System.out.println("Connected to the database successfully");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to connect to database");;
        }
    }
    public void CreateStudent(Student student) {
        String sql = "insert into students(nom , prenom , email , dateNaissance) values(?,?,?,?)";
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
    public List<Student> getallStudents() {
        List<Student> studentlist = new ArrayList<>();
        String sql="SELECT * FROM students";
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxx");
        try(Statement stmt = conn.createStatement(); ResultSet res = stmt.executeQuery(sql)) {
            System.out.println("ww");
            while (res.next()) {
                Student student = new Student();
                student.setId(res.getInt("idStudent"));
                student.setName(res.getString("nom"));
                student.setPrenom(res.getString("prenom"));
                student.setEmail(res.getString("email"));
                student.setDateNaissance(res.getString("dateNaissance"));

                studentlist.add(student);
            }

        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("qsqs");
        }
        return studentlist;

    }
    public Student getStudBYid(int id) {
        Student student = null;
        String sql="SELECT * FROM students WHERE idStudent = ?";
        try(PreparedStatement prest = conn.prepareStatement(sql)) {
            prest.setInt(1, id);
            try (ResultSet res = prest.executeQuery()){
                if (res.next()) {
                    student = new Student();
                    student.setId(res.getInt("idStudent"));
                    student.setName(res.getString("nom"));
                    student.setPrenom(res.getString("prenom"));
                    student.setEmail(res.getString("email"));
                    student.setDateNaissance(res.getString("dateNaissance"));


                }

            }
            System.out.println("sffffff");

        }catch (Exception e) {
            System.out.println("cours not found");
        }
        return student;
    }

    public void modifierstudent(Student student) {
        System.out.println("nnn");
        String query = "UPDATE students SET nom = ?, prenom = ? , email = ? , dateNaissance = ? WHERE idStudent = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, student.getName());
            stmt.setString(2, student.getPrenom());
            stmt.setString(3, student.getEmail());
            stmt.setString(4, student.getDateNaissance());
            stmt.setInt(5, student.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("stud n f ");
        }
    }

    public  void deleteStudent(int id) {
        String sql = "DELETE FROM students WHERE idStudent = ?";
        try (PreparedStatement pres = conn.prepareStatement(sql)){
            pres.setInt(1,id);
            pres.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("student not founddd");
        }
    }

}
