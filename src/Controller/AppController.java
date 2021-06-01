/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.*;
import DB_Connection.mysql_connection;
import LoaderFxml.Load_Fxml;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Syed Areeb
 */
public class AppController implements Initializable {
 
    @FXML
    private BorderPane border_Pane;
    
    @FXML
    public AnchorPane dashboard;

    @FXML
    private Label stu_count;
  
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
        Connection con = mysql_connection.getConnection();
        PreparedStatement ps;
        
        try{
           
           ps = con.prepareStatement("SELECT COUNT(*) FROM sms.students");
           ResultSet rs  = ps.executeQuery();
           
              rs.next();
              int count = rs.getInt(1);
              stu_count.setText(Integer.toString(count));
           
        }catch(Exception ex){
            
        }
      
    }    

    @FXML
     void show_dashboard(MouseEvent event) {
       border_Pane.setCenter(dashboard);
       
       
    }
    
    @FXML
    void show_Student(MouseEvent event) {
       Load_Fxml.load_center(border_Pane, "Student");
    }

    @FXML
    void show_Teacher(MouseEvent event) {
        Load_Fxml.load_center(border_Pane, "Teacher");
    }
    @FXML
    void show_Staff(MouseEvent event) {
        Load_Fxml.load_center(border_Pane, "Staff");
    }
    @FXML
    void show_Attendance(MouseEvent event) {
        Load_Fxml.load_center(border_Pane, "Attendance");
    }
    
    
     
   
}
