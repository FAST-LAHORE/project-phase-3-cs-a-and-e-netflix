/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netflixproject;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    private Database()
    {
        String URL = "jdbc:derby://localhost:1527/Netflix";
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
    
    public static Database getInstance(){
        if(database == null){
            database = new Database();
        } 
        return database;
    }
    
    
    
    public Boolean isExistingAccount(String account){
         try {
            Query = "Select * from users where account='" + account + "'";
            rs = this.s.executeQuery(Query);
            if (rs.next()){
                return false;
            } else return true;
           
        } catch (SQLException ex) {
            Logger.getLogger(NetflixProject.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
      public Boolean isExistingEmail(String email){
         try {
            Query = "Select * from users where email='" + email + "'";
            rs = this.s.executeQuery(Query);
            if (rs.next()){
                return false;
            } else return true;
           
        } catch (SQLException ex) {
            Logger.getLogger(NetflixProject.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    void SelectAll()
    {
        try {
            Query = "Select * from users";
            rs = this.s.executeQuery(Query);
            while(rs.next())
            {
                String account = rs.getString("account");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String password = rs.getString("password");
                int plan = rs.getInt("plan");
                
                System.out.println("Account: " + account);
                System.out.println("Name: " + name);
                System.out.println("Email: " + email);
                System.out.println("Password: " + password);
                System.out.println("Plan: " + plan);

            }
        } catch (SQLException ex) {
            Logger.getLogger(NetflixProject.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    public int registerUser(String name, String account, String email, String password, int Plan)
    {
        if(!isExistingEmail(email)){
            return -1;
        }
        
        if (!isExistingAccount(account)){
            return -2;
        }
        
        String pass = getPasswordHash(password, salt);
        try 
        {
          Query = "INSERT INTO users VALUES (" + "'" + email + "'"  + "," + "'" + account + "'" + "," + "'" + name + "'" + "," + "'" + pass + "'" + "," + Plan + ")";
          int count1 = s.executeUpdate(Query);
          Query = "Insert into plan values (" + "'" + email + "'"  + "," + Plan + "," + "'" + getcurrentDate()+ "')";
          int count2 = s.executeUpdate(Query);
          if(count1 >= 1 && count2 >= 1){
              return 0;
          }
        }
        
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        
        return -3;
    }
    
    public int authenticateUser(String email, String password){
         try {
            Query = "Select * from users where email='" + email + "'";
            rs = this.s.executeQuery(Query);
            while(this.rs.next())
            {
                String savedPass = rs.getString("password");
                String date = getTermination(email);
                int plan = getPlan(email);
                if (plan == -1){
                    return 1;
                }
                else
                {
                    if(!checkDeadline(date, plan)){
                        return 2;
                    }
                }
                
                String enteredPassword = getPasswordHash(password, salt);
                if(savedPass.matches(enteredPassword)){
                    
                    return 0;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(NetflixProject.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        return -1;
    }
    
    public Boolean checkPassword(String email, String password){
        try {
            Query = "Select * from users where email='" + email + "'";
            rs = this.s.executeQuery(Query);
            while(this.rs.next())
            {
                String savedPass = rs.getString("password");
                String enteredPassword = getPasswordHash(password, salt);
                if(savedPass.matches(enteredPassword)){
                    
                    return true;
                } 
            }
        } catch (SQLException ex) {
            Logger.getLogger(NetflixProject.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        return false;
    }
    
    
    public Boolean updateInfo(String email, String account, String name, String password){
        Boolean check = false;
        if(account.length()> 0 || name.length() > 0 || password.length() > 0){
            if(!account.matches("")){
                check = updateBank(email, account);
            }

            if(!name.matches("")){
                check = updateName(email, name);
            }

            if(!password.matches("")){
                check = updatePassword(email, password);
            } 
            
            return check;
        } 
        
        return false;
        
    }
    
    public Boolean updateBank(String email, String account){
        try {
            Query = "Update users set account = '" + account + "' where email='" + email + "'";
            int count = s.executeUpdate(Query);
            if(count >= 1){
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
         
        return false;
    }
    
    
    public Boolean updateName(String email, String name){
        try {
            Query = "Update users set name = '" + name + "' where email='" + email + "'";
            int count = s.executeUpdate(Query);
            if(count >= 1){
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
         
        return false;
    }
    
    public Boolean updatePassword(String email, String password){
        try {
            Query = "Update users set password = '" + getPasswordHash(password, salt) + "' where email='" + email + "'";
            int count = s.executeUpdate(Query);
            if(count >= 1){
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
         
        return false;
    }
    
    public Boolean updatePlan(String email, int plan){
         try {
            Query = "Update users set plan = " + plan + " where email='" + email + "'";
            int count1 = s.executeUpdate(Query);
            Query = "Update plan set plan = " + plan + ", termination='" + getcurrentDate() +"' where email='" + email + "'";
            int count2 = s.executeUpdate(Query);
            if(count1 >= 1 && count2>=1)
            {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
         
        return false;
    }
    
    public Boolean removePlan(String email){
        try {
            Query = "Update users set plan = -1 where email='" + email + "'";  
            int count1 = s.executeUpdate(Query);
            Query = "Update plan set plan = -1 where email='" + email + "'";
            int count2 = s.executeUpdate(Query);
            if(count1 >= 1 && count2>=1)
            {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
         
        return false;
    }
    
    public int getPlan(String email){
         try {
            Query = "Select plan from users where email = '" + email + "'";
           
            rs = this.s.executeQuery(Query);
            if(rs.next()){
                int plan = rs.getInt("plan");
                return plan;
            }
        } catch (SQLException ex) {
            Logger.getLogger(NetflixProject.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
    
    public String getTermination(String email){
     try {
            Query = "Select termination from plan where email = '" + email + "'";
           
            rs = this.s.executeQuery(Query);
            if(rs.next()){
                String date  = rs.getString("termination");
                return date;
            }
        } catch (SQLException ex) {
            Logger.getLogger(NetflixProject.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    
    public String getName(String email){
          try {
            Query = "Select name from users where email = '" + email + "'";
           
            rs = this.s.executeQuery(Query);
            if(rs.next()){
                String name = rs.getString("name");
                return name;
            }
        } catch (SQLException ex) {
            Logger.getLogger(NetflixProject.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    
    public String getAccount(String email){
          try {
            Query = "Select account from users where email = '" + email + "'";
           
            rs = this.s.executeQuery(Query);
            if(rs.next()){
                String account = rs.getString("account");
                return account;
            }
        } catch (SQLException ex) {
            Logger.getLogger(NetflixProject.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    } 
    
    public String getPassword(String email){
          try {
            Query = "Select password from users where email = '" + email + "'";
           
            rs = this.s.executeQuery(Query);
            if(rs.next()){
                String pass = rs.getString("password");
                return pass;
            }
        } catch (SQLException ex) {
            Logger.getLogger(NetflixProject.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    
    public String getcurrentDate(){
          
        return (new java.sql.Date(System.currentTimeMillis())).toString();
         
    }
    
    private String getPasswordHash(String password, byte [] salt){
           
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(salt);
            byte[] bytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            return sb.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        return null;
    }
    
    private String[] toArray(String s) {
    return s.split("(?!^)");
}
    
    
    private Boolean checkDeadline(String deadline, int plan){
        String year = "";
        String month = "";
        String day = "";
        String year1 = "";
        String month1 = "";
        String day1 = "";
        String [] date = toArray(deadline);
        String [] today = toArray(getcurrentDate());
        
        
        for (int i = 0 ; i<date.length; ++i){
           if(i <= 3){
              year+= date[i];
              year1+=today[i];
           } 
           
           else if (i>4 && i<=6){
               month+=date[i];
               month1+=today[i];
           }
           else if(i>7 && i<=9){
               day+=date[i];
               day1+=today[i];
           } 
        }
        
        int y = Integer.valueOf(year);
        int m = Integer.valueOf(month);
        int d = Integer.valueOf(day);
        
        int y1 = Integer.valueOf(year1);
        int m1 = Integer.valueOf(month1);
        int d1 = Integer.valueOf(day1);
        
        
        
        if (plan == 0){
            if(y1 > y){
                return false;
            } else if(y1 == y){
                if (m1 == m){
                    if (d1 - d >= 30){
                        return false;
                    }
                } else if (m1 > m){
                    return false;
                }
            }
        }
        return true;   
    }
}

