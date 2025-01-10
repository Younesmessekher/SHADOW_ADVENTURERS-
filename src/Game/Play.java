package Game;
import java.util.Scanner;

public class Play{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("__Pseudo__\n");
        String nom = scanner.next();
        // Choix du personnage par le joueur:
        
        

        //choix d'un nom pour chaque personnage
        Personnage guerrier = new Guerrier();
        Personnage mage = new Mage();
        Personnage voleur = new Voleur();
        Personnage Loupgarou = new Loupgarou();
        Personnage joueur ;

        System.out.println("Choisissez votre personnage :\n1. Guerrier\n2. Magicien\n3. Voleur\n4. Loupgarou");
        int choix = scanner.nextInt();
        
        switch (choix) {
            case 1 -> {
                joueur = new Guerrier(nom);
                guerrier = joueur;
            }
            case 2 -> {
                joueur = mage = new Mage(nom);
            }
            case 3 -> {
                joueur = voleur = new Voleur(nom);
            }
            case 4 ->{
                joueur = Loupgarou = new Loupgarou(nom);
            }
            default -> {
            System.out.println("Choix invalide ! ,, Le Guerrier est sélectionné par défaut.");
                joueur = guerrier = new Guerrier(nom);
            }
        }

        // Boucle de combat
        while (joueur.estVivant()) {
            
            // Vérification de l'état des personnages après chaque action
            if (!guerrier.estVivant()) {
                System.out.println(guerrier.getNom() + " est vaincu !");
                break;
            }
            if (!mage.estVivant()) {
                System.out.println(mage.getNom() + " est vaincu !");
                break;
            }
            if (!voleur.estVivant()) {
                System.out.println(voleur.getNom() + " est vaincu !");
                break;
            }
            if (!Loupgarou.estVivant()) {
                System.out.println(Loupgarou.getNom() + " est vaincu !");
                break;
            }

            // Actions du joueur
        System.out.println("\n___ Tour de combat ___");
        System.out.printf("Choisissez une action :\n1. Attaquer un adversaire "+(joueur.competence>=300?"\n2. Utiliser Competence speciale ":"\n2. Competence Speciale %f%%")+"\n3. Passer son tour\n",joueur.competence/300);
        int action = scanner.nextInt();
        switch (action) {
            case 1:
                int cible;
                    System.out.println("Choisissez un adversaire :");
                    if (guerrier.estChoisi()) {
                        System.out.println("1. " + mage.getNom() + "\n2. "+ voleur.getNom()+ "\n3. "+ Loupgarou.getNom());
                        cible = scanner.nextInt();
                        if (cible == 1 && mage.estVivant()) {
                            joueur.attaquer(mage);
                            System.out.println("\nCompetence atteinte : "+joueur.competence);
                        } else if (cible == 2 && voleur.estVivant()) {
                            joueur.attaquer(voleur);
                            System.out.println("\nCompetence atteinte : "+joueur.competence);
                        } else if (cible == 3 && Loupgarou.estVivant()) {
                            joueur.attaquer(Loupgarou);
                            System.out.println("\nCompetence atteinte : "+joueur.competence);
                        
                        } else {
                            System.out.println("\nCible invalide.");
                        }
                    } else if (mage.estChoisi()){
                        System.out.println("1. " + guerrier.getNom() + "\n2. "+ voleur.getNom()+ "\n3. "+ Loupgarou.getNom());
                        cible = scanner.nextInt();
                        if (cible == 1 && guerrier.estVivant()) {
                            joueur.attaquer(guerrier);
                            System.out.println("Competence atteinte : "+joueur.competence);
                        } else if (cible == 2 && voleur.estVivant()) {
                            joueur.attaquer(voleur);
                            System.out.println("Competence atteinte : "+joueur.competence);
                        } else if (cible == 3 && Loupgarou.estVivant()) {
                            joueur.attaquer(Loupgarou);
                            System.out.println("Competence atteinte : "+joueur.competence);
                        
                        } else {
                            System.out.println("Cible invalide.");
                        }
                    } else if (voleur.estChoisi()){
                        System.out.println("1. " + guerrier.getNom()+"\n2. "+ mage.getNom()+ "\n3. "+ Loupgarou.getNom());
                        cible = scanner.nextInt();
                        if (cible == 1 && guerrier.estVivant()) {
                            joueur.attaquer(guerrier);
                            System.out.println("Competence atteinte : "+joueur.competence);
                        } else if (cible == 2 && mage.estVivant()) {
                            joueur.attaquer(mage);
                            System.out.println("Competence atteinte : "+joueur.competence);
                        } else if (cible == 3 && Loupgarou.estVivant()) {
                            joueur.attaquer(Loupgarou);
                            System.out.println("Competence atteinte : "+joueur.competence);
                        } else {
                            System.out.println("Cible invalide.");
                        }
                    } else {
                        System.out.println("1. " + guerrier.getNom() + "\n2. "+ mage.getNom() + "\n3. "+ voleur.getNom());
                        cible = scanner.nextInt();
                        if (cible == 1 && guerrier.estVivant()) {
                            joueur.attaquer(guerrier);
                            System.out.println("Competence atteinte : "+joueur.competence);
                        } else if (cible == 2 && mage.estVivant()) {
                            joueur.attaquer(mage);
                            System.out.println("Competence atteinte : "+joueur.competence);
                        } else if (cible == 3 && voleur.estVivant()) {
                            joueur.attaquer(voleur);
                            System.out.println("Competence atteinte : "+joueur.competence);
                        }
                    }
                    
                    break;
            case 2 :
                if (joueur.competence>=300) {
                    if (guerrier.estChoisi()) {
                        System.out.println("1. " + mage.getNom() + "\n2. "+ voleur.getNom()+"\n3. "+ Loupgarou.getNom());
                        cible = scanner.nextInt();
                        if (cible == 1 && mage.estVivant()) {
                            joueur.utiliserCompetence(mage);
                        } else if (cible == 2 && voleur.estVivant()) {
                            joueur.utiliserCompetence(voleur);
                        }else if (cible == 3 && Loupgarou.estVivant()) {
                            joueur.utiliserCompetence(Loupgarou);
                        }else {
                            System.out.println("Cible invalide.");
                        }
                        } else if (mage.estChoisi()){
                        System.out.println("1. " + guerrier.getNom() + "\n2. "+ voleur.getNom()+"\n3. "+ Loupgarou.getNom());
                        cible = scanner.nextInt();
                        if (cible == 1 && guerrier.estVivant()) {
                            joueur.utiliserCompetence(guerrier);
                        } else if (cible == 2 && voleur.estVivant()) {
                            joueur.utiliserCompetence(voleur);
                        }else if (cible == 3 && Loupgarou.estVivant()) {
                            joueur.utiliserCompetence(Loupgarou);
                        }else {
                            System.out.println("Cible invalide.");
                        }
                    } else if (voleur.estChoisi()){
                        System.out.println("1. " + guerrier.getNom() + "\n2. "+ mage.getNom()+"\n3. "+ Loupgarou.getNom());
                        cible = scanner.nextInt();
                        if (cible == 1 && guerrier.estVivant()) {
                            joueur.utiliserCompetence(guerrier);
                        } else if (cible == 2 && mage.estVivant()) {
                            joueur.utiliserCompetence(mage);
                        }else if (cible == 3 && Loupgarou.estVivant()) {
                            joueur.utiliserCompetence(Loupgarou);
                        }
                        else {
                            System.out.println("Cible invalide.");
                        }
                    } else {
                        System.out.println("1. " + guerrier.getNom()+"\n2. "+ mage.getNom()+"\n3. "+voleur.getNom());
                        cible = scanner.nextInt();
                        if (cible == 1 && guerrier.estVivant()) {
                            joueur.utiliserCompetence(guerrier);
                        } else if (cible == 2 && mage.estVivant()) {
                            joueur.utiliserCompetence(mage);
                        }else if (cible == 3 && voleur.estVivant()) {
                            joueur.utiliserCompetence(voleur);
                        } else {
                            System.out.println("Cible invalide.");
                        }
                    }
                }else{
                    System.out.println("! Votre competence ne pe pas etre activer mainetenant");
                }
                    break;
            case 3:
                        System.out.println(joueur.getNom() + " passe son tour.");
                    break;
            default:
                    System.out.println("Action invalide.");
                    break;
                }
                // Actions des adversaires
                if (guerrier.estChoisi()) {
                    if (mage.estVivant()&&voleur.estVivant()&&Loupgarou.estVivant()){
                        mage.attaquer(joueur);
                        if (!joueur.estVivant()) {
                            System.out.println(joueur.getNom() + " est vaincu !\n");
                            break;
                        }
                        voleur.attaquer(joueur);
                        if (!joueur.estVivant()) {
                            System.out.println(joueur.getNom() + " est vaincu !\n");
                            break;
                        }
                        Loupgarou.attaquer(joueur);
                        if (!joueur.estVivant()) {
                            System.out.println(joueur.getNom() + " est vaincu !\n");
                            break;
                        }
                    }
                } else if (mage.estChoisi()) {
                    if (guerrier.estVivant()&&voleur.estVivant()&&Loupgarou.estVivant()){
                        guerrier.attaquer(joueur);
                        if (!joueur.estVivant()) {
                            System.out.println(joueur.getNom() + " est vaincu !\n");
                            break;
                        }
                        voleur.attaquer(joueur);
                        if (!joueur.estVivant()) {
                            System.out.println(joueur.getNom() + " est vaincu !\n");
                            break;
                        }    
                        Loupgarou.attaquer(joueur);
                        if (!joueur.estVivant()) {
                            System.out.println(joueur.getNom() + " est vaincu !\n");
                            break;
                        }
                    }
                }else if (voleur.estChoisi()) {
                    if (guerrier.estVivant()&&mage.estVivant()&&Loupgarou.estVivant()){
                        guerrier.attaquer(joueur);
                        if (!joueur.estVivant()) {
                            System.out.println(joueur.getNom() + " est vaincu !\n");
                            break;
                        }
                        voleur.attaquer(joueur);
                        if (!joueur.estVivant()) {
                            System.out.println(joueur.getNom() + " est vaincu !\n");
                            break;
                        }
                        Loupgarou.attaquer(joueur);
                        if (!joueur.estVivant()) {
                            System.out.println(joueur.getNom() + " est vaincu !\n");
                            break;
                        }
                } else {
                    if (guerrier.estVivant()&&mage.estVivant()&&voleur.estVivant()){
                        guerrier.attaquer(joueur);
                        if (!joueur.estVivant()) {
                            System.out.println(joueur.getNom() + " est vaincu !\n");
                            break;
                        }
                        voleur.attaquer(joueur);
                        if (!joueur.estVivant()) {
                            System.out.println(joueur.getNom() + " est vaincu !\n");
                            break;
                        }
                        mage.attaquer(joueur);
                        if (!joueur.estVivant()) {
                            System.out.println(joueur.getNom() + " est vaincu !\n");
                            break;
                        }
                    }
                }
        }
        }
    System.out.println("Le combat est terminé !");
    scanner.close();
    
    }
}