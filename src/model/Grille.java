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
public class Grille {

        private Case[][] plateau;
        public Case[][] getGrille(){ return plateau; }


        public Grille()
        {
            plateau = new Case[6][7];
            for (int i = 0; i < 6; i++)
            {
                for (int j = 0; j < 7; j++)
                {
                    plateau[i][j] = new Case('0');
                }
            }
        }

        public Boolean mettreJeton(int col, char couleur)
        {
            for (int i = 0; i < 6; i++)
            {
                if (plateau[i][col].getJeton() == false)
                {
                    plateau[i][col].mettreJeton(couleur);
                    return true;
                }
            }
            return false;
        }


        public Boolean GagnerLigne()
        {
            int result = 0;
            for (int line = 0; line < 6; line++)
            {
                for (int col = 0; col < 4; col++)
                {
                    for (int k = 1; k < 4; k++)
                    {
                        if (plateau[line][col].getCouleur() == plateau[line][col + k].getCouleur() && plateau[line][col + k].getJeton() == true)
                        {
                            result++;
                        }
                        if (result == 3)
                        {
                            return true;
                        }
                    }
                    result = 0;
                }
            }
            return false;
        }

        public Boolean GagnerCol()
        {
            int result = 0;
            for (int col = 0; col < 7; col++)
            {
                for (int line = 0; line < 3; line++)
                {
                    for (int k = 1; k < 4; k++)
                    {
                        if (plateau[line][col].getCouleur() == plateau[line + k][col].getCouleur() && plateau[line + k][col].getJeton() == true)
                        {
                            result++;
                        }
                        if (result == 3)
                        {
                            return true;
                        }
                    }
                    result = 0;
                }
            }
            return false;
        }


        public Boolean GagnerDiago1()
        {
            int result = 0;

            //Diago du bas vers le haut
            for (int line = 0; line < 3; line++)
            {
                for (int col = 0; col < 4; col++)
                {
                    for (int k = 1; k < 4; k++)
                    {
                        if (plateau[line][col].getCouleur() == plateau[line + k][col + k].getCouleur() && plateau[line + k][col + k].getJeton() == true)
                        {
                            result++;
                        }
                        if (result == 3)
                            return true;
                    }
                    result = 0;
                }
            }
            return false;
        }

        public Boolean GagnerDiago2()
        {
            // Diago du haut vers le bas
            int result = 0;
            for (int line = 3; line < 6; line++)
            {
                for (int col = 0; col < 4; col++)
                {
                    for (int k = 1; k < 4; k++)
                    {
                        if (plateau[line][col].getCouleur() == plateau[line - k][col + k].getCouleur() && plateau[line - k][col + k].getJeton() == true)
                        {
                            result++;
                        }
                        if (result == 3)
                            return true;
                    }
                    result = 0;
                }
            }
            
            return false;
        }
}