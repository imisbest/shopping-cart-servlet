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

public class QPreviousPageAction extends HttpServlet {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer countPage = (Integer) session.getAttribute("countPage");

        String productName = (String) session.getAttribute("productName");
        Double price = (Double) session.getAttribute("price");
        Integer opt = (Integer) session.getAttribute("opt");
        System.out.println("\nQPreviousPageActio-productname=" + productName + "\nQPreviousPageActio-price=" + price + "\nQPreviousPageActio-opt=" + opt);
        String currPageInteger = request.getParameter("currPage");
        Integer currPage = Integer.parseInt(currPageInteger);

        ProductService ps = new ProductServiceImpl();

        List<Product> list = ps.queryPersonByArrayLike(currPage, 3, productName, price, opt, countPage);
        System.out.println("\nQPreviousPageActio-list=" + list);

//		Integer countPage = ps.countPageAction();
//		System.out.println("\\firstPage countPage//" + countPage);
        //request.setAttribute("countPage", countPage);
        request.setAttribute("list", list);
        request.setAttribute("currPage", currPage);
        request.getRequestDispatcher("/QueryProductView.jsp").forward(request, response);

    }

}
