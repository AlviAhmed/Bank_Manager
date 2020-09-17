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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Alvi Ahmed (500696421) (a266ahme)
 */
public class CustomerController implements Initializable {

    public double amount = 0;
    @FXML public TextField Amount;
    @FXML public Label balance;
    @FXML public Label state; 

    @FXML
    public void logoutButton(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @FXML
    public void depositButton() {
        try {
            amount = Double.parseDouble(Amount.getText());
            MainController.customer.setBalance(amount + MainController.customer.getBalance());
            MainController.customer.getState().nextState(MainController.customer);
            balance.setText(Double.toString(MainController.customer.getBalance()));
            state.setText(MainController.customer.getState().toString());
        } catch (Exception e) {
            balance.setText("Not a valid amount");
        }
    }   

    @FXML
    public void withdrawButton() {
        try{
            amount = Double.parseDouble(Amount.getText());
            if (MainController.customer.getBalance() < amount)
                balance.setText("Not enough money");
            else{
                balance.setText(Double.toString(MainController.customer.balance -= amount));
                MainController.customer.getState().nextState(MainController.customer);
                state.setText(MainController.customer.getState().toString());
            }
        } catch (Exception e){
            balance.setText("Not a valid amount");
            }
        
    }

    @FXML
    public void balanceButton() {
         balance.setText(Double.toString(MainController.customer.getBalance()));
         state.setText(MainController.customer.getState().toString());
    } 

    @FXML 
    public void onlinepurchaseButton() {
        try{
            amount = Double.parseDouble(Amount.getText());
            if (amount >= 50){
                if (MainController.customer.getBalance() < amount + MainController.customer.getState().getadditional())
                    balance.setText("Not enough money");
                else{
                    balance.setText(Double.toString(MainController.customer.balance -= (amount + MainController.customer.getState().getadditional())));
                    MainController.customer.getState().nextState(MainController.customer);
                    state.setText(MainController.customer.getState().toString());
                }
            }
            else 
                balance.setText("Minimum $50");
        } catch (Exception e){
            balance.setText("Not a valid amount");
        }
    }





    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
