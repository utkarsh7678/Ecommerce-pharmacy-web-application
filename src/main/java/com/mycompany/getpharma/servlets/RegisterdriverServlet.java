/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.getpharma.servlets;

import com.mycompany.getpharma.dao.dog;
import com.mycompany.getpharma.entites.Delivery_partnear;
import com.mycompany.getpharma.helper.FactoryProvider;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;/**
 *
 * @author Utkarsh Kumar
 */
@WebServlet(name = "RegisterdriverServlet", urlPatterns = {"/RegisterdriverServlet"})
public class RegisterdriverServlet extends HttpServlet {
         private SessionFactory factory;

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
                     try{
         String driverName=   request.getParameter("driver_name") ;  
               String driverEmail=request.getParameter("driver_email");
        //      String email = userEmail;
          //    dog Dog=new dog(FactoryProvider.getFactory());
            //  User user1= Dog.getUserByEmail(email);
             
               String driverPassword=request.getParameter("driver_password");
               String driverPhone=request.getParameter("driver_phone");
               String driverAddress=request.getParameter("driver_address");
               String driverLicence=request.getParameter("licence_no");
                              String drivervehicles=request.getParameter("bike_no");

               //validation
               if(driverName.isEmpty()){
                  // out.println("name is blank");
                 
          HttpSession http=request.getSession();
          http.setAttribute("message","warning invalid!! username");
          response.sendRedirect("register_driver.jsp");
                return;
                  
               }
         
                if(driverPassword.isEmpty()){
                  // out.println("name is blank");
                 
          HttpSession http=request.getSession();
          http.setAttribute("message","warning invalid!! password");
          response.sendRedirect("register_driver.jsp");
                return;                
               }
                                 if(driverEmail.isEmpty()){
                  // out.println("name is blank");
                 
          HttpSession http=request.getSession();
          http.setAttribute("message","warning invalid!! mail");
          response.sendRedirect("register_driver.jsp");
                return;
                  
               }
                              //     if(user1!=null){
                  // HttpSession http=request.getSession();
         // http.setAttribute("message","warning email already exist");
          //response.sendRedirect("register.jsp");
            //    return;          
              // }
 if(driverPhone.isEmpty()){
                  // out.println("name is blank");
                 
          HttpSession http=request.getSession();
          http.setAttribute("message","warning invalid!! phone");
          response.sendRedirect("register_driver.jsp");
                return;
                  
               }
 if(driverAddress.isEmpty()){
                  // out.println("name is blank");
                 
          HttpSession http=request.getSession();
          http.setAttribute("message","warning invalid!! userADDRESS");
          response.sendRedirect("register_driver.jsp");
                return;
                  
               }


//creating user object to store data
Delivery_partnear user=new Delivery_partnear( driverName,  driverEmail,  driverPassword,  driverPhone, "default.jpg", driverAddress);
    Session hibernateSession=FactoryProvider.getFactory().openSession();
    Transaction tx=hibernateSession.beginTransaction();
    int userId=(int) hibernateSession.save(user);
    tx.commit();
         hibernateSession.close();
          HttpSession http=request.getSession();
          http.setAttribute("message","Registration Successful !! userId is"+userId);
          response.sendRedirect("register_driver.jsp");
                return;
           }
           catch(Exception e){
               e.printStackTrace();
               
                   }
        }
    }
  
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
