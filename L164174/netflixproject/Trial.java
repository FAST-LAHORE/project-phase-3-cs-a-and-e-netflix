/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netflixproject;

import javafx.stage.Screen;

/**
 *
 * @author Munam Malik
 */
public class Trial extends SubscriptionPlan{
    final Quality quality = Quality.SD;
    final int Screens = 1;

    public Trial() {
       super();
    }
    
     public Trial(String termination) {
        super(termination);

    }
     
     @Override
     public String planType(){
         return "Trial";
     }
   
}
