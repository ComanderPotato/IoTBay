package iotbay.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import iotbay.model.dao.CustomerDBManager;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;

import jakarta.servlet.http.HttpServletRequest;

import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.http.HttpSession;
import iotbay.model.Customer;


public class LoginServlet extends HttpServlet {
    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException {

        HttpSession session = request.getSession();
        Validator validator = new Validator();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        CustomerDBManager manager = (CustomerDBManager) session.getAttribute("manager");
        Customer customer = null;
        validator.clear(session);

       if(!validator.validateEmail(email)) {
           session.setAttribute("emailErr", "Error: Email format incorrect");
           request.getRequestDispatcher("login.jsp").include(request, response);
       } else if(!validator.validatePassword(password)) {
           session.setAttribute("passErr", "Error: Password format incorrect");
           request.getRequestDispatcher("login.jsp").include(request, response);
       } else {
           try {
               customer = manager.findCustomer(email, password);
               if(customer != null) {
                   session.setAttribute("customer", customer);
                   request.getRequestDispatcher("main.jsp").include(request, response);
               } else {
                   session.setAttribute("existErr", "Error: Customer does not exist");
                   request.getRequestDispatcher("login.jsp").include(request, response);
               }
           } catch (SQLException | NullPointerException ex) {
               System.out.println(ex.getMessage() == null ? "Customer does not exist" : "Welcome");
           }
       }

    }
}
