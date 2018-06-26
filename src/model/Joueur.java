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
public class Joueur {
    
    public Joueur(String Pseudo, char Couleur)
    {
        setPseudo(Pseudo);
        setCouleur(Couleur);
    }
    
    protected StringProperty pseudo = new SimpleStringProperty();
        public String getPseudo(){ return pseudo.get(); }
        private void setPseudo(String pseudo){ this.pseudo.set(pseudo); }
        public StringProperty pseudoProperty(){ return pseudo; }
        
    protected char couleur;
    public char getCouleur(){ return couleur; }
    private void setCouleur(char couleur)
    {
        if(couleur == 'R' || couleur == 'J')
            this.couleur = couleur;
    }

}
