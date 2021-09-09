/*
 * I implemented picture. 
 */
package project1part3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author vukic
 */
public class Project1Part3 extends Application {
    
    @Override
    public void start(Stage stage){
      
       Image butterfly = new Image("https://www.mdsci.org/wp-content/uploads/2018/05/flight-butterflies-3.jpg");
       ImageView imageView = new ImageView();
       
       imageView.setImage(butterfly);
       imageView.setFitWidth(300);
       imageView.setPreserveRatio(true);
       
       StackPane root = new StackPane();
       root.getChildren().add(imageView);
        
       stage.setScene(new Scene(root,400,400));
       stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
