/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netflix.pkg2;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class RatepopupController implements Initializable {

    
    public movie movietorate;
    public tvshow tvshowtorate;
    public User user;
    
    @FXML
    private RadioButton onestar;
    @FXML
    private Button confirmrating;
    @FXML
    private RadioButton twostar;
    @FXML
    private RadioButton threestar;
    @FXML
    private RadioButton fourstar;
    @FXML
    private RadioButton fivestar;
    
    
    @FXML
    private ToggleGroup rate;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.movietorate = null;
        this.tvshowtorate = null;
        this.user = user;
    }    
    
    @FXML
    private void ratingupdate(ActionEvent event) throws SQLException {
        
        Database db = new Database();
        
        Node  source = (Node)  event.getSource(); 
        Stage stage  = (Stage) source.getScene().getWindow();
        int num =0;
        
        
        System.out.println("calling updaterating");
        
        if(this.movietorate != null)
        {
            db.once_rated(this.user.email, this.movietorate.title);
            if(onestar.isSelected())
            {
                num = db.get_movie_one_star(this.movietorate.title);
                num++;
                db.set_movie_onestar(this.movietorate,num);
            }
            else
            {
                if(twostar.isSelected())
                {
                    num = db.get_movie_two_star(this.movietorate.title);
                    num++;
                    db.set_movie_twostar(this.movietorate,num);
                }
                else
                {
                    if(threestar.isSelected())
                    {
                        num = db.get_movie_three_star(this.movietorate.title);
                        num++;
                        db.set_movie_threeestar(this.movietorate,num);
                    }
                    else
                    {
                        if(fourstar.isSelected())
                        {
                            num = db.get_movie_four_star(this.movietorate.title);
                            num++;
                            db.set_movie_fourstar(this.movietorate,num);
                        }
                        else
                        {
                            num = db.get_movie_five_star(this.movietorate.title);
                            num++;
                            db.set_movie_fivestar(this.movietorate,num);
                        }
                    }
                }
            }
        }
        else
        {
            db.once_rated(this.user.email, this.tvshowtorate.title);
            if(onestar.isSelected())
            {
                num = db.get_tvshow_one_star(this.tvshowtorate.title);
                num++;
                db.set_tvshow_onestar(this.tvshowtorate,num);
            }
            else
            {
                if(twostar.isSelected())
                {
                    num = db.get_tvshow_two_star(this.tvshowtorate.title);
                    num++;
                    db.set_tvshow_twostar(this.tvshowtorate,num);
                }
                else
                {
                    if(threestar.isSelected())
                    {
                        num = db.get_tvshow_three_star(this.tvshowtorate.title);
                        num++;
                        db.set_tvshow_threeestar(this.tvshowtorate,num);
                    }
                    else
                    {
                        if(fourstar.isSelected())
                        {
                            num = db.get_tvshow_four_star(this.tvshowtorate.title);
                            num++;
                            db.set_tvshow_fourstar(this.tvshowtorate,num);
                        }
                        else
                        {
                            num = db.get_tvshow_five_star(this.tvshowtorate.title);
                            num++;
                            db.set_tvshow_fivestar(this.tvshowtorate,num);
                        }
                    }
                }
            }
        }
        
        stage.close();
        
    }
    
    
    
    public void setmovie(movie m)
    {
        this.movietorate = m;
    }
    public void settvshow(tvshow tv)
    {
        this.tvshowtorate = tv;
    }
    public void setUser(User user)
    {
        this.user = user;
    }
    
}
