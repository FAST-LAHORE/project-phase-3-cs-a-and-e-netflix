/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netflix.pkg2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.media.Media;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class LoadingpageController implements Initializable {

    @FXML
    private AnchorPane rootpane;
    @FXML
    private MediaView mediaview;
    
    private Media media;
    private MediaPlayer mediaplayer;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String videourl = "file:///C:/Users/hp/Documents/NetBeansProjects/netflix-2/src/netflix/images/opening.MP4";
        media = new Media(videourl);
        
        mediaplayer = new MediaPlayer(media);
        
        mediaview.setFitHeight(535);
        mediaview.setFitWidth(940);
        
        mediaview.setMediaPlayer(mediaplayer);
        mediaplayer.setAutoPlay(true);
        new loadingpage().start();
    }    
    
    class loadingpage extends Thread
    {
        @Override
        public void run()
        {
            try 
            {
                Thread.sleep(5000);
                
                Platform.runLater(new Runnable()
                {
                    @Override
                    public void run() 
                    {
                        Parent root2=null;
                        try {
                            root2 = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
                        } catch (IOException ex) {
                            Logger.getLogger(LoadingpageController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        Stage stage2 = new Stage();
                        Scene scene2 = new Scene(root2);
                        stage2.initStyle(StageStyle.UNDECORATED);
                        stage2.setScene(scene2);
                        rootpane.getScene().getWindow().hide();
                        stage2.show();
                    }
                    
                });
            } 
            catch (InterruptedException ex) 
            {
                Logger.getLogger(LoadingpageController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
