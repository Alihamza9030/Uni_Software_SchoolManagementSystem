/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DB_Connection.mysql_connection;
import java.sql.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Syed Areeb
 */
public class Delete_StudentController implements Initializable {

    @FXML
    private TextField ID;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
     @FXML
    void DeleteData(ActionEvent event) {

        Connection con = mysql_connection.getConnection();
        PreparedStatement ps = null;
         try {
             String value = ID.getText();
             
             String sql = "DELETE FROM sms.student WHERE id = '"+value+"'";
             ps = con.prepareStatement(sql);
             ps.execute();
             JOptionPane.showMessageDialog(null,"Delete Student Successfully");
         } catch (SQLException e) {
             System.out.println(e.getMessage());
             JOptionPane.showMessageDialog(null,"Delete Failed...");
         }
    }

}
