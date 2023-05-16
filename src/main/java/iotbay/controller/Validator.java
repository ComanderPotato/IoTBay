package iotbay.controller;
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import jakarta.servlet.http.HttpSession;

public class Validator implements Serializable{


    private String emailPattern = "([a-zA-Z0-9]+)(([._-])([a-zA-Z0-9]+))*(@)([a-z]+)(.)([a-z]{3})((([.])[a-z]{0,2})*)";
    private String namePattern = "([A-Z][a-z]+[\\s])+[A-Z][a-z]*";
    private String passwordPattern = "[a-z0-9]{4,}";

    private String itemNamePattern = "^[A-Za-z0-9\\s]+$";
    private String itemCategoryPattern = "^[A-Za-z\\s]+$";
    //    private String itemImagePattern = "^.+\\.(jpg|jpeg|png)$";
    private String itemDescriptionPattern = "^[A-Za-z0-9\\s.,\\-!@#$%&*'\":?<>()]*";
    private String itemCostPattern = "^[1-9][0-9]*\\.[0-9]{2}$";
    private String itemQuantityPattern = "^[1-9][0-9]*$"; //eg. 0, 1, 2, 10, 12345, ....
    public Validator(){}
    public boolean validate(String pattern, String input){
        Pattern regEx = Pattern.compile(pattern);
        Matcher match = regEx.matcher(input);
        return match.matches();
    }
    public boolean checkEmpty(String email, String password){
        return  email.isEmpty() || password.isEmpty();
    }
    public boolean validateEmail(String email){
        return validate(emailPattern,email);
    }
    public boolean validateName(String name){
        return validate(namePattern,name);
    }
    public boolean validatePassword(String password){
        return validate(passwordPattern,password);
    }
    public void clear(HttpSession session) {
        session.setAttribute("emailErr", "Enter email");
        session.setAttribute("passErr", "Enter password");
        session.setAttribute("existErr", "");
        session.setAttribute("nameErr", "Enter name");
    }
    public boolean checkEmpty(String name, String category, String cost, String quantity) {
        return name.isEmpty() || category.isEmpty() || cost.isEmpty() || quantity.isEmpty();
    }

    public boolean validateItemName(String name) {
        return validate(itemNamePattern, name);
    }

    public boolean validateItemCategory(String category) {
        return validate(itemCategoryPattern, category);
    }

//    public boolean validateItemImage(String image) {
//        return validate(itemImagePattern, image);
//    }

    public boolean validateItemDescription(String description) {
        return validate(itemDescriptionPattern, description);
    }

    public boolean validateItemCost(String cost) {
        return validate(itemCostPattern, cost);
    }

    public boolean validateItemQuantity(String quantity) {
        return validate(itemQuantityPattern, quantity);
    }
}