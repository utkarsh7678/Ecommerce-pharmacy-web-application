<%@page import="com.mycompany.getpharma.helper.FactoryProvider"%>
<%@page import="com.mycompany.getpharma.entites.product"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Session"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>GETPHARMA - Your Health, Delivered</title>
        <%@include file="componenets/common_css_js.jsp"%>
    </head>
    <body>
        <%@include file="componenets/navbar.jsp" %>
        
        <div class="container-fluid">
            <div class="row mt-3 mx-2">
                <div class="col-md-12">
                    <div class="card-columns">
                        <%
                            Session s = FactoryProvider.getFactory().openSession();
                            List<product> list = s.createQuery("from product").list();
                            
                            for(product p : list) {
                        %>
                        <div class="card product-card">
                            <div class="container text-center">
                                <img src="image/products/<%=p.getpPhoto()%>" style="max-height: 200px; max-width: 100%; width: auto;" class="card-img-top m-2" alt="...">
                            </div>
                            <div class="card-body">
                                <h5 class="card-title"><%=p.getpName()%></h5>
                                <p class="card-text"><%=p.getpDesc()%></p>
                                <div class="card-footer text-center">
                                    <button class="btn custom-bg text-white" onclick="add_to_cart(<%=p.getPId()%>, '<%=p.getpName()%>', <%=p.getpPrice()%>)">Add to Cart</button>
                                    <button class="btn btn-outline-success">₹ <%=p.getpPrice()%>/- <span class="text-secondary discount-label"><%=p.getpDiscount()%>% off</span></button>
                                </div>
                            </div>
                        </div>
                        <%
                            }
                            s.close();
                        %>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>