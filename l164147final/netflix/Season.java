/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netflix;

import java.util.ArrayList;

/**
 *
 * @author MianSaqib
 */
public class Season {
    private String Name;
    private ArrayList<Episode> S;
    private String path;//path of image of a season
    private String genre;
    
    Season(String Na, Episode e,String path,String g){
        Name = Na;
        addEpisode(e);
        this.path=path;
        genre=g;
    }
    public String getgenre(){
        return genre;
    }
    public String getpath(){
        return path;
    }
    public int getnumberofepisode(){
        return S.size();
    }
    public void addEpisode(Episode e){
        S.add(e);
    }
    
    public void delEpisode(Episode e){
        S.remove(e);
    }
    public String getName(){
        return Name;
    }
    
}
