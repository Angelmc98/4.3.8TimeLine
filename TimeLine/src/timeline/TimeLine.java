/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timeline;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Angel Medina Cantos
 */
public class TimeLine extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        Pane root = new Pane();
        Scene scene = new Scene(root, 300, 250);
        
        // Creamos la bolita
        Circle bolita = new Circle(20, Color.BLACK);
        bolita.relocate(10,10);
        root.getChildren().add(bolita);
        
        
        Timeline timeline = new Timeline(2, new KeyFrame(Duration.millis(2), 
                new EventHandler<ActionEvent>() {
 
        	double dx = Math.random(); 
        	double dy = Math.random(); 
        	
            @Override
            public void handle(ActionEvent t) {
            	//Movemos la bolita
            	bolita.setLayoutX(bolita.getLayoutX() + dx);
            	bolita.setLayoutY(bolita.getLayoutY() + dy);
                Bounds bounds = root.getBoundsInLocal();
                
                
                if(bolita.getLayoutX() <= (bounds.getMinX() + bolita.getRadius()) || 
                        bolita.getLayoutX() >= (bounds.getMaxX() - bolita.getRadius()) ){
 
                	dx = -dx;
 
                }
 
                
                if((bolita.getLayoutY() >= (bounds.getMaxY() - bolita.getRadius())) || 
                        (bolita.getLayoutY() <= (bounds.getMinY() + bolita.getRadius()))){
 
                	dy = -dy;
 
                }
            }
        }));
        
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
 
        primaryStage.setTitle("Time Line");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
