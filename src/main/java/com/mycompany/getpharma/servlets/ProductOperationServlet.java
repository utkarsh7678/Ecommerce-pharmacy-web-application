package com.mycompany.getpharma.servlets;

import com.mycompany.getpharma.entites.category;
import com.mycompany.getpharma.entites.product;
import com.mycompany.getpharma.helper.FactoryProvider;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import org.hibernate.Session;
import org.hibernate.Transaction;

@WebServlet(name = "ProductOperationServlet", urlPatterns = {"/ProductOperationServlet"})
@MultipartConfig
public class ProductOperationServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String pName = request.getParameter("pTitle");
            String pDesc = request.getParameter("pDescription");
            int pPrice = Integer.parseInt(request.getParameter("pprice"));
            int pDiscount = Integer.parseInt(request.getParameter("pdiscount"));
            int pQuantity = Integer.parseInt(request.getParameter("pquantity"));
            Part part = request.getPart("imageUpload");
            
            // Save product to database
            product p = new product();
            p.setpName(pName);
            p.setpDesc(pDesc);
            p.setpPrice(pPrice);
            p.setpDiscount(pDiscount);
            p.setpQuantity(pQuantity);
            p.setpPhoto(part.getSubmittedFileName());
            
            Session hibernateSession = FactoryProvider.getFactory().openSession();
            Transaction tx = hibernateSession.beginTransaction();
            
            hibernateSession.save(p);
            
            tx.commit();
            hibernateSession.close();
            
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("message", "Product added successfully!");
            response.sendRedirect("admin.jsp");
            return;
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

    @Override
    public String getServletInfo() {
        return "Product Operation Servlet";
    }
}