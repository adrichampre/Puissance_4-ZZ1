/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import static java.lang.Math.abs;
import java.util.Random;

/**
 *
 * @author adrien
 */
public class IAAlea extends Joueur{
    
    public IAAlea(String Pseudo, char Couleur) {
        super(Pseudo, Couleur);
    }
    
    public int jouer(Grille grille, int y)
    {
        Random rand = new Random();
        y = abs(rand.nextInt()%7);
        while(!grille.mettreJeton(y, couleur))
        {
            y = abs(rand.nextInt()%7);
        }
        
        return y;
    }
}
