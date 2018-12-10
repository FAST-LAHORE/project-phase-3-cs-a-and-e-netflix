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
public class Episode {
    private int ID;
    private String Name;
    private String Duration;
    private double Rating;
    private String Date;
    private String pathSD;
    private String pathHD;
    private String pathUHD;
    private String imgPath;
    
    Episode(int id, String Na, String Da, String d, String S, String H, String UH, String i){
        ID = id;
        Name = Na;
        Duration = d;
        pathSD = S;
        pathHD = H;
        pathUHD = UH;
        imgPath = i;
        Date = Da;
    }
    
    
    
}
