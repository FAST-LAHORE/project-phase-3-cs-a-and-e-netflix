/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netflix.pkg2;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author hp
 */
public class FXMLDocumentController implements Initializable {
   
    @FXML
    private Button cross;
    @FXML
    private Button loginButton;
    @FXML
    private Button signup;
    @FXML
    private Button button;
    @FXML
    private Button button2;
    @FXML
    private AnchorPane rootpane;
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        
        Node  source = (Node)  event.getSource(); 
        Stage stage  = (Stage) source.getScene().getWindow();
    
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void windowclosed(ActionEvent event) {
        Node  source = (Node)  event.getSource(); 
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void signup(ActionEvent event) throws IOException {
        Node  source = (Node)  event.getSource(); 
        Stage stage  = (Stage) source.getScene().getWindow();
    
        Parent root = FXMLLoader.load(getClass().getResource("videopalayer.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void openmovie(ActionEvent event) throws IOException, SQLException {
        
        SubscriptionPlan plan =  new Standard();
        User user =  new User();
        user.setName("Mahad Sajeel");
        user.setEmail("mahad@gmail.com");
        user.setPassword("mahad");
        user.setBankAccount("50000");
        user.setPlan(plan);
        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ratingpage.fxml"));
        loader.load();
        
        RatingpageController rpcontroller = loader.getController();
        
        
        
        //data from database
        String title = this.button.getText();
        
        Database db =new Database();
        
        
        
        String movietitle = title;
        String release_date = db.get_movie_release_date(title);
        System.out.println(release_date);
        String runtime=db.get_movie_runtime(title);
        String sdurl = db.get_movie_sd(title);
        String hdurl = db.get_movie_hd(title);
        String uhdurl = db.get_movie_uhd(title);
        String movie_imgurl = db.get_movie_img(title);
        System.out.println(movie_imgurl);
        
        // making a movie object from data extracted from database
        movie selected_movie = new movie(movietitle,release_date,runtime);
        selected_movie.setRating(db.get_movie_one_star(title),db.get_movie_two_star(title),
                db.get_movie_three_star(title),db.get_movie_four_star(title),db.get_movie_five_star(title));
        selected_movie.seturls(sdurl, hdurl, uhdurl, movie_imgurl);
        
        //sent the movie to ratingpage
        rpcontroller.setmovie(selected_movie);
        rpcontroller.setUser(user);
        
        //new window opened
        Parent root = loader.getRoot();
        
        Scene scene = button.getScene();
        
        root.translateYProperty().set(scene.getHeight());
        rootpane.getChildren().add(root);
        
        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateYProperty(),0,Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(0.5),kv);
        timeline.getKeyFrames().add(kf);
        timeline.play();
    }

    @FXML
    private void opentvshow(ActionEvent event) throws IOException, SQLException {
        
        //user set
        SubscriptionPlan plan =  new Standard();
        User user =  new User();
        user.setName("Mahad Sajeel");
        user.setEmail("mahad@gmail.com");
        user.setPassword("mahad");
        user.setBankAccount("50000");
        user.setPlan(plan);
        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("tvshow.fxml"));
        loader.load();
        
        //data from database
        
        Database db = new Database();
        
        //tvshowdetails
        String title = this.button2.getText();
        
        String tvshowtitle = title;
        String release_date = db.get_tvshow_release_date(title);
        String tvshow_imgurl = db.get_tvshow_img(title);
        
        tvshow tv = new tvshow(tvshowtitle,release_date,tvshow_imgurl);
        
        tv.setRating(db.get_tvshow_one_star(title),db.get_tvshow_two_star(title),
                db.get_tvshow_three_star(title),db.get_tvshow_four_star(title),
                db.get_tvshow_five_star(title));
        System.out.println("tvshow-created");
        
        
        int num_of_seasons = db.get_tvshow_season_num(title);
        
        System.out.println(num_of_seasons);
        
        for (int i=0; i<num_of_seasons; i++)
        {
            tv.addnewseason();
            System.out.println("season-added");
            
            int real_season_num = i+1;
            System.out.println("Season "+real_season_num+"created");
            
            int episode_num = db.get_season_episode_num(title,real_season_num);
            System.out.println(episode_num);
            
            for(int j=0; j<episode_num; j++)
            {
                int real_episode_num = j+1;
                
                String eptitle = db.get_episode_title(title,real_season_num,real_episode_num);
                String ep_sdurl = db.get_episode_sd(title,real_season_num,real_episode_num);
                String ep_hdurl = db.get_episode_hd(title,real_season_num,real_episode_num);
                String ep_uhdurl = db.get_episode_hd(title,real_season_num,real_episode_num);

                tv.seasons.get(i).addepisode(eptitle,"", ep_sdurl, ep_hdurl, ep_uhdurl);
                
                System.out.println("Episode" + real_episode_num + "added");
            }
            
        }
        
        //add tvshow in tvshowpage
        
        TvshowController tvshow_controller = loader.getController();
        tvshow_controller.settvshow(tv);
        tvshow_controller.setUser(user);
        
        //new window opened
       Parent root = loader.getRoot();
        
        Scene scene = button.getScene();
        
        root.translateYProperty().set(scene.getHeight());
        rootpane.getChildren().add(root);
        
        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateYProperty(),0,Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(0.5),kv);
        timeline.getKeyFrames().add(kf);
        timeline.play();
       
        
        
    }
    
}
