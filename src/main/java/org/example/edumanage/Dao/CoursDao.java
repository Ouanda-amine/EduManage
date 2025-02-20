package org.example.edumanage.Dao;

import org.example.edumanage.bean.Cours;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CoursDao {
    private Connection con ;
    public CoursDao() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/Management","root","");
            System.out.println("Connected to the database successfully");


        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to connect to database");
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

    public List<Cours> getallCourses() {
        List<Cours> coursList = new ArrayList<>();
        String sql="SELECT * FROM courses";
        try(Statement stmt = con.createStatement(); ResultSet res = stmt.executeQuery(sql)) {
            System.out.println("sssssssss");
            while (res.next()) {
                Cours cours = new Cours();
                cours.setIdcours(res.getInt("id_cours"));
                cours.setCoursname(res.getString("nom_cours"));
                cours.setDescription(res.getString("description"));

                coursList.add(cours);
            }

        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("aaaaaa");
        }
        return coursList;

    }
    public Cours getECoursById(int id) {
        Cours cours = null;
        String sql="SELECT * FROM courses WHERE id_cours = ?";
        try(PreparedStatement prest = con.prepareStatement(sql)) {
            prest.setInt(1, id);
            try (ResultSet res = prest.executeQuery()){
                if (res.next()) {
                    cours = new Cours();
                    cours.setIdcours(res.getInt("id_cours"));
                    cours.setCoursname(res.getString("nom_cours"));
                    cours.setDescription(res.getString("description"));

                }

            }
            System.out.println("sffffff");

        }catch (Exception e) {
            System.out.println("cours not found");
        }
        return cours;
    }

    public void modifiercours(Cours cours) {
        System.out.println("ccccc");
        String query = "UPDATE courses SET nom_cours = ?, description = ? WHERE id_cours = ?";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, cours.getCoursname());
            stmt.setString(2, cours.getDescription());
            stmt.setInt(3, cours.getIdcours());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("coursss n f ");
        }
    }

    public  void deleteCours(int id) {
        String sql = "DELETE FROM courses WHERE id_cours = ?";
        try (PreparedStatement pres = con.prepareStatement(sql)){
            pres.setInt(1,id);
            pres.executeUpdate();

        } catch (SQLException e) {
            System.out.println("cours not founddd");
        }
    }






}
