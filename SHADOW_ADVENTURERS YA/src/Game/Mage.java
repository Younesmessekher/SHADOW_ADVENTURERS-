package Game;

public class Mage extends Personnage {

    public Mage(String nom) {
        super(nom, 2000, 170);
        this.choix=true;
        this.critique=0.02;
    }

    public Mage(){
        super("Gandalf",2000,170);
        this.genre = "Mage";
    }

    @Override
    public void attaquer(Personnage cible) {
        System.out.println(
        "| '"+ this.nom + "' ATTAQUE -> '" + cible.getNom() + "' !");
        cible.recevoirDegats(this.degats);
		this.competence += this.degats*0.75;
        if (Math.random() < this.critique) {
            System.out.println("|(?!) '" + this.nom + "' INFLIGE Un Coup Critique -> '" + cible.getNom()+"'");
            cible.recevoirDegats(this.degats);
        }
    }
    @Override
    public void utiliserCompetence(Personnage cible) {
        System.out.println("|(C) '"+this.nom + "' Utilise Son Coup De Feu Magique -> '" + cible.getNom() +"' !");
        cible.recevoirDegats(this.degats + 300);
    }
}

