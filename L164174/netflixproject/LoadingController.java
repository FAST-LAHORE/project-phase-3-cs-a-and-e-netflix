/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netflixproject;

import java.io.File;
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
/**
 * FXML Controller class
 *
 * @author Munam Malik
 */
public class LoadingController implements Initializable {
    
    @FXML
    private AnchorPane rootpane;
    @FXML
    private MediaView mediaview;
    private Media media;
    private MediaPlayer mediaplayer;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        String workingdir = System.getProperty("user.dir");
       
        File f = new File(workingdir, "/src/images/opening.MP4");
        
        media = new Media((f.toURI().toString()));
        
        mediaplayer = new MediaPlayer(media);
        
        mediaview.setFitHeight(530);
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
                        Parent root2;
                        try {
                            root2 = FXMLLoader.load(getClass().getResource("index.fxml"));
                            Stage stage2 = new Stage();
                            Scene scene2 = new Scene(root2);
                            stage2.initStyle(StageStyle.UNDECORATED);
                            stage2.setScene(scene2);
                            rootpane.getScene().getWindow().hide();
                            stage2.show();
                        } catch (IOException ex) {
                            Logger.getLogger(LoadingController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                      
                    }
                    
                });
            } 
            catch (InterruptedException ex) 
            {
                Logger.getLogger(LoadingController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
