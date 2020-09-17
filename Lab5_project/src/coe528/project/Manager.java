/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author Alvi Ahmed (500696421) (a226ahme)
 */
public class Manager {  

    // Implementing Single Design Pattern to ensure only 1 manager exists 
    private static Manager manager;  
    public Manager() {
    } 
    private static Manager getInstance(){
        if (manager == null){ 
            manager = new Manager();
        } 
        return manager;
    }
    //******************************************************************* 

    static ArrayList<Customer> customers = new ArrayList<Customer>();
    private final String role = "Manager";     // role: Manager 
    
    // Methods 
    
    public String getRole(){ 
        return role;
    } 

    public boolean createCustomer(String un, String pass, double bal) { 
        String filename = un + ".txt";
        boolean test = false;
        for (Customer cust : customers){
            if (cust.username.equals(un)){
                System.out.println("Customer  "+ un + " already exists ");
                return false;
            }
            else{ 
                test = true;
            }
        } 
        try{
            if (test = true){
                customers.add(new Customer(un, pass, bal)); 
                File f = new File (filename);
                f.createNewFile();
                PrintWriter pw = new PrintWriter(f);
                pw.println(pass);
                pw.close(); 
                System.out.println(" Success: User file has been created!!!");
            }
        } 
        catch (IOException e){
            System.out.println("ERROR!");  
        }
        return test;
    } 
    

    public boolean deleteCustomer(String un) {
        for (Customer cust : customers){
            if (cust.username.equals(un)){
                customers.remove(new Customer(un)); 
                System.out.println("Customer: " + un + " Successfully Removed");
                return true;
            } 
            else{  
                System.out.println("Customer: " + un + " Does not exist please try again");
            }
        }
        return false;
    } 
    // public static void main(String[] args) {
    //     System.out.println("Testing the Main class");
    //     // Customer Alvi = new Customer  ("Alvi", "alv", 1000000000.0);
    // //     Customer John = new Customer  ("John", "alv", 100.0);
    // //     Customer Bob =  new Customer  ("Bob", "alv", 11000.0); 
    //     Manager Alvi = new Manager(); 
    //     Alvi.createCustomer("Alvi", "alv", 1000000000.0);
    //     Alvi.createCustomer("John", "alv", 100.0);
    //     Alvi.createCustomer("Bod", "alv", 11000.0);
    // }
}
