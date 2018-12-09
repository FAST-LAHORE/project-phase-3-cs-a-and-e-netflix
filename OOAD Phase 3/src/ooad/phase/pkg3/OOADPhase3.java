/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooad.phase.pkg3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.spi.DirStateFactory.Result;

/**
 *
 * @author Arsalan Nawaz
 */
public class OOADPhase3 {

Connection c;

String url="jdbc:derby://localhost:1527/Netflix";
String name="Arsalan";
String pass="12345";

OOADPhase3() throws SQLException
{
        c=DriverManager.getConnection(url,name,pass);
}
ResultSet RecommendByGenre(String g)
{
    String query="SELECT * FROM MOVIE WHERE GENRE=? AND FOUR_STAR > THREE_STAR";

    PreparedStatement s;
ResultSet r=null;
    try {
        
        s=c.prepareStatement(query);
        s.setString(1, g);
        r=s.executeQuery();
        return r;
    } 
    catch (SQLException ex) {
        Logger.getLogger(OOADPhase3.class.getName()).log(Level.SEVERE, null, ex);
    }
    return r;
}


void saveresumePoint(String em,int rp) throws SQLException
{
    String query="INSERT INTO ARSALAN.RESUMEPOINT (USERID, RESUMEPOINT) "+"VALUES (?, ?)";

    PreparedStatement s=c.prepareStatement(query);
    s.setString(1, em);
    s.setInt(2, rp);
    s.executeUpdate();
}

    static OOADPhase3 obj;
    public static void main(String[] args) throws SQLException {
       
      
        obj =new OOADPhase3();
        
        Recommendation frame=new Recommendation();
        frame.setVisible(true);
       
       
    }
    
}
