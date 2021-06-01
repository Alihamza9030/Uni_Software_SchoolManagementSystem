/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoaderFxml;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author Syed Areeb
 */
public class Load_Fxml {
    
    private Load_Fxml(){
    }
    
    
    public static void load_center(BorderPane borderPane, String resources){
        try {
            Parent UI = FXMLLoader.load(new Load_Fxml().getClass().getResource("/fxml/" + resources + ".fxml"));
            borderPane.setCenter(UI);
            
        } catch (IOException ex) {
            Logger.getLogger(Load_Fxml.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
}
