package org.example.edumanage.Dao;

import org.example.edumanage.bean.Cours;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AffectationDao {

    private Connection connexion;

    public AffectationDao() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connexion= DriverManager.getConnection("jdbc:mysql://localhost:3306/Management","root","");
            System.out.println("Connected to the database successfully");

        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to connect to database");
        }
    }
    public void assignCourseToStudent(int studentId, int courseId) {
        String sql = "INSERT INTO students_courses (idStudent, id_cours) VALUES (?, ?)";
        try (PreparedStatement pr = connexion.prepareStatement(sql)) {
            pr.setInt(1, studentId);
            pr.setInt(2, courseId);
            pr.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed ");
        }
    }

    public List<Cours> getCoursesByStudentId(int studentId) {
        List<Cours> coursList = new ArrayList<>();
        String sql = "SELECT c.id_cours, c.nom_cours, c.description " +
                "FROM courses c " +
                "JOIN students_courses sc ON c.id_cours = sc.id_cours " +
                "WHERE sc.idStudent = ?";

        try (PreparedStatement pr = connexion.prepareStatement(sql)) {
            pr.setInt(1, studentId);

            try (ResultSet rs = pr.executeQuery()) {
                while (rs.next()) {
                    int idCours = rs.getInt("id_cours");
                    String nomCours = rs.getString("nom_cours");
                    String description = rs.getString("description");

                    Cours cours = new Cours(idCours, nomCours, description);
                    coursList.add(cours);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to get courses by student ID");
        }
        return coursList;
    }

}
