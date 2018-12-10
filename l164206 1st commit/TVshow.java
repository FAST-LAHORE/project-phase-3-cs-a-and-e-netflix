/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netflix_administration;
import java.util.ArrayList;
/**
 *
 * @author MianSaqib
 */
public class TVshow {
    private String Name;
    private ArrayList<Season> N;
    private String Genre;
    private String Date;
    private String PicP;
    private int One;
    private int Two;
    private int Three;
    private int Four;
    private int Five;
    
    TVshow(String Na, String Gen, String D, String p, int o, int tw, int th, int f, int fi){
        N = new ArrayList();
        Name = Na;
        Genre = Gen;
        Date = D;
        One = o;
        Two = tw;
        Three = th;
        Four = f;
        Five = fi;
        PicP = p;
    }
    
    public void addSeason(Season S){
        N.add(S);
    }
    
    public void remSeason(Season S){
        N.remove(S);
    }
    
}
