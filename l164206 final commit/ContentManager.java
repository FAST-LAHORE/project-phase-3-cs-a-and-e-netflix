/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netflix_administration;

import java.util.ArrayList;

/**
 *
 * @author MianSaqib
 */
public class ContentManager {
    private static ContentManager CM = new ContentManager();
    private ArrayList<Movie> M;
    private ArrayList<TVshow> T;
    private ContentManager(){
        M = MediaContent.getInitMovie();
        T = MediaContent.getInitTvshow();
    }
    
    public static ContentManager getInit(){
        return CM;
    }
    
    public void addNewMovie(Movie m){
        MediaContent.addMovie(m);
    }
    
    public void addNewTVshow(TVshow t){
        MediaContent.addTvshow(t);
    }
    
    public void deleteMovie(String T){
        for(int i = 0; i < M.size(); i++){
            if(M.get(i).getN().compareTo(T) == 0){
                Movie m = M.get(i);
                MediaContent.remMovie(m);
            }
        }
    }
    
    public void deleteTVshow(String Ti){
        for(int i = 0; i < T.size(); i++){
            if(M.get(i).getN().compareTo(Ti) == 0){
                Movie m = M.get(i);
                MediaContent.remMovie(m);
            }
        }
    }
}

