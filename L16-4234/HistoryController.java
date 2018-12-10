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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class HistoryController implements Initializable {

    @FXML
    private ImageView movieimage;
    @FXML
    private Button cross;
    @FXML
    private Button homebutton;
    @FXML
    private Button watchagain1;
    @FXML
    private Button watchmovietwo;
    @FXML
    private Button watchmoviethree;
    
    
    private User user;
    private String one_url;
    private String two_url;
    private String three_url;
    
    @FXML
    private Text movie1text;
    @FXML
    private Text movie2text;
    @FXML
    private Text movie3text;
    @FXML
    private Text movie1date;
    @FXML
    private Text movie2date;
    @FXML
    private Text movie3date;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void crosspressed(ActionEvent event) {
        Node  source = (Node)  event.getSource(); 
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();
    }

    private void handleButtonAction(ActionEvent event) throws IOException {
        Node  source = (Node)  event.getSource(); 
        Stage stage  = (Stage) source.getScene().getWindow();
        
        Parent root = FXMLLoader.load(getClass().getResource("ratingpage.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void openmovieone(ActionEvent event) throws SQLException, IOException {
        Date date = new Date();
            streaminghistory history = new streaminghistory(this.user,this.movie1text.getText(),this.one_url,date);
            
            historymanagement historymanager = new historymanagement();
            
            historymanager.addhistory(history);
            
            
            FXMLLoader loader = new FXMLLoader();
            System.out.println("videoplayer not called yed");
            loader.setLocation(getClass().getResource("videopalayer.fxml"));

            System.out.println("videoplayed called");



            loader.load();
            System.out.println("loader.load() called");

            VideopalayerController playnow = loader.getController();
            playnow.setvideourl(this.one_url);
            playnow.setmovietitle(this.movie1text.getText());
            playnow.setmedia();


            Stage stage =  new Stage();
            Parent root = loader.getRoot();
            stage.setScene(new Scene(root));
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();
    }

    @FXML
    private void openmovietwo(ActionEvent event) throws SQLException, IOException {
        Date date = new Date();
            streaminghistory history = new streaminghistory(this.user,this.movie2text.getText(),this.two_url,date);
            
            historymanagement historymanager = new historymanagement();
            
            historymanager.addhistory(history);
            
            
            FXMLLoader loader = new FXMLLoader();
            System.out.println("videoplayer not called yed");
            loader.setLocation(getClass().getResource("videopalayer.fxml"));

            System.out.println("videoplayed called");



            loader.load();
            System.out.println("loader.load() called");

            VideopalayerController playnow = loader.getController();
            playnow.setvideourl(this.two_url);
            playnow.setmovietitle(this.movie2text.getText());
            playnow.setmedia();


            Stage stage =  new Stage();
            Parent root = loader.getRoot();
            stage.setScene(new Scene(root));
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();
    }

    @FXML
    private void openmoviethree(ActionEvent event) throws IOException, SQLException {
        Date date = new Date();
            streaminghistory history = new streaminghistory(this.user,this.movie3text.getText(),this.three_url,date);
            
            historymanagement historymanager = new historymanagement();
            
            historymanager.addhistory(history);
            
            
            FXMLLoader loader = new FXMLLoader();
            System.out.println("videoplayer not called yed");
            loader.setLocation(getClass().getResource("videopalayer.fxml"));

            System.out.println("videoplayed called");



            loader.load();
            System.out.println("loader.load() called");

            VideopalayerController playnow = loader.getController();
            playnow.setvideourl(this.three_url);
            playnow.setmovietitle(this.movie3text.getText());
            playnow.setmedia();


            Stage stage =  new Stage();
            Parent root = loader.getRoot();
            stage.setScene(new Scene(root));
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();
    }
    
    
    public void set_user(User user) throws SQLException
    {
        this.user = user;
        
        Database db = new Database();
        int enteries = db.history_num(this.user);
        
        if(enteries== 0)
        {
            this.movie1text.setText("");
            this.movie1date.setText("");
            this.movie2text.setText("");
            this.movie2date.setText("");
            this.movie3text.setText("");
            this.movie3date.setText("");
            
            this.watchagain1.setOpacity(0);
            this.watchmovietwo.setOpacity(0);
            this.watchmoviethree.setOpacity(0);
        }
        else
        {
            if(enteries == 1)
            {
                set_only_one();
                this.movie2text.setText("");
                this.movie2date.setText("");
                this.movie3text.setText("");
                this.movie3date.setText("");
                this.watchmovietwo.setOpacity(0.0);
                this.watchmoviethree.setOpacity(0.0);
            }
            else
            {
                if(enteries == 2)
                {
                    set_only_two();
                    this.movie3text.setText("");
                    this.movie3date.setText("");
                    this.watchmoviethree.setOpacity(0.0);
                }
                else
                {
                    set_all_three();
                }
            }
        }
    }

    @FXML
    private void openhome(ActionEvent event) {
    }
    
    public void set_only_one() throws SQLException
    {
        Database db =  new Database();
        ArrayList<String> history = db.get_history(this.user);
        
        String title = "";
        String date = "";
        
        title = history.get(0);
        this.one_url = history.get(1);
        date = history.get(2);
        
        this.movie1text.setText(title);
        this.movie1date.setText("Last Date Watched : "+ date);
        
    }
    public void set_only_two() throws SQLException
    {
        Database db =  new Database();
        ArrayList<String> history = db.get_history(this.user);
        
        String title = "";
        String date = "";
        
        title = history.get(0);
        this.one_url = history.get(1);
        date = history.get(2);
        
        this.movie1text.setText(title);
        this.movie1date.setText("Last Date Watched : "+ date);
        
        title = history.get(3);
        this.two_url = history.get(4);
        date = history.get(5);
        
        this.movie2text.setText(title);
        this.movie2date.setText("Last Date Watched : "+ date);
    }
    public void set_all_three() throws SQLException
    {
        Database db =  new Database();
        ArrayList<String> history = db.get_history(this.user);
        
        String title = "";
        String date = "";
        
        title = history.get(0);
        this.one_url = history.get(1);
        date = history.get(2);
        
        this.movie1text.setText(title);
        this.movie1date.setText("Last Date Watched : "+ date);
        
        title = history.get(3);
        this.two_url = history.get(4);
        date = history.get(5);
        
        this.movie2text.setText(title);
        this.movie2date.setText("Last Date Watched : "+ date);
        
        title = history.get(6);
        this.three_url = history.get(7);
        date = history.get(8);
        
        this.movie3text.setText(title);
        this.movie3date.setText("Last Date Watched : "+ date);
        
    }
    
}
