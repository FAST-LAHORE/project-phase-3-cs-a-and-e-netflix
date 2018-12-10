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
public class Standard extends SubscriptionPlan{
    final Quality quality = Quality.HD;
    final int Screens = 2;

     public Standard(){
        super();
      
    }
    
    public Standard(String termination){
        super(termination);
    }
   
      @Override
     public String planType(){
         return "Standard";
     }
}
