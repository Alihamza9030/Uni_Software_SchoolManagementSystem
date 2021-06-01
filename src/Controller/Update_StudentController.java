/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DB_Connection.mysql_connection;
import com.jfoenix.controls.JFXCheckBox;
import java.sql.*;
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
public class Update_StudentController implements Initializable {

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

      @FXML
    private TextField Id;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     @FXML
    void UpdateData(ActionEvent event) {
       Connection con = mysql_connection.getConnection();
       PreparedStatement ps = null;
       String gender = "";

        if (Male.isSelected()) {
            gender = String.valueOf(Male.getText());
        }
        if (Female.isSelected()) {
            gender = String.valueOf(Female.getText());
        }
         try {
             String value1 = Id.getText();
             String value2 = Sname.getText();
             String value3 = fname.getText();
             String value4 = cast.getText();
             String value5 = age.getText();
             String value6 = gender;
             String value7 = String.valueOf(dob.getValue());
             String value8 = SClass.getText();
             String value9 = rollno.getText();
             String value10 = address.getText();
             String value11 = contact.getText();
             
             String sql = "UPDATE sms.student SET Name='"+value2+"', Fname='"+value3+"', Cast='"+value4+"', Age='"+value5+"', Gender='"+value6+"', Dob='"+value7+"', Stuclass='"+value8+"', RollNo='"+value9+"', Address='"+value10+"', Contact='"+value11+"' WHERE id='"+value1+"'";
             ps = con.prepareStatement(sql);
             ps.execute();
             JOptionPane.showMessageDialog(null, "Student Updated Successfully.");
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "Failed...");
         }
    }
}
