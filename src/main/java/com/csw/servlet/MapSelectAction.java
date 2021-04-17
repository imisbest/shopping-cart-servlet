package com.csw.servlet;

import com.csw.entity.Product;
import com.csw.service.ProductService;
import com.csw.service.ProductServiceImpl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.rmi.ServerException;
import java.util.Map;
import java.util.Set;

public class MapSelectAction extends HttpServlet {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServerException, IOException {
        System.out.println(" \nMapSelectAction ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        HttpSession session = request.getSession();

        Map<Product, Integer> mapEnd = (Map<Product, Integer>) session
                .getAttribute("mapEnd");
        Set<Product> set3 = mapEnd.keySet();

        for (Product x : set3) {
            System.out.println("\nMapSelectAction-mapEnd1=" + x + "\n" + mapEnd.get(x));
        }
        String idstr = request.getParameter("nameid");
        Integer id = Integer.parseInt(idstr);

        ProductService ps = new ProductServiceImpl();
        Product pro = ps.getProductById(id);

        boolean flag = true;

        for (Product x : set3) {
            if (x.equals(pro)) {
                flag = false;
            }

        }
        if (flag) {
            mapEnd.put(pro, 1);
        } else {

            mapEnd.put(pro, mapEnd.get(pro) + 1);
        }

        for (Product x : set3) {
            System.out.println("\nMapSelectAction-mapEnd2=" + x + "\n" + mapEnd.get(x));
        }

        Map<Product, Integer> map = (Map<Product, Integer>) session
                .getAttribute("map");
        Set<Product> set1 = map.keySet();
        for (Product p : set1) {
            System.out.println("\nMapSelectAction-map1=" + p + "\n" + map.get(p));
        }

        map = mapEnd;
        for (Product p : set1) {
            System.out.println("\nMapSelectAction-map2=" + p);
        }
        session.setAttribute("mapEnd", mapEnd);
        session.setAttribute("map", map);
        response.sendRedirect(request.getContextPath() + "/AddCarSuccess.jsp");
    }
}
