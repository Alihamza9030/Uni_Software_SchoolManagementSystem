/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DB_Connection.mysql_connection;
import com.jfoenix.controls.JFXCheckBox;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Syed Areeb
 */
public class Add_TeacherController implements Initializable {

     @FXML
    private TextField tname;

    @FXML
    private TextField fname;

    @FXML
    private TextField cast;

    @FXML
    private TextField age;

    @FXML
    private TextField martialstatus;

    @FXML
    private TextField address;

    @FXML
    private TextField lastqualification;

    @FXML
    private TextField subject;

    @FXML
    private DatePicker dob;

    @FXML
    private TextField contact;

    @FXML
    private JFXCheckBox male;

    @FXML
    private JFXCheckBox female;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    void SubmitTForm(ActionEvent event) {

         Connection con = mysql_connection.getConnection();
        PreparedStatement ps = null;
       
    
        String sql = "INSERT INTO sms.teacher (Name, FatherName, Cast, Age, Dob, Subject, LQualification, Contact, Address, Gender) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        String gender = "";

        if (male.isSelected()) {
            gender = String.valueOf(male.getText());
        }
        if (female.isSelected()) {
            gender = String.valueOf(female.getText());
        }
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, tname.getText());
            ps.setString(2, fname.getText());
            ps.setString(3, cast.getText());
            ps.setString(4, age.getText());
            ps.setString(5, martialstatus.getText());
            ps.setString(6, String.valueOf(dob.getValue()));
            ps.setString(7, subject.getText());
            ps.setString(8, lastqualification.getText());
            ps.setString(9, contact.getText());
            ps.setString(10, address.getText());
            ps.setString(11, gender);
            
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Teacher Added Successfully.");
      
          
            
        } catch (Exception ex) {
            //Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Failed...");

        }
    }
}
