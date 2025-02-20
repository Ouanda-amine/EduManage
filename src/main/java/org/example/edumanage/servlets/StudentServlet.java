package org.example.edumanage.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.edumanage.Dao.StudentDao;
import org.example.edumanage.bean.Cours;
import org.example.edumanage.bean.Student;

import java.io.IOException;
import java.util.List;

@WebServlet("/StudentServlet")

public class StudentServlet extends HttpServlet {
    private StudentDao stdao;

    public void init(){
        stdao = new StudentDao();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if("edit".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            Student student = stdao.getStudBYid(id);
            request.setAttribute("student", student);
            request.getRequestDispatcher("modifierStudent.jsp").forward(request, response);

        } else if ("delete".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            stdao.deleteStudent(id);
            response.sendRedirect(request.getContextPath() + "/StudentServlet");


        } else{

            List<Student> studentList = stdao.getallStudents();
            request.setAttribute("studentlist", studentList);
            request.getRequestDispatcher("ListStudent.jsp").forward(request, response);
        }





    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if("update".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            String nom = request.getParameter("nom");
            String prenom = request.getParameter("prenom");
            String email = request.getParameter("email");
            String datenaissance = request.getParameter("dateNaissance");



            Student student = new Student(nom, prenom, email, datenaissance);
            student.setId(id);
            stdao.modifierstudent(student);

        }else  {
            String nom = request.getParameter("nom");
            String prenom = request.getParameter("prenom");
            String email = request.getParameter("email");
            String datenaissance = request.getParameter("dateNaissance");

            Student student = new Student(nom, prenom, email, datenaissance);
            stdao.CreateStudent(student);

        }


        response.sendRedirect(request.getContextPath() + "/StudentServlet");
    }
}
