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
public class TVshow {
    private String Name;
    private ArrayList<Season> N;
    private double Rating;
    
    TVshow(String Na, Season S){
        N = new ArrayList();
        Name = Na;
    }
    public Season getSeasoninfo(int i){
        return N.get(i);
    }
    public void addSeason(Season S){
        N.add(S);
    }
    
    public void remSeason(Season S){
        N.remove(S);
    }
    public String getSeason(){
        return Name;
    }
}
