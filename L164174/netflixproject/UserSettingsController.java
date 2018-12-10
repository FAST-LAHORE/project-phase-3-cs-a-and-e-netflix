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
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
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
public class UserSettingsController implements Initializable {

    private User user;
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
    private TextField name;
    @FXML
    private TextField bank;
    @FXML
    private TextField password;
    @FXML
    private ImageView upName;
    @FXML
    private ImageView upPass;
    @FXML
    private ImageView upBank;
    @FXML
    private Button update;
    @FXML
    private Text currentPlan;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    void setUser(User u) {
        this.user = u;
    }

    void set() {
        menu.setText(user.name);
        name.setText(user.name);
        bank.setText(user.BankAccount);
        currentPlan.setText(user.getPlan());

    }

    @FXML
    private void dropdownfunction(MouseEvent event) {
    }

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("home.fxml"));
        loader.load();
        HomeController home = loader.getController();
        home.setUser(user);
        home.set();
        Parent root = loader.getRoot();
        rootpane.getScene().getWindow().hide();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void windowclosed(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
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

    @FXML
    private void updateName(MouseEvent event) throws IOException {
        AccountManager accountManager = AccountManager.getInstance();
        if (!name.getText().toString().matches(this.user.name)) {
            user = accountManager.updateInfo(name.getText().toString(), user.email, "", "");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("popup.fxml"));
            Parent root = loader.load();
            PopupController popup = loader.getController();
            menu.setText(user.name);
            popup.set("Name is successfully updated");
            Stage stage2 = new Stage();
            stage2.setScene(new Scene(root));
            stage2.initStyle(StageStyle.UNDECORATED);
            stage2.show();
        }
    }

    @FXML
    private void updatePassword(MouseEvent event) throws IOException {
        AccountManager accountManager = AccountManager.getInstance();
        Database db = Database.getInstance();

        if (!accountManager.checkPassword(user.email, password.getText().toString())) {
            user = accountManager.updateInfo("", user.email, "", password.getText().toString());
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("popup.fxml"));
            Parent root = loader.load();
            PopupController popup = loader.getController();
            popup.set("Password is successfully updated");
            Stage stage2 = new Stage();
            stage2.setScene(new Scene(root));
            stage2.initStyle(StageStyle.UNDECORATED);
            stage2.show();
        }
    }

    @FXML
    private void updateBank(MouseEvent event) throws IOException {
        AccountManager accountManager = AccountManager.getInstance();
        if (!bank.getText().toString().matches(this.user.BankAccount)) {
            user = accountManager.updateInfo("", user.email, "",bank.getText().toString());
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("popup.fxml"));
            Parent root = loader.load();
            PopupController popup = loader.getController();
            popup.set("Bank Account is successfully updated");
            Stage stage2 = new Stage();
            stage2.setScene(new Scene(root));
            stage2.initStyle(StageStyle.UNDECORATED);
            stage2.show();
        }
    }

    @FXML
    private void updateSubscription(ActionEvent event) throws IOException {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("SubcriptionSettings.fxml"));
        loader.load();
        SubcriptionSettingsController sub = loader.getController();
        sub.setUser(user);
        sub.set();
        Parent root = loader.getRoot();
        stage.setScene(new Scene(root));
        stage.show();
    }

}
