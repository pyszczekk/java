/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package photos;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import javafx.event.EventType;
import javafx.scene.input.MouseEvent;
import javax.swing.text.View;


/**
 *
 * @author pyszczekk
 */
public class Gallery extends Application{
    Stage stage;
    @Override
    public void start(Stage primaryStage) throws Exception {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String path = "/Users/pyszczekk/Desktop/wszystko/all";

    File folder = new File(path);
    File[] listOfFiles = folder.listFiles();
   
    stage = primaryStage;
    ScrollPane root = new ScrollPane();
    TilePane tile = new TilePane();
    
    for(final File file: listOfFiles){
        //System.out.println(file);
       
        if(file.isFile()){
        String fileName = file.getName();          
        String fileExtension = fileName.substring(fileName.lastIndexOf(".")+1, file.getName().length());
        //System.out.println(fileExtension);
        if("png".equals(fileExtension) ||"jpg".equals(fileExtension)||"gif".equals(fileExtension)||"jpeg".equals(fileExtension)){    
        FileInputStream input = new FileInputStream(file);
        
        Image image = new Image(input);

        ImageView imageView = new ImageView(image);
        //imageView = new ImageView("/Users/pyszczekk/Desktop/wx.png");
        imageView.setFitWidth(100);
        imageView.setFitHeight(100);
        imageView.setPreserveRatio(true);
        imageView.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
             System.out.println(imageView.getImage());
            }
        });
        tile.getChildren().addAll(imageView);
        }
        }
    }
        //ImageView imageView;
        //FileInputStream input = new FileInputStream("/Users/pyszczekk/Desktop/wx.png");
        //Image image;
        //image = ImageIO.read("/Users/pyszczekk/Desktop/wx.png");
        
    
        root.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER); // Horizontal
        root.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED); // Vertical scroll bar
        root.setFitToWidth(true);
        root.setContent(tile);
        
        primaryStage.setWidth(Screen.getPrimary().getVisualBounds().getWidth());
        primaryStage.setHeight(Screen.getPrimary().getVisualBounds()
                .getHeight());
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
   
    
     public static void main(String[] args) {
        launch(args);
    }
}
