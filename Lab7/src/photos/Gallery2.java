/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package photos;
import java.io.File;

import javafx.event.EventHandler;

import javafx.scene.control.ScrollPane;

import javafx.scene.layout.TilePane;

import javafx.stage.Screen;

import javafx.application.Application;
import javafx.scene.Scene;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.stage.Stage;

import java.io.FileInputStream;
import static javafx.application.Application.launch;

import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.DirectoryChooser;


/**
 *
 * @author pyszczekk
 */
public class Gallery2 extends Application{
    Stage stage;
    ImageView main;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      
       String path = "/Users/pyszczekk/Desktop/wszystko/all";
        DirectoryChooser directoryChooser = new DirectoryChooser();
        File selectedDirectory = directoryChooser.showDialog(primaryStage);

        if(selectedDirectory == null){
              path = "/Users/pyszczekk/Desktop/wszystko/all";
        }else{
            path=selectedDirectory.getAbsolutePath();
        }
         primaryStage.setTitle("Gallery of: "+path);
    File folder = new File(path);
    File[] listOfFiles = folder.listFiles();
   
    stage = primaryStage;
    ScrollPane root = new ScrollPane();
    TilePane centeredLayout = new TilePane();
    TilePane tile = new TilePane();
    TilePane tile2 = new TilePane();
    for(final File file: listOfFiles){
        //System.out.println(file);
       
        if(file.isFile()){
        String fileName = file.getName();          
        String fileExtension = fileName.substring(fileName.lastIndexOf(".")+1, file.getName().length());
       
        if("png".equals(fileExtension) ||"jpg".equals(fileExtension)||"gif".equals(fileExtension)||"jpeg".equals(fileExtension)){    
        FileInputStream input = new FileInputStream(file);
        
        Image image = new Image(input);
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(50);
        imageView.setPreserveRatio(true);
        imageView.setPickOnBounds(true);
        
        imageView.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
           
            main= new ImageView(imageView.getImage());
           // main.setFitWidth(Screen.getPrimary().getVisualBounds().getWidth()/2);
            if(imageView.getImage().getHeight()>imageView.getImage().getWidth()){
                 main.setFitHeight(Screen.getPrimary().getVisualBounds().getHeight());
            }else{
            main.setFitWidth(Screen.getPrimary().getVisualBounds().getWidth()/2);
            }
            main.setPreserveRatio(true);
           
        
            tile2.setPrefColumns(1);
            tile2.setPrefRows(1);
            tile2.getChildren().clear();
             tile2.getChildren().addAll(main);
           
        
            // TilePane.setAlignment(main,Pos.TOP_LEFT);
           centeredLayout.getChildren().add(tile2);
           
            }
        });
        
        tile.getChildren().addAll(imageView);
       // tile.setStyle("-fx-background-color: rgb(35, 39, 50);");
        }
        }
    }
        
        root.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED); // Horizontal
        root.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED); // Vertical scroll bar

        root.setContent(tile);
        
        centeredLayout.getChildren().addAll(root, tile2);

        primaryStage.setWidth(Screen.getPrimary().getVisualBounds().getWidth());
        primaryStage.setHeight(Screen.getPrimary().getVisualBounds()
                .getHeight());
        Scene scene = new Scene(centeredLayout, Color.rgb(35, 39, 50));
 
        primaryStage.setScene(scene);
       
        primaryStage.show();
    }
    
   
    
     public static void main(String[] args) {
        
        launch(args);
    }
}
