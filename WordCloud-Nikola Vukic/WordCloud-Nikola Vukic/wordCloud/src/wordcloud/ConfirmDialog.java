/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordcloud;

import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Nikola Vukic
 */
class ConfirmDialog {
    
    static boolean response;
    
    public static boolean display(String title, String message){
        Stage window = new Stage();
        
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(300);
        Label label = new Label();
        label.setText(message);
        
        Button yesB= new Button("Yes");
        Button noB= new Button("No");

        yesB.setOnAction(e -> {
            response=true;
            window.close();
        });
        noB.setOnAction(e -> {
            response=false;
            window.close();
        });
        
        HBox layoutB =  new HBox(10);
        layoutB.getChildren().addAll(yesB, noB);
        layoutB.setAlignment(Pos.CENTER);
        
        VBox layout =  new VBox(20);
        layout.getChildren().addAll(label,layoutB);
        layout.setAlignment(Pos.CENTER);
        
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
        
        return response;
    }
}
