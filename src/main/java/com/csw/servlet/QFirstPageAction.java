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

public class QFirstPageAction extends HttpServlet {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String productName = (String) session.getAttribute("productName");
        Double price = (Double) session.getAttribute("price");
        Integer opt = (Integer) session.getAttribute("opt");
        System.out.println("\nQFirstPageAction-productname=" + productName
                + "\nQFirstPageAction-price=" + price
                + "\nQFirstPageAction-opt=" + opt);
        ProductService ps = new ProductServiceImpl();
        Integer countPage = ps.countPageLike(productName, price, opt);

        System.out.println("\nQFirstPageAction-fcountPage=" + countPage);
        List<Product> list = ps.queryPersonByArrayLike(1, 3, productName,
                price, opt, countPage);
        System.out.println("\nQFirstPageAction-list=" + list);

        session.setAttribute("countPage", countPage);

        request.setAttribute("list", list);
        request.setAttribute("currPage", 1);
        request.getRequestDispatcher("/QueryProductView.jsp").forward(request,
                response);

    }

}