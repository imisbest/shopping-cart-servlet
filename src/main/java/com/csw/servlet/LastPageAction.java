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

public class LastPageAction extends HttpServlet {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Integer countPage = (Integer) session.getAttribute("countPage");
        // Integer countPage = Integer.parseInt(count);
        System.out.println("\\firstPage countPage//" + countPage);

        ProductService ps = new ProductServiceImpl();
        List<Product> list = ps.queryPersonByArray(countPage, 2, countPage);// /
        System.out.println(" CurrentPageAction list//" + list);


        // request.setAttribute("countPage", countPage);
        String judge = "judge";
        request.setAttribute("judge", judge);
        request.setAttribute("list", list);
        request.setAttribute("currPage", countPage);
        request.getRequestDispatcher("/QueryProductView.jsp").forward(request, response);

    }

}
