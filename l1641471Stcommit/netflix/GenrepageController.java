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
public class GenrepageController implements Initializable {
  @FXML
   private Label label1;
  @FXML
   private Label label2;
  @FXML
   private Label label3;
  @FXML
   private Label label4;
    @FXML
   ImageView image1;
    @FXML
   ImageView image2;
     @FXML
   ImageView image3;
      @FXML
   ImageView image4;
    @FXML
   private Button back;
    @FXML
    private  Button close;
    @FXML
    private TextField genrefield;
    @FXML
    private void closewindow(ActionEvent event){
    Stage stage=(Stage)close.getScene().getWindow();
    stage.close();
  }
    @FXML
    private AnchorPane rootpane3;
    @FXML
     private void backtohome(ActionEvent event) throws IOException{
     AnchorPane pane2 = FXMLLoader.load(getClass().getResource("OOASA.fxml"));
       rootpane3.getChildren().setAll(pane2);
  }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        genrefield.setText(str.s);
        Movie a=new Movie("boss","/pics/images.jpg");
        Movie b=new Movie("infinitywar","/pics/download.jpg");
        MediaContent.addMovie(a);
        MediaContent.addMovie(b);
         ArrayList<Movie> x = new ArrayList();
         ArrayList<String> genres=new ArrayList();
         ArrayList<String> name=new ArrayList();
        x=MediaContent.getInitMovie();
         for(int i=0;i<x.size();i++){
         if(x.get(i).getgenre().equalsIgnoreCase(str.s)){
         String path=x.get(i).getpath();
         if(path!=null)
         {genres.add(path);
         name.add(x.get(i).getname());
         }
                                                          }  
         }
         Image im1=new Image(genres.get(0));
         Image im2=new Image(genres.get(1));
         String s1=name.get(0);
         String s2=name.get(1);
         //Image im3=new Image(genres.get(2));
         //Image im4=new Image(genres.get(3));
         image1.setImage(im1);
         label1.setText(s1);
         image2.setImage(im2);
         label2.setText(s2);
        //image3.setImage(im3);
         //image4.setImage(im4);
    }
}
