/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.util.logging.Level;
import java.util.logging.Logger;
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
        Parent root = FXMLLoader.load(getClass().getResource("/ressource/fxml/Menu.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        scene.getStylesheets().add(getClass().getResource("/ressource/css/Style.css").toExternalForm());
        stage.setResizable(false);
        stage.setTitle("Puissance 4");
        stage.show();
    }
    
    private static Stage getPrimaryStage() {
        return primaryStage;
    }
        
    public static void changerStage(String window, Class classFenetre) throws Exception{
        Stage stage = Principale.getPrimaryStage();
        stage.close();
        Parent fenetre = FXMLLoader.load(classFenetre.getResource(window));
        Scene sfenetre = new Scene(fenetre);
        stage.setScene(sfenetre);
        stage.show();
    }
    
    public static void changerFenetre(String window, Class classFenetre){
        try{
            changerStage(window,classFenetre);
        }
        catch(Exception ex){
            Logger.getLogger(classFenetre.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
