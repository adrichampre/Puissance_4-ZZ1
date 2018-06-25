/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.stage.Modality;
import core.Principale;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * FXML Controller class
 *
 * @author adchampred
 */
public class MenuController implements Initializable {
    
    private Media mediaBouton;
    private Media mediaJeu;
    private MediaPlayer mediaplayerBouton;
    private MediaPlayer mediaplayerJeu;
    
    
    @FXML
    private void handleButtonJouer(ActionEvent event) throws IOException {
        try {
            mediaBouton = new Media(getClass().getResource("/ressource/music/bouton.mp3").toURI().toString());
        } catch (URISyntaxException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
        mediaplayerBouton = new MediaPlayer(mediaBouton);
        mediaplayerBouton.play();
        mediaplayerJeu.stop();
        Principale.changerFenetre("/ressource/fxml/Choix.fxml", getClass());
    }
    
    @FXML
    private void handleButtonRegles(ActionEvent event) throws IOException {
        try {
            mediaBouton = new Media(getClass().getResource("/ressource/music/bouton.mp3").toURI().toString());
        } catch (URISyntaxException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
        mediaplayerBouton = new MediaPlayer(mediaBouton);
        mediaplayerBouton.play();
        
        Stage stage= new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ressource/fxml/Regles.fxml"));
        loader.setController(new ReglesController(stage,mediaplayerJeu));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    private void handleButtonQuitter(ActionEvent event) {
        try {
            mediaBouton = new Media(getClass().getResource("/ressource/music/bouton.mp3").toURI().toString());
        } catch (URISyntaxException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
        mediaplayerBouton = new MediaPlayer(mediaBouton);
        mediaplayerBouton.play();
        Principale.getStage().close();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            mediaJeu = new Media(getClass().getResource("/ressource/music/jeuTheme.mp3").toURI().toString());
        } catch (URISyntaxException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
        mediaplayerJeu = new MediaPlayer(mediaJeu);
        mediaplayerJeu.play();
    } 
}
