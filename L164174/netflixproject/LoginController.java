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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Munam Malik
 */
public class LoginController implements Initializable {
    User user;
    @FXML
    private AnchorPane rootpane;
    @FXML
    private Button backbutton;
    @FXML
    private TextField email;
    @FXML
    private PasswordField password;
    @FXML
    private Button cross;
    @FXML
    private Button sigin;

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
    
        Parent root = FXMLLoader.load(getClass().getResource("index.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void signinpressed(ActionEvent event) throws IOException {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        
        FXMLLoader loader =  new FXMLLoader();
        
        if(email.getText().toString().matches("") || password.getText().toString().matches("")){
            loader.setLocation(getClass().getResource("popup.fxml"));
            Parent root = loader.load();
            PopupController popup = loader.getController();
            popup.set("Enter all fields correctly");
            Stage stage2 = new Stage();
            stage2.setScene(new Scene(root));
            stage2.initStyle(StageStyle.UNDECORATED);
            stage2.show();
            return;
        }
        
        
        
        AccountManager accountManager = AccountManager.getInstance();
        user = accountManager.login(email.getText().toString(), password.getText().toString());
        if(user.isValid()){
            loader.setLocation(getClass().getResource("home.fxml"));
            loader.load();
            HomeController home = loader.getController();
            home.setUser(user);
            home.set();
            Parent root = loader.getRoot();
            stage.setScene(new Scene(root));
            stage.show();
        } else {
            loader.setLocation(getClass().getResource("popup.fxml"));
            Parent root = loader.load();
            PopupController popup = loader.getController();
            popup.set("Incorrect Email or Password");
            Stage stage2 = new Stage();
            stage2.setScene(new Scene(root));
            stage2.initStyle(StageStyle.UNDECORATED);
            stage2.show();
        }
        
        
        
    }

    @FXML
    private void windowclosed(ActionEvent event) {
        Node node = (Node)event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
    }
    
}
