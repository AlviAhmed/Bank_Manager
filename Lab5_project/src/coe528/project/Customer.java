
package coe528.project;

/**
 *
 * @author Alvi Ahmed (500696421) (a226ahme)
 */ 


// ABSTRACTION FUNCTION:
//
// AF(c) = a Customer, c
//         where c.BankAccount is the account number for c
//
// REP INVARIANT:
//
// RI(c) = true if c.username != null for the customer c
//
//       = false otherwise
//

public class Customer {   
   
    //State Interface 
    private State state = new Silver(); //Default case for state         
    // Variables
    public String username;
    private String password;
    private final String role = "Customer"; 
    public  double balance;  
    

    /**
     * 
     * @param u 
     */
    public Customer(String un) {
        this.username = un;
    }

    /**
     * 
     * @param un
     * @param pass
     * @param bal
     */
    public Customer(String un, String pass, double bal) { //constructor that initializes the main variables whenever customer is created
        this.username = un;
        this.password = pass; 
        this.balance = bal;  
        if(this.balance < 10000) {  
            state = new Silver();
        }
        else if(this.balance >= 10000 && this.balance < 20000){ 
            state = new Gold();
        }
        else if (this.balance > 20000){ 
            state = new Platinum();
        } 
        // return state_String;
    }


    //State Travel Methods  

 /**
     * REQUIRES: Input be valid object
     * MODIFIES: Modifies customer's state
     * EFFECTS: Sets the customers state
     * @param s
     */
    public void setState(State s){  
        state = s;
    }  
    
 /**
     * REQUIRES:
     * MODIFIES:
     * EFFECTS: Returns the customer's state
     * @return 
     */
    public State getState() {
        return state;
    }

    //  Methods  
    public String getRole(){ 
        return role;
    }

   /**
     * REQUIRES: amount be non negative
     * MODIFIES: balance and state of customer
     * EFFECTS: increases account balance
     * @return 
     * @param amount 
     */
    public void Deposit(double depo){ 
        // will most likely increment the addbalance in the state interface 
            balance = balance + depo;
    } 
    /**
     * REQUIRES: balance non negative, same or higher than amount being withdrawn
     * MODIFIES: balance and state of customer
     * EFFECTS: reduced account balance
     * @param with
     */
    public void WithDraw(double with){  
        if (balance >= with){   //means that customer has enough money in the bank
            balance = balance - with;
        } 
        else{   
            System.out.println("Warning! The amount being drawn is greater then available balance");
        }
    }  


 /**
     * REQUIRES:
     * MODIFIES:
     * EFFECTS: Returns the customer's balance
     * @return 
     */
    public double getBalance() {  
        System.out.printf("Customers current state " + state);
        return balance;
    } 

 /**
     * REQUIRES:
     * MODIFIES:
     * EFFECTS: Sets customer's balance
     * @param bal
     */
    public void setBalance(double bal) {  
         balance = bal;
    }


    /**
     * REQUIRES: price to be at least 50 
                 balance non negative and greater that price purchasing
     * MODIFIES: balance of customer and state
     * EFFECTS: Adds on fee to price based on customer state 
     * @param cost 
     */
    public void doOnlinePurchase(double price){   
        if (price > 50){ //price of object for online shopping must be atleast 50 dollars or more
            if (price > balance){  
                System.out.printf("Cannot Purchase, price higher than your current balance ");
            }  
            else {    
                if (state.equals("Silver")){
                    balance = balance - price - 20; // if customer Silver level must pay 20 dollar extra fee 
                } 
                else if (state.equals("Gold")){
                    balance = balance - price - 10; // if customer Gold level must pay 10 dollar extra fee 
                } 
                else if (state.equals("Platinum")){
                    balance = balance - price; // if customer Platinum level, doesn't pay fee  
                } 
            }
        }
        else{ 
            System.out.printf("Warning! Item being purchased must be at least 50 dollars!");
        }
    }  
    public String toString(){ 
        return username;
    }
    

public boolean repOK() {
        if(username == null)
            return false;
        else
            return true;
        }

    // public static void main(String[] args) {
    //     System.out.println("testing \n"); 
    //     Customer Alvi = new Customer  ("Alvi", "alv", 1000000000.0);
    //     Customer John = new Customer  ("John", "alv", 100.0);
    //     Customer Bob =  new Customer  ("Bob", "alv", 11000.0); 
        
    //     System.out.println("Customers toString \n"); 
    //     System.out.println(Alvi.toString() + "\n");
    //     System.out.println(John.toString() + "\n");
    //     System.out.println(Bob.toString() + "\n");
    //     System.out.println("Customers state \n"); 
    //     System.out.println(Alvi.getState() + "\n");
    //     System.out.println(John.getState() + "\n");
    //     System.out.println( Bob.getState()  + "\n");
    // }
}
