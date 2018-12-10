/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netflix;
import java.util.ArrayList;
/**
 *
 * @author MianSaqib
 */
public class MediaContent {
    private static ArrayList<Movie> M = new ArrayList();
    private static ArrayList<TVshow> T = new ArrayList();
    
    MediaContent(){};
    
    public static ArrayList<Movie> getInitMovie(){
        return M;
    }
    public static ArrayList<TVshow> getInitTvshow(){
        return T;
    }
    
    public static void addMovie(Movie Mo){
        M.add(Mo);
    }
    public static void addTvshow(TVshow Tv){
        T.add(Tv);
    }
    
    public static void remMovie(Movie Mo){
        M.remove(Mo);
    }
    
    public static void remTvshow(TVshow Tv){
        T.remove(Tv);
    }
    
}
