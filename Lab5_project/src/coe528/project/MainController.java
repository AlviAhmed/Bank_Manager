/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author Alvi Ahmed (500696421) (a266ahme)
 */ 


public class MainController implements Initializable {

    BufferedReader br = null;
    ObservableList<String> userList = FXCollections.observableArrayList("Customer", "Manager");

    @FXML private TextField username;
    @FXML private PasswordField password;
    @FXML private ChoiceBox<String> choiceBox;  
    @FXML private Label choiceBoxLabel;

    static Manager manager = new Manager();
    public final String manager_user = "admin"; 
    public final String manager_pass = "admin";
   

    static Customer customer;
 
    // Updating the label and dealing with choice 
    @FXML
    public void choiceBoxButtonPushed(ActionEvent event) throws IOException{  
        choiceBoxLabel.setText(choiceBox.getValue().toString()); 
        if (choiceBox.getValue()== "Manager"){
            if (username.getText().equals(manager_user) && password.getText().equals(manager_pass)){
                Parent root = FXMLLoader.load(getClass().getResource("Manager.fxml"));
                Scene scene = new Scene(root);
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(scene);
                window.show();
            }
            else 
                choiceBoxLabel.setText("Either Username or Password is incorrent please try again");
        } 
        if (choiceBox.getValue() == "Customer"){
            for (Customer c: manager.customers){
                if (username.getText().equals(c.username)){
                    try {
                        br = new BufferedReader(new FileReader(c.username + ".txt"));
                        String input;
                        while ((input = br.readLine()) != null){
                            if (password.getText().equals(input)){
                                customer = c;
                                Parent customerUIParent = FXMLLoader.load(getClass().getResource("Customer.fxml"));          
                                Scene customerUIScene = new Scene(customerUIParent);
                                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                                window.setScene(customerUIScene);
                                window.show();
                            }
                        }
                    } catch (IOException e) {
                        System.out.println("Please enter a valid password");}
                } 
            }
            choiceBoxLabel.setText("Incorrect Username or Password, please try again");
        }
    }
    /**
     * Initializes the controller class.
     */ 
    @Override
    public void initialize(URL url, ResourceBundle rb) { 
        // Configuring the choicebox    
        choiceBoxLabel.setText("");
        choiceBox.setValue("Customer"); 
        choiceBox.setItems(userList);
        // choiceBoxLabel.setText(""); 
        // choiceBox.getItems().add("Manager");
        // choiceBox.getItems().add("Customer");
    }    
    
}
