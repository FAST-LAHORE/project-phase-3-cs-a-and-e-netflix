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
import javafx.scene.control.ComboBox;
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
public class SignupController implements Initializable {

    User user;
    @FXML
    private AnchorPane rootpane;
    @FXML
    private Button backbutton;
    @FXML
    private TextField email;
    @FXML
    private TextField account;
    @FXML
    private TextField fname;
    @FXML
    private PasswordField password;
    @FXML
    private Button sigin;
    @FXML
    private Button cross;
    @FXML
    private TextField lname;
    @FXML
    private ComboBox<String> plans;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        String[] planNames = {"Trial", "Basic", "Standard", "Premium"};
        plans.getItems().addAll(planNames);
        plans.setValue(planNames[0]);

    }

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {

        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("index.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void signuppressed(ActionEvent event) throws IOException {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader();

        String emailString = email.getText().toString();
        String fnameString = fname.getText().toString();
        String lnameString = lname.getText().toString();
        String accountString = account.getText().toString();
        String passwordString = password.getText().toString();

        if (emailString.matches("") || fnameString.toString().matches("") || !(emailString.contains("@")) || lnameString.matches("") || accountString.matches("") || passwordString.matches("")) {

            loader.setLocation(getClass().getResource("popup.fxml"));
            Parent root = loader.load();
            PopupController popup = loader.getController();
            popup.set("Enter all fields correctly");
            Stage stage2 = new Stage();
            stage2.setScene(new Scene(root));
            stage2.initStyle(StageStyle.UNDECORATED);
            stage2.show();
        } else {
            AccountManager accountManager = AccountManager.getInstance();
            if (accountManager.isValidEmailAddress(emailString)) {
                user = accountManager.register(emailString, accountString, (fnameString + " " + lnameString), passwordString, mapPlan(plans.getValue()));
                if (user.isValid()) {
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
                    popup.set("Email or Account already exists");
                    Stage stage2 = new Stage();
                    stage2.setScene(new Scene(root));
                    stage2.initStyle(StageStyle.UNDECORATED);
                    stage2.show();

                }
            } else {
                loader.setLocation(getClass().getResource("popup.fxml"));
                Parent root = loader.load();
                PopupController popup = loader.getController();
                popup.set("Invalid email address");
                Stage stage2 = new Stage();
                stage2.setScene(new Scene(root));
                stage2.initStyle(StageStyle.UNDECORATED);
                stage2.show();
            }
        }
    }

    private int mapPlan(String plan) {
        if (plan.matches("Trial")) {
            return 0;
        } else if (plan.matches("Basic")) {
            return 1;
        } else if (plan.matches("Standard")) {
            return 2;
        } else if (plan.matches("Premium")) {
            return 3;
        } else {
            return -1;
        }

    }

    @FXML
    private void windowclosed(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
}
