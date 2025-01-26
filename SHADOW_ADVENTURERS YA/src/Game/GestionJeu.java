package Game;

import java.util.ArrayList;

public class GestionJeu {
    ArrayList<Personnage> adversaires;
    String help;

    public GestionJeu() {
        this.adversaires = new ArrayList<>();
    }

    public void listAdversaires(){
        for (int index = 0; index < getAdversaires().size(); index++) {
            System.out.println("|(" + index + ") "+ getAdversaires().get(index).getNom() +"~[Un "+ getAdversaires().get(index).getGenre()+"]");            
        }
    }


    public ArrayList<Personnage> getAdversaires() {
        return this.adversaires;
    }

    public void setAdversaires(ArrayList<Personnage> adversaires) {
        this.adversaires = adversaires;
    }

    public String getHelp() {
        return help;
    }

}

