package coe528.project;

/**
 *
 * @author Alvi Ahmed (500696421) (a226ahme)
 */
public class Silver extends State{  
    private String state_String; 
    public final double add_cost = 20;
    public void nextState(Customer cust) {
        // if(cust.getBalance() < 10000) { 
        //     state_String =  "Silver";
        // }
        if(cust.getBalance() >= 10000 && cust.getBalance() < 20000){  
            cust.setState(new Gold());
            // state_String = "Gold";
        }
        else if (cust.getBalance() > 20000){ 
           // state_String = "Platinum";
           cust.setState(new Platinum());
        } 
        // return state_String;
    }  
    @Override 
    public double getadditional(){  
        return add_cost;
    }
    @Override 
    public String toString(){ 
        return "Silver";
    }
    
}
