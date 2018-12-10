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
public class episode {
    
    private String title;
    private String runtime;
    
    public String sdurl;
    public String hdurl;
    public String uhdurl;
    
    public episode(String title,String runtime)
    {System.out.println("episdoe created");
        this.title=title;
        this.runtime=runtime;
    }
    public void seturls(String sd, String hd, String uhd)
    {System.out.println("url setted");
        this.sdurl=sd;
        this.hdurl=hd;
        this.uhdurl=uhd;
    }
    
    
    public String gettitle()
    {
        return this.title;
    }
    public String getruntime()
    {
        return this.runtime;
    }
    
}
