package org.example.edumanage.bean;

import java.util.List;

public class Cours {
    private int idcours;
    private String coursname;
    private String description;
    private List<Student> studentss;

    public Cours() {}
    public Cours( String coursname, String description) {
        this.coursname = coursname;
        this.description = description;
    }

    public Cours(int idCours, String nomCours, String description) {
        this.idcours = idCours;
        this.coursname = nomCours;
        this.description = description;
    }

    public int getIdcours() {
        return idcours;
    }

    public void setIdcours(int idcours) {
        this.idcours = idcours;
    }

    public String getCoursname() {
        return coursname;
    }

    public void setCoursname(String coursname) {
        this.coursname = coursname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
