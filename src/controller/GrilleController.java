/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import core.Principale;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
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
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.j1 = new Joueur("Joueur 1", 'R');
        this.j2 = new Joueur("Joueur 2", 'J');
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
            if(jeu.jouer(y))
            {
                ImageView img = (ImageView) gridPane.getChildren().get(x*7 + y);
                img.setImage(new Image("/ressource/img/"+jeu.getJCourant().getCouleur()+".png"));
                if(jeu.Gagner())
                {
                    System.out.println("Victoire de "+jeu.getJCourant().getPseudo());
                }
                else
                {
                    jeu.changementTour();
                }
            }
        }
        
    }
    
    @FXML
    private void clickRetour(MouseEvent event) throws IOException {
        Principale.changerFenetre("/ressource/fxml/Choix.fxml", getClass());
    } 
    
    
}
