/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netflix.pkg2;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class TvshowController implements Initializable {

    @FXML
    private AnchorPane rootpane;
    @FXML
    private Button cross;
    @FXML
    private Button backbutton;
    @FXML
    private Text genre;
    @FXML
    private Button homebutton;
    @FXML
    private Button historybutton;
    @FXML
    private ProgressBar onebar;
    @FXML
    private ProgressBar twobar;
    @FXML
    private ProgressBar threebar;
    @FXML
    private ProgressBar fourbar;
    @FXML
    private ProgressBar fivebar;
    @FXML
    private Button ratebutton;
    @FXML
    private ComboBox selectseason;
    
    @FXML
    private ComboBox selectepisode;
    @FXML
    private Button HDbutton;
    @FXML
    private Button SDbutton;
    @FXML
    private Button UHDbutton;

    
    @FXML
    private Text tvshowtitle;
    @FXML
    private Text release_date;
    
    private tvshow selected_tvshow;
    private int season_num;
    private int episode_num;
    private String sdurl;
    private String hdurl;
    private String uhdurl;
    private User user;
    
    @FXML
    private ImageView tvshowimg;
    @FXML
    private Text overallrating;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    @FXML
    private void crosspressed(ActionEvent event) {
        Node  source = (Node)  event.getSource(); 
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        Node  source = (Node)  event.getSource(); 
        Stage stage  = (Stage) source.getScene().getWindow();
    
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void openhistory(ActionEvent event) throws IOException, SQLException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("history.fxml"));
        loader.load();
        
        // movie to be rated is passed
        HistoryController hc = loader.getController();
        hc.set_user(this.user);
        
        //new window opened
        Stage stage  = new Stage();
        Parent root = loader.getRoot();
        stage.setScene(new Scene(root));
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }

    @FXML
    private void openratingpage(ActionEvent event) throws IOException, SQLException {
        
        Database db = new Database();
        boolean israted = db.already_rated(this.user.email, this.tvshowtitle.getText());
        
        if(!israted)
        {
            // load the fxml
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("ratepopup.fxml"));
            loader.load();

            // movie to be rated is passed
            RatepopupController rp = loader.getController();
            System.out.println(this.selected_tvshow.title);
            rp.settvshow(this.selected_tvshow);
            rp.setUser(this.user);

            //new window opened
            Stage stage  = new Stage();
            Parent root = loader.getRoot();
            stage.setScene(new Scene(root));
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();
        }
        else
        {
            // load the fxml
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("popup.fxml"));
            loader.load();

            // movie to be rated is passed
            PopupController pc = loader.getController();
            pc.set(" You have Already Rated the Movie");

            //new window opened
            Stage stage  = new Stage();
            Parent root = loader.getRoot();
            stage.setScene(new Scene(root));
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();
        }
    }

    @FXML
    private void StreaminHD(ActionEvent event) throws IOException, SQLException {
        String plan_type = this.user.getPlan();
        if(plan_type.equals("Standard") || plan_type.equals("Premium"))
        {
            Date date = new Date();
            streaminghistory history = new streaminghistory(this.user,this.tvshowtitle.getText()+" "+this.selected_tvshow.seasons.get(this.season_num-1).episodes.get(episode_num-1).gettitle(),this.hdurl,date);
            
            historymanagement historymanager = new historymanagement();
            
            historymanager.addhistory(history);

            FXMLLoader loader = new FXMLLoader();
            System.out.println("videoplayer not called yed");
            loader.setLocation(getClass().getResource("videopalayer.fxml"));

            System.out.println("videoplayed called");



            loader.load();
            System.out.println("loader.load() called");

            VideopalayerController playnow = loader.getController();
            playnow.setvideourl(this.hdurl);
            playnow.setmovietitle(this.selected_tvshow.seasons.get(this.season_num-1).episodes.get(episode_num-1).gettitle());
            playnow.setmedia();


            Stage stage = new Stage();
            Parent root = loader.getRoot();
            stage.setScene(new Scene(root));
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();
        }
        else
        {
            // load the fxml
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("popup.fxml"));
            loader.load();

            // movie to be rated is passed
            PopupController pc = loader.getController();
            pc.set("Feature Not Available to " + plan_type + " Subscription");

            //new window opened
            Stage stage  = new Stage();
            Parent root = loader.getRoot();
            stage.setScene(new Scene(root));
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();
        }
    }

    @FXML
    private void streaminSD(ActionEvent event) throws IOException, SQLException {

        Date date = new Date();
            streaminghistory history = new streaminghistory(this.user,this.tvshowtitle.getText()+" "+this.selected_tvshow.seasons.get(this.season_num-1).episodes.get(episode_num-1).gettitle(),this.sdurl,date);
            
            historymanagement historymanager = new historymanagement();
            
            historymanager.addhistory(history);

        FXMLLoader loader = new FXMLLoader();
        System.out.println("videoplayer not called yed");
        loader.setLocation(getClass().getResource("videopalayer.fxml"));

        System.out.println("videoplayed called");



        loader.load();
        System.out.println("loader.load() called");

        VideopalayerController playnow = loader.getController();
        playnow.setvideourl(this.sdurl);
        playnow.setmovietitle(this.selected_tvshow.seasons.get(this.season_num-1).episodes.get(episode_num-1).gettitle());
        playnow.setmedia();


        Stage stage =  new Stage();
        Parent root = loader.getRoot();
        stage.setScene(new Scene(root));
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();

    }

    @FXML
    private void streaminUHD(ActionEvent event) throws IOException, SQLException {
        String plan_type = this.user.getPlan();
        if(plan_type.equals("Premium"))
        {
            //updating history
            Date date = new Date();
            streaminghistory history = new streaminghistory(this.user,this.tvshowtitle.getText()+" "+this.selected_tvshow.seasons.get(this.season_num-1).episodes.get(episode_num-1).gettitle(),this.uhdurl,date);
            historymanagement historymanager = new historymanagement();
            historymanager.addhistory(history);
            
            FXMLLoader loader = new FXMLLoader();
            System.out.println("videoplayer not called yed");
            loader.setLocation(getClass().getResource("videopalayer.fxml"));

            System.out.println("videoplayed called");



            loader.load();
            System.out.println("loader.load() called");

            VideopalayerController playnow = loader.getController();
            playnow.setvideourl(this.uhdurl);
            playnow.setmovietitle(this.selected_tvshow.seasons.get(this.season_num-1).episodes.get(episode_num-1).gettitle());
            playnow.setmedia();

            Stage stage = new Stage();
            Parent root = loader.getRoot();
            stage.setScene(new Scene(root));
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();
        }
        else
        {
            // load the fxml
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("popup.fxml"));
            loader.load();

            // movie to be rated is passed
            PopupController pc = loader.getController();
            pc.set("Feature Not Available to " + plan_type + " Subscription");

            //new window opened
            Stage stage  = new Stage();
            Parent root = loader.getRoot();
            stage.setScene(new Scene(root));
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();
        }
    }
    
    public void settvshow(tvshow tv)
    {
        this.selected_tvshow=tv;
        
        
        this.tvshowtitle.setText(tv.title);
        this.release_date.setText(tv.release_date);
        
        String s = "Season ";
        int season_num =0;
        
        for(int i=0; i<tv.seasons.size(); i++)
        {
            season_num=i+1;
            this.selectseason.getItems().add(s+season_num);
        }
        this.setImage();
        this.setratingui();
    }
    
    @FXML
    private void seasonselected(ActionEvent event) {
        
        this.selectepisode.getItems().clear();
        
        // extract the season number from selected season
        Scanner sc = new Scanner((String) this.selectseason.getValue());
        sc.skip("[^0-9]*");
        this.season_num = sc.nextInt();
        
        int seasontoget = this.season_num -1;
        ArrayList<season> s = this.selected_tvshow.seasons;
        season se = s.get(seasontoget);
        
        int ep =0;
        for(int i=0; i < se.episodes.size(); i++)  
        {
            ep = i+1;
            this.selectepisode.getItems().add("Episode "+ep);
        }
        this.sdurl="";
        this.hdurl="";
        this.uhdurl=" ";
    }

    @FXML
    private void episodeselected(ActionEvent event) {
        
        // extract the season number from selected season
        Scanner sc = new Scanner((String) this.selectepisode.getValue());
        sc.skip("[^0-9]*");
        this.episode_num = sc.nextInt();
        
        ArrayList<season> s = this.selected_tvshow.seasons;
        
        int seasontoget = this.season_num -1;
        season se = s.get(seasontoget);
        ArrayList<episode> e = se.episodes;
        int episodetoget =this.episode_num-1;
        episode ep = e.get(episodetoget);
        
        
        this.sdurl=ep.sdurl;
        this.hdurl=ep.hdurl;
        this.uhdurl=ep.uhdurl;
        
    }
    
    public void setImage()
    {
        Image image = new Image(this.selected_tvshow.imgurl);
        
        this.tvshowimg.setImage(image);
    }
    public void setratingui()
    {
        double one;
        double two;
        double three;
        double four;
        double five;
        
        one = this.selected_tvshow.rating.onestar;
        two = this.selected_tvshow.rating.twostar;
        three =this.selected_tvshow.rating.threestar;
        four = this.selected_tvshow.rating.fourstar;
        five = this.selected_tvshow.rating.fivestar;
        
        double total_responses = one+two+three+four+five;
        
        this.onebar.setProgress(one/total_responses);
        this.twobar.setProgress(two/total_responses);
        this.threebar.setProgress(three/total_responses);
        this.fourbar.setProgress(four/total_responses);
        this.fivebar.setProgress(five/total_responses);
        
        String rating ="";
        for(double i=1; i <= this.selected_tvshow.rating.getoverallrating(); i++)
        {
            rating=rating+"🌟";
        }
        this.overallrating.setText(""+this.selected_tvshow.rating.getoverallrating()+"/5 " +rating);
        
    }
    
    public void setUser(User user)
    {
        this.user = user;
    }
}

