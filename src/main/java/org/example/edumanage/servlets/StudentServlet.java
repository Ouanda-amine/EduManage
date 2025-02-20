package org.example.edumanage.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.edumanage.Dao.StudentDao;
import org.example.edumanage.bean.Student;

import java.io.IOException;

@WebServlet("/createStudent")

public class StudentServlet extends HttpServlet {
    private StudentDao stdao;

    public void init(){
        stdao = new StudentDao();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String prenom = request.getParameter("prenom");
        String email = request.getParameter("email");
        String dateNaissance = request.getParameter("dateNaissance");
        Student student = new Student(name, prenom, email, dateNaissance);
        stdao.CreateStudent(student);

    }
}
