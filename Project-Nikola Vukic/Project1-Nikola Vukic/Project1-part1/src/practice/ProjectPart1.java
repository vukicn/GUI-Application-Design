/*
 * For this project I used Scene Builder. 
 * I implemented buttons, labels, binding, Hbox, Vbox, nesting
 */
package practice;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author vukic
 */
public class ProjectPart1 extends Application {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
       
        stage.setScene(new Scene(root));
        stage.show();
    }
}
