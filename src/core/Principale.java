/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Principale extends Application {
    private static Stage primaryStage;
    
    public static Stage getStage() {
        return primaryStage;
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        Principale.primaryStage = stage;
        Parent root = FXMLLoader.load(getClass().getResource("/view_controller/Menu.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        scene.getStylesheets().add(getClass().getResource("/view_controller/Style.css").toExternalForm());
        stage.setResizable(false);
        stage.setTitle("Puissance 4");
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
