/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import core.Principale;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.text.Font;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
        
/**
 * FXML Controller class
 *
 * @author loudu
 */
public class ReglesController implements Initializable {
    
    private final Stage stageRegles;
    private Media mediaBouton;
    private MediaPlayer mediaplayerBouton;
    private MediaPlayer mediaplayerJeu;
    
    public ReglesController(Stage stageRegles,MediaPlayer mediaplayerJeu) {
        this.mediaplayerJeu=mediaplayerJeu;
        this.stageRegles=stageRegles;
        stageRegles.setMinWidth(250);
        stageRegles.setMinHeight(400);
    }
    
    @FXML
    private TextArea zoneTexte;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Platform.runLater(()->zoneTexte.getScene().getWindow().widthProperty().addListener((obs, old, newV) -> {
            Font texte = new Font(newV.intValue() / 40);
            zoneTexte.setFont(texte);
        }));
        
        try {
            mediaBouton = new Media(getClass().getResource("/ressource/music/bouton.mp3").toURI().toString());
        } catch (URISyntaxException ex) {
            Logger.getLogger(ReglesController.class.getName()).log(Level.SEVERE, null, ex);
        }
        mediaplayerBouton = new MediaPlayer(mediaBouton);
    }  
    
    @FXML
    private void clickOnJouer(ActionEvent event) throws IOException {
        mediaplayerBouton.play();
        mediaplayerJeu.stop();
        Principale.changerFenetre("/ressource/fxml/Choix.fxml", getClass());
        stageRegles.hide();
    }
    
    @FXML
    private void clickOnRetour(ActionEvent event) throws IOException {
        mediaplayerBouton.play();
        stageRegles.close();
    }
}
    
