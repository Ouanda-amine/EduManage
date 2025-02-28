package org.example.edumanage.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.edumanage.Dao.UserDao;
import org.example.edumanage.bean.User;

import java.io.IOException;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private UserDao userDao;
    public void init() {userDao = new UserDao();}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = userDao.getUser(username, password);

        if (user != null) {

            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            response.sendRedirect(request.getContextPath() + "/Home.jsp");
        } else {
            request.setAttribute("errorMessage", "Nom d'utilisateur ou mot de passe invalide.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
