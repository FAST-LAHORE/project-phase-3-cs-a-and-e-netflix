/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netflix;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Faaiz
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
   
    private javafx.scene.control.Button closeButton;
    
    @FXML
  private void close(ActionEvent event){
  Stage stage=(Stage)closeButton.getScene().getWindow();
  stage.close();
  }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
