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
public class Movie {
    private int ID;
    private String Name;
    private int Duration;
    private String Date;
    private double Rating;
    private String pathSD;
    private String pathHD;
    private String pathUHD;
    private String imgPath;
    
    Movie(int id, String Na, String Da, int d, String S, String H, String UH, String i){
        ID = id;
        Name = Na;
        pathSD = S;
        pathHD = H;
        pathUHD = UH;
        imgPath = i;
        Duration = d;
        Date = Da;
    }
    
    public int getId(){
        return ID;
    }
}
