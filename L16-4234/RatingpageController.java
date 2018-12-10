package netflix.pkg2;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class RatingpageController implements Initializable {
    
    private String hdurl;
    private String sdurl;
    private String uhdurl;
    private movie selected_movie;
    private User user;
    
    @FXML
    private AnchorPane rootpane;
    @FXML
    private Button cross;
    private RadioButton onestar;
    private RadioButton twostar;
    private RadioButton threestar;
    private RadioButton fourstar;
    @FXML
    private Button backbutton;
    @FXML
    private Text movietitle;
    @FXML
    private Text genre;
    @FXML
    private ImageView movieimage;
    @FXML
    private Button HDbutton;
    @FXML
    private Button SDbutton;
    @FXML
    private Button UHDbutton;
    @FXML
    private Button homebutton;
    @FXML
    private Button historybutton;
    
    @FXML
    private Text runtime;
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
    private Text overallrating;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        hdurl = null;
        sdurl=null;
        uhdurl=null;
        selected_movie=null;
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
    private void crosspressed(ActionEvent event) {
        Node  source = (Node)  event.getSource(); 
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();
    }
    
    public void setmovie(movie m)
    {
        this.selected_movie = m;
        this.setmovietitle(this.selected_movie.title);
        this.setImage(this.selected_movie.imgurl);
        this.setsdurl(this.selected_movie.sdurl);
        this.sethdurl(this.selected_movie.hdurl);
        this.setuhdurl(this.selected_movie.uhdurl);
        this.setruntime(this.selected_movie.getruntime());
        setratingui();
        
    }
    public void setratingui()
    {
        double one;
        double two;
        double three;
        double four;
        double five;
        
        one = (this.selected_movie.rating.onestar);
        two = this.selected_movie.rating.twostar;
        three =this.selected_movie.rating.threestar;
        four = this.selected_movie.rating.fourstar;
        five = this.selected_movie.rating.fivestar;
        
        double total_responses = one+two+three+four+five;
        
        this.onebar.setProgress(one/total_responses);
        this.twobar.setProgress(two/total_responses);
        this.threebar.setProgress(three/total_responses);
        this.fourbar.setProgress(four/total_responses);
        this.fivebar.setProgress(five/total_responses);
        
        String rating ="";
        for(double i=1; i <= this.selected_movie.rating.getoverallrating(); i++)
        {
            rating=rating+"🌟";
        }
        this.overallrating.setText(""+this.selected_movie.rating.getoverallrating()+"/5 " +rating);
        
        
    }
    public void setgenre(String s)
    {
        genre.setText(s);
    }
    private void setmovietitle(String s)
    {
        movietitle.setText(s);
    }
    private void setImage(String url)
    {
        Image image = new Image(url);
        
        movieimage.setImage(image);
    }
    private void sethdurl(String url)
    {
        this.hdurl = url;
    }
    private void setsdurl(String url)
    {
        this.sdurl=url;
    }
    private void setuhdurl(String url)
    {
        this.uhdurl=url;
    }
    private void setruntime(String runtime)
    {
        this.runtime.setText(runtime);
    }
    
    public void setUser(User user)
    {
        this.user= user;
        
        this.user.display();
    }
    
    
    
    @FXML
    private void StreaminHD(ActionEvent event) throws IOException, SQLException {
        String plan_type = this.user.getPlan();
        if(plan_type.equals("Standard") || plan_type.equals("Premium"))
        {
            Date date = new Date();
            streaminghistory history = new streaminghistory(this.user,this.selected_movie.title,this.selected_movie.hdurl,date);
            
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
            playnow.setmovietitle(this.movietitle.getText());
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
            streaminghistory history = new streaminghistory(this.user,this.selected_movie.title,this.selected_movie.sdurl,date);
            
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
            playnow.setmovietitle(this.movietitle.getText());
            playnow.setmedia();


            
            Stage stage = new Stage();
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
            Date date = new Date();
            streaminghistory history = new streaminghistory(this.user,this.selected_movie.title,this.selected_movie.uhdurl,date);
            
            historymanagement historymanager = new historymanagement();
            
            historymanager.addhistory(history);
            
            Node  source = (Node)  event.getSource(); 
            Stage stage  = (Stage) source.getScene().getWindow();


            FXMLLoader loader = new FXMLLoader();
            System.out.println("videoplayer not called yed");
            loader.setLocation(getClass().getResource("videopalayer.fxml"));

            System.out.println("videoplayed called");



            loader.load();
            System.out.println("loader.load() called");

            VideopalayerController playnow = loader.getController();
            playnow.setvideourl(this.uhdurl);
            playnow.setmovietitle(this.movietitle.getText());
            playnow.setmedia();


            Parent root = loader.getRoot();
            stage.setScene(new Scene(root));
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
        boolean israted = db.already_rated(this.user.email, this.movietitle.getText());
        
        if(!israted)
        {
            // load the fxml
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("ratepopup.fxml"));
            loader.load();

            // movie to be rated is passed
            RatepopupController rp = loader.getController();
            rp.setmovie(this.selected_movie);
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
    
}
