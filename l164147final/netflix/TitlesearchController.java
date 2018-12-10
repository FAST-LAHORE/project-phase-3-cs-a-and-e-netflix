/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netflix;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Faaiz
 */
public class TitlesearchController implements Initializable {
    @FXML
    private Button closeButton;
    @FXML
    private Label label1;
    @FXML
    private Label label2;
    @FXML
    private Label label3;
    
   
    @FXML
    private void close(ActionEvent event){
  Stage stage=(Stage)closeButton.getScene().getWindow();
  stage.close();
  }
    @FXML
    private AnchorPane rootpane2;
     @FXML
    private void back(ActionEvent event) throws IOException {
        AnchorPane pane2 = FXMLLoader.load(getClass().getResource("OOASA.fxml"));
       rootpane2.getChildren().setAll(pane2);
    }
    @FXML
    private TextField searched;
    @FXML
    
    private ImageView imageview;
   
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Movie a=new Movie("boss","/pics/images.jpg");
        Movie b=new Movie("infinitywar","/pics/download.jpg");
        MediaContent.addMovie(a);
        MediaContent.addMovie(b);
        ArrayList<TVshow> y=new ArrayList();
        ArrayList<Movie> x = new ArrayList();
        x=MediaContent.getInitMovie();
        y=MediaContent.getInitTvshow();
         for(int i=0;i<x.size();i++){
         if(x.get(i).getname().equalsIgnoreCase(str.s)){
        searched.setText(x.get(i).getname());     
         String path=x.get(i).getpath();
            

         Image image=new Image(path);
          imageview.setImage(image);
    }
         }
         for(int i=0;i<y.size();i++){
         if(y.get(i).getSeason().equalsIgnoreCase(str.s)){
        searched.setText(y.get(i).getSeason());     
         String path=y.get(i).getSeasoninfo(i).getpath();
         int k=y.get(i).getSeasoninfo(i).getnumberofepisode();
         if(k==0){
          }
         if (k==1){
             label1.setText("Episode 1");
         }
         else if (k==2){
             label1.setText("Episode 2");
         }
         else if (k==3){
             label1.setText("Episode 3");
         }
         Image image=new Image(path);
          imageview.setImage(image);
    }
         }

    }    
   
}
