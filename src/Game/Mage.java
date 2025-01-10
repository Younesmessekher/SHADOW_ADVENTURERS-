package Game;

class Mage extends Personnage {

    public Mage(String nom) {
        super(nom, 1000, 170);
        this.choix=true;
        this.critique=0.02;
    }

    public Mage(){
        super("Gandalf",1000,170);
    }

    @Override
    public void attaquer(Personnage cible) {
        System.out.println(nom + " lance un sort sur " + cible.getNom() + " !");
        cible.recevoirDegats(degats);
        competence += degats*0.75;
        if (Math.random() < critique) {
            System.out.println(nom + " inflige un coup critique !");
            cible.recevoirDegats(degats);
        }
    }

    @Override
    public void utiliserCompetence(Personnage cible) {
            System.out.println(nom + " invoque une tempête magique !");
            cible.recevoirDegats(degats + 300);
    }
}

