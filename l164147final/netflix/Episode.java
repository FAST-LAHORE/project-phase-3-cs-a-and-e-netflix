/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netflix;

/**
 *
 * @author MianSaqib
 */
public class Episode {
    private String Name;
    private java.sql.Timestamp Duration;
    private String Path;
    
    Episode(String Na, java.sql.Timestamp d, String p){
        Name = Na;
        Duration = d;
        Path = p;
    }
    
}
