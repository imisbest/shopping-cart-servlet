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

public class QCurrentPageAction extends HttpServlet {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer countPage = (Integer) session.getAttribute("countPage");

        String productName = (String) session.getAttribute("productName");
        Double price = (Double) session.getAttribute("price");
        Integer opt = (Integer) session.getAttribute("opt");
        System.out.println("\nQCurrentPageAction-productname=" + productName + "\nQCurrentPageAction-price=" + price
                + "\nQCurrentPageAction-opt=" + opt);
        String currPageInteger = request.getParameter("currPage");
        Integer currPage = Integer.parseInt(currPageInteger);
        System.out.println("\nQCurrentPageAction-CurrentPageInteger=" + currPageInteger);
        System.out.println("\nQCurrentPageAction-CurrPage=" + currPage);

        ProductService ps = new ProductServiceImpl();
        List<Product> list = ps.queryPersonByArrayLike(currPage, 3,
                productName, price, opt, countPage);
        System.out.println("\nQCurrentPageAction-list=" + list);

        request.setAttribute("list", list);
        request.setAttribute("currPage", currPage);
        request.getRequestDispatcher("/QueryProductView.jsp").forward(request,
                response);

    }

}
