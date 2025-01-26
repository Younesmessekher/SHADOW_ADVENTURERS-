package Game;

public class Voleur extends Personnage {

    public Voleur(String nom) {
        super(nom, 900, 150);
        this.choix=true;
        this.critique=0.3;
    }

    //constucteur par default
    public Voleur(){
        super("Loki",900,150);
        this.genre = "Voleur";
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
        System.out.println("|(C) '"+this.nom + "' Utilise Son Attaque Rapide -> '" + cible.getNom() +"' !");
        cible.recevoirDegats(this.degats * 3);
    }
}

