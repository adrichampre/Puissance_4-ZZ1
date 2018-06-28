/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import core.Principale;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
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
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.IAAlea;
import model.IADefense;
import model.IAFort;
import model.Joueur;
import model.Jeu;

/**
 * FXML Controller class
 *
 * @author adchampred
 */
public class ChoixController implements Initializable {

    private Media media;
    private MediaPlayer mediaplayer;
          
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            media = new Media(getClass().getResource("/ressource/music/bouton.mp3").toURI().toString());
        } catch (URISyntaxException ex) {
            Logger.getLogger(ChoixController.class.getName()).log(Level.SEVERE, null, ex);
        }
        mediaplayer = new MediaPlayer(media);
    }    
    
    @FXML
    private void clickOnRetour(ActionEvent event) throws IOException {
        mediaplayer.play();
        Principale.changerFenetre("/ressource/fxml/Menu.fxml", getClass());
    }
    
    @FXML
    private void clickOn2Joueurs(MouseEvent event) throws IOException {
        mediaplayer.play();
        
        
        //Principale.changerFenetre("/ressource/fxml/Grillev2.fxml", getClass());
       
        Stage stage = Principale.getStage();
        stage.close();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ressource/fxml/Grille.fxml"));
        loader.setController(new GrilleController(new Joueur("Joueur 1", 'R'),new Joueur("Joueur 2", 'J')));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    private void clickOnIA(MouseEvent event) throws IOException {
        mediaplayer.play();
        Stage stage = Principale.getStage();
        stage.close();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ressource/fxml/Grille.fxml"));
        loader.setController(new GrilleController(new Joueur("Joueur 1", 'R'),new IADefense("Skynet", 'J')));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    } 
}
