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
public class Basic extends SubscriptionPlan{

    final Quality quality = Quality.SD;
    final int Screens = 1;

    
    public Basic() {
        super();
    }
    
    public Basic(String termination) {
        super(termination);

    }
    
      @Override
     public String planType(){
         return "Basic";
     }
   
}
