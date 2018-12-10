/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netflix.pkg2;

/**
 *
 * @author hp
 */
public class Rating {
    
    public double onestar;
    public double twostar;
    public double threestar;
    public double fourstar;
    public double fivestar;
    
    public double overallrating;
    
    public Rating()
    {
        this.onestar = 0;
        this.twostar = 0;
        this.threestar=0;
        this.fourstar=0;
        this.fivestar=0;
        this.overallrating=0;
    }
    public Rating(double one,double two,double three,double four,double five)
    {
        this.onestar = one;
        this.twostar = two;
        this.threestar=three;
        this.fourstar=four;
        this.fivestar=five;
        updateoverallrating();
    }
    public void addonestar()
    {
        this.onestar++;
        updateoverallrating();
    }
    public void addtwostar()
    {
        this.twostar++;
        updateoverallrating();
    }
    public void addthreestar()
    {
        this.threestar++;
        updateoverallrating();
    }
    public void addfourstar()
    {
        this.fourstar++;
        updateoverallrating();
    }
    public void addfivestar()
    {
        this.fivestar++;
        updateoverallrating();
    }
    
    public void updateoverallrating()
    {
        double total_responses = this.onestar+this.twostar+this.threestar+this.fourstar+this.fivestar;
        
        this.overallrating = (1*this.onestar)+(2*this.twostar)+(3*this.threestar)+(4*this.fourstar)+(5*this.fivestar);
        this.overallrating = this.overallrating/total_responses;
        
        this.overallrating = this.overallrating*10;
        int rating = (int) this.overallrating;
        this.overallrating = (double) rating/10;
    }
    
    public double getoverallrating()
    {
        return this.overallrating;
    }
}
