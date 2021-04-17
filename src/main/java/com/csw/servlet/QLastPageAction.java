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

public class QLastPageAction extends HttpServlet {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String productName = (String) session.getAttribute("productName");
        Double price = (Double) session.getAttribute("price");
        Integer opt = (Integer) session.getAttribute("opt");
        System.out.println("\nQLastPageAction-productname=" + productName + "\nQLastPageAction-price=" + price + "\nQLastPageAction-opt=" + opt);
        Integer countPage = (Integer) session.getAttribute("countPage");
        // Integer countPage = Integer.parseInt(count);
        System.out.println("\nQLastPageAction-countPage=" + countPage);

        ProductService ps = new ProductServiceImpl();
        List<Product> list = ps.queryPersonByArrayLike(countPage, 3, productName, price, opt, countPage);// /
        System.out.println("\nQLastPageAction-list=" + list);


        // request.setAttribute("countPage", countPage);

        request.setAttribute("list", list);
        request.setAttribute("currPage", countPage);
        request.getRequestDispatcher("/QueryProductView.jsp").forward(request, response);

    }

}
