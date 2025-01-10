package Game;

class Voleur extends Personnage {

    public Voleur(String nom) {
        super(nom, 900, 150);
        this.choix=true;
        this.critique=0.3;
    }

    //constucteur par default
    public Voleur(){
        super("Loki",900,150);
    }

    @Override
    public void attaquer(Personnage cible) {
        System.out.println(nom + " attaque " + cible.getNom() + " !");
        cible.recevoirDegats(degats);
		competence += degats*0.75;
        if (Math.random() < critique) {
            System.out.println(nom + " inflige un coup critique !");
            cible.recevoirDegats(degats);
        }
    }
    
    @Override
    public void utiliserCompetence(Personnage cible) {
        System.out.println(nom + " utilise sa compétence spéciale : Attaque rapide !");
        cible.recevoirDegats(degats * 3);
    }
}

