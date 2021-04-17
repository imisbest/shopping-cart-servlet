package com.csw.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class QChange extends HttpServlet {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String productName = request.getParameter("productName");
        String pricesString = request.getParameter("price");
        Double price = Double.parseDouble(pricesString);
        String optstr = request.getParameter("opt");
        Integer opt = Integer.parseInt(optstr);
        HttpSession session = request.getSession();
        session.setAttribute("productName", productName);
        session.setAttribute("price", price);
        session.setAttribute("opt", opt);
        request.getRequestDispatcher("/a/QFirstPageAction").forward(request,
                response);
    }
}
