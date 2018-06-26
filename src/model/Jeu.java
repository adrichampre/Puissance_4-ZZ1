/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
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
        
    public Boolean jouer(int y)
    {
        return grille.mettreJeton(y, jCourant.getCouleur());
    }
    
    public int firstCase(int y)
    {
        for (int i = 0; i < 6; i++) {
            if(!grille.getGrille()[i][y].getJeton())
            {
                return i;
            }
        }
        return -1;
    }
    
    public Boolean Gagner()
    {
        return (grille.GagnerLigne() || grille.GagnerCol() || grille.GagnerDiago1() || grille.GagnerDiago2());

    }
    
            /*int q = 3;
            while (q == 3)
            {
                Console.WriteLine("Combien de joueur êtes vous ?");
                int nbjoueur = int.Parse(Console.ReadLine());
                q = 2;

                //Partie pour deux joueurs
                if (nbjoueur == 2)
                {
                    while (q == 2)
                    {

                        Console.WriteLine("\nQuel est le nom du premier joueur qui aura la couleur rouge ?");
                        string nom = Console.ReadLine();
                        Joueur j1 = new Joueur(nom, 1, 20, 'R');
                        Console.WriteLine("\nQuel est le nom du deuxiéme joueur qui aura la couleur jaune ?");
                        nom = Console.ReadLine();
                        Joueur j2 = new Joueur(nom, 1, 20, 'J');
                        q = 1;

                        while (q == 1)
                        {
                            Grille grille = new Grille();
                            while (grille.Gagner() != true)
                            {

                                Console.Clear();
                                grille.affich();
                                j1.Jouer(grille);

                                if (grille.Gagner() == true)
                                {
                                    Console.WriteLine("{0} a gagné !!!", j1.Nom);
                                    break;
                                }

                                Console.Clear();
                                grille.affich();
                                j2.Jouer(grille);
                                if (grille.Gagner() == true)
                                {
                                    Console.WriteLine("{0} a gagné", j2.Nom);
                                    break;
                                }
                                Console.Clear();
                            }

                            Console.WriteLine("\nChoisir un chiffre proposé dans le menu :");
                            Console.WriteLine("1 : Recommencer la partie.");
                            Console.WriteLine("2 : Recommencer le jeu en changeant les noms.");
                            Console.WriteLine("3 : Recommencer le jeu.");
                            Console.WriteLine("Pour quitter taper un autre chiffre de la liste.");

                            q = int.Parse(Console.ReadLine());
                        }
                    }
                }

                //Partie pour un joueur
                if (nbjoueur == 1)
                {
                    while (q == 2)
                    {

                        Console.WriteLine("\nQuel est votre nom ?");
                        string nom = Console.ReadLine();
                        Joueur j1 = new Joueur(nom, 1, 20, 'R');
                        Console.WriteLine("\n{0} vous avez la couleur rouge", j1.Nom);
                        Console.Clear();
                        q = 1;

                        while (q == 1)
                        {

                            Console.WriteLine("\n Choisissez le niveau de difficulté :");
                            Console.WriteLine("1 : IAidiot\n");
                            Console.WriteLine("2 : IAdefense\n");
                            Console.WriteLine("3 : IAmix\n");
                            Console.WriteLine("4 : IAvictoire\n");
                            int a = int.Parse(Console.ReadLine());
                            q = 0;
                            while (q == 0)
                            {

                                if (a == 1)
                                {
                                    Joueur ordi = new IAidiot("IA", 2, 20, 'J');


                                    Grille grille = new Grille();
                                    while (grille.Gagner() != true)
                                    {

                                        Console.Clear();
                                        grille.affich();
                                        j1.Jouer(grille);

                                        if (grille.Gagner() == true)
                                        {
                                            Console.WriteLine("{0} a gagné !!!", j1.Nom);
                                            break;
                                        }

                                        Console.Clear();
                                        grille.affich();
                                        ordi.Jouer(grille);
                                        if (grille.Gagner() == true)
                                        {
                                            Console.WriteLine("{0} a gagné", ordi.Nom);
                                            break;
                                        }
                                        Console.Clear();
                                    }
                                }

                                if (a == 2)
                                {
                                    Joueur ordi = new IAdefense("IA", 2, 20, 'J');


                                    Grille grille = new Grille();
                                    while (grille.Gagner() != true)
                                    {

                                        Console.Clear();
                                        grille.affich();
                                        j1.Jouer(grille);

                                        if (grille.Gagner() == true)
                                        {
                                            Console.WriteLine("{0} a gagné !!!", j1.Nom);
                                            break;
                                        }

                                        Console.Clear();
                                        grille.affich();
                                        ordi.Jouer(grille);
                                        if (grille.Gagner() == true)
                                        {
                                            Console.WriteLine("{0} a gagné", ordi.Nom);
                                            break;
                                        }
                                        Console.Clear();
                                    }
                                }

                                if (a == 3)
                                {
                                    Joueur ordi = new IAmix("IA", 2, 20, 'J');


                                    Grille grille = new Grille();
                                    while (grille.Gagner() != true)
                                    {

                                        Console.Clear();
                                        grille.affich();
                                        j1.Jouer(grille);

                                        if (grille.Gagner() == true)
                                        {
                                            Console.WriteLine("{0} a gagné !!!", j1.Nom);
                                            break;
                                        }

                                        Console.Clear();
                                        grille.affich();
                                        ordi.Jouer(grille);
                                        if (grille.Gagner() == true)
                                        {
                                            Console.WriteLine("{0} a gagné", ordi.Nom);
                                            break;
                                        }
                                        Console.Clear();
                                    }
                                }

                                if (a == 4)
                                {
                                    Joueur ordi = new IAvictoire("IA", 2, 20, 'J');


                                    Grille grille = new Grille();
                                    while (grille.Gagner() != true)
                                    {

                                        Console.Clear();
                                        grille.affich();
                                        j1.Jouer(grille);

                                        if (grille.Gagner() == true)
                                        {
                                            Console.WriteLine("{0} a gagné !!!", j1.Nom);
                                            break;
                                        }

                                        Console.Clear();
                                        grille.affich();
                                        ordi.Jouer(grille);
                                        if (grille.Gagner() == true)
                                        {
                                            Console.WriteLine("{0} a gagné", ordi.Nom);
                                            break;
                                        }
                                        Console.Clear();
                                    }
                                }
                                    Console.WriteLine("\nChoisir un chiffre proposé dans le menu :");
                                    Console.WriteLine("0 : Recommencer la partie.");
                                    Console.WriteLine("1 : Changer le niveau de difficulté.");
                                    Console.WriteLine("2 : Recommencer le jeu en changeant de nom.");
                                    Console.WriteLine("3 : Recommencer le jeu.");
                                    Console.WriteLine("Pour quitter taper un autre chiffre de la liste.");

                                    q = int.Parse(Console.ReadLine());
                                
                            }
                        }
                    }
                }
            }
            Console.WriteLine("\nTaper sur une touche pour continuer...");

            Console.ReadKey();*/
}