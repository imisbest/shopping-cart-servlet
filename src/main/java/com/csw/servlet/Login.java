package com.csw.servlet;

import com.csw.entity.Product;
import com.csw.entity.User;
import com.csw.service.UserService;
import com.csw.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Login extends HttpServlet {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserService userService = new UserServiceImpl();

        User acc = userService.queryBy(username, password);
        if (acc != null) {
            HttpSession session = request.getSession();
            Map<Product, Integer> map = new HashMap<Product, Integer>();
            Map<Product, Integer> mapSub = new HashMap<Product, Integer>();
            Map<Product, Integer> mapEnd = new HashMap<Product, Integer>();
            session.setAttribute("map", map);
            session.setAttribute("mapSub", mapSub);
            session.setAttribute("mapEnd", mapEnd);
            session.setAttribute("acc", acc);
            session.setAttribute("username", username);
            session.setAttribute("password", password);
            request.setAttribute("username", username);
            request.getRequestDispatcher("/a/FirstPageAction").forward(request,
                    response);
        } else {
            response.sendRedirect(request.getContextPath()
                    + "/LoginView.jsp?erroMessage=password or username error");
        }
    }

}
