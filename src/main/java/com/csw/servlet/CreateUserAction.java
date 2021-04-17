package com.csw.servlet;

import com.csw.entity.User;
import com.csw.service.UserService;
import com.csw.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateUserAction extends HttpServlet {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String pass1 = request.getParameter("pass1");
        String pass2 = request.getParameter("pass2");
        String name = request.getParameter("name");
        String zipz = request.getParameter("zip");
        Integer zip = Integer.parseInt(zipz);
        String address = request.getParameter("address");

        UserService userService = new UserServiceImpl();
        if (pass1.equals(pass2)) {
            User uu = new User(username, pass1, name, zip, address);
            userService.addUsers(uu);

            response.sendRedirect(request.getContextPath() + "/LoginView.jsp");
        } else {

            response.sendRedirect(request.getContextPath()
                    + "/CreateUserView.jsp?erroMessage=regist fail");
        }

    }

}