/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package iotbay.controller;

import java.io.IOException;

import iotbay.model.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import iotbay.model.dao.ProductDBManager;

public class DeleteItemController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        //get session attribute ssaved by ConnServlet
        ProductDBManager productManager = (ProductDBManager) session.getAttribute("productManager");
        
        //fetch products based on search input
//        ArrayList<Item> products = new ArrayList<>();
        String itemToDelete = request.getParameter("itemName");
        String selectedCategory = (String) session.getAttribute("selectedCategory");
        try {
            ArrayList<Product> products;
            
            productManager.deleteProduct(itemToDelete);

            if ((productManager.fetchItemsByCategory("", selectedCategory)).isEmpty()) { //no more products in that category
                ArrayList<ArrayList<String>> categories = productManager.fetchCategories(); //update the categories
                session.setAttribute("categories", categories);
                
                session.setAttribute("selectedCategory", "All");
                products = productManager.fetchItemsByCategory("", "All"); //show All instead

            } else { //still some item in the selected category
                products = productManager.fetchItemsByCategory("", selectedCategory);
            }
            
            session.setAttribute("popupMsg", "One item deleted.");
            session.setAttribute("products", products);
            
            request.getRequestDispatcher("ItemManagement.jsp").include(request, response);  

        } catch (SQLException ex) {
            Logger.getLogger(DeleteItemController.class.getName()).log(Level.SEVERE, null, ex);
            //request.getRequestDispatcher("ItemManagement.jsp").include(request, response); 
        }
    }


}
