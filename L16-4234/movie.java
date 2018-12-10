/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netflix.pkg2;


/**
 *
 * @author hp
 */
public class movie extends Media{
    
    public String runtime;
    public Rating rating;          // aggregation applied here
    public String sdurl;
    public String hdurl;
    public String uhdurl;
    
    public movie()
    {
        super.release_date=null;
        super.title=null;
        this.rating=null;
        this.runtime=null;
        this.sdurl=null;
        this.hdurl=null;
        this.uhdurl=null;
        super.imgurl=null;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public String getSdurl() {
        return sdurl;
    }

    public void setSdurl(String sdurl) {
        this.sdurl = sdurl;
    }

    public String getHdurl() {
        return hdurl;
    }

    public void setHdurl(String hdurl) {
        this.hdurl = hdurl;
    }

    public String getUhdurl() {
        return uhdurl;
    }

    public void setUhdurl(String uhdurl) {
        this.uhdurl = uhdurl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }
    
    public movie(String title,String release_date,String runtime)
    {
        super.title=title;
        super.release_date = release_date;
        this.runtime = runtime;
        
        rating = null;
    }
    public void seturls(String sd, String hd, String uhd,String img)
    {
        this.sdurl=sd;
        this.hdurl=hd;
        this.uhdurl=uhd;
        super.imgurl=img;
    }
    public void setRating(double one,double two,double three,double four,double five)
    {
        System.out.println("no error here");
        this.rating = new Rating(one,two,three,four,five);
    }
    public void updaterating(int updatestar)
    {
        System.out.println("updaterating called");
        switch (updatestar)
        {
            case 1:
                this.rating.addonestar();
                break;
            case 2:
                this.rating.addtwostar();
                break;
            case 3:
                this.rating.addthreestar();
                break;
            case 4:
                this.rating.addfourstar();
                break;
            case 5:
                this.rating.addfivestar();
                break;
        }
    }
    public String getruntime()
    {
        return this.runtime;
    }
}
