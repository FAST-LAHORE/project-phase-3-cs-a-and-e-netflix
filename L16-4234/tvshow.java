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
public class tvshow extends Media{
    
    public int num0fseasons;
    public ArrayList<season> seasons;
    public Rating rating;
    
    public tvshow(String title,String release_date,String img)
    {
        System.out.println("tvshow-constructor");
        seasons = new ArrayList<season>();
        rating=null;
        this.num0fseasons=0;
        super.title=title;
        super.release_date=release_date;
        super.imgurl=img;
    }
    
    public void setRating(double one,double two,double three,double four,double five)
    {
        this.rating = new Rating(one,two,three,four,five);
    }
    public void updaterating(int updatestar)
    {
        System.out.println("updaterating called");
        switch (updatestar)
        {
            case 1:
                rating.addonestar();
                break;
            case 2:
                rating.addtwostar();
                break;
            case 3:
                rating.addthreestar();
                break;
            case 4:
                rating.addfourstar();
                break;
            case 5:
                rating.addfivestar();
                break;
        }
    }
    
    public void addnewseason()
    {
        System.out.println("adding season");
        int num=this.num0fseasons+1;
        this.num0fseasons=num;
        
        season s = new season(this.num0fseasons);
        seasons.add(s);
    }
    public void addepisode(int season_num,String title,String runtime,String sd,String hd,String uhd)
    {
        for(int i=0;i<seasons.size(); i++)
        {
            if(season_num == seasons.get(i).season_num)
            {
                seasons.get(i).addepisode(title, runtime, sd, hd, uhd);
            }
        }
            
    }
    
}
