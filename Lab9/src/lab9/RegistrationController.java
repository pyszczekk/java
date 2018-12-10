/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab9;

import communicator.*;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author pyszczekk
 */
public class RegistrationController implements Initializable {

    @FXML
    private PasswordField password;
    @FXML
    private TextField login;
    @FXML
    private Button RegButton;
     DataBase db = new DataBase();
    boolean connection=false;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void newAccount(ActionEvent event) throws IOException, SQLException {
            db.connection();
            connection=db.isConnected();
            if(!connection){
               System.out.println("nie udalo sie polaczyc");
               //System.exit(-1);
            }
            if(connection){
               System.out.println("sprawdzam czy dobre dane");
                Statement stmt=db.getConnection().createStatement();
                stmt.executeUpdate("INSERT INTO komunikator (login, password) VALUES ('"+login.getText()+"', '"+password.getText()+"');");
                db.getConnection().close();
                Stage stage = (Stage) RegButton.getScene().getWindow();
                stage.close();
            }
       
    }
    
}
