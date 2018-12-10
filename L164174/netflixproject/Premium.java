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
public class Premium extends SubscriptionPlan{
    final Quality quality=Quality.UHD;
    final int Screens = 4;

    public Premium() {
        super();
    }

    
    
    public Premium(String termination) {
        super(termination);
    }
   
      @Override
     public String planType(){
         return "Premium";
     }
}
