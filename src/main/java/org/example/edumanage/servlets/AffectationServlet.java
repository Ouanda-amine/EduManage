package org.example.edumanage.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.edumanage.Dao.AffectationDao;
import org.example.edumanage.Dao.CoursDao;
import org.example.edumanage.Dao.StudentDao;
import org.example.edumanage.bean.Cours;
import org.example.edumanage.bean.Student;

import java.io.IOException;
import java.util.List;

@WebServlet("/affectationServlet")

public class AffectationServlet extends HttpServlet {
    private StudentDao stdao;
    private CoursDao cdao;
    private AffectationDao affectationDao;

    public void init(){
        stdao = new StudentDao();
        cdao = new CoursDao();
        affectationDao = new AffectationDao();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String act = request.getParameter("act");
        if("affectation".equals(act)){
            int id = Integer.parseInt(request.getParameter("id"));
            AffectationDao affectationDao = new AffectationDao();
            List<Cours> courslist = affectationDao.getCoursesByStudentId(id);
            request.setAttribute("courslist", courslist);
            request.getRequestDispatcher("CoursOFstudent.jsp").forward(request, response);
        }else{

        int id = Integer.parseInt(request.getParameter("id"));
        Student student = stdao.getStudBYid(id);
        request.setAttribute("student", student);

        List<Cours> coursList = cdao.getallCourses();
        request.setAttribute("courslist", coursList);
        request.getRequestDispatcher("Assigner.jsp").forward(request, response);

        }


    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("////////////////////////");

        int studentId = Integer.parseInt(request.getParameter("studdiid"));
        int courseId = Integer.parseInt(request.getParameter("select"));

        affectationDao.assignCourseToStudent(studentId, courseId);
        response.sendRedirect(request.getContextPath() + "/StudentServlet");














    }
}
