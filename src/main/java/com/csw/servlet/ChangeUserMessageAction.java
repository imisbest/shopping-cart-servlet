package com.csw.servlet;

import com.csw.entity.User;
import com.csw.service.UserService;
import com.csw.service.UserServiceImpl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ChangeUserMessageAction extends HttpServlet {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        String password = (String) session.getAttribute("password");

        String name = request.getParameter("name");

        String zipz = request.getParameter("zip");
        Integer zip = Integer.parseInt(zipz);

        String address = request.getParameter("address");

        UserService userService = new UserServiceImpl();

        User uu = new User(username, password, name, zip, address);
        userService.updateBy(uu);
        System.out.println("{{ChangeUserMessageAction uu}}=" + uu);
        response.sendRedirect(request.getContextPath()
                + "/ChangeUserMessageSuccess.jsp");

    }

}
