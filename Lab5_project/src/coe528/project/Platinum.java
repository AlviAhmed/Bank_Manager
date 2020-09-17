package coe528.project;

/**
 *
 * @author Alvi Ahmed (500696421) (a226ahme)
 */
public class Platinum extends State{
    private String state_String;
    public final double add_cost = 0;
    @Override
    public void nextState(Customer cust) {
        if(cust.getBalance() < 10000) { 
            // state_String =  "Silver";
            cust.setState(new Silver());
        }
        else if(cust.getBalance() >= 10000 && cust.getBalance() < 20000){ 
            // state_String = "Gold"             
            cust.setState(new Gold());
        }
        // else if (cust.getBalance() > 20000){ 
        //    state_String = "Platinum";
        // }  
        // return state_String;
    }
    
    @Override 
    public double getadditional(){  
        return add_cost;
    }
    @Override 
    public String toString(){ 
        return "Platinum";
    }
}
