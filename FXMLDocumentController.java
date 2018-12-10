/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netflix_administration;

import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.util.concurrent.TimeUnit;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
/**
 *
 * @author MianSaqib
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private void closeButtonAction(ActionEvent event) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    private void customerService(ActionEvent event){
        if(event.getTarget() != null){
            A_aTVshow.setVisible(false);
            A_dMovie.setVisible(false);
            A_dTVshow.setVisible(false);
            A_aMovie.setVisible(false);
            A_Save.setVisible(false);
            A_Save1.setVisible(false);
            A_Save2.setVisible(false);
            //A_Save3.setVisible(false);
            ImM.setVisible(false);
            A_Menu.setVisible(false);
            A_Cust.setVisible(true);
        }
    }
    
    @FXML
    private void backButtonAction(ActionEvent event){
        if(event.getTarget() != null){
            A_aTVshow.setVisible(false);
            A_Cust.setVisible(false);
            A_dMovie.setVisible(false);
            A_dTVshow.setVisible(false);
            A_aMovie.setVisible(false);
            A_Save.setVisible(false);
            A_Save1.setVisible(false);
            A_Save2.setVisible(false);
            //A_Save3.setVisible(false);
            ImM.setVisible(false);
            A_Menu.setVisible(true);
        }
    }
    
    @FXML
    private void addNewMovie(ActionEvent event){
        if(event.getTarget() != null){
            A_aTVshow.setVisible(false);
            A_Cust.setVisible(false);
            A_dMovie.setVisible(false);
            A_dTVshow.setVisible(false);
            A_Menu.setVisible(false);
            A_Save.setVisible(false);
            A_Save1.setVisible(false);
            A_Save2.setVisible(false);
            //A_Save3.setVisible(false);
            ImM.setVisible(false);
            A_aMovie.setVisible(true);
        }
    }
    
    @FXML
    private void addNewTVshow(ActionEvent event){
        A_dMovie.setVisible(false);
        A_dTVshow.setVisible(false);
        A_Menu.setVisible(false);
        A_Cust.setVisible(false);
        A_aMovie.setVisible(false);
        A_Save.setVisible(false);
        A_Save1.setVisible(false);
        A_Save2.setVisible(false);
        //A_Save3.setVisible(false);
        ImM.setVisible(false);
        A_aTVshow.setVisible(true);
        
    }
    
    @FXML
    private void deleteMovie(ActionEvent event){
        A_aTVshow.setVisible(false);
        A_dTVshow.setVisible(false);
        A_Menu.setVisible(false);
        A_aMovie.setVisible(false);
        A_Save.setVisible(false);
        A_Cust.setVisible(false);
        A_Save1.setVisible(false);
        A_Save2.setVisible(false);
        //A_Save3.setVisible(false);
        ImM.setVisible(false);
        A_dMovie.setVisible(true);
        DelM.setText("");
    }
    
    @FXML
    private void deleteTVshow(ActionEvent event){
        A_aTVshow.setVisible(false);
        A_dMovie.setVisible(false);
        A_Menu.setVisible(false);
        A_aMovie.setVisible(false);
        A_Cust.setVisible(false);
        A_Save.setVisible(false);
        A_Save1.setVisible(false);
        A_Save2.setVisible(false);
        //A_Save3.setVisible(false);
        ImM.setVisible(false);
        A_dTVshow.setVisible(true);
        
    }
    
    @FXML
    private void save(ActionEvent event){
        if(event.getTarget() == save){
            A_Save.setVisible(true);
            sp.setVisible(true);
            date = (String) dM.getValue().toString();
            title = (String) txtM.getText();
            SDM = (String) pMSD.getText();
            HDM = (String) pMHD.getText();
            UHDM = (String) pMUHD.getText();
            PM = (String) pMCP.getText();
            GenreM = (String) genM.getText();
            ActorM = (String) actM.getText();
            if(IdM.getText() == null){
                IDM = 0;
            }
            else if(IdM.getText() != null){
                IDM = Integer.parseInt((String) IdM.getText());
            }
            if(pMD.getText() == null){
                DM = 0;
            }
            else if(pMD.getText() != null){
                DM = Integer.parseInt((String) pMD.getText());
            }
            
        }
        else if(event.getTarget() == save1){
            A_Save1.setVisible(true);
            sp1.setVisible(true);
        }
        else if(event.getTarget() == DeleteM){
            DelMS = Integer.parseInt(DelM.getText());
            String path = null;
            String sql = "Select * from MOVIE where ID = " + DelMS;
            // file path = file:///F:\Godfather.jpg
            try{
                c = DriverManager.getConnection("jdbc:derby://localhost:1527/Netflix", "l164206", "qwertyu");
                s = c.createStatement();
                r = s.executeQuery(sql);
                r.next();
                path = r.getString("PATHCOVERPIC");
                ImM.setImage(new Image(path));
            }
            catch(SQLException sq){
                System.out.println(sq);
            }
            
            if(path != null){
                ImM.setVisible(true);
                A_Save2.setVisible(true);
                sp2.setVisible(true);
            }
            else{
                DelM.setText("Movie not found");
            }
        }
        /*else if(event.getTarget() == save3){
            A_Save3.setVisible(true);
            sp3.setVisible(true);
        }*/
    }
    
    @FXML
    private void yes(ActionEvent event){
        if(event.getTarget() == yes){
            A_Save.setVisible(false);
            sp.setVisible(false);
            A_aMovie.setVisible(false);
            
            if(IDM == 0 || DM == 0 || title == null || date == null || SDM == null || HDM == null || UHDM == null || PM == null){
                A_aMovie.setVisible(true);
            }
            
            else{
                ContentManager M = ContentManager.getInit();
                Movie nM = new Movie(IDM, title, date, DM, SDM, HDM, UHDM, PM);
                M.addNewMovie(nM);
                String sql = "INSERT INTO MOVIE(ID, TITLE, RELEASEDATE, GENRE, ACTOR, PATHSD, PATHHD, PATHUHD, PATHCOVERPIC, DURATION) Values (";
                String remainingStat = null;
                try{
                    c = DriverManager.getConnection("jdbc:derby://localhost:1527/Netflix", "l164206", "qwertyu");
                    s = c.createStatement();
                    remainingStat = String.valueOf(IDM) + "," + "'" +(String)title + "'" + "," + "'" + date + "'" + "," + "'" + (String)GenreM + "'" + "," + "'" + (String)ActorM + "'" + "," + "'" + (String)SDM + "'" + "," + "'" + (String)HDM + "'" + "," + "'" + (String)UHDM + "'" + "," + "'" + (String)PM + "'" + ","  + String.valueOf(DM) + ")";
                    System.out.println(sql+remainingStat);
                    int q = s.executeUpdate(sql+remainingStat);
                }
                catch(SQLException sq){
                    System.out.println(sq);
                }
                A_Menu.setVisible(true);
            }
        }
        else if(event.getTarget() == yes1){
            A_Save1.setVisible(false);
            sp1.setVisible(false);
            A_aTVshow.setVisible(false);
            A_Menu.setVisible(true);
        }
        else if(event.getTarget() == yes2){
            ContentManager cc = ContentManager.getInit();
            cc.deleteMovie(DelMS);
            
            String sql = "Delete from MOVIE where ID = " + DelMS;
            try{
                c = DriverManager.getConnection("jdbc:derby://localhost:1527/Netflix", "l164206", "qwertyu");
                s = c.createStatement();
                int ii = s.executeUpdate(sql);
            }
            catch(SQLException sq){
                System.out.println(sq);
            }
            
            ImM.setVisible(false);
            A_Save2.setVisible(false);
            sp2.setVisible(false);
            A_dMovie.setVisible(false);
            A_Menu.setVisible(true);
        }
        /*else if(event.getTarget() == yes3){
            A_Save3.setVisible(false);
            sp3.setVisible(false);
            A_dTVshow.setVisible(false);
            A_Menu.setVisible(true);
        }*/
    }
    
    @FXML
    private void no(ActionEvent event){
        if(event.getTarget() == no){
            A_aMovie.setVisible(true);
            A_Save.setVisible(false);
        }
        else if(event.getTarget() == no1){
            A_aTVshow.setVisible(true);
            A_Save1.setVisible(false);
        }
        else if(event.getTarget() == no2){
            ImM.setVisible(false);
            A_dMovie.setVisible(true);
            A_Save2.setVisible(false);
        }
        else if(event.getTarget() == no3){
            A_dTVshow.setVisible(true);
            A_Save3.setVisible(false);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    
    @FXML
    private javafx.scene.control.Button closeButton;
    @FXML
    private javafx.scene.control.Button backButton;
    @FXML
    private javafx.scene.control.Button customerS;
    @FXML
    private javafx.scene.control.Button addNMovie;
    @FXML
    private javafx.scene.control.Button addNTVshow;
    @FXML
    private javafx.scene.control.Button delMovie;
    @FXML
    private javafx.scene.control.Button delTVshow;
    @FXML
    private javafx.scene.control.Button save;
    @FXML
    private javafx.scene.control.Button save1;
    @FXML
    private javafx.scene.control.Button save3;
    @FXML
    private javafx.scene.control.Button yes;
    @FXML
    private javafx.scene.control.Button yes1;
    @FXML
    private javafx.scene.control.Button yes2;
    @FXML
    private javafx.scene.control.Button yes3;
    @FXML
    private javafx.scene.control.Button no;
    @FXML
    private javafx.scene.control.Button no1;
    @FXML
    private javafx.scene.control.Button no2;
    @FXML
    private javafx.scene.control.Button no3;
    @FXML
    private com.jfoenix.controls.JFXSpinner sp;
    @FXML
    private com.jfoenix.controls.JFXSpinner sp1;
    @FXML
    private com.jfoenix.controls.JFXSpinner sp2;
    @FXML
    private com.jfoenix.controls.JFXSpinner sp3;
    @FXML
    private AnchorPane A_Menu;
    @FXML
    private AnchorPane A_Cust;
    @FXML
    private AnchorPane A_Save;
    @FXML
    private AnchorPane A_Save1;
    @FXML
    private AnchorPane A_Save2;
    @FXML
    private AnchorPane A_Save3;
    @FXML
    private AnchorPane A_aMovie;
    @FXML
    private AnchorPane A_aTVshow;
    @FXML
    private AnchorPane A_dMovie;
    @FXML
    private AnchorPane A_dTVshow;
    
    @FXML 
    private com.jfoenix.controls.JFXTextField DelM;
    @FXML
    private javafx.scene.control.Button DeleteM;
    @FXML
    private ImageView ImM;
    private int DelMS;
    
    @FXML 
    private com.jfoenix.controls.JFXTextField UsrID;
    @FXML 
    private com.jfoenix.controls.JFXTextArea Msg;
    @FXML
    private TableView complain;
    
    @FXML 
    private com.jfoenix.controls.JFXTextField IdM;
    @FXML 
    private com.jfoenix.controls.JFXTextField txtM;
    @FXML 
    private com.jfoenix.controls.JFXTextField genM;
    @FXML 
    private com.jfoenix.controls.JFXTextField actM;
    @FXML
    private com.jfoenix.controls.JFXDatePicker dM;
    @FXML 
    private com.jfoenix.controls.JFXTextField pMSD;
    @FXML 
    private com.jfoenix.controls.JFXTextField pMHD;
    @FXML 
    private com.jfoenix.controls.JFXTextField pMUHD;
    @FXML 
    private com.jfoenix.controls.JFXTextField pMCP;
    @FXML 
    private com.jfoenix.controls.JFXTextField pMD;
    private String date;
    private String title;
    private String SDM;
    private String HDM;
    private String UHDM;
    private String PM;
    private int DM;
    private int IDM;
    private String GenreM;
    private String ActorM;
    Connection c = null;
    Statement s = null;
    ResultSet r = null;
}
