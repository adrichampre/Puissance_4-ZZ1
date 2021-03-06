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
public class IAFort extends Joueur{
    
    public IAFort(String Pseudo, char Couleur) {
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
        int poidsJ=0;
        int poidsR=0;
        
        for (int i = 1; i < 4; i++) {
            if( (col-i) >= 0 )
            {
                if(grille.getGrille()[line][col-i].getCouleur() == 'R')
                {
                    if(poidsJ>0)
                    {
                        break;
                    }
                    poidsR++;
                }
                if(grille.getGrille()[line][col-i].getCouleur() == 'J')
                {
                    if(poidsR>0)
                    {
                        break;
                    }
                    poidsJ++;
                }
                if(grille.getGrille()[line][col-i].getCouleur() == '0')
                    break;
            }
            else
                break;
        }
        
        for (int i = 1; i < 4; i++) {
            if( (col+i) < 7 )
            {
                if(grille.getGrille()[line][col+i].getCouleur() == 'R')
                {
                    if(poidsJ>0)
                    {
                        break;
                    }
                    poidsR++;
                }
                if(grille.getGrille()[line][col+i].getCouleur() == 'J')
                {
                    if(poidsR>0)
                    {
                        break;
                    }
                    poidsJ++;
                }
                if(grille.getGrille()[line][col+i].getCouleur() == '0')
                    break;
            }
            else
                break;
        }
        
        return max(poidsR,poidsJ);
    }
    
    
    private int calculPoidsVertical(Grille grille, int line, int col)
    {
        int poidsJ=0;
        int poidsR=0;
        
        for (int i = 1; i < 4; i++) {
            if( (line-i) >= 0 )
            {
                if(grille.getGrille()[line-i][col].getCouleur() == 'R')
                {
                    if(poidsJ>0)
                    {
                        break;
                    }
                    poidsR++;
                }
                if(grille.getGrille()[line-i][col].getCouleur() == 'J')
                {
                    if(poidsR>0)
                    {
                        break;
                    }
                    poidsJ++;
                }
                if(grille.getGrille()[line-i][col].getCouleur() == '0')
                    break;
            }
            else
                break;
        }
        return max(poidsR,poidsJ);
   
    }
    
    private int calculPoidsDiago1(Grille grille, int line, int col)
    {
        int poidsJ=0;
        int poidsR=0;
        
        for (int i = 1; i < 4; i++) {
            if( (col-i) >= 0 && (line+i) < 6 )
            {
                if(grille.getGrille()[line+i][col-i].getCouleur() == 'R')
                {
                    if(poidsJ>0)
                    {
                        break;
                    }
                    poidsR++;
                }
                if(grille.getGrille()[line+i][col-i].getCouleur() == 'J')
                {
                    if(poidsR>0)
                    {
                        break;
                    }
                    poidsJ++;
                }
                if(grille.getGrille()[line+i][col-i].getCouleur() == '0')
                    break;
            }
            else
                break;
        }
        
        for (int i = 1; i < 4; i++) {
            if( (col+i) < 7 && (line-i) >= 0 )
            {
                if(grille.getGrille()[line-i][col+i].getCouleur() == 'R')
                {
                    if(poidsJ>0)
                    {
                        break;
                    }
                    poidsR++;
                }
                if(grille.getGrille()[line-i][col+i].getCouleur() == 'J')
                {
                    if(poidsR>0)
                    {
                        break;
                    }
                    poidsJ++;
                }
                if(grille.getGrille()[line-i][col+i].getCouleur() == '0')
                    break;
            }
            else
                break;
        }
        
        return max(poidsR,poidsJ);
    }
    
    private int calculPoidsDiago2(Grille grille, int line, int col)
    {
        int poidsJ=0;
        int poidsR=0;
        
        for (int i = 1; i < 4; i++) {
            if( (col+i) < 7 && (line+i) < 6 )
            {
                if(grille.getGrille()[line+i][col+i].getCouleur() == 'R')
                {
                    if(poidsJ>0)
                    {
                        break;
                    }
                    poidsR++;
                }
                if(grille.getGrille()[line+i][col+i].getCouleur() == 'J')
                {
                    if(poidsR>0)
                    {
                        break;
                    }
                    poidsJ++;
                }
                if(grille.getGrille()[line+i][col+i].getCouleur() == '0')
                    break;
            }
            else
                break;
        }
        
        for (int i = 1; i < 4; i++) {
            if( (col-i) >= 0 && (line-i) >= 0 )
            {
                if(grille.getGrille()[line-i][col-i].getCouleur() == 'R')
                {
                    if(poidsJ>0)
                    {
                        break;
                    }
                    poidsR++;
                }
                if(grille.getGrille()[line-i][col-i].getCouleur() == 'J')
                {
                    if(poidsR>0)
                    {
                        break;
                    }
                    poidsJ++;
                }
                if(grille.getGrille()[line-i][col-i].getCouleur() == '0')
                    break;
            }
            else
                break;
        }
        
        return max(poidsR,poidsJ);
    }
}
