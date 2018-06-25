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
/*
        private Case[,] plateau = new Case[6, 7];
        public Case[,] Plateau
        {
            get { return plateau; }
            set
            {
                if (value != null)
                {
                    plateau = value;
                }
                else Console.WriteLine("null");
            }

        }


        public Grille()
        {
            for (int i = 0; i <= 6; i++)
            {
                for (int k = 0; k <= 5; k++)
                {
                    Plateau[k, i] = new Case(false, ' ');

                }
            }

        }

        public void affich()
        {

            Console.WriteLine("  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |");
            Console.WriteLine("6 |  {0}  |  {1}  |  {2}  |  {3}  |  {4}  |  {5}  |  {6}  |", Plateau[5, 0].Couleur, Plateau[5, 1].Couleur, Plateau[5, 2].Couleur, Plateau[5, 3].Couleur, Plateau[5, 4].Couleur, Plateau[5, 5].Couleur, Plateau[5, 6].Couleur);
            Console.WriteLine("5 |  {0}  |  {1}  |  {2}  |  {3}  |  {4}  |  {5}  |  {6}  |", Plateau[4, 0].Couleur, Plateau[4, 1].Couleur, Plateau[4, 2].Couleur, Plateau[4, 3].Couleur, Plateau[4, 4].Couleur, Plateau[4, 5].Couleur, Plateau[4, 6].Couleur);
            Console.WriteLine("4 |  {0}  |  {1}  |  {2}  |  {3}  |  {4}  |  {5}  |  {6}  |", Plateau[3, 0].Couleur, Plateau[3, 1].Couleur, Plateau[3, 2].Couleur, Plateau[3, 3].Couleur, Plateau[3, 4].Couleur, Plateau[3, 5].Couleur, Plateau[3, 6].Couleur);
            Console.WriteLine("3 |  {0}  |  {1}  |  {2}  |  {3}  |  {4}  |  {5}  |  {6}  |", Plateau[2, 0].Couleur, Plateau[2, 1].Couleur, Plateau[2, 2].Couleur, Plateau[2, 3].Couleur, Plateau[2, 4].Couleur, Plateau[2, 5].Couleur, Plateau[2, 6].Couleur);
            Console.WriteLine("2 |  {0}  |  {1}  |  {2}  |  {3}  |  {4}  |  {5}  |  {6}  |", Plateau[1, 0].Couleur, Plateau[1, 1].Couleur, Plateau[1, 2].Couleur, Plateau[1, 3].Couleur, Plateau[1, 4].Couleur, Plateau[1, 5].Couleur, Plateau[1, 6].Couleur);
            Console.WriteLine("1 |  {0}  |  {1}  |  {2}  |  {3}  |  {4}  |  {5}  |  {6}  |", Plateau[0, 0].Couleur, Plateau[0, 1].Couleur, Plateau[0, 2].Couleur, Plateau[0, 3].Couleur, Plateau[0, 4].Couleur, Plateau[0, 5].Couleur, Plateau[0, 6].Couleur);
        }



        public int MettreJeton(int col, Joueur j)
        {
            col -= 1;
            for (int i = 0; i < 6; i++)
            {
                if (Plateau[i, col].Jeton == false)
                {
                    Plateau[i, col].Couleur = j.Couleur;
                    Plateau[i, col].Jeton = true;
                    return 0;
                }
            }
            return -1;

        }


        public bool Gagner()
        {
            if (GagnerLigne() == 'R' || GagnerCol() == 'R' || GagnerDiago1() == 'R' || GagnerDiago2() == 'R')
            {
                return true;
            }
            if (GagnerLigne() == 'J' || GagnerCol() =='J' || GagnerDiago1() == 'J' || GagnerDiago2() == 'R')
            {
                return true;
            }
            return false;
        }


        public char GagnerLigne()
        {
            int result = 0;
            for (int line = 0; line < 6; line++)
            {
                for (int col = 0; col < 4; col++)
                {
                    for (int k = 1; k < 4; k++)
                    {
                        if (Plateau[line, col].Couleur == Plateau[line, col + k].Couleur && Plateau[line, col + k].Jeton == true)
                        {
                            result++;
                        }
                        if (result == 3)
                        {
                            return Plateau[line, col].Couleur;
                        }
                    }
                    result = 0;
                }
            }
            return 'N';
        }

        public char GagnerCol()
        {
            int result = 0;
            for (int col = 0; col < 7; col++)
            {
                for (int line = 0; line < 3; line++)
                {
                    for (int k = 1; k < 4; k++)
                    {
                        if (Plateau[line, col].Couleur == Plateau[line + k, col].Couleur && Plateau[line + k, col].Jeton == true)
                        {
                            result++;
                        }
                        if (result == 3)
                        {
                            return Plateau[line, col].Couleur;
                        }
                    }
                    result = 0;
                }
            }
            return 'N';
        }


        public char GagnerDiago1()
        {
            int result = 0;

            //Diago du bas vers le haut
            for (int line = 0; line < 3; line++)
            {
                for (int col = 0; col < 4; col++)
                {
                    for (int k = 1; k < 4; k++)
                    {
                        if (Plateau[line, col].Couleur == Plateau[line + k, col + k].Couleur && Plateau[line + k, col + k].Jeton == true)
                        {
                            result++;
                        }
                        if (result == 3)
                            return Plateau[line, col].Couleur;
                    }
                    result = 0;
                }
            }
            return 'N';
        }

        public char GagnerDiago2()
        {
            // Diago du haut vers le bas
            int result = 0;
            for (int line = 3; line < 6; line++)
            {
                for (int col = 0; col < 4; col++)
                {
                    for (int k = 1; k < 4; k++)
                    {
                        if (Plateau[line, col].Couleur == Plateau[line - k, col + k].Couleur && Plateau[line - k, col + k].Jeton == true)
                        {
                            result++;
                            Console.WriteLine("Diago haut vers bas !");
                        }
                        if (result == 3)
                            return Plateau[line, col].Couleur;
                    }
                    result = 0;
                }
            }
            
            return 'N';
        }
*/
}