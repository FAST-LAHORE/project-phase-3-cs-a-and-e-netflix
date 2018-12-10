/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netflix;
/**
 *
 * @author MianSaqib
 */
public class Movie {
    private String Name;
    private String genre="thriller";
    private String path;
    
    Movie(String Na, String p){
        Name = Na;
        path = p;
    }
    public String getname(){
        return Name;
    }
    public String getpath(){
        return path;
    }
    public String getgenre(){
        return genre;
    }
}
