/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author adrien
 */
public class Case {
    
        private char couleur;
        public char getCouleur(){ return couleur; }
        private void setCouleur(char couleur)
        {
            if(couleur != 'R' && couleur != 'J')
            {
                this.couleur = '0';
            }
            else
            {
                this.couleur = couleur;
            }
        }


        private Boolean jeton;
        public Boolean getJeton(){ return jeton; }
        private void setJeton(Boolean jeton) { this.jeton = jeton; }
        

        public Case(char Couleur)
        {
            setCouleur(Couleur);
            if(Couleur != 'R' && Couleur != 'J')
            {
                setJeton(false);
            }
            else
            {
                setJeton(true);
            }
        }
}
