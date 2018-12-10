/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netflixproject;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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

/**
 * FXML Controller class
 *
 * @author Munam Malik
 */
public class IndexController implements Initializable {

    @FXML
    private AnchorPane rootpane;
    @FXML
    private Button loginButton;
    @FXML
    private Button signup;
    @FXML
    private Button cross;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        
        Node  source = (Node)  event.getSource(); 
        Stage stage  = (Stage) source.getScene().getWindow();
    
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
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
    
        Parent root = FXMLLoader.load(getClass().getResource("signup.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }
    
}
