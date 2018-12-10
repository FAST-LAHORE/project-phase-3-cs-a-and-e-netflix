/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netflix.pkg2;

import java.io.IOException;
import java.net.URL;
import javafx.util.Duration;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import static javafx.scene.media.MediaPlayer.Status.PLAYING;
import javafx.scene.media.MediaView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class VideopalayerController implements Initializable {

    @FXML
    private Button cross;
    @FXML
    private MediaView mediaview;
    @FXML
    private Button playbutton;
    @FXML
    private Button stopbutton;
    @FXML
    private Button pausebutton;
    
    String videourl;
    Media media;
    MediaPlayer mediaplayer;
    double rate;
    @FXML
    private Text movietitle;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
    public void setmedia()
    {
        media = new Media(videourl);
        
        mediaplayer = new MediaPlayer(media);
        
        mediaview.setFitHeight(500);
        mediaview.setFitWidth(990);
        
        mediaview.setMediaPlayer(mediaplayer);
    }
    
    public void setvideourl(String s)
    {
        System.out.println("Video Url is set");
        this.videourl=s;
    }
    public void setmovietitle(String s)
    {
        this.movietitle.setText(s);
    }
    
    @FXML
    private void windowclosed(ActionEvent event) {
        Node  source = (Node)  event.getSource(); 
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void playbuttonpressed(ActionEvent event) {
        if(mediaplayer.getStatus() != PLAYING)
        {
            mediaplayer.play();
        }
    }

    @FXML
    private void stopbuttonpressed(ActionEvent event) {
        if(mediaplayer.getStatus() == PLAYING)
        {
            mediaplayer.stop();
        }
    }

    @FXML
    private void pausebuttonpressed(ActionEvent event) {
        if(mediaplayer.getStatus() == PLAYING)
        {
            mediaplayer.pause();
        }
    }
}
