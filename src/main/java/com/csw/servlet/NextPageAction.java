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

public class NextPageAction extends HttpServlet {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer countPage = (Integer) session.getAttribute("countPage");
        String currPageInteger = request.getParameter("currPage");
        Integer currPage = Integer.parseInt(currPageInteger);
        System.out.println("\\next currPage//" + currPage);

        ProductService ps = new ProductServiceImpl();
        List<Product> list = ps.queryPersonByArray(currPage, 2, countPage);

        System.out.println(" CurrentPageAction list//" + list);

//		Integer countPage = ps.countPageAction();
//		System.out.println("\\firstPage countPage//" + countPage);
//		request.setAttribute("countPage", countPage);
        String judge = "judge";
        request.setAttribute("judge", judge);
        request.setAttribute("list", list);
        request.setAttribute("currPage", currPage);
        request.getRequestDispatcher("/QueryProductView.jsp").forward(request, response);

    }

}