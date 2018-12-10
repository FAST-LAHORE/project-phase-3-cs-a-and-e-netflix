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
    private void Login(ActionEvent event){
        String path = null;
        String sql = "Select * from ADMIN where Email = '" + Email.getText() + "'";
        try{
            c = DriverManager.getConnection("jdbc:derby://localhost:1527/Netflix", "l164206", "qwertyu");
            s = c.createStatement();
            r = s.executeQuery(sql);
            r.next();
            path = r.getString("EMAIL");
        }
        catch(SQLException sq){
            System.out.println(sq);
        }
        
        if(path == null){
            Email.setText("Please enter correct Email");
        }
        
        else if(path != null){
            log.setVisible(false);
            A_Menu.setVisible(true);
        }
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
            A_Save3.setVisible(false);
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
            A_Save3.setVisible(false);
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
            A_Save3.setVisible(false);
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
        A_Save3.setVisible(false);
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
        A_Save3.setVisible(false);
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
        A_Save3.setVisible(false);
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
            genrM = (String) genM.getText();
            DM = (String) pMD.getText();
            oneM = oneSM.getText();
            twoM = twoSM.getText();
            threeM = threeSM.getText();
            fourM = fourSM.getText();
            fiveM = fiveSM.getText();
            
        }
        else if(event.getTarget() == save1){
            A_Save1.setVisible(true);
            sp1.setVisible(true);
            GenTV = (String) pTVGen.getText();
            CPTV = (String) pTVCP.getText();
            DaTV = (String) pTVDa.getValue().toString();
            TitleTV = (String) pTVtitle.getText();
            oneS = oneSS.getText();
            twoS = twoSS.getText();
            threeS = threeSS.getText();
            fourS = fourSS.getText();
            fiveS = fiveSS.getText();
            
        }
        else if(event.getTarget() == DeleteM){
            String path = null;
            String sql = "Select * from MOVIE where TITLE = '" + DelM.getText() + "'";
            // file path = file:///F:\Godfather.jpg
            try{
                c = DriverManager.getConnection("jdbc:derby://localhost:1527/Netflix", "l164206", "qwertyu");
                s = c.createStatement();
                r = s.executeQuery(sql);
                r.next();
                path = r.getString("IMG");
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
        else if(event.getTarget() == DeleteS){
            String path = null;
            String sql = "Select * from TVSHOW where TITLE = '" + DelS.getText() + "'";
            // file path = file:///F:\Godfather.jpg
            try{
                c = DriverManager.getConnection("jdbc:derby://localhost:1527/Netflix", "l164206", "qwertyu");
                s = c.createStatement();
                r = s.executeQuery(sql);
                r.next();
                path = r.getString("IMG");
                ImS.setImage(new Image(path));
            }
            catch(SQLException sq){
                System.out.println(sq);
            }
            
            if(path != null){
                ImS.setVisible(true);
                A_Save3.setVisible(true);
                sp3.setVisible(true);
            }
        }
    }
    
    @FXML
    private void yes(ActionEvent event){
        if(event.getTarget() == yes){
            A_Save.setVisible(false);
            sp.setVisible(false);
            A_aMovie.setVisible(false);
            
            if( title == null || date == null || SDM == null || HDM == null || UHDM == null || PM == null){
                A_aMovie.setVisible(true);
            }
            
            else{
                ContentManager M = ContentManager.getInit();
                Movie nM = new Movie(title, date, DM, genrM, SDM,HDM, UHDM, PM, Integer.parseInt(oneM), Integer.parseInt(twoM), Integer.parseInt(threeM), Integer.parseInt(fourM), Integer.parseInt(fiveM));
                M.addNewMovie(nM);
                String sql = "INSERT INTO MOVIE(TITLE, RELEASE_DATE, GENRE, Sdurl, Hdurl, Uhdurl, Img, Duration, one_star, two_star, three_star, four_star, five_star) Values (";
                String remainingStat = null;
                try{
                    c = DriverManager.getConnection("jdbc:derby://localhost:1527/Netflix", "l164206", "qwertyu");
                    s = c.createStatement();
                    remainingStat = "'"+ title +  "'" + "," + "'" + date + "'" + "," + "'" + (String)genrM + "'" + "," + "'" + (String)SDM + "'" + "," + "'" + (String)HDM + "'" + "," + "'" + (String)UHDM + "'" + "," + "'" + (String)PM + "'" + ","  + "'" + DM + "'"+ "," +String.valueOf(oneM) + "," + String.valueOf(twoM) + "," + String.valueOf(threeM)+ "," + String.valueOf(fourM) + "," + String.valueOf(fiveM) + ")";
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
            
            
            if( TitleTV == null || DaTV == null || GenTV == null || CPTV == null){
                A_aTVshow.setVisible(true);
            }
            
            else{
                ContentManager M = ContentManager.getInit();
                TVshow t = new TVshow(TitleTV, GenTV, DaTV, CPTV, Integer.parseInt(oneS), Integer.parseInt(twoS), Integer.parseInt(threeS), Integer.parseInt(fourS), Integer.parseInt(fiveS));
                
                String sql = "INSERT INTO Tvshow(TITLE, RELEASE_DATE, GENRE, Img, one_star, two_star, three_star, four_star, five_star) Values (";
                String remainingStat = null;
                try{
                    c = DriverManager.getConnection("jdbc:derby://localhost:1527/Netflix", "l164206", "qwertyu");
                    s = c.createStatement();
                    remainingStat = "'"+ TitleTV +  "'" + "," + "'" + DaTV + "'" + "," + "'" + (String)GenTV + "'" + "," + "'" + (String)CPTV + "'" + ","  + String.valueOf(oneS) + "," + String.valueOf(twoS) + "," + String.valueOf(threeS)+ "," + String.valueOf(fourS) + "," + String.valueOf(fiveS) + ")";
                    System.out.println(sql+remainingStat);
                    int q = s.executeUpdate(sql+remainingStat);
                }
                catch(SQLException sq){
                    System.out.println(sq);
                }
                
                A_Menu.setVisible(true);
            }            
        }
        else if(event.getTarget() == yes2){
            ContentManager cc = ContentManager.getInit();
            cc.deleteMovie(DelMS);
            
            String sql = "Delete from MOVIE where TITLE = '" + DelM.getText() + "'";
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
        else if(event.getTarget() == yes3){
            ContentManager m = ContentManager.getInit();
            m.deleteTVshow(DelS.getText());
            
            String sql = "Delete from TVSHOW where TITLE = '" + DelS.getText() + "'";
            try{
                c = DriverManager.getConnection("jdbc:derby://localhost:1527/Netflix", "l164206", "qwertyu");
                s = c.createStatement();
                int ii = s.executeUpdate(sql);
            }
            catch(SQLException sq){
                System.out.println(sq);
            }
            
            ImS.setVisible(false);
            A_Save3.setVisible(false);
            sp3.setVisible(false);
            A_dTVshow.setVisible(false);
            A_Menu.setVisible(true);
        }
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
    private AnchorPane log;
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
    private String DelMS;
    
    @FXML 
    private com.jfoenix.controls.JFXTextField DelS;
    @FXML
    private javafx.scene.control.Button DeleteS;
    @FXML
    private ImageView ImS;
    private String DelSS;
    
    @FXML 
    private com.jfoenix.controls.JFXTextField UsrID;
    @FXML 
    private com.jfoenix.controls.JFXTextArea Msg;
    @FXML
    private TableView complain;
    
    @FXML 
    private com.jfoenix.controls.JFXTextField Email;
    
    @FXML 
    private com.jfoenix.controls.JFXTextField txtM;
    @FXML 
    private com.jfoenix.controls.JFXTextField genM;
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
    @FXML 
    private com.jfoenix.controls.JFXTextField oneSM;
    @FXML 
    private com.jfoenix.controls.JFXTextField twoSM;
    @FXML 
    private com.jfoenix.controls.JFXTextField threeSM;
    @FXML 
    private com.jfoenix.controls.JFXTextField fourSM;
    @FXML 
    private com.jfoenix.controls.JFXTextField fiveSM;
    
    private String date;
    private String title;
    private String SDM;
    private String HDM;
    private String UHDM;
    private String PM;
    private String DM;
    private String genrM;
    private String oneM;
    private String twoM;
    private String threeM;
    private String fourM;
    private String fiveM;
    
    
    @FXML 
    private com.jfoenix.controls.JFXTextField pTVtitle;
    @FXML 
    private com.jfoenix.controls.JFXTextField pTVGen;
    @FXML 
    private com.jfoenix.controls.JFXTextField pTVCP;
    @FXML 
    private com.jfoenix.controls.JFXDatePicker pTVDa;
    @FXML 
    private com.jfoenix.controls.JFXTextField oneSS;
    @FXML 
    private com.jfoenix.controls.JFXTextField twoSS;
    @FXML 
    private com.jfoenix.controls.JFXTextField threeSS;
    @FXML 
    private com.jfoenix.controls.JFXTextField fourSS;
    @FXML 
    private com.jfoenix.controls.JFXTextField fiveSS;
    
    
    private String GenTV;
    private String CPTV;
    private String DaTV;
    private String TitleTV;
    private String oneS;
    private String twoS;
    private String threeS;
    private String fourS;
    private String fiveS;
        
    Connection c = null;
    Statement s = null;
    ResultSet r = null;
}
