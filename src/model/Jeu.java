/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author adrien
 */
public class Jeu {
    
    private Joueur j1;
    public Joueur getJ1(){ return j1; }
    
    private Joueur j2;
    public Joueur getJ2(){ return j2; }
    
    private Joueur jCourant;
    public Joueur getJCourant(){ return jCourant; }
    
    private StringProperty jTour = new SimpleStringProperty();
    public StringProperty getJTour(){ return jTour; }
    
    private Grille grille;
    
    public Jeu(Joueur j1, Joueur j2)
    {
        this.j1 = j1;
        this.j2 = j2;
        this.grille = new Grille();
        this.jCourant = j1;
        jTour.set(jCourant.getPseudo());
    }
    
    public void changementTour() {
        if (this.jCourant.equals(j1)) {
            this.jCourant = j2;
        } else {
            this.jCourant = j1;
        }
        jTour.set(jCourant.getPseudo());
    }
        
    public int jouerJoueur(int y)
    {
        return jCourant.jouer(grille,y);
    }
    
    public int firstCase(int y)
    {
        
            if(jCourant.getClass() != Joueur.class)
            {
                for (int i = 5; i >= 0; i--) {
                    if(grille.getGrille()[i][y].getJeton())
                    {
                        return i;
                    }
                }
            }
            else
            {
                for (int i = 0; i < 6; i++) {
                    if(!grille.getGrille()[i][y].getJeton())
                    {
                        return i;
                    }
                }
            }
        
            
        return -1;
    }
    
    public Boolean grillePleine()
    {
        for (int i = 0; i < 7; i++) {
            if(!grille.getGrille()[5][i].getJeton())
            {
                return false;
            }
        }
        return true;
    }
    
    public Boolean Gagner()
    {
        return (grille.GagnerLigne() || grille.GagnerCol() || grille.GagnerDiago1() || grille.GagnerDiago2());

    }
    
}