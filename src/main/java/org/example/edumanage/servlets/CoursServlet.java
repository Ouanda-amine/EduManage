package org.example.edumanage.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.edumanage.Dao.CoursDao;
import org.example.edumanage.bean.Cours;

import java.io.IOException;
import java.util.List;

@WebServlet("/CoursServlet")
public class CoursServlet extends HttpServlet {
    private CoursDao coursDao = new CoursDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if("edit".equals(action)) {
            int id = Integer.parseInt(request.getParameter("idcours"));
            Cours cours = coursDao.getECoursById(id);
            request.setAttribute("cours", cours);
            request.getRequestDispatcher("modifierCours.jsp").forward(request, response);

        } else if ("delete".equals(action)) {
            int id = Integer.parseInt(request.getParameter("idcours"));
            coursDao.deleteCours(id);
            response.sendRedirect(request.getContextPath() + "/CoursServlet");


        } else{

        List<Cours> coursList = coursDao.getallCourses();
        request.setAttribute("courslist", coursList);
        request.getRequestDispatcher("CoursList.jsp").forward(request, response);
        }





    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if("update".equals(action)) {
            int id = Integer.parseInt(request.getParameter("idcours"));
            String nomCours = request.getParameter("nomcours");
            String description = request.getParameter("description");

            Cours cours = new Cours(nomCours, description);
            cours.setIdcours(id);
            coursDao.modifiercours(cours);

        }else  {
            String nomCours = request.getParameter("nomcours");
            String description = request.getParameter("description");


            Cours cours = new Cours(nomCours, description);
            coursDao.CreateCours(cours);

        }


        response.sendRedirect(request.getContextPath() + "/CoursServlet");
    }
}
