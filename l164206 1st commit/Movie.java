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
    private String Name;
    private String Duration;
    private String Genre;
    private String Date;
    private String pathSD;
    private String pathHD;
    private String pathUHD;
    private String imgPath;
    private int one;
    private int two;
    private int three;
    private int four;
    private int five;
    
    Movie(String Na, String Da, String d, String G, String S, String H, String UH, String i, int o, int tw, int th, int f, int fi){
        Name = Na;
        pathSD = S;
        pathHD = H;
        pathUHD = UH;
        imgPath = i;
        Duration = d;
        Date = Da;
        one = o;
        two = tw;
        three = th;
        four = f;
        five = fi;
    }
    
    public String getN(){
        return Name;
    }
}
