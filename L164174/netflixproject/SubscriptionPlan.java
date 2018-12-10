/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netflixproject;

import java.sql.Date;

/**
 *
 * @author Munam Malik
 */
public class SubscriptionPlan {
    String terminationDate; 

    public SubscriptionPlan() {
        this.terminationDate = (new java.sql.Date(System.currentTimeMillis())).toString();
    }

    
    
    public SubscriptionPlan(String terminationDate) {
        this.terminationDate = terminationDate;
    }
    
    
    
    public String getTerminationDate() {
        return terminationDate;
    }
    
    
    public String planType(){
        return "None";
    }
    
}
