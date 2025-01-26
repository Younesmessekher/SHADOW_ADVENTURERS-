package Game;

public class Guerrier extends Personnage {
    
    public Guerrier(){
        super("Thor",750,220);
        this.genre = "Guerrier";
    }
    public Guerrier(String nom) {
        super(nom, 750, 220);
        this.choix=true;
        this.critique = 0.1;
    }

    @Override
    public void attaquer(Personnage cible) {
        System.out.println(
        "| '"+ this.nom + "' ATTAQUE -> '" + cible.getNom() + "' !");
        cible.recevoirDegats(this.degats);
		this.competence += this.degats*0.75;
        if (Math.random() < this.critique) {
            System.out.println("|(?!) '" + this.nom + "' INFLIGE Un Coup Critique -> '" + cible.getNom());
            cible.recevoirDegats(this.degats);
        }
    }
    @Override
    public void utiliserCompetence(Personnage cible) {
        System.out.println("|(C) '"+this.nom + "' Utilise Son Coup De Rage -> '" + cible.getNom() +"' !");
        cible.recevoirDegats(this.degats * 2);
    }
}
