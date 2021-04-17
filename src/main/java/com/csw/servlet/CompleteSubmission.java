package com.csw.servlet;

import com.csw.entity.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class CompleteSubmission extends HttpServlet {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        System.out
                .println(" \nCompleteSubmission ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        HttpSession session = request.getSession();
        Map<Product, Integer> mapEnd = (Map<Product, Integer>) session
                .getAttribute("mapEnd");
        Set<Product> set3 = mapEnd.keySet();

        for (Product x : set3) {
            System.out.println("\nMapSelectAction-mapEnd1=" + x + "\n" + mapEnd.get(x));
        }


        for (Product p : set3) {
            System.out.println("\nCompleteSubmission-mapEnd1=" + p + "\n" + mapEnd.get(p));
        }
//		Map<Product, Integer> map = (Map<Product, Integer>) session
//				.getAttribute("map");
//		Set<Product> set1 = map.keySet();
//		for (Product p : set1) {
//			System.out.println("\nCompleteSubmission-map1=" + p+"\n"+map.get(p));
//		}
        Map<Product, Integer> mapSub = (Map<Product, Integer>) session.getAttribute("mapSub");
        Set<Product> set2 = mapSub.keySet();
        for (Product p : set2) {

            System.out.println("\nCompleteSubmission-mapSub0=" + p);

        }

        mapEnd = mapSub;
        for (Product p : set3) {
            System.out.println("\nCompleteSubmission-mapEnd2=" + p + "\n" + mapEnd.get(p));
        }

//		map = mapEnd;
//		for (Product p : set1) {
//			System.out.println("\nCompleteSubmission-map2=" + p+"\n"+map.get(p));
//		}
        session.setAttribute("mapEnd", mapEnd);

        request.getRequestDispatcher("/ShopCarView.jsp").forward(request,
                response);
    }

}