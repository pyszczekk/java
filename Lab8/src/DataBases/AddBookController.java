/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBases;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author pyszczekk
 */
public class AddBookController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private TextField isbn;
    @FXML
    private TextField title;
    @FXML
    private TextField auhor; /*literowka lol */
    @FXML
    private TextField year;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        isbn.textProperty().addListener(new ChangeListener<String>() {
            @Override
           public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                 if (!newValue.matches("\\d{0,13}?")) {
                    isbn.setText(oldValue);
                }
            }
        });
    }    

    @FXML
    private void addBook(ActionEvent event) {
        Thread thread = new Thread(){
            @Override
            public void run(){
              NewBook book = new NewBook(isbn.getText(),title.getText(),auhor.getText(),year.getText());
                DataBase db = new DataBase();
                try {
                    db.connection();
                    Statement stmt=db.getConnection().createStatement();
                    stmt.executeUpdate("INSERT INTO books (isbn, title, author, year) VALUES ('"+book.getIBSN()+"', '"+book.getTitle()+"', '"+book.getAuthor()+"', '"+book.getYear()+"');");
                    db.getConnection().close();
                } catch (SQLException ex) {
                    Logger.getLogger(AddBookController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };

        thread.start();
        Stage sc = (Stage)year.getScene().getWindow();
        sc.close();
        
    }
    
    
}
