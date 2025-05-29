package com.mycompany.getpharma.servlets;

import com.mycompany.getpharma.entites.Order;
import com.mycompany.getpharma.entites.OrderItem;
import com.mycompany.getpharma.entites.User;
import com.mycompany.getpharma.entites.product;
import com.mycompany.getpharma.helper.FactoryProvider;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.json.JSONObject;

@WebServlet(name = "OrderServlet", urlPatterns = {"/OrderServlet"})
public class OrderServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            try {
                // Get user from session
                HttpSession httpSession = request.getSession();
                User user = (User) httpSession.getAttribute("current-user");
                
                if (user == null) {
                    httpSession.setAttribute("message", "Please login first!");
                    response.sendRedirect("login.jsp");
                    return;
                }
                
                // Get form data
                String shippingAddress = request.getParameter("address");
                String contactNumber = request.getParameter("phone");
                String paymentMethod = request.getParameter("payment");
                double totalAmount = Double.parseDouble(request.getParameter("total_amount"));
                String cartItems = request.getParameter("cart_items");
                
                // Create order
                Order order = new Order();
                order.setUser(user);
                order.setShippingAddress(shippingAddress);
                order.setContactNumber(contactNumber);
                order.setTotalAmount(totalAmount);
                order.setOrderStatus("PENDING");
                order.setOrderDate(new Date());
                order.setPaymentMethod(paymentMethod);
                order.setPaymentStatus(paymentMethod.equals("cod") ? "PENDING" : "PAID");
                
                Session hibernateSession = FactoryProvider.getFactory().openSession();
                Transaction tx = hibernateSession.beginTransaction();
                
                int orderId = (int) hibernateSession.save(order);
                
                // Create order items
                JSONObject cart = new JSONObject(cartItems);
                for (String key : cart.keySet()) {
                    JSONObject item = cart.getJSONObject(key);
                    
                    product p = hibernateSession.get(product.class, Integer.parseInt(key));
                    
                    OrderItem orderItem = new OrderItem();
                    orderItem.setOrder(order);
                    orderItem.setProduct(p);
                    orderItem.setQuantity(item.getInt("quantity"));
                    orderItem.setPrice(item.getDouble("price"));
                    
                    hibernateSession.save(orderItem);
                    
                    // Update product quantity
                    p.setpQuantity(p.getpQuantity() - item.getInt("quantity"));
                    hibernateSession.update(p);
                }
                
                tx.commit();
                hibernateSession.close();
                
                // Clear cart
                response.getWriter().print("<script>localStorage.removeItem('cart');</script>");
                
                httpSession.setAttribute("message", "Order placed successfully! Order ID: " + orderId);
                response.sendRedirect("orders.jsp");
                
            } catch (Exception e) {
                e.printStackTrace();
                HttpSession httpSession = request.getSession();
                httpSession.setAttribute("message", "Error: " + e.getMessage());
                response.sendRedirect("checkout.jsp");
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}