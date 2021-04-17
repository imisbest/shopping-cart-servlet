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
import java.util.Map;
import java.util.Set;

public class SubmitChangeAction extends HttpServlet {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        System.out.println(" \nSubmitChangeAction ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        HttpSession session = request.getSession();

        Map<Product, Integer> mapEnd = (Map<Product, Integer>) session
                .getAttribute("mapEnd");
        Set<Product> set3 = mapEnd.keySet();

        for (Product x : set3) {
            System.out.println("\n&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&mapEnd1=" + x + "\n" + mapEnd.get(x));
        }
        String[] ids = request.getParameterValues("ids");
        System.out.println("/nSubmitChangeAction-ids=" + ids);
        String[] number = request.getParameterValues("1");
        System.out.println("/nSubmitChangeAction-number=" + number);

        Map<Product, Integer> mapSub = (Map<Product, Integer>) session
                .getAttribute("mapSub");
        Set<Product> set2 = mapSub.keySet();
        for (Product p : set2) {
            System.out.println("\nSubmitChangeAction-mapSub1" + p + "\n" + mapSub.get(p));
        }

        ProductService ps = new ProductServiceImpl();
        Product product;


        mapSub.clear();
        for (int i = 0; i < ids.length; i++) {

            product = ps.getProductById(Integer.parseInt(ids[i]));
            mapSub.put(product, Integer.parseInt(number[i]));
        }


        for (Product p : set2) {
            System.out.println("\nSubmitChangeAction-mapSub2" + p + "\n" + mapSub.get(p));
        }
        Map<Product, Integer> map = (Map<Product, Integer>) session
                .getAttribute("map");
        Set<Product> set1 = map.keySet();
        for (Product p : set1) {
            System.out.println("\nSubmitChangeAction-map1" + p + "\n" + map.get(p));
        }


        map = mapSub;


        for (Product p : set1) {
            System.out.println("\nSubmitChangeAction-map2" + p + "\n" + map.get(p));
        }


        for (Product x : set3) {
            System.out.println("\n$$$$$$$$$$$$$$$$$$$$$$$$$$mapEnd1=" + x + "\n" + mapEnd.get(x));
        }
        session.setAttribute("mapSub", mapSub);
        session.setAttribute("map", map);
        request.getRequestDispatcher("/ShopCarView.jsp").forward(request,
                response);
    }

}
