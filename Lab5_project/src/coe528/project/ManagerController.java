/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 * @author Alvi Ahmed (500696421) (a266ahme)
 */
public class ManagerController implements Initializable {
    protected Manager manager = new Manager(); 
    static double amount = 0;
    double balance = 0; 

    @FXML private TextField username;
    @FXML private TextField initamount;
    @FXML private PasswordField password;
    @FXML private Label label;

    @FXML
    public void addcust(){
        try {
            balance = Double.parseDouble(initamount.getText());
            if (balance < 100)
                label.setText("Account must be at least $100");
            else{
                if (manager.createCustomer(username.getText(), password.getText(), balance)){
                    label.setText("Customer created, balance: " + initamount.getText());
                }
            else {
                label.setText("Username already taken");
            }
            }
        } catch (Exception e) {
                    label.setText("Please enter a valid amount");
        }
    } 

    @FXML
    public void delcust(){
        if (manager.deleteCustomer(username.getText()))
            label.setText(username.getText() + " has been successfully deleted");
        else
            label.setText(username.getText() + " does not exist");
    }

    @FXML
    public void logout(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }



    /**
     * Initializes the controller class.
     */ 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
}
