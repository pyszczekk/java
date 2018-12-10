/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab9;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author pyszczekk
 */
public class LoginPanelController implements Initializable {

    @FXML
    private Button LoginButton;
    @FXML
    private PasswordField password;
    @FXML
    private TextField login;
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
    private void login(ActionEvent event) throws IOException {
            db.connection();
            connection=db.isConnected();
                
            
            if(!connection){
               System.out.println("nie udalo sie polaczyc");
               System.exit(-1);
            }
            if(connection){
               System.out.println("sprawdzam czy dobre dane");
               
            }
             Stage stage = (Stage) LoginButton.getScene().getWindow();
                stage.close();
       
       }
    public String getLogin()
    {
        String login = this.login.getText();
        System.out.println("Login: " + login);
        return login;
    }

    public String getPassword()
    {
        String haslo = this.password.getText().toString();
        System.out.println("Haslo: " + haslo);
        return haslo;
    }

 

    
}
