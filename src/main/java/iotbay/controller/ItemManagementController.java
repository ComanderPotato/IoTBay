/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package iotbay.controller;

import java.io.IOException;
import java.sql.SQLException;
//import java.sql.Connection;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;

import iotbay.model.Product;
import iotbay.model.dao.ProductDBManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class ItemManagementController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        //get session attribute ssaved by ConnServlet
        ProductDBManager itemManager = (ProductDBManager) session.getAttribute("itemManager");

        //to here
        ArrayList<Product> items = new ArrayList<>();
        String selectedCategory =  request.getParameter("category");

        //fetch Items based on category selection        
        try {
            ArrayList<ArrayList<String>> categories = itemManager.fetchCategories();

            //find items by categories
            if (selectedCategory == null) {
                session.setAttribute("selectedCategory", "All");
                //items = itemManager.fetchItems();
                items = itemManager.fetchItemsByCategory("", "All");

            } else {
                session.setAttribute("selectedCategory", selectedCategory);
                items = itemManager.fetchItemsByCategory("", selectedCategory);
            }

            session.removeAttribute("selectedSort");
            session.setAttribute("categories", categories);
            session.setAttribute("items", items);

            //store image path in session
            String imagePath = "DBImages/";
            session.setAttribute("imagePath", imagePath);

            request.getRequestDispatcher("ItemManagement.jsp").include(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(ItemManagementController.class.getName()).log(Level.SEVERE, null, ex);
//            request.getRequestDispatcher("ItemManagement.jsp").include(request, response); 
        }

    }


}
