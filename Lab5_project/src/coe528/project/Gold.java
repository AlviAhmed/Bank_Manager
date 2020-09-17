package coe528.project;

/**
 *
 * @author Alvi Ahmed (500696421) (a226ahme)
 */
public class Gold extends State{
    private String state_String;
    public final double add_cost = 10;
    @Override
    public void nextState(Customer cust) {
        if(cust.getBalance() < 10000) {  
            cust.setState(new Silver());
            // state_String =  "Silver";
        }
        // else if(cust.getBalance() >= 10000 && cust.getBalance() < 20000){ 
        //     state_String = "Gold";
        // }
        else if (cust.getBalance() > 20000){ 
            cust.setState(new Platinum());
           // state_String = "Platinum";
        } 
        // return state_String;
    }
    
    @Override 
    public double getadditional(){  
        return add_cost;
    }
    @Override 
    public String toString(){ 
        return "Gold";
    }
}
