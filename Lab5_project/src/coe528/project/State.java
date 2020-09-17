package coe528.project;

/**
 *
 * @author Alvi Ahmed (500696421) (a226ahme)
 */
public abstract class State {   

    // protected Customer cust; 
    // private String state_String; 

    // public String getcurrentState() {
    //     if(cust.getBalance() < 10000) { 
    //         state_String =  "Silver";
    //     }
    //     else if(cust.getBalance() >= 10000 && cust.getBalance() < 20000){ 
    //         state_String = "Gold";
    //     }
    //     else if (cust.getBalance() > 20000){ 
    //        state_String = "Platinum";
    //     } 
    //     return state_String;
    // }
    public abstract void nextState(Customer cust); 
    public abstract double getadditional(); 

    // @Override 
    // public String toString(){ 
    //     return getcurrentState();
    // }
}
