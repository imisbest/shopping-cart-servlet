package com.csw.servlet;

import com.csw.entity.User;
import com.csw.service.UserService;
import com.csw.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ChangePasswordAction extends HttpServlet {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

        System.out.println("{{ ChangePasswordAction username}=" + username);
        String oldPass = request.getParameter("oldPass");
        String newPass1 = request.getParameter("newPass1");
        String newPass2 = request.getParameter("newPass2");

        UserService userService = new UserServiceImpl();
        User user = userService.queryBy(username, oldPass);
        if (newPass1.equals(newPass2) && user != null) {

            userService.changePassword(newPass1, username);
            session.setAttribute("password", newPass1);
            response.sendRedirect(request.getContextPath()
                    + "/ChangePasswordSuccess.jsp");
        } else {

            response.sendRedirect(request.getContextPath()
                    + "/ChangePasswordView.jsp?erroMessage=changePassword fail");
        }

    }
}
