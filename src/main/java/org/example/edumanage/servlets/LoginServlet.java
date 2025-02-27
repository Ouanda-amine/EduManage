package org.example.edumanage.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.edumanage.Dao.UserDao;
import org.example.edumanage.bean.User;

import java.io.IOException;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private UserDao userDao;
    public void init() {userDao = new UserDao();}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.sendRedirect("login.jsp");
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        User user=userDao.getUser(username,password);
        if(user!=null){
            request.setAttribute("user",user);
            request.getRequestDispatcher("Home.jsp").forward(request,response);
        }
        else{
            response.sendRedirect("login.jsp");
        }

    }
}
