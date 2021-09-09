/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordcloud;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import static jdk.nashorn.tools.ShellFunctions.input;


/**
 *
 * @author Nikola Vukic
 */


public class PieChartController implements Initializable {
    
    private Map<String, PieChart.Data> cloudWedges;
    private Map<String, Label> cloudLabels;
    // @FXML
    //private Pane pane;// = new Pane();
     
    @FXML
    private AnchorPane cloud;
    
    @FXML
    private TextField addField;

    @FXML
    private Button addNew;
    
    @FXML
    private Button reset;

    @FXML
    private Button quit;
    
    
    @FXML
    private PieChart candPieChart;

    @FXML
    void addCandidate1(ActionEvent event) {
        String name = addField.getText();
     
        addWord(name);
        addWedge(name);
    }
    private void addWord(String candName)
    {
        Label newWord = cloudLabels.get(addField.getText());
        if (newWord!=null) {
            double currFontSize = newWord.getFont().getSize();
            newWord.setFont(new Font(newWord.getFont().getName(), currFontSize+2));
            setWord(newWord);
            PieChart.Data wedge = cloudWedges.get(newWord.getText());
            wedge.setPieValue(wedge.getPieValue()+1);
            return;
        }
        newWord = new Label(addField.getText());
        cloud.getChildren().add(newWord);
        cloud.applyCss();
        cloud.layout();
        
        setWord(newWord);
        //Label newWord = addField.getText();
       /* if (newWord!=null) {
            double currFontSize = newWord.getFont().getSize();
            newWord.setFont(new Font(newWord.getFont().getName(), currFontSize+2));
            setWord(newWord);
            PieChart.Data wedge = cloudWedges.get(newWord.getText());
            wedge.setPieValue(wedge.getPieValue()+1);
            return;
        }*/
        /*pane.setStyle("-fx-background-color: black;");
        pane.setPrefSize(200,200);
        Circle circle = new Circle(50,Color.BLUE);
        pane.relocate(20, 20);
        Rectangle rectangle = new Rectangle(100,100,Color.RED);
        rectangle.relocate(70,70);
        pane.getChildren().addAll(circle,rectangle);*/
        //Label lab= new Label();
        //lab.setText(candName);
        //pane1.add(lab);
        //GridPane gridpane = new GridPane();
        //T/extField text = new TextField(candName);
        //text =candName;
      //gridpane.add(text,1,1);
        //  anchor1.addtext(candName);
    }
    // set Word to be added
    public void setWord(Label newWord)
    {
        
        boolean intersects = false;
        double radius = 1;
        double angle = 0;
        double middleX = cloud.getWidth()/2;
        double middleY = cloud.getHeight()/2;
        do {
            double xPos = middleX + radius*Math.cos(angle);
            double yPos = middleY + radius*Math.cos(angle);
            newWord.setLayoutX(xPos);
            newWord.setLayoutY(yPos);
            newWord.setRotate(0);
            intersects = intersects(newWord);
            if(intersects) {
                newWord.setRotate(90);
                intersects = intersects(newWord);
            }
            radius+=0.5;
            angle+=0.1;
            } while(intersects);
        
        newWord.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
              
              double currFontSize = newWord.getFont().getSize();
              newWord.setFont(new Font(newWord.getFont().getName(), currFontSize+2));
              setWord(newWord);
              PieChart.Data wedge = cloudWedges.get(newWord.getText());
              wedge.setPieValue(wedge.getPieValue()+1);

            }
        });
    }
    private void addWedge(String candName)
    {
        PieChart.Data wedge = new PieChart.Data(candName, 1);
        candPieChart.getData().add(wedge); 
        wedge.getNode().setOnMouseClicked(mev -> growWedge(mev, wedge));      
    }
    
    private void growWedge(MouseEvent e, PieChart.Data w)
    {
        w.setPieValue(w.getPieValue() +1 );
    }
    
    private void reset(PieChart e) {
        e.getData().clear();
        cloud.getChildren().clear();
        addField.setText("");
    }
    
    @FXML
    void clear(ActionEvent event){
        boolean result = ConfirmDialog.display("Clear All", "Are you sure?");
            if(result==true)
            {
                PieChart a=candPieChart;
                reset(a);
            }
    }
    @FXML
    void quit(ActionEvent event){
        boolean result = ConfirmDialog.display("Quit", "Are you sure?");
            if(result==true)
            {
               System.exit(0); //close
            }
    }

    
     private boolean intersects(Label newWord) {
        
        for (Node word: cloud.getChildren())
        {
            Label oldWord = (Label) word;
            Bounds newBounds = newWord.getBoundsInParent();
            Bounds oldBounds = oldWord.getBoundsInParent();
            if(oldBounds.intersects(newBounds) && newWord != oldWord) {
               return true;
            }
      }
      return false;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cloudWedges = new HashMap<String, PieChart.Data>();
        cloudLabels = new HashMap<String, Label>();
    }    

   

    
    
}













/***
 *
 * @author Nikola Vukic
 */
/*

public class PieChartController implements Initializable {
    
     @FXML
    private Pane pane;// = new Pane();
     
    @FXML
    private AnchorPane anchor2;
    
    @FXML
    private TextField addField;

    @FXML
    private Button addNew;
    
    @FXML
    private Button reset;

    @FXML
    private Button quit;
    
    
    @FXML
    private PieChart candPieChart;

    @FXML
    void addCandidate1(ActionEvent event) {
        String name = addField.getText();
     
       // addWord(name);
        addWedge(name);
    }
    private void addWord(String candName)
    {
        pane.setStyle("-fx-background-color: black;");
        pane.setPrefSize(200,200);
        Circle circle = new Circle(50,Color.BLUE);
        pane.relocate(20, 20);
        Rectangle rectangle = new Rectangle(100,100,Color.RED);
        rectangle.relocate(70,70);
        pane.getChildren().addAll(circle,rectangle);
        //Label lab= new Label();
        //lab.setText(candName);
        //pane1.add(lab);
        //GridPane gridpane = new GridPane();
        //T/extField text = new TextField(candName);
        //text =candName;
      //gridpane.add(text,1,1);
        //  anchor1.addtext(candName);
    }
    private void addWedge(String candName)
    {
        PieChart.Data wedge = new PieChart.Data(candName, 1);
        candPieChart.getData().add(wedge); 
        wedge.getNode().setOnMouseClicked(mev -> growWedge(mev, wedge));      
    }
    
    private void growWedge(MouseEvent e, PieChart.Data w)
    {
        w.setPieValue(w.getPieValue() +1 );
    }
    @FXML
    void clear(ActionEvent event){
        boolean result = ConfirmDialog.display("Clear All", "Are you sure?");
            if(result==true)
            {
                PieChart a=candPieChart;
                reset(a);
            }
    }
    @FXML
    void quit(ActionEvent event){
        boolean result = ConfirmDialog.display("Quit", "Are you sure?");
            if(result==true)
            {
               System.exit(0); //close
            }
    }

    private void reset(PieChart e) {
        e.getData().clear();
        addField.setText("");
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
    
}*/
