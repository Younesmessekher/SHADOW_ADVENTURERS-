package Game;

class Loupgarou extends Personnage{
    public Loupgarou(){
        super("Rougarou",1200,100);
    }
    public Loupgarou(String nom) {
        super(nom, 1200, 100);
        this.choix=true;
        this.critique = 0.8;
    }

    @Override
    public void attaquer(Personnage cible) {
        System.out.println(nom + " attaque " + cible.getNom() + " !");
        cible.recevoirDegats(degats);
		competence += degats*0.80;
        if (Math.random() < critique) {
            System.out.println(nom + " inflige un coup critique !");
            cible.recevoirDegats(degats);
        }
    }
    @Override
    public void utiliserCompetence(Personnage cible) {
        System.out.println(nom + " utilise sa compétence spéciale : Coup de t5bicha !");
        cible.recevoirDegats(degats * 4);
    }
}