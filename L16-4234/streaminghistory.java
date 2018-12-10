/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netflix.pkg2;

import java.util.Date;

/**
 *
 * @author hp
 */
public class streaminghistory {
    
    private User user;
    private String title;
    private String url;
    private Date date;

    
    public streaminghistory(User user,String title,String url, Date date)
    {
        this.user = user;
        this.title=title;
        this.url=url;
        this.date= date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
}
