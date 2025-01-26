package Game;
import java.util.Scanner;

public class Play{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestionJeu gestionJeu = new GestionJeu();


        System.out.println("====||PSEUDO||====\n");
        String nom = scanner.nextLine();

        // Choix du personnage par le joueur:
        Personnage joueur,adversaire1,adversaire2,adversaire3;
        System.out.println(
        "====|CHOIX PERSONNAGE|====\n\n"+
        "1. Guerrier\n"+
        "2. Magicien\n"+
        "3. Voleur\n"+
        "4. Loupgarou\n\n");
        System.out.print("Index de votre personnage :");
        int choixPers = scanner.nextInt();
        switch (choixPers) {
            case 1 -> {
                joueur = new Guerrier(nom);
                adversaire1 = new Mage(); 
                adversaire2 = new Voleur();
                adversaire3 = new Loupgarou();
            }
            case 2 -> {
                joueur = new Mage(nom);
                adversaire1 = new Guerrier(); 
                adversaire2 = new Voleur();
                adversaire3 = new Loupgarou();
            }
            case 3 -> {
                joueur = new Voleur(nom);
                adversaire1 = new Guerrier(); 
                adversaire2 = new Mage();
                adversaire3 = new Loupgarou();
            }
            case 4 ->{
                joueur = new Loupgarou(nom);
                adversaire1 = new Guerrier(); 
                adversaire2 = new Mage();
                adversaire3 = new Voleur();
            }
            default -> {
            System.out.println("Choix invalide !\nLe Guerrier est sélectionné par défaut.");
                joueur = new Guerrier(nom);
                adversaire1 = new Mage(); 
                adversaire2 = new Voleur();
                adversaire3 = new Loupgarou();
            }
        }
        gestionJeu.getAdversaires().add(adversaire1);
        gestionJeu.getAdversaires().add(adversaire2);
        gestionJeu.getAdversaires().add(adversaire3);

        boolean marche = true;
        while(marche){
            System.out.println("\n\n|====|SHADOW ADVENTURES|====|\n");
            System.out.println(
                "1. Combat\n"+
                "2. Aide\n"+
                "3. Quitter\n\n");
            int choix = scanner.nextInt();
            switch (choix) {
                case 1:
                    boolean combatmrch = true;
                    while (combatmrch && joueur.estVivant() ) {
                        gestionJeu.listAdversaires();
                        System.out.print("\nChoisissez Un Adversaire [Index]: ");
                        int choixAdvrs = scanner.nextInt();
                        System.out.printf(
                            "1\\ Attaquer l'adversaire\n"+
                            (joueur.competence>=300?"2\\ Utiliser Competence speciale\n":"2\\ Competence Speciale %.0f%%\n")+
                            "3\\ Passer son tour\n"+
                            "4\\ RETOUR\n",joueur.competence/3);
                        int option = scanner.nextInt();
                        if (option == 1) {
                            System.out.println(
                                "\n=============|Votre Tour|================"+
                                "\n~" + nom +  "             (+):"+joueur.pointsDeVie+"\n"+
                                "_________________________________________\n");
                            joueur.attaquer(gestionJeu.getAdversaires().get(choixAdvrs));
                            joueur.gagnerExperience(1);
                            System.out.printf("|{Competence atteinte : %.0f%%}\n",joueur.competence/3);
                            System.out.println(
                                "\n\n=============|Tour de l'Adversaire|================"+
                                "\n~"+ gestionJeu.getAdversaires().get(choixAdvrs).getNom()+"                         (+):"+gestionJeu.getAdversaires().get(choixAdvrs).pointsDeVie+"\n"+
                                "___________________________________________________\n");
                                gestionJeu.getAdversaires().get(choixAdvrs).attaquer(joueur);
                            if (!gestionJeu.getAdversaires().get(choixAdvrs).estVivant()) {
                                System.out.println(gestionJeu.getAdversaires().get(choixAdvrs).getNom() + " est vaincu !");
                                gestionJeu.getAdversaires().remove(choixAdvrs);
                            }
                        System.out.print("\nTapez n'importe quoi pour retournez: ");
                        String retour = scanner.next();
                        }else if (option == 2) {
                            if(joueur.competence>=300){
                                System.out.println(
                                    "\n=============|Votre Tour|================"+
                                    "\n~" + nom +  "             (+):"+joueur.pointsDeVie+"\n"+
                                    "_________________________________________\n");
                                joueur.utiliserCompetence(gestionJeu.getAdversaires().get(choixAdvrs));
                                System.out.println(
                                    "\n\n=============|Tour de l'Adversaire|================"+
                                    "\n~"+ gestionJeu.getAdversaires().get(choixAdvrs).getNom()+"                         (+):"+gestionJeu.getAdversaires().get(choixAdvrs).pointsDeVie+"\n"+
                                    "___________________________________________________\n");
                                    gestionJeu.getAdversaires().get(choixAdvrs).attaquer(joueur);
                                if (!gestionJeu.getAdversaires().get(choixAdvrs).estVivant()) {
                                    System.out.println("\n"+gestionJeu.getAdversaires().get(choixAdvrs).getNom() + " est vaincu !\n");
                                    gestionJeu.getAdversaires().remove(choixAdvrs);
                                }
                            }else{
                                System.out.println("\nPAS CHARGER POUR L'INSTANT!\n");
                            }
                            System.out.print("Tapez n'importe quoi pour retournez: ");
                            String retour = scanner.next();
                        }else if (option == 3) {
                            System.out.println("\nVous avez passez votre tour!");
                            System.out.println(
                                "\n\n=============|Tour de l'Adversaire|================"+
                                "\n~"+ gestionJeu.getAdversaires().get(choixAdvrs).getNom()+"                         (+):"+gestionJeu.getAdversaires().get(choixAdvrs).pointsDeVie+"\n"+
                                "___________________________________________________\n");
                            gestionJeu.getAdversaires().get(choixAdvrs).attaquer(joueur);
                            System.out.print("\n\nTapez n'importe quoi pour retournez: ");
                            String retour = scanner.next();
                        }else {
                            combatmrch=false;
                            marche=false;
                        }
                        if(!joueur.estVivant()){
                            marche=false;
                        }
                    }
                case 2:
                    
                    break;
                case 3:
                    marche=false;
                    break;
                default:
                    System.out.println("====|PARTIE TERMINÉ|====\n");
                    marche=false;
                    break;
            }
        }
        System.out.println("====|PARTIE TERMINÉ|====\n");
        scanner.close();
    }
}