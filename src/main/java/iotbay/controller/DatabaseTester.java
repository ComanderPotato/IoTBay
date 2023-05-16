package iotbay.controller;

import iotbay.model.*;
import iotbay.model.dao.CustomerDBManager;
import iotbay.model.dao.DBConnector;
import iotbay.model.dao.OrderDBManager;
import iotbay.model.dao.UserAccountDBManager;
import iotbay.model.dao.RegistrationDBManager;

import java.util.ArrayList;
import iotbay.model.dao.ProductDBManager;

import java.sql.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseTester {

    private static Scanner sc = new Scanner(System.in);
    private static RegistrationDBManager rdb;
    private static CustomerDBManager cdb;
    private static OrderDBManager odb;
    private static Customer customer;
    public static void main(String[] args) {
        try {
            DBConnector connector = new DBConnector();
            Connection conn = connector.openConnection();
            // Instantiate what DAO object you want to test

            rdb = new RegistrationDBManager(conn);
            cdb = new CustomerDBManager(conn);
            odb = new OrderDBManager(conn);
            ProductDBManager pdb = new ProductDBManager(conn);
            Customer c = cdb.findCustomer("tomgolding2012@outlook.com", "password1");
            ArrayList<Order> a = odb.getOrders();

            for(Order i : a) {
                System.out.println(i.getOrderTotal());
                System.out.println(i.getOrderDate());
                for(OrderLineItem q : i.getOrderLineItem()) {
                    System.out.print("Quantity: ");
                    System.out.println(q.getItemQuantity());
                    System.out.print("ProductID: ");
                    System.out.println(q.getProductID());
                }
            }

//            menu();
            connector.closeConnection();
            // Call function here you want to test


        } catch(ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    private static void menu() throws SQLException {
        System.out.println("Login: L, SignUp: S, Guest: G, Quit: X");
        String c = sc.nextLine();
        switch (c.charAt(0)) {
            case 'L':
                login();
                break;
            case 'S':
                break;
            case 'G':
                break;

            default:
                System.out.println("Login: L, SignUp: S, Guest: G");
        }
    }
    private static void login() throws SQLException {
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();
        System.out.println();
        customer = cdb.findCustomer(email.trim(), password.trim());
        makeOrder();

        System.out.println(customer.getCustomerEmail());
    }
    private static void makeOrder() throws SQLException {
        ArrayList<CartItem> items = new ArrayList<>();
        System.out.println("Add some cart items");
        int count = 1;
        while(count != 5) {
            System.out.print("ProductID: ");
            int productId = sc.nextInt();
            System.out.print("Quantity: ");
            int productQuantity = sc.nextInt();
            items.add(new CartItem(count, 1, productId, productQuantity));
            count++;
        }
        odb.createOrder(cdb.findAssociatedAccount(customer.getCustomerID()), items);
    }

}
