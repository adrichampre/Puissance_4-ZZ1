/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view_controller;

import core.Principale;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author loudu
 */
public class ChoixController implements Initializable {

    private Media media;
    private MediaPlayer mediaplayer;
          
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            media = new Media(getClass().getResource("/music/bouton.mp3").toURI().toString());
        } catch (URISyntaxException ex) {
            Logger.getLogger(ChoixController.class.getName()).log(Level.SEVERE, null, ex);
        }
        mediaplayer = new MediaPlayer(media);
    }    
    
    @FXML
    private void clickOnRetour(ActionEvent event) throws IOException {
        mediaplayer.play();
        Stage stage = Principale.getStage();
        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/view_controller/Style.css").toExternalForm());
        stage.setScene(scene);
    }
    
    @FXML
    private void clickOn2Joueurs(MouseEvent event) throws IOException {
        mediaplayer.play();
        Stage stage = Principale.getStage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Test.fxml"));
        //loader.setController(new NiveauController(1));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/view_controller/Style.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    private void clickOnIA(MouseEvent event) throws IOException {
        mediaplayer.play();
        Stage stage = Principale.getStage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Test.fxml"));
        //loader.setController(new NiveauController(2));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/view_controller/Style.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    } 
}
