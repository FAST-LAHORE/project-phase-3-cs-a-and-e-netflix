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
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
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
public class SubcriptionSettingsController implements Initializable {

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
    private ComboBox<String> plans;
    @FXML
    private Text currentPlan;
    @FXML
    private ImageView upSub;
    @FXML
    private ImageView delSub;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        String[] planNames = {"Basic", "Standard", "Premium"};
        plans.getItems().addAll(planNames);
        plans.setValue(planNames[0]);
    }

    @FXML
    private void dropdownfunction(MouseEvent event) {
    }

    void setUser(User user) {
        this.user = user;
    }

    void set() {
        menu.setText(user.name);
        currentPlan.setText(this.user.getPlan());

    }

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
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
    private void windowclosed(ActionEvent event) {
        Node  source = (Node)  event.getSource(); 
        Stage stage  = (Stage) source.getScene().getWindow();
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
    private void updateSubsciption(MouseEvent event) throws IOException {
        AccountManager accountManager = AccountManager.getInstance();
        if (plans.getValue().toString().matches("Basic")) {
            user = accountManager.updateSubscription(user.email, 1);
            set();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("popup.fxml"));
            Parent root = loader.load();
            PopupController popup = loader.getController();
            popup.set("Plan is successfully updated to Basic");
            Stage stage2 = new Stage();
            stage2.setScene(new Scene(root));
            stage2.initStyle(StageStyle.UNDECORATED);
            stage2.show();
        } else if (plans.getValue().toString().matches("Standard")) {
            user = accountManager.updateSubscription(user.email, 2);
            set();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("popup.fxml"));
            Parent root = loader.load();
            PopupController popup = loader.getController();
            popup.set("Plan is successfully updated to Standard");
            Stage stage2 = new Stage();
            stage2.setScene(new Scene(root));
            stage2.initStyle(StageStyle.UNDECORATED);
            stage2.show();
        } else if (plans.getValue().toString().matches("Premium")) {
            user = accountManager.updateSubscription(user.email, 3);
            set();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("popup.fxml"));
            Parent root = loader.load();
            PopupController popup = loader.getController();
            popup.set("Plan is successfully updated to Premium");
            Stage stage2 = new Stage();
            stage2.setScene(new Scene(root));
            stage2.initStyle(StageStyle.UNDECORATED);
            stage2.show();
        } else {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("popup.fxml"));
            Parent root = loader.load();
            PopupController popup = loader.getController();
            popup.set("A valid choice must be made");
            Stage stage2 = new Stage();
            stage2.setScene(new Scene(root));
            stage2.initStyle(StageStyle.UNDECORATED);
            stage2.show();
        }
    }

    @FXML
    private void RemoveSubscription(MouseEvent event) throws IOException {
        AccountManager accountManager = AccountManager.getInstance();
        user = accountManager.cancelSubscription(user.email);
        set();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("popup.fxml"));
        Parent root = loader.load();
        PopupController popup = loader.getController();
        popup.set("Subscription has been removed successfully");
        Stage stage2 = new Stage();
        stage2.setScene(new Scene(root));
        stage2.initStyle(StageStyle.UNDECORATED);
        stage2.show();

    }

}
