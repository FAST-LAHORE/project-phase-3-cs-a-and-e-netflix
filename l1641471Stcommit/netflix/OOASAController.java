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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;



/**
 * FXML Controller class
 *
 * @author Faaiz
 */
public class OOASAController implements Initializable {
   ObservableList <String> genreslist=FXCollections.observableArrayList("FICTION","ACTION","THRILLER");
   
   @FXML
   private Button seriesbutton;
   @FXML
   private Button next;
   @FXML
   private Button next1;
   @FXML
    private AnchorPane rootpane;
    @FXML
    private Button closeButton;
    @FXML 
    private Button moviesbutton;
    @FXML
    private TextField searchbar;
    @FXML
    private ComboBox genres;
    @FXML
    private ImageView imageview1;
    @FXML
    private ImageView imageview2;
    @FXML
    private ImageView imageview3;
    @FXML
    
    private ImageView imageview4;
    @FXML
    private ImageView imageview5;
    @FXML
    private ImageView imageview6;
    @FXML
    private ImageView imageview7;
    @FXML
    private ImageView imageview8;
   
    @FXML
    private Button previous;
    @FXML
    private Button previous1;
    @FXML
    private Label label7;
    @FXML
    private Label label2;
    @FXML
    private Label label3;
    @FXML
    private Label label4;
    @FXML
    private Label label5;
    @FXML
    private Label label6;
    @FXML
    private Label label1;
    @FXML
    private Label label8;
    @FXML
    private Label label11;
    @FXML
    private Label label10;
    @FXML
    private Label label9;
    @FXML
    private Label label12;
    @FXML
    
    
    private void close(ActionEvent event){
    Stage stage=(Stage)closeButton.getScene().getWindow();
    stage.close();
  }
    
   @FXML
    private void loadmovies(ActionEvent event){
        
   Movie a=new Movie("boss","/pics/images.jpg");
        Movie b=new Movie("infinitywar","/pics/download.jpg");
        Movie c=new Movie("boss","/pics/images.jpg");
        Movie d=new Movie("infinitywar","/pics/download.jpg");
        Movie e=new Movie("boss","/pics/images.jpg");
        Movie f=new Movie("infinitywar","/pics/download.jpg");
        Movie g=new Movie("boss","/pics/images.jpg");
        Movie h=new Movie("infinitywar","/pics/download.jpg");
        Movie i=new Movie("boss","/pics/images.jpg");
        Movie j=new Movie("infinitywar","/pics/download.jpg");
        Movie k=new Movie("boss","/pics/images.jpg");
        Movie l=new Movie("infinitywar","/pics/download.jpg");
       MediaContent.addMovie(a);
        MediaContent.addMovie(b);
        MediaContent.addMovie(c);
        MediaContent.addMovie(d);
        MediaContent.addMovie(e);
        MediaContent.addMovie(f);
        MediaContent.addMovie(g);
        MediaContent.addMovie(h);
        MediaContent.addMovie(i);
        MediaContent.addMovie(j);
        MediaContent.addMovie(k);
        MediaContent.addMovie(l);
        ArrayList<Movie> x = new ArrayList();
        x=MediaContent.getInitMovie();
       
        String path=x.get(0).getpath();
        Image ima=new Image(path);
        imageview1.setImage(ima);
        String name=x.get(0).getname();
        label1.setText(name);
        
        path=x.get(1).getpath();
        Image ima2=new Image(path);
        imageview2.setImage(ima2);
        name=x.get(1).getname();
        label2.setText(name);
        
        path=x.get(2).getpath();
        Image ima3=new Image(path);
        imageview3.setImage(ima3);
        name=x.get(2).getname();
        label3.setText(name);
        
        path=x.get(3).getpath();
        Image ima4=new Image(path);
        imageview4.setImage(ima4);
        name=x.get(3).getname();
        
        label4.setText(name);
        path=x.get(4).getpath();
        Image ima5=new Image(path);
        imageview5.setImage(ima5);
        name=x.get(4).getname();
        label5.setText(name);
        
        path=x.get(5).getpath();
        Image ima6=new Image(path);
        imageview6.setImage(ima6);
        name=x.get(5).getname();
        label6.setText(name);
        
        path=x.get(6).getpath();
        Image ima7=new Image(path);
        imageview7.setImage(ima7);
        name=x.get(6).getname();
        label7.setText(name);
        
        path=x.get(7).getpath();
        Image ima8=new Image(path);
        imageview8.setImage(ima8);
        name=x.get(7).getname();
        label8.setText(name);
        
        
  }
    
    @FXML
    private void loadseries(ActionEvent event){
   Movie a=new Movie("boss","/pics/images.jpg");
        Movie b=new Movie("infinitywar","/pics/download.jpg");
        Movie c=new Movie("boss","/pics/images.jpg");
        Movie d=new Movie("infinitywar","/pics/download.jpg");
        Movie e=new Movie("boss","/pics/images.jpg");
        Movie f=new Movie("infinitywar","/pics/download.jpg");
        Movie g=new Movie("boss","/pics/images.jpg");
        Movie h=new Movie("infinitywar","/pics/download.jpg");
        Movie i=new Movie("boss","/pics/images.jpg");
        Movie j=new Movie("infinitywar","/pics/download.jpg");
        Movie k=new Movie("boss","/pics/images.jpg");
        Movie l=new Movie("infinitywar","/pics/download.jpg");
       MediaContent.addMovie(a);
        MediaContent.addMovie(b);
        MediaContent.addMovie(c);
        MediaContent.addMovie(d);
        MediaContent.addMovie(e);
        MediaContent.addMovie(f);
        MediaContent.addMovie(g);
        MediaContent.addMovie(h);
        MediaContent.addMovie(i);
        MediaContent.addMovie(j);
        MediaContent.addMovie(k);
        MediaContent.addMovie(l);
        ArrayList<Movie> x = new ArrayList();
        x=MediaContent.getInitMovie();
       
          String path=x.get(0).getpath();
        Image ima=new Image(path);
        imageview1.setImage(ima);
        String name=x.get(0).getname();
        label1.setText(name);
        
        path=x.get(1).getpath();
        Image ima2=new Image(path);
        imageview2.setImage(ima2);
        name=x.get(1).getname();
        label2.setText(name);
        
        path=x.get(2).getpath();
        Image ima3=new Image(path);
        imageview3.setImage(ima3);
        name=x.get(2).getname();
        label3.setText(name);
        
        path=x.get(3).getpath();
        Image ima4=new Image(path);
        imageview4.setImage(ima4);
        name=x.get(3).getname();
        
        label4.setText(name);
        path=x.get(4).getpath();
        Image ima5=new Image(path);
        imageview5.setImage(ima5);
        name=x.get(4).getname();
        label5.setText(name);
        
        path=x.get(5).getpath();
        Image ima6=new Image(path);
        imageview6.setImage(ima6);
        name=x.get(5).getname();
        label6.setText(name);
        
        path=x.get(6).getpath();
        Image ima7=new Image(path);
        imageview7.setImage(ima7);
        name=x.get(6).getname();
        label7.setText(name);
        
        path=x.get(7).getpath();
        Image ima8=new Image(path);
        imageview8.setImage(ima8);
        name=x.get(7).getname();
        label8.setText(name);
        
        
        
  }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //genres.setValue("                           GENRE");
        genres.setItems(genreslist);
       
        
        
         }
        


    @FXML
    private void titlesearch(ActionEvent event) throws IOException {
      String s=searchbar.getText();
     //  str text=new str(s);
       str.s=s;
       
        AnchorPane pane = FXMLLoader.load(getClass().getResource("titlesearch.fxml"));
       rootpane.getChildren().setAll(pane);
    }

    @FXML
    private void traverseright(ActionEvent event){
        int k=incdec.givestart();
 
        
         ArrayList<Movie> x = new ArrayList();
        x=MediaContent.getInitMovie();
        if(k==x.size())
        {k=0;
        incdec.i=0;}
        String path=x.get(k).getpath();
        Image ima=new Image(path);
        String name=x.get(k).getname();
        label1.setText(name);
        imageview1.setImage(ima);
        k=k+1;
        if(k==x.size())
        {k=0;
        incdec.i=0;}
        path=x.get(k).getpath();
        Image ima2=new Image(path);
        imageview2.setImage(ima2);
        name=x.get(k).getname();
        label2.setText(name);
        k=k+1;
        if(k==x.size())
        {k=0;
        incdec.i=0;}
        path=x.get(k).getpath();
        Image ima3=new Image(path);
        imageview3.setImage(ima3);
        name=x.get(k).getname();
        label3.setText(name);
        k=k+1;
        if(k==x.size())
        {k=0;
        incdec.i=0;
        }
        path=x.get(k).getpath();
        Image ima4=new Image(path);
        imageview4.setImage(ima4);
        name=x.get(k).getname();
        label4.setText(name);
    }
    @FXML
    private void traverseleft(ActionEvent event){
        int k=incdec.giveend();
 
        
         ArrayList<Movie> x = new ArrayList();
        x=MediaContent.getInitMovie();
        if(k==0)
        {k=x.size();
        incdec.i=x.size();}
        String path=x.get(k).getpath();
        Image ima=new Image(path);
        imageview1.setImage(ima);
        String name=x.get(k).getname();
        label1.setText(name);
        k=k-1;
        if(k==0)
        {k=x.size();
        incdec.i=x.size();}
        path=x.get(k).getpath();
        Image ima2=new Image(path);
        imageview2.setImage(ima2);
        name=x.get(k).getname();
        label2.setText(name);
        k=k-1;
        if(k==0)
        {k=x.size();
        incdec.i=x.size();}
        path=x.get(k).getpath();
        Image ima3=new Image(path);
        imageview3.setImage(ima3);
        name=x.get(k).getname();
        label3.setText(name);
        k=k-1;
        if(k==0)
        {k=x.size();
        incdec.i=x.size();}
        path=x.get(k).getpath();
        Image ima4=new Image(path);
        imageview4.setImage(ima4);
        name=x.get(k).getname();
        label4.setText(name);
        
    }
    @FXML
    private void traverseright1(ActionEvent event){
        int k=incdec.givestart2();
         ArrayList<Movie> x = new ArrayList();
        x=MediaContent.getInitMovie();
        if(k==x.size())
        {k=0;
        incdec.i2=0;}
        String path=x.get(k).getpath();
        Image ima=new Image(path);
        imageview5.setImage(ima);
        String name=x.get(k).getname();
        label5.setText(name);
        k=k+1;
        if(k==x.size())
        {k=0;
        incdec.i2=0;}
        path=x.get(k).getpath();
        Image ima2=new Image(path);
        imageview6.setImage(ima2);
        name=x.get(k).getname();
        label6.setText(name);
        k=k+1;
        if(k==x.size())
        {k=0;
        incdec.i2=0;}
        path=x.get(k).getpath();
        Image ima3=new Image(path);
        imageview7.setImage(ima3);
        name=x.get(k).getname();
        label7.setText(name);
        k=k+1;
        if(k==x.size())
        {k=0;
        incdec.i2=0;}
        path=x.get(k).getpath();
        Image ima4=new Image(path);
        imageview8.setImage(ima4);
        name=x.get(k).getname();
        label8.setText(name);
        
    }
@FXML
    private void traverseleft1(ActionEvent event){
      
        int k=incdec.giveend2();
 
       
         ArrayList<Movie> x = new ArrayList();
        x=MediaContent.getInitMovie();
        if(k==0)
        {k=x.size();
        incdec.i2=x.size();
        
        }
        String path=x.get(k).getpath();
        
        Image ima5=new Image(path);
        imageview5.setImage(ima5);
        String name=x.get(k).getname();
        label5.setText(name);
        k=k-1;
        if(k==0)
        {k=x.size();
        incdec.i2=x.size();}
        path=x.get(k).getpath();
        Image ima6=new Image(path);
        imageview6.setImage(ima6);
        name=x.get(k).getname();
        label6.setText(name);
        k=k-1;
        if(k==0)
        {k=x.size();
        incdec.i2=x.size();}
        path=x.get(k).getpath();
        Image ima7=new Image(path);
        imageview7.setImage(ima7);
        name=x.get(k).getname();
        label7.setText(name);
        k=k-1;
        if(k==0)
        {k=x.size();
        incdec.i2=x.size();}
        path=x.get(k).getpath();
         Image ima8=new Image(path);
        imageview8.setImage(ima8);
        name=x.get(k).getname();
        label8.setText(name);
    }
    @FXML
    private void loadgenrepage(ActionEvent event) throws IOException {
         String s=(String)genres.getValue();
     
       str.s=s;
       
        AnchorPane pane = FXMLLoader.load(getClass().getResource("genrepage.fxml"));
       rootpane.getChildren().setAll(pane);
    }

    
  

    
    
}
