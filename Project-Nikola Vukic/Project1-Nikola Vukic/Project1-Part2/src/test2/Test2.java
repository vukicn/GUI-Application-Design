/*
 * I implemented shapes, colors, gradients
 */
package test2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author vukic
 */
public class Test2 extends Application {
    
    @Override
    public void start(Stage stage) {

        Arc arc = new Arc();
        arc.setCenterX(300);
        arc.setCenterY(225);
        arc.setRadiusX(50);
        arc.setRadiusY(50);
        arc.setStartAngle(45);
        arc.setLength(270);
        arc.setType(ArcType.OPEN);
        arc.setFill(Color.rgb(150, 50, 100));
        arc.setStroke(Color.rgb(255,0,255));
                
        Polyline polyline = new Polyline();
        polyline.getPoints().addAll(new Double[]
        {100.0, 200.0,
         100.0, 100.0,
         200.0, 100.0,
         200.0, 200.0
        });
        polyline.setStrokeWidth(15);
        polyline.setStroke(Color.web("#0099FF"));
        
        Line line = new Line();
        line.setStartX(100);
        line.setStartY(100);
        line.setEndX(150);
        line.setEndY(300);
        
        Rectangle rectangle = new Rectangle();
        Stop[] gradientStops;
        gradientStops = new Stop[]{
            new Stop(0, Color.OLIVE),
            new Stop(1, Color.WHITE)};
        LinearGradient lg = new LinearGradient(0,0,1,0, true, 
                                CycleMethod.NO_CYCLE,gradientStops );
        rectangle.setX(80);
        rectangle.setY(300);
        rectangle.setWidth(300);
        rectangle.setHeight(100);
        rectangle.setFill(lg);
        
        Circle circle = new Circle();
        Stop[] gradientStop;
        gradientStop = new Stop[]{
            new Stop(0, Color.YELLOW),
            new Stop(1, Color.WHITE)};
        LinearGradient gg = new LinearGradient(0.1,.1,5,5, true, 
                                CycleMethod.NO_CYCLE,gradientStop );
        circle.setRadius(70);
        circle.setCenterX(100);
        circle.setCenterY(400);
        circle.setFill(gg);
        
        AnchorPane root = new AnchorPane();
        
        line.setStrokeWidth(25);
        line.setStroke(Color.TOMATO);
        
        
        root.getChildren().add(rectangle);
        root.getChildren().add(line);
        root.getChildren().add(polyline);
        root.getChildren().add(arc);
        root.getChildren().add(circle);
        stage.setScene(new Scene(root, 600, 600));
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
