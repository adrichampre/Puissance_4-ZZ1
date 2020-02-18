/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import static java.lang.Integer.max;

/**
 *
 * @author adrien
 */
public class IADefense extends Joueur
{

    public IADefense(String Pseudo, char Couleur) {
        super(Pseudo, Couleur);
    }

    @Override
    public int jouer(Grille grille, int y)
    {
        int poids[] = new int[7];
        int max=0;
        
        for (int col = 0; col < 7; col++) {
            
            for (int line = 0; line < 6; line++) {
                if(!grille.getGrille()[line][col].getJeton())
                {
                    poids[col] = calculPoidsPoint(grille,line,col);
                    break;
                }
            }
        }
        
        for (int i = 1; i < poids.length; i++) {
            if(poids[max] < poids[i])
            {
                max = i;
            }
        }
        grille.mettreJeton(max, couleur);
        return max;
    }
    
    private int calculPoidsPoint(Grille grille,int line, int col)
    {
        int max=0;
        
        max = max(calculPoidsHorizontal(grille, line, col),calculPoidsVertical(grille, line, col));
        max = max(max,calculPoidsDiago1(grille, line, col));
        max = max(max,calculPoidsDiago2(grille, line, col));
        
        return max;
    }
    
    
    private int calculPoidsHorizontal(Grille grille, int line, int col)
    {
        int poids=0;
        
        for (int i = 1; i < 4; i++) {
            if( (col-i) >= 0 )
            {
                if(grille.getGrille()[line][col-i].getCouleur() != couleur && grille.getGrille()[line][col-i].getCouleur() != '0')
                {
                    poids++;
                }
                else
                    break;
            }
            else
                break;
        }
        
        for (int i = 1; i < 4; i++) {
            if( (col+i) < 7 )
            {
                if(grille.getGrille()[line][col+i].getCouleur() != couleur && grille.getGrille()[line][col+i].getCouleur() != '0')
                {
                    poids++;
                }
                else
                    break;
            }
            else
                break;
        }
        
        return poids;
    }
    
    
    private int calculPoidsVertical(Grille grille, int line, int col)
    {
        int poids=0;
        
        for (int i = 1; i < 4; i++) {
            if( (line-i) >= 0 )
            {
                if(grille.getGrille()[line-i][col].getCouleur() != couleur)
                {
                    poids++;
                }
                else
                    break;
            }
            else
                break;
        }
        return poids;
   
    }
    
    private int calculPoidsDiago1(Grille grille, int line, int col)
    {
        int poids=0;
        
        for (int i = 1; i < 4; i++) {
            if( (col-i) >= 0 && (line+i) < 6 )
            {
                if(grille.getGrille()[line+i][col-i].getCouleur() != couleur && grille.getGrille()[line+i][col-i].getCouleur() != '0')
                {
                    poids++;
                }
                else
                    break;
            }
            else
                break;
        }
        
        for (int i = 1; i < 4; i++) {
            if( (col+i) < 7 && (line-i) >= 0 )
            {
                if(grille.getGrille()[line-i][col+i].getCouleur() != couleur && grille.getGrille()[line-i][col+i].getCouleur() != '0')
                {
                    poids++;
                }
                else
                    break;
            }
            else
                break;
        }
        
        return poids;
    }
    
    private int calculPoidsDiago2(Grille grille, int line, int col)
    {
        int poids=0;
        
        for (int i = 1; i < 4; i++) {
            if( (col+i) < 7 && (line+i) < 6 )
            {
                if(grille.getGrille()[line+i][col+i].getCouleur() != couleur && grille.getGrille()[line+i][col+i].getCouleur() != '0')
                {
                    poids++;
                }
                else
                    break;
            }
            else
                break;
        }
        
        for (int i = 1; i < 4; i++) {
            if( (col-i) >= 0 && (line-i) >= 0 )
            {
                if(grille.getGrille()[line-i][col-i].getCouleur() != couleur && grille.getGrille()[line-i][col-i].getCouleur() != '0')
                {
                    poids++;
                }
                else
                    break;
            }
            else
                break;
        }
        
        return poids;
    }
}
