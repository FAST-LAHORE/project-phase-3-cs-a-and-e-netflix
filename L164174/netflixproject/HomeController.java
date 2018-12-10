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
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Munam Malik
 */
public class HomeController implements Initializable {

    User user;
    @FXML
    private AnchorPane rootpane;
    @FXML
    private Button backbutton;
    @FXML
    private Button cross;
    @FXML
    private MenuButton menu;
    @FXML
    private MenuItem signout;
    @FXML
    private MenuItem editUser;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

    @FXML
    private void handleButtonAction(ActionEvent event) {
    }

    @FXML
    private void windowclosed(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    public void setUser(User u) {

        this.user = u;
    }

    public void set() {
       
        menu.setText(user.name);
    }

    @FXML
    private void dropdownfunction(MouseEvent event) {
    }

    @FXML
    private void editSettings(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("userSettings.fxml"));
        loader.load();
        UserSettingsController u = loader.getController();
        u.setUser(user);
        u.set();
        
        Parent root2 = loader.getRoot();
        Stage stage2 = (Stage) menu.getScene().getWindow();
        rootpane.getScene().getWindow().hide();
        Scene scene2 = new Scene(root2);
        stage2.setScene(scene2);
        
        stage2.show();
    }

    @FXML
    private void Signout(ActionEvent event) throws IOException {
        user = null;

        Parent root2 = FXMLLoader.load(getClass().getResource("index.fxml"));
        Stage stage2 = new Stage();
        Scene scene2 = new Scene(root2);
        stage2.initStyle(StageStyle.UNDECORATED);
        stage2.setScene(scene2);
        rootpane.getScene().getWindow().hide();
        stage2.show();
    }

}
