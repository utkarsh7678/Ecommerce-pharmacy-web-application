<%@page import="com.mycompany.getpharma.helper.FactoryProvider"%>
<%@page import="com.mycompany.getpharma.entites.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    User user = (User) session.getAttribute("current-user");
    if (user == null) {
        session.setAttribute("message", "You are not logged in! Please login first.");
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Checkout - Getpharm</title>
        <%@include file="componenets/common_css_js.jsp"%>
    </head>
    <body>
        <%@include file="componenets/navbar.jsp" %>
        
        <div class="container">
            <div class="row mt-5">
                <div class="col-md-6">
                    <div class="card">
                        <div class="card-body">
                            <h3 class="text-center mb-4">Your Order Details</h3>
                            <div class="cart-body">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="card">
                        <div class="card-body">
                            <h3 class="text-center mb-4">Shipping Details</h3>
                            <form action="OrderServlet" method="post" id="checkout-form">
                                <div class="form-group">
                                    <label for="name">Name</label>
                                    <input type="text" class="form-control" id="name" name="name" value="<%=user.getUserName()%>" readonly>
                                </div>
                                <div class="form-group">
                                    <label for="phone">Contact Number</label>
                                    <input type="text" class="form-control" id="phone" name="phone" value="<%=user.getUserPhone()%>" required>
                                </div>
                                <div class="form-group">
                                    <label for="address">Shipping Address</label>
                                    <textarea class="form-control" id="address" name="address" rows="3" required><%=user.getUserAddress()%></textarea>
                                </div>
                                <div class="form-group">
                                    <label for="payment">Payment Method</label>
                                    <select class="form-control" id="payment" name="payment" required>
                                        <option value="cod">Cash on Delivery</option>
                                        <option value="online">Online Payment</option>
                                    </select>
                                </div>
                                <input type="hidden" name="total_amount" id="total_amount">
                                <input type="hidden" name="cart_items" id="cart_items">
                                <div class="container text-center">
                                    <button type="submit" class="btn btn-primary custom-bg">Place Order</button>
                                    <button type="button" class="btn btn-secondary" onclick="window.history.back()">Go Back</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <script>
            $(document).ready(function() {
                updateCart();
                
                $('#checkout-form').submit(function(e) {
                    let cartString = localStorage.getItem("cart");
                    $('#cart_items').val(cartString);
                    
                    let cart = JSON.parse(cartString);
                    let total = 0;
                    for(let pid in cart) {
                        total += cart[pid].price * cart[pid].quantity;
                    }
                    $('#total_amount').val(total);
                });
            });
        </script>
    </body>
</html>