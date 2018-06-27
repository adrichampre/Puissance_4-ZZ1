/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import core.Principale;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import model.Joueur;
import model.Jeu;

/**
 * FXML Controller class
 *
 * @author adrien
 */
public class GrilleController implements Initializable {

    @FXML
    private GridPane gridPane;
    
    //Model
    private Joueur j1;
    private Joueur j2;
    private Jeu jeu;
    
    public GrilleController(Joueur j1, Joueur j2)
    {
        this.j1 = j1;
        this.j2 = j2;
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.jeu = new Jeu(this.j1,this.j2);
    }
    
    public void jouerTour(MouseEvent event) throws IOException {
        
        int y;
        int x;
        ImageView source = (ImageView) event.getSource();
        
        if (GridPane.getColumnIndex(source) != null) {
            y = GridPane.getColumnIndex(source);
        } else {
            y = 0;
        }
        x = jeu.firstCase(y);
        System.out.println("y :"+ y + " x:" + x);
        if(x != -1)
        {
            jeu.jouerJoueur(y);
            ImageView img = (ImageView) gridPane.getChildren().get(x*7 + y);
            img.setImage(new Image("/ressource/img/"+jeu.getJCourant().getCouleur()+".png"));
            if(jeu.Gagner())
            {
                showMessage(Alert.AlertType.INFORMATION, null, "Victoire de "+jeu.getJCourant().getPseudo(),ButtonType.OK);
                Principale.changerFenetre("/ressource/fxml/Menu.fxml", getClass());
            }
            else
            {
                jeu.changementTour();
                if(jeu.getJCourant().getClass() != Joueur.class)
                {
                    y = jeu.jouerJoueur(y);
                    x = jeu.firstCase(y)-1;
                    img = (ImageView) gridPane.getChildren().get(x*7 + y);
                    img.setImage(new Image("/ressource/img/"+jeu.getJCourant().getCouleur()+".png"));
                    if(jeu.Gagner())
                    {
                        showMessage(Alert.AlertType.INFORMATION, null, "Victoire de "+jeu.getJCourant().getPseudo(),ButtonType.OK);
                        Principale.changerFenetre("/ressource/fxml/Menu.fxml", getClass());
                    }
                    else
                    {
                        jeu.changementTour();
                    }
                }
            }
        }
        
    }
    
    @FXML
    private void clickRetour(MouseEvent event) throws IOException {
        Principale.changerFenetre("/ressource/fxml/Choix.fxml", getClass());
    } 

    private Optional<ButtonType> showMessage(Alert.AlertType type,String header,String message,ButtonType... lesBoutonsDifferents){
        Alert laFenetre = new Alert(type);
        laFenetre.setHeaderText(header);
        laFenetre.setContentText(message);
        if (lesBoutonsDifferents.length > 0) {
            laFenetre.getButtonTypes().clear();
            laFenetre.getButtonTypes().addAll(lesBoutonsDifferents);
        }
        return laFenetre.showAndWait();
    }
    
    
}
