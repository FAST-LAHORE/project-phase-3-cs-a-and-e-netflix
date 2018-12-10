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
    
    Season(String Na, Episode e){
        Name = Na;
        addEpisode(e);
    }
    
    public void addEpisode(Episode e){
        S.add(e);
    }
    
    public void delEpisode(Episode e){
        S.remove(e);
    }
}
