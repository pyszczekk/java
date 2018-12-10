/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab9;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author pyszczekk
 */
public class StartController implements Initializable {

    @FXML
    private Button login;
    @FXML
    private Button signin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void lWindow(ActionEvent event) throws IOException {
        Stage stage = (Stage) login.getScene().getWindow();
                stage.close();
                Parent root=  FXMLLoader.load(Clients.class.getResource("LoginPanel.fxml"));
                Scene newScene = new Scene(root);
                Stage newStage = new Stage();
                newStage.setScene(newScene);
                newStage.show(); 
    }

    @FXML
    private void sWindow(ActionEvent event) throws IOException {
        Stage stage = (Stage) login.getScene().getWindow();
                stage.close();
                Parent root=  FXMLLoader.load(DataBase.class.getResource("Registration.fxml"));
                Scene newScene = new Scene(root);
                Stage newStage = new Stage();
                newStage.setScene(newScene);
                newStage.show(); 
    }
    
}
