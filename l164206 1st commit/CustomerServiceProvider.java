/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netflix_administration;

/**
 *
 * @author MianSaqib
 */
public class CustomerServiceProvider {
    String msg = null;
    private static CustomerServiceProvider C = new CustomerServiceProvider();
    private CustomerServiceProvider(){}
    
    public static CustomerServiceProvider getinit(){
        return C;
    }
    
    public void getNotified(String n, User u){
        msg = n;
    }
    
    public void newMsg(String n){
        msg = n;
    }
    
    public String getResponse(){
        return msg;
    }
}
