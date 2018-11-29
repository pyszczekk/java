/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBases;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import java.sql.*;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.text.TextAlignment;
import javafx.stage.*;
/**
 * FXML Controller class
 *
 * @author pyszczekk
 */
public class AppController implements Initializable {
    int l=0;
    boolean connection=false;
    boolean search = false;
    private Statement stmt=null;
    ResultSet rs;
    NewBook book;
    String ibsn,title,author,year;
    @FXML
    private ChoiceBox<String> sortChoice;
    private ListView<?> res;
    @FXML
    private Button connectButton;
    @FXML
    private Label connLabel;
    @FXML
    private Button sortButton;

    DataBase db = new DataBase();
    @FXML
    private Button showButton;
    @FXML
    private Button addBookBtn;
    @FXML
    private Button searchButton;
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private CheckBox checkA;
    @FXML
    private CheckBox checkI;
    @FXML
    private TextField AuthorName;
    @FXML
    private TextField IsbnName;
    @FXML
    private CheckBox descSort;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        sortChoice.setItems(FXCollections.observableArrayList("ISBN", "Title","Author","year"));
        showButton.setDisable(true);
        addBookBtn.setDisable(true);
        searchButton.setDisable(true);
        sortButton.setDisable(true);
        IsbnName.textProperty().addListener(new ChangeListener<String>() {
            @Override
           public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                 if (!newValue.matches("\\d{0,13}?")) {
                    IsbnName.setText(oldValue);
                }
            }
        });
        
    }    

    @FXML
    private void connectDB(ActionEvent event) throws InterruptedException, IOException {
        connectButton.setText("connecting...");
        if(l==0){
        l++;
        connectButton.fire();
        }else{
           connecting();
        }
        
    }

    @FXML
    private void showAll(ActionEvent event) {
        //System.out.println("show");
        try {
            search=false;
            stmt = db.getConnection().createStatement();
            rs = stmt.executeQuery("SELECT * FROM books;");
            TilePane main = new TilePane();
            while(rs.next()){
                TilePane pane=new TilePane();
                Label isbn =new Label(rs.getString(1));
                isbn.setPrefWidth(507);
                isbn.setAlignment(Pos.CENTER);
                isbn.setStyle("-fx-font-weight:bold;");
                Label title =new Label(rs.getString(2));
                title.setAlignment(Pos.CENTER);
                title.setPrefWidth(507);
                Label author =new Label(rs.getString(3));
                author.setAlignment(Pos.CENTER);
                author.setPrefWidth(507);
                Label year =new Label(rs.getString(4));
                year.setAlignment(Pos.CENTER);
                year.setPrefWidth(507);
               
               
                pane.getChildren().addAll(isbn,title,author,year);
                pane.setStyle("-fx-padding: 20px; -fx-background-color:rgba(134,255,236,0.1); -fx-border-color: rgba(113,187,208,0.5); -fx-border-width: 1;");
                pane.setPrefWidth(507);
                pane.setVgap(10);
               
                main.getChildren().add(pane);
                main.setVgap(15);
                main.setStyle("-fx-background-color: rgba(255,255,255,0.8);");
                main.setPrefColumns(1);
            }
            scrollPane.setContent(main);
        } catch (SQLException ex) {
            Logger.getLogger(AppController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void addNewBook(ActionEvent event) throws IOException {
        
        Parent root=  FXMLLoader.load(Main.class.getResource("AddBook.fxml"));
        Scene newScene = new Scene(root);
       
        System.out.println(root.getChildrenUnmodifiable().get(5));
        Stage newStage = new Stage();
        newStage.setScene(newScene);
        newStage.show();
        
       
    }

    @FXML
    private void searchBooks(ActionEvent event) {
        try {
            search =true;
            stmt = db.getConnection().createStatement();
            rs=null;
            if(checkA.isSelected() && checkI.isSelected()){
                 rs = stmt.executeQuery("SELECT * FROM books WHERE isbn="+IsbnName.getText()+" AND author LIKE '%"+AuthorName.getText()+"';" );
            }
            else if(checkA.isSelected()){
                  rs = stmt.executeQuery("SELECT * FROM books WHERE author LIKE '% "+AuthorName.getText()+"';" );
            }else if(checkI.isSelected()){
                 rs = stmt.executeQuery("SELECT * FROM books WHERE isbn="+IsbnName.getText()+";" );
            };
           
            TilePane main = new TilePane();
            while(rs.next()){
                TilePane pane=new TilePane();
                Label isbn =new Label(rs.getString(1));
                isbn.setPrefWidth(507);
                isbn.setAlignment(Pos.CENTER);
                isbn.setStyle("-fx-font-weight:bold;");
                Label title =new Label(rs.getString(2));
                title.setAlignment(Pos.CENTER);
                title.setPrefWidth(507);
                Label author =new Label(rs.getString(3));
                author.setAlignment(Pos.CENTER);
                author.setPrefWidth(507);
                Label year =new Label(rs.getString(4));
                year.setAlignment(Pos.CENTER);
                year.setPrefWidth(507);
               
               
                pane.getChildren().addAll(isbn,title,author,year);
                pane.setStyle("-fx-padding: 20px; -fx-background-color:rgba(134,255,236,0.1); -fx-border-color: rgba(113,187,208,0.5); -fx-border-width: 1;");
                pane.setPrefWidth(507);
                pane.setVgap(10);
               
                main.getChildren().add(pane);
                main.setVgap(15);
                main.setPrefColumns(1);
            }
            scrollPane.setContent(main);
        } catch (SQLException ex) {
            Logger.getLogger(AppController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void connecting() throws InterruptedException, IOException{
         while(l<=3 && !connection){
                l+=1;
                System.out.println("łącze ....");
                db.connection();
                connection=db.isConnected();
                TimeUnit.SECONDS.sleep(2);
            }
            if(l>2 && !connection){
                Stage stage = (Stage) connectButton.getScene().getWindow();
                stage.close();
                Parent root=  FXMLLoader.load(Main.class.getResource("Failure.fxml"));
                Scene newScene = new Scene(root);
                Stage newStage = new Stage();
                newStage.setScene(newScene);
                newStage.show(); 
            }
            if(connection){
                connLabel.setText("connection succeeded ");
                showButton.setDisable(false);
                addBookBtn.setDisable(false);
                searchButton.setDisable(false);
                sortButton.setDisable(false);
                connectButton.setDisable(true);
            }
    }

    @FXML
    private void sort(ActionEvent event) {
        try {
            stmt = db.getConnection().createStatement();
            rs=null;
            if(sortChoice.getSelectionModel().getSelectedItem()!=null){
                String field=sortChoice.getSelectionModel().getSelectedItem();
                if(search){
                if(checkA.isSelected() && checkI.isSelected()){
                    if(descSort.isSelected()){
                         rs = stmt.executeQuery("SELECT * FROM books WHERE isbn="+IsbnName.getText()+" AND author LIKE '%"+AuthorName.getText()+"' ORDER BY "+field+" DESC;" );
               
                    }else{
                        rs = stmt.executeQuery("SELECT * FROM books WHERE isbn="+IsbnName.getText()+" AND author LIKE '%"+AuthorName.getText()+"' ORDER BY "+field+";" );
               
                    }
                // rs = stmt.executeQuery("SELECT * FROM books WHERE isbn="+IsbnName.getText()+" AND author LIKE '%"+AuthorName.getText()+"';" );
                }
                else if(checkA.isSelected()){
                    if(descSort.isSelected()){
                         rs = stmt.executeQuery("SELECT * FROM books WHERE author LIKE '% "+AuthorName.getText()+"' ORDER BY "+field+" DESC;" );
               
                    }else{
                         rs = stmt.executeQuery("SELECT * FROM books WHERE author LIKE '% "+AuthorName.getText()+"' ORDER BY "+field+" ;" );
               
                    }
                     // rs = stmt.executeQuery("SELECT * FROM books WHERE author LIKE '% "+AuthorName.getText()+"';" );
                }else if(checkI.isSelected()){
                    if(descSort.isSelected()){
                        rs = stmt.executeQuery("SELECT * FROM books WHERE isbn="+IsbnName.getText()+" ORDER BY "+field+" DESC;" );
                    }else{
                      rs = stmt.executeQuery("SELECT * FROM books WHERE isbn="+IsbnName.getText()+" ORDER BY "+field+";" );
                    }
                }
                }
                else{
                   if(descSort.isSelected()){
                        rs = stmt.executeQuery("SELECT * FROM books ORDER BY "+field+" DESC;" );
                    }else{
                      rs = stmt.executeQuery("SELECT * FROM books ORDER BY "+field+";" );
                    } 
                }
               // if ("IBN".equals(field))  field="isbn";
                
            }
            
           
            TilePane main = new TilePane();
            while(rs.next()){
                TilePane pane=new TilePane();
                Label isbn =new Label(rs.getString(1));
                isbn.setPrefWidth(507);
                isbn.setAlignment(Pos.CENTER);
                isbn.setStyle("-fx-font-weight:bold;");
                Label title =new Label(rs.getString(2));
                title.setAlignment(Pos.CENTER);
                title.setPrefWidth(507);
                Label author =new Label(rs.getString(3));
                author.setAlignment(Pos.CENTER);
                author.setPrefWidth(507);
                Label year =new Label(rs.getString(4));
                year.setAlignment(Pos.CENTER);
                year.setPrefWidth(507);
               
               
                pane.getChildren().addAll(isbn,title,author,year);
                pane.setStyle("-fx-padding: 20px; -fx-background-color:rgba(134,255,236,0.1); -fx-border-color: rgba(113,187,208,0.5); -fx-border-width: 1;");
                pane.setPrefWidth(507);
                pane.setVgap(10);
               
                main.getChildren().add(pane);
                main.setVgap(15);
                main.setPrefColumns(1);
            }
            scrollPane.setContent(main);
        } catch (SQLException ex) {
            Logger.getLogger(AppController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
