/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netflix.pkg2;

import java.sql.SQLException;

/**
 *
 * @author hp
 */
public class historymanagement {
    
    private Database db;
    
    public historymanagement()
    {
        db = new Database();
    }
    
    public void addhistory(streaminghistory history) throws SQLException
    {
        db.add_in_history_database(history);
    }
    
    
}
