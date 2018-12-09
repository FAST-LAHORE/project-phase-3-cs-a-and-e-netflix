/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooad.phase.pkg3;

import java.sql.ResultSet;
import static ooad.phase.pkg3.OOADPhase3.obj;

/**
 *
 * @author Arsalan Nawaz
 */
public class Recommender 
{
 
    ResultSet recommendByGenre(String g)
    {
        return obj.RecommendByGenre(g);
    }
    
    /*ResultSet recommendBySimilarity()
    {
    
    }*/
}
