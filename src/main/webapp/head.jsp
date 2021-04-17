<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    request.setAttribute("path", request.getContextPath());
%>
<!DOCTYPE html>
<html>
<head>

</head>
<body>

<!-- Title -->
<img src="${path}/image/zgc_px.jpg" align="middle" class="f" alt=""/>
<span>欢迎访问我的购物网站</span>
<hr/>
<a href="${path}/SafeOut"><input type="button" value="安全退出"></a>
<%
    String username = (String) session.getAttribute("username");
%>

<%
    System.out.println("username" + username);
%>
<div class="c2">
    欢迎<%=username%>
</div>

<!--  Menu Bar  -->
<center>
    <div class="d">
        <a href="${path}/a/FirstPageAction"><img
                src="${path}/image/index.gif"/></a> <a
            href="${path}/UserManageView.jsp"><img
            src="${path}/image/reg.gif"/></a> <a href="${path}/ShopCarView.jsp"><img
            src="${path}/image/cart.gif"/></a> <a href=""><img
            src="${path}/image/order.gif"/></a> <a href="${path}/LoginView.jsp"><img
            src="${path}/image/exit.gif"/></a>
    </div>
</center>


</body>
</html>