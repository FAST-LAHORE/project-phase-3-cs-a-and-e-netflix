/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netflix.pkg2;

import java.util.ArrayList;

/**
 *
 * @author hp
 */
public class season {
    
    public int season_num;
    public ArrayList<episode> episodes;
    
    public season(int num)
    {
        this.season_num=num;
        episodes = new ArrayList<episode>();
        
    }
    public void addepisode(String title,String runtime,String sd,String hd,String uhd)
    {
        System.out.println("adding episode");
        episode ep = new episode(title,runtime);
        ep.seturls(sd, hd, uhd);
        this.episodes.add(ep);
    }
}
