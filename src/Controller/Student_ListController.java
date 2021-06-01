/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaFiles.Student;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.print.PageLayout;
import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Syed Areeb
 */
public class Student_ListController implements Initializable {

    @FXML
    private TableView<Student> Table;
    @FXML
    private TableColumn<Student, Integer> col_id;
    @FXML
    private TableColumn<Student, String> col_name;
    @FXML
    private TableColumn<Student, String> col_fname;
    @FXML
    private TableColumn<Student, String> col_cast;
    @FXML
    private TableColumn<Student, String> col_age;
    @FXML
    private TableColumn<Student, String> col_gender;
    @FXML
    private TableColumn<Student, String> col_dob;
    @FXML
    private TableColumn<Student, Integer> col_Sclass;
    @FXML
    private TableColumn<Student, String> col_rollno;
    @FXML
    private TableColumn<Student, String> col_add;
    @FXML
    private TableColumn<Student, String> col_cont;
     
    ObservableList<Student> listm;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        col_id.setCellValueFactory(new PropertyValueFactory<Student,Integer>("id"));
        col_name.setCellValueFactory(new PropertyValueFactory<Student,String>("sname"));
        col_fname.setCellValueFactory(new PropertyValueFactory<Student,String>("fname"));
        col_cast.setCellValueFactory(new PropertyValueFactory<Student,String>("cast"));
        col_age.setCellValueFactory(new PropertyValueFactory<Student,String>("age"));
        col_gender.setCellValueFactory(new PropertyValueFactory<Student,String>("gender"));
        col_dob.setCellValueFactory(new PropertyValueFactory<Student,String>("dob"));
        col_Sclass.setCellValueFactory(new PropertyValueFactory<Student,Integer>("sclass"));
        col_rollno.setCellValueFactory(new PropertyValueFactory<Student,String>("rollno"));
        col_add.setCellValueFactory(new PropertyValueFactory<Student,String>("address"));
        col_cont.setCellValueFactory(new PropertyValueFactory<Student,String>("contact"));
        
        listm = StudentController.getData();
        Table.setItems(listm);
    }    
    @FXML
    void UpdateStudent(ActionEvent event) {
       try {
            FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("/fxml/Update_Student.fxml"));
            Parent root = (Parent) fxmlloader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
          
        } catch (IOException ex) {
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     @FXML
    void RefreshList(ActionEvent event) {
       listm = StudentController.getData();
       Table.setItems(listm);
    }
    
    @FXML
    void DeleteStudent(ActionEvent event) {
      try {
            FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("/fxml/Delete_Student.fxml"));
            Parent root = (Parent) fxmlloader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
          
        } catch (IOException ex) {
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    void PrintData(ActionEvent event) {

            Printer printer = Printer.getDefaultPrinter();
            PageLayout pageLayout = printer.createPageLayout(Paper.A4, PageOrientation.LANDSCAPE, Printer.MarginType.DEFAULT);


            PrinterJob job = PrinterJob.createPrinterJob();
            if (job != null) {
                boolean successPrintDialog = job.showPrintDialog(null);
                if(successPrintDialog){
                    boolean success = job.printPage(pageLayout,Table);
                    if (success) {
                        job.endJob();
                    }
                }
            }
        
    }
}
