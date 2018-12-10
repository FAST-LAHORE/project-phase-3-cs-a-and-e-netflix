/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netflixproject;

/**
 *
 * @author Munam Malik
 */
public class User {
    String name;
    public String email;
    String password;
    String BankAccount;
    SubscriptionPlan Plan;

    public User() {
        this.name = "";
        this.email = "";
        this.password = "";
        this.BankAccount = "";
        this.Plan = null;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBankAccount(String BankAccount) {
        this.BankAccount = BankAccount;
    }

    public void setPlan(SubscriptionPlan Plan) {
        this.Plan = Plan;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getBankAccount() {
        return BankAccount;
    }

    public String getPlan() {
       if(Plan != null){
        return this.Plan.planType();
       }
       
       return "None";
    }
    
    
    public int checkPlan(){
        String myplan = getPlan().toLowerCase();
        if(myplan.matches("None")){
            return -1;
        } else if(myplan.matches("trial")){
            return 0;
        } else if(myplan.matches("basic")){
            return 1;
        } else if(myplan.matches("standard")){
            return 2;
        } else if(myplan.matches("premium")){
            return 3;
        } else {
            return -1;
        }
    }
    

    public User(String name, String email, String password, String BankAccount, int Plan, String termination) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.BankAccount = BankAccount;
        switch (Plan) {
            case 0:
                if(Credit.checkCredit(new Trial(), BankAccount)){
                    this.Plan = new Trial(termination);
                }
                break;
            case 1:
                if(Credit.checkCredit(new Basic(), BankAccount)){
                    this.Plan = new Basic(termination);
                }
                break;
            case 2:
               if(Credit.checkCredit(new Standard(), BankAccount)){
                    this.Plan = new Standard(termination);
                }
                break;
            case 3:
                if(Credit.checkCredit(new Premium(), BankAccount)){
                    this.Plan = new Premium(termination);
                }
                break;
            default:
                this.Plan = null;
                break;
        }
    }
    
    Boolean isValid(){
        if(this.email.matches("")){
            return false;
        }
        
        return true;
        
    }
    
   
    public void display(){
        System.out.println(this.name);
        System.out.println(this.email);
        System.out.println(this.BankAccount);
        System.out.println(this.password);
        System.out.println(this.Plan);
        
        
    }
}
