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
    
    public Joueur(String Pseudo)
    {
        setPseudo(Pseudo);
    }
    
    protected StringProperty pseudo = new SimpleStringProperty();
        public String getPseudo(){ return pseudo.get(); }
        private void setPseudo(String pseudo){ this.pseudo.set(pseudo); }
        public StringProperty pseudoProperty(){ return pseudo; }
        

    public void Jouer(Grille grille)
    {
        /*int col;
        int a;
        //Console.WriteLine("{0} quel colonne souhaitez vous jouer ?",Nom);
        //col = int.Parse(Console.ReadLine());
        a = grille.MettreJeton(col, this);
        while (a != 0)
        {
            Console.WriteLine("Veuillez choisir une autre colonne car la colonne {0} est pleine.", col); 
            col = int.Parse(Console.ReadLine());
            a = grille.MettreJeton(col, this);
        }*/
    }
}
