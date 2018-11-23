/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plot;

import static java.lang.Math.abs;
import static java.lang.Math.pow;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author pyszczekk
 */
public class DrawPlot extends Application {
    double a5,a4,a3,a2,a1,a0;
    boolean dark;
    int x1=-10,x2=10;
    int delta;
    double maxY=1;
    boolean draw=true;
    public void customize(){
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Panel użytkownika");
        a.setHeaderText("Podaj przedziały i częstość probkowania");
        a.initStyle(StageStyle.UNDECORATED);
        ButtonType save = new ButtonType("Draw!");
        a.getButtonTypes().clear();
        a.getButtonTypes().addAll(save);
        
        TilePane limField = new TilePane();
        limField.setTranslateY(20);
        TextField xMin = new TextField();
        xMin.setMaxWidth(42);
        TextField xMax = new TextField();
        xMax.setMaxWidth(42);
        TextField d = new TextField();
        d.setMaxWidth(42);
        d.setText("0.1");
        CheckBox color = new CheckBox("dark theme");
        limField.getChildren().addAll(new Label("xMin:"),xMin,new Label("xMax:"),xMax,new Label("Unit:"),d,color);
        StackPane lay = new StackPane();
        lay.getChildren().add(limField);
        lay.setPrefHeight(200);
        lay.setPrefWidth(600);
        a.getDialogPane().setContent(lay);
        
        
        a.showAndWait();
        try{
        dark=color.isSelected();
        this.x1=Integer.parseInt(xMin.getText());
        this.x2=Integer.parseInt(xMax.getText());
        }
        catch(NumberFormatException e){
              draw=false;
              System.out.println("Wrong datas, I can't draw a plot! #Customize");
        }
        
    }
    public void getData(){
        Alert a = new Alert(Alert.AlertType.INFORMATION);
      a.setTitle("Panel użytkownika");
        a.setHeaderText("Podaj kolejne wspolczynniki wielomianu: a5, a4, a3, a2, a1, a0");
        a.initStyle(StageStyle.UNDECORATED);
      
        ButtonType save = new ButtonType("Next step!");
        a.getButtonTypes().clear();
 
        a.getButtonTypes().addAll(save);
        Label l = new Label("a5=");
        Label l2 = new Label("a4=");
        Label l3 = new Label("a3=");
        Label l4 = new Label("a2=");
        Label l5 = new Label("a1="); 
        Label l6 = new Label("a0="); 
        TextField a5 = new TextField();
        TextField a4 = new TextField();
        TextField a3 = new TextField();
        TextField a2 = new TextField();
        TextField a1 = new TextField();
        TextField a0 = new TextField();
       
        a5.setMaxWidth(42);
        a4.setMaxWidth(42);
        a3.setMaxWidth(42);
        a2.setMaxWidth(42);
        a1.setMaxWidth(42);
        a0.setMaxWidth(42);
       
        TilePane aField = new TilePane();
        aField.setTranslateY(20);
        StackPane lay = new StackPane();
        lay.setPrefHeight(150);
        lay.setPrefWidth(500);
        
        aField.setPrefWidth(500);
        aField.getChildren().addAll(l,a5,l2,a4,l3,a3,l4,a2,l5,a1,l6,a0);
        lay.getChildren().addAll(aField);
        
        
        a.getDialogPane().setContent(lay);
        
        
        a.showAndWait();
        try{
        this.a5=Double.parseDouble(a5.getText().replace(",","."));
        this.a4=Double.parseDouble(a4.getText().replace(",","."));
        this.a3=Double.parseDouble(a3.getText().replace(",","."));
        this.a2=Double.parseDouble(a2.getText().replace(",","."));
        this.a1=Double.parseDouble(a1.getText().replace(",","."));
        this.a0=Double.parseDouble(a0.getText().replace(",","."));
       
        }
        catch(NumberFormatException e){
              draw=false;
              System.out.println("Wrong datas, I can't draw a plot!");
        }
    }
    public void findMaxY(){
        for(int i=x1;i<=x2;i++){
        double y=a5 * pow(i,5) + a4 * pow(i,4) + a3 * pow(i,3) + a2 * pow(i,2) + a1 * i + a0 ;
        if(y> maxY)maxY=y;
        }
    }
    
    @Override
    public void start(Stage primaryStage) {
        
        this.getData();
        this.customize();
        if(abs(this.x1)>=abs(this.x2)){
            delta=abs(this.x1);
        }else{
            delta=abs(this.x2);
        }
        findMaxY();
        if(draw){
        Axes axes;
        if(maxY>1){  
        axes = new Axes(
                500, 500,
                -delta, delta, 1,
                (int)-maxY,(int)maxY, (int)maxY/10
        );}
        else{
        axes = new Axes(
                500, 500,
                -delta, delta, 1,
                (int)-maxY,(int)maxY, 0.2
        );}
        Plot plot = new Plot(
                x -> a5 * pow(x,5) + a4 * pow(x,4) + a3 * pow(x,3) + a2 * pow(x,2) + a1 * x + a0,
                this.x1, this.x2, 0.1,
                axes,
                dark
        );

        StackPane root = new StackPane(
                plot
        );
        root.setPadding(new Insets(40));
        if(dark){
            root.setStyle("-fx-background-color: rgb(35, 39, 50);");
            primaryStage.setScene(new Scene(root, Color.rgb(35, 39, 50)));
        }else{
            root.setStyle("-fx-background-color: rgb(240, 255, 234);");
            primaryStage.setScene(new Scene(root, Color.rgb(240, 255, 234)));
        }

        primaryStage.setTitle("Plot");
       // primaryStage.setScene(new Scene(root, Color.rgb(35, 39, 50)));
        primaryStage.show();
        }else{
           throw new UnsupportedOperationException("Wrong datas, I can't draw a plot!");
        }
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    
}
