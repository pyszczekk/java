/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plot;


import java.util.function.Function;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author pyszczekk
 */
public class Plot extends Pane {
    double xMin, xMax;
    
        public Plot(
                Function<Double, Double> f,
                double xMin, double xMax, double xInc,
                Axes axes,
                boolean dark
        ) {
            Path path = new Path();
            if(dark){
                path.setStroke(Color.ORANGE.deriveColor(0, 1, 1, 0.6));
            }else{
                path.setStroke(Color.RED.deriveColor(0, 1, 1, 0.6));
            }
            path.setStrokeWidth(2);

            path.setClip(
                    new Rectangle(
                            0, 0, 
                            axes.getPrefWidth(), 
                            axes.getPrefHeight()
                    )
            );
            this.xMin=xMin;
            this.xMax=xMax;
            double x = xMin;
            double y = f.apply(x);

            path.getElements().add(
                    new MoveTo(
                            mapX(x, axes), mapY(y, axes)
                    )
            );

            x += xInc;
            while (x < xMax) {
                y = f.apply(x);

                path.getElements().add(
                        new LineTo(
                                mapX(x, axes), mapY(y, axes)
                        )
                );

                x += xInc;
            }

            setMinSize(Pane.USE_PREF_SIZE, Pane.USE_PREF_SIZE);
            setPrefSize(axes.getPrefWidth(), axes.getPrefHeight());
            setMaxSize(Pane.USE_PREF_SIZE, Pane.USE_PREF_SIZE);

            getChildren().setAll(axes, path);
        }

        private double mapX(double x, Axes axes) {
            double tx = axes.getPrefWidth()/2;
            double sx = axes.getPrefWidth() / 
               (axes.getXAxis().getUpperBound() - 
                axes.getXAxis().getLowerBound());

            return x * sx + tx;
        }

        private double mapY(double y, Axes axes) {
            double ty = axes.getPrefHeight()/2 ;
            double sy = axes.getPrefHeight() / 
                (axes.getYAxis().getUpperBound() - 
                 axes.getYAxis().getLowerBound());
            return -y * sy + ty;
        }
        
    
}
