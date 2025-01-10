package Game;

class Guerrier extends Personnage {
    
    public Guerrier(){
        super("Thor",750,220);
    }
    public Guerrier(String nom) {
        super(nom, 750, 220);
        this.choix=true;
        this.critique = 0.1;
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
        System.out.println(nom + " utilise sa compétence spéciale : Coup de rage !");
        cible.recevoirDegats(degats * 2);
    }
}
