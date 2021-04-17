package com.csw.servlet;

import com.csw.entity.Product;
import com.csw.service.ProductService;
import com.csw.service.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class FirstPageAction extends HttpServlet {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ProductService ps = new ProductServiceImpl();
        Integer countPage = ps.countPageAction();
        System.out.println("\\firstPage countPage//" + countPage);
        List<Product> list = ps.queryPersonByArray(1, 2, countPage);
        System.out.println("\\firstPage//" + list);

        HttpSession session = request.getSession();
        session.setAttribute("countPage", countPage);
        String judge = "judge";
        request.setAttribute("judge", judge);
        request.setAttribute("list", list);
        request.setAttribute("currPage", 1);
        request.getRequestDispatcher("/QueryProductView.jsp").forward(request, response);

    }

}