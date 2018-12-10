/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netflix.pkg2;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Munam Malik
 */
public class Database {
    
    static Database database;
    Connection c= null;
    ResultSet rs=null;
    String Query=null;
    Statement s=null;
    byte[] salt = ("[B@5e481248").getBytes();
    
    public Database()
    {
        String URL = "jdbc:derby://localhost:1527/database";
        try
        {
            c = DriverManager.getConnection(URL);
            s = c.createStatement();
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();            
        }

    }
        
    public String get_movie_release_date(String title) throws SQLException
    {
        String query = "Select * from MOVIE Where TITLE = '" + title + "'" ;
        String result="";
        rs = this.s.executeQuery(query);
        
        while(rs.next())
        {
        result = rs.getString("RELEASE_DATE");
        }
        return result;
    }
    public String get_movie_runtime(String title) throws SQLException
    {
        String query = "Select * from MOVIE Where TITLE = '" + title + "'" ;
        String result="";
        rs = this.s.executeQuery(query);
        
        while(rs.next())
        {
        result = rs.getString("DURATION");
        }
        return result;
    }
    public String get_movie_img(String title) throws SQLException
    {
        String query = "Select * from MOVIE Where TITLE = '" + title + "'" ;
        String result="";
        rs = this.s.executeQuery(query);
        
        while(rs.next())
        {
        result = rs.getString("IMG");
        }
        return result;
    }
    public String get_movie_sd(String title) throws SQLException
    {
        String query = "Select * from MOVIE Where TITLE = '" + title + "'" ;
        String result="";
        rs = this.s.executeQuery(query);
        
        while(rs.next())
        {
        result = rs.getString("SDURL");
        }
        return result;
    }
    public String get_movie_hd(String title) throws SQLException
    {
        String query = "Select * from MOVIE Where TITLE = '" + title + "'" ;
        String result="";
        rs = this.s.executeQuery(query);
        
        while(rs.next())
        {
        result = rs.getString("HDURL");
        }
        return result;
    }
    public String get_movie_uhd(String title) throws SQLException
    {
        String query = "Select * from MOVIE Where TITLE = '" + title + "'" ;
        String result="";
        rs = this.s.executeQuery(query);
        
        while(rs.next())
        {
        result = rs.getString("UHDURL");
        }
        return result;
    }
    
    public int get_movie_one_star(String title) throws SQLException
    {
        String query = "Select * from MOVIE Where TITLE = '" + title + "'" ;
        int result =0;
        rs = this.s.executeQuery(query);
        
        while(rs.next())
        {
        result = rs.getInt("ONE_STAR");
        }
        return result;
    }
    public int get_movie_two_star(String title) throws SQLException
    {
        String query = "Select * from MOVIE Where TITLE = '" + title + "'" ;
        int result =0;
        rs = this.s.executeQuery(query);
        
        while(rs.next())
        {
        result = rs.getInt("TWO_STAR");
        }
        return result;
    }
    public int get_movie_three_star(String title) throws SQLException
    {
        String query = "Select * from MOVIE Where TITLE = '" + title + "'" ;
        int result =0;
        rs = this.s.executeQuery(query);
        
        while(rs.next())
        {
        result = rs.getInt("THREE_STAR");
        }
        return result;
    }
    public int get_movie_four_star(String title) throws SQLException
    {
        String query = "Select * from MOVIE Where TITLE = '" + title + "'" ;
        int result =0;
        rs = this.s.executeQuery(query);
        
        while(rs.next())
        {
        result = rs.getInt("FOUR_STAR");
        }
        return result;
    }
    public int get_movie_five_star(String title) throws SQLException
    {
        String query = "Select * from MOVIE Where TITLE = '" + title + "'" ;
        int result =0;
        rs = this.s.executeQuery(query);
        
        while(rs.next())
        {
        result = rs.getInt("FIVE_STAR");
        }
        return result;
    }
    
    // tv show
    
    
    public String get_tvshow_release_date(String title) throws SQLException
    {
        String result="";
        
        this.Query = "SELECT RELEASE_DATE FROM TVSHOW WHERE TITLE = '" + title + "'";
        rs = this.s.executeQuery(this.Query);
        
        while(rs.next())
        {
            result = rs.getString("RELEASE_DATE");
        }
        
        return result;
    }
    public String get_tvshow_img(String title) throws SQLException
    {
        String result="";
        
        this.Query = "SELECT IMG FROM TVSHOW WHERE TITLE = '" + title + "'";
        rs = this.s.executeQuery(this.Query);
        
        while(rs.next())
        {
            result = rs.getString("IMG");
        }
        
        return result;
    }
    public int get_tvshow_one_star(String title) throws SQLException
    {
        String query = "Select ONE_STAR from TVSHOW Where TITLE = '" + title + "'" ;
        int result =0;
        rs = this.s.executeQuery(query);
        
        while(rs.next())
        {
        result = rs.getInt("ONE_STAR");
        }
        return result;
    }
    public int get_tvshow_two_star(String title) throws SQLException
    {
        String query = "Select TWO_STAR from TVSHOW Where TITLE = '" + title + "'" ;
        int result =0;
        rs = this.s.executeQuery(query);
        
        while(rs.next())
        {
        result = rs.getInt("TWO_STAR");
        }
        return result;
    }
    public int get_tvshow_three_star(String title) throws SQLException
    {
        String query = "Select THREE_STAR from TVSHOW Where TITLE = '" + title + "'" ;
        int result =0;
        rs = this.s.executeQuery(query);
        
        while(rs.next())
        {
        result = rs.getInt("THREE_STAR");
        }
        return result;
    }
    public int get_tvshow_four_star(String title) throws SQLException
    {
        String query = "Select FOUR_STAR from TVSHOW Where TITLE = '" + title + "'" ;
        int result =0;
        rs = this.s.executeQuery(query);
        
        while(rs.next())
        {
        result = rs.getInt("FOUR_STAR");
        }
        return result;
    }
    public int get_tvshow_five_star(String title) throws SQLException
    {
        String query = "Select FIVE_STAR from TVSHOW Where TITLE = '" + title + "'" ;
        int result =0;
        rs = this.s.executeQuery(query);
        
        while(rs.next())
        {
        result = rs.getInt("FIVE_STAR");
        }
        return result;
    }
    
    public int get_tvshow_season_num(String title) throws SQLException
    {
        int num =0;
        String query = "SELECT COUNT(NUM) AS RESULT FROM (SELECT COUNT (SEASON_NUM) AS NUM FROM SEASON\n" +
                        "WHERE TVSHOW = '" + title + "' group by SEASON_NUM) AS tab";
        
        rs= this.s.executeQuery(query);
        while(rs.next())
        {
            num = rs.getInt("RESULT");
        }
        return num;
    }
    public int get_season_episode_num(String title,int season_num) throws SQLException
    {
        int num=0;
        
        String query = "SELECT COUNT (SEASON_NUM) AS NUM FROM SEASON\n" +
                       "WHERE TVSHOW = '" + title + "' AND SEASON_NUM = "+season_num +
                       " group by SEASON_NUM";
        
        rs = this.s.executeQuery(query);
        while(rs.next())
        {
            num = rs.getInt("NUM");
        }
        return num;
    }
   
    
    public String get_episode_title(String title, int season, int episode) throws SQLException
    {
        String result="";
        
        String query = "SELECT TITLE FROM SEASON " +
                       "WHERE TVSHOW = '" + title + "' AND SEASON_NUM = " + season + " AND EPISODE_NUM = "+ episode;
        
        rs = this.s.executeQuery(query);
        while(rs.next())
        {
            result = rs.getString("TITLE");
        }
        
        return result;
    }
    public String get_episode_sd(String title, int season, int episode) throws SQLException
    {
        String result="";
        
        String query = "SELECT SDURL FROM SEASON " +
                       "WHERE TVSHOW = '" + title + "' AND SEASON_NUM = " + season + " AND EPISODE_NUM = "+ episode;
        
        rs = this.s.executeQuery(query);
        while(rs.next())
        {
            result = rs.getString("SDURL");
        }
        
        return result;
    }
    public String get_episode_hd(String title, int season, int episode) throws SQLException
    {
        String result="";
        
        String query = "SELECT HDURL FROM SEASON " +
                       "WHERE TVSHOW = '" + title + "' AND SEASON_NUM = " + season + " AND EPISODE_NUM = "+ episode;
        
        rs = this.s.executeQuery(query);
        while(rs.next())
        {
            result = rs.getString("HDURL");
        }
        
        return result;
    }
    public String get_episode_uhd(String title, int season, int episode) throws SQLException
    {
        String result="";
        
        String query = "SELECT UHDURL FROM SEASON " +
                       "WHERE TVSHOW = '" + title + "' AND SEASON_NUM = " + season + " AND EPISODE_NUM = "+ episode;
        
        rs = this.s.executeQuery(query);
        while(rs.next())
        {
            result = rs.getString("UHDURL");
        }
        
        return result;
    }
    
    
    public void set_movie_onestar(movie m, int num) throws SQLException
    {
        String Query = "UPDATE MOVIE\n" +
                       "SET ONE_STAR = "+ num +"\n" +
                       "WHERE TITLE = '"+ m.title +"'";
        
        s.executeUpdate(Query);
    }
    public void set_movie_twostar(movie m, int num) throws SQLException
    {
        String Query = "UPDATE MOVIE\n" +
                       "SET TWO_STAR = "+ num +"\n" +
                       "WHERE TITLE = '"+ m.title +"'";
        
        s.executeUpdate(Query);
    }
    public void set_movie_threeestar(movie m, int num) throws SQLException
    {
        String Query = "UPDATE MOVIE\n" +
                       "SET THREE_STAR = "+ num +"\n" +
                       "WHERE TITLE = '"+ m.title +"'";
        
        s.executeUpdate(Query);
    }
    public void set_movie_fourstar(movie m, int num) throws SQLException
    {
        String Query = "UPDATE MOVIE\n" +
                       "SET FOUR_STAR = "+ num +"\n" +
                       "WHERE TITLE = '"+ m.title +"'";
        
        s.executeUpdate(Query);
    }
    public void set_movie_fivestar(movie m, int num) throws SQLException
    {
        String Query = "UPDATE MOVIE\n" +
                       "SET FIVE_STAR = "+ num +"\n" +
                       "WHERE TITLE = '"+ m.title +"'";
        
        s.executeUpdate(Query);
    }
    
    
    public void set_tvshow_onestar(tvshow tv, int num) throws SQLException
    {
        String Query = "UPDATE TVSHOW\n" +
                       "SET ONE_STAR = "+ num +"\n" +
                       "WHERE TITLE = '"+ tv.title +"'";
        
        s.executeUpdate(Query);
    }
    public void set_tvshow_twostar(tvshow tv, int num) throws SQLException
    {
        String Query = "UPDATE TVSHOW\n" +
                       "SET TWO_STAR = "+ num +"\n" +
                       "WHERE TITLE = '"+ tv.title +"'";
     
        s.executeUpdate(Query);
    }
    public void set_tvshow_threeestar(tvshow tv, int num) throws SQLException
    {
        String Query = "UPDATE TVSHOW\n" +
                       "SET THREE_STAR = "+ num +"\n" +
                       "WHERE TITLE = '"+ tv.title +"'";
        
        s.executeUpdate(Query);
    }
    public void set_tvshow_fourstar(tvshow tv, int num) throws SQLException
    {
        String Query = "UPDATE TVSHOW\n" +
                       "SET FOUR_STAR = "+ num +"\n" +
                       "WHERE TITLE = '"+ tv.title +"'";
        
        s.executeUpdate(Query);
    }
    public void set_tvshow_fivestar(tvshow tv, int num) throws SQLException
    {
        String Query = "UPDATE TVSHOW\n" +
                       "SET FIVE_STAR = "+ num +"\n" +
                       "WHERE TITLE = '"+ tv.title +"'";
        
        s.executeUpdate(Query);
    }
        
    public void add_in_history_database(streaminghistory history) throws SQLException
    {
        Calendar c = Calendar.getInstance();
        c.setTime(history.getDate());
        
        Date currentdate = c.getTime();
      
        java.sql.Date date = new java.sql.Date(currentdate.getTime());
 
        
        String query = "SELECT RATED FROM HISTORY\n" +
                       "WHERE USER_ID = '"+ history.getUser().getEmail() +"' AND CONTENT_TITLE = '"+ history.getTitle() +"'" ;
        
        rs = this.s.executeQuery(query);
        
        boolean rated = false;
        
        while(rs.next())
        {
            rated = rs.getBoolean("RATED");
        }
        
        this.Query = "DELETE FROM HISTORY \n"+
                "WHERE USER_ID = '"+ history.getUser().getEmail() +"' AND CONTENT_TITLE = '"+ history.getTitle() +"'" ;
        
        this.s.executeUpdate(this.Query);
        
        this.Query = "INSERT INTO APP.HISTORY (USER_ID, CONTENT_TITLE, URL, DATE_WATCHED, RATED) \n" +
         "VALUES ('" + history.getUser().email + "', '" + history.getTitle() + "', '"+ history.getUrl() +"', '"+ date +"',"+rated+")";
        
        this.s.executeUpdate(this.Query);
        
    }
    
    public boolean already_rated(String user_id,String title) throws SQLException
    {
        boolean result = false;
        
        this.Query = "SELECT RATED FROM HISTORY \n" +
                     "WHERE USER_ID = '"+ user_id +"' AND CONTENT_TITLE LIKE '"+title + "%'";
        
        rs = this.s.executeQuery(this.Query);
        
        while(rs.next())
        {
            System.out.println("Movie was watched");
            result = rs.getBoolean("RATED");
        }
        
        return result; 
    }
    public void once_rated(String user_id,String title) throws SQLException
    {
        this.Query = "UPDATE HISTORY\n" +
                     "SET RATED = "+ true +"\n"+
                     "WHERE USER_ID = '"+ user_id +"' AND CONTENT_TITLE LIKE '"+title + "%'";
        
        this.s.executeUpdate(this.Query);
        
    }
    public int history_num(User user) throws SQLException
    {
        this.Query = "SELECT COUNT(CONTENT_TITLE) AS NUM FROM HISTORY\n" +
                     "WHERE USER_ID = '" + user.email + "'";
        
        rs = this.s.executeQuery(this.Query);
        int num_of_enteries = 0;
        while(rs.next())
        {
            num_of_enteries = rs.getInt("NUM");
        }
        
        return num_of_enteries;
    }
    
    public ArrayList<String> get_history(User user) throws SQLException
    {
        ArrayList<String> history = new ArrayList<String>();
        
        this.Query = "SELECT CONTENT_TITLE, URL, DATE_WATCHED FROM HISTORY\n" +
                     "WHERE USER_ID = '"+ user.email +"'";
        
        rs = this.s.executeQuery(this.Query);
        
        String title="";
        String date="";
        String url="";
        
        while(rs.next())
        {
            title= rs.getString("CONTENT_TITLE");
            url = rs.getString("URL");
            date = rs.getString("DATE_WATCHED");
            
            history.add(title);
            history.add(url);
            history.add(date);
        }
        
        return history;
    }
}