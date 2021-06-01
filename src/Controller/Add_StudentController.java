/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.*;
import DB_Connection.mysql_connection;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;

import java.net.URL;
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
public class Add_StudentController implements Initializable {

    @FXML
    private TextField Sname;
    @FXML
    private TextField fname;
    @FXML
    private TextField cast;
    @FXML
    private TextField contact;
    @FXML
    private TextField address;
    @FXML
    private JFXCheckBox Male;
    @FXML
    private JFXCheckBox Female;
    @FXML
    private TextField age;
    @FXML
    private DatePicker dob;
    @FXML
    private TextField SClass;
    @FXML
    private TextField rollno;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void SubmitForm(ActionEvent event) {
        
        Connection con = mysql_connection.getConnection();
        PreparedStatement ps = null;
       
    
        String sql = "INSERT INTO sms.student (Name, Fname, Cast, Age, Gender, Dob, Stuclass, RollNo, Address, Contact) VALUES (?,?,?,?,?,?,?,?,?,?)";
        String gender = "";

        if (Male.isSelected()) {
            gender = String.valueOf(Male.getText());
        }
        if (Female.isSelected()) {
            gender = String.valueOf(Female.getText());
        }
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, Sname.getText());
            ps.setString(2, fname.getText());
            ps.setString(3, cast.getText());
            ps.setString(4, age.getText());
            ps.setString(5, gender);
            ps.setString(6, String.valueOf(dob.getValue()));
            ps.setString(7, SClass.getText());
            ps.setString(8, rollno.getText());
            ps.setString(9, address.getText());
            ps.setString(10, contact.getText());
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Student Added Successfully.");
      
          
            
        } catch (Exception ex) {
            //Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Failed...");

        }
    }
    
}
