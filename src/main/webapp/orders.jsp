<%@page import="com.mycompany.getpharma.helper.FactoryProvider"%>
<%@page import="com.mycompany.getpharma.entites.*"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.query.Query"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    User user = (User) session.getAttribute("current-user");
    if (user == null) {
        session.setAttribute("message", "You are not logged in!");
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Orders - Getpharm</title>
        <%@include file="componenets/common_css_js.jsp"%>
    </head>
    <body>
        <%@include file="componenets/navbar.jsp" %>
        
        <div class="container">
            <div class="row mt-5">
                <div class="col-md-12">
                    <div class="card">
                        <div class="card-body">
                            <h3 class="text-center mb-4">My Orders</h3>
                            
                            <table class="table table-bordered">
                                <thead>
                                    <tr>
                                        <th>Order ID</th>
                                        <th>Date</th>
                                        <th>Items</th>
                                        <th>Total Amount</th>
                                        <th>Status</th>
                                        <th>Payment</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%
                                        Session s = FactoryProvider.getFactory().openSession();
                                        Query q = s.createQuery("from Order o where o.user.userId =: uid order by o.orderDate desc");
                                        q.setParameter("uid", user.getUserId());
                                        List<Order> orders = q.list();
                                        
                                        for(Order o : orders) {
                                            Query itemQuery = s.createQuery("from OrderItem where order.orderId =: oid");
                                            itemQuery.setParameter("oid", o.getOrderId());
                                            List<OrderItem> items = itemQuery.list();
                                    %>
                                    <tr>
                                        <td>#<%=o.getOrderId()%></td>
                                        <td><%=o.getOrderDate()%></td>
                                        <td>
                                            <% for(OrderItem item : items) { %>
                                                <%=item.getProduct().getpName()%> (<%=item.getQuantity()%>)<br>
                                            <% } %>
                                        </td>
                                        <td>₹<%=o.getTotalAmount()%></td>
                                        <td><%=o.getOrderStatus()%></td>
                                        <td><%=o.getPaymentStatus()%></td>
                                    </tr>
                                    <%
                                        }
                                        s.close();
                                    %>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>