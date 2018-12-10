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
public class CustomerService {
    private String issue = null;
    private User u = null;
    private CustomerServiceProvider n;
    private static CustomerService C = new CustomerService();
    
    private CustomerService(){
        n = CustomerServiceProvider.getinit();
    }
    
    public void notify(String s, User u){
        issue = s;
        this.u = u;
        n.getNotified(issue, this.u);
    }
    
    public String respondBack(){
        u = null;
        issue = null;
        return n.getResponse();
    }
    
    
}
