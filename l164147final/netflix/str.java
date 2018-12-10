/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netflix;

/**
 *
 * @author Faaiz
 */
class str {
    static String s;
    private static str p = new str(s);
    private str(String s){
    this.s=s;
    }
    public static str getInit(){
        return p;
    }
    public String gettext(){
    return s;
    }
    
}
