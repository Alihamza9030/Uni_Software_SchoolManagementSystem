 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DB_Connection.mysql_connection;
import java.sql.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaFiles.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Syed Areeb
 */
public class StudentController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void AddStudent(MouseEvent event) {
        try {
            FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("/fxml/Add_Student.fxml"));
            Parent root = (Parent) fxmlloader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
          
        } catch (IOException ex) {
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
        }

    
        
}
     @FXML
    private void searchStudent(MouseEvent event) {
      try {
            FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("/fxml/Search_Student.fxml"));
            Parent root = (Parent) fxmlloader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
          
        } catch (IOException ex) {
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    @FXML
    private void StudentList(MouseEvent event) {
      try {
            FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("/fxml/Student_List.fxml"));
            Parent root = (Parent) fxmlloader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
          
        } catch (IOException ex) {
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public static ObservableList<Student> getData(){
        Connection con = mysql_connection.getConnection();
        
        ObservableList<Student> list = FXCollections.observableArrayList();
        try{
            PreparedStatement ps = con.prepareStatement("SELECT * FROM sms.student");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                list.add(new Student (Integer.parseInt( rs.getString("id")),rs.getString("Name"),rs.getString("Fname"),rs.getString("Cast"),rs.getString("Age"),rs.getString("Gender"),rs.getString("Dob"),Integer.parseInt(rs.getString("Stuclass")),rs.getString("RollNo"),rs.getString("Address"),rs.getString("Contact")));
            }
        }catch(Exception ex){
            
        }
        
        return list;
    }

}