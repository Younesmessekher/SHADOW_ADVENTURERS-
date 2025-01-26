package Game;

public class Loupgarou extends Personnage{

    public Loupgarou(){
        super("Rougarou",2500,100);
        this.genre = "Loupgarou";
    }
    public Loupgarou(String nom) {
        super(nom, 1200, 100);
        this.choix=true;
        this.critique = 0.8;
    }

    @Override
    public void attaquer(Personnage cible) {
        System.out.println(
        "| '"+ this.nom + "' ATTAQUE -> '" + cible.getNom() + "' !");
        cible.recevoirDegats(this.degats);
		this.competence += this.degats*0.8;
        if (Math.random() < this.critique) {
            System.out.println("|(?!) '" + this.nom + "' INFLIGE Un Coup Critique -> '" + cible.getNom()+"'");
            cible.recevoirDegats(this.degats);
        }
    }
    @Override
    public void utiliserCompetence(Personnage cible) {
        System.out.println("|(C) '"+this.nom + "' Utilise Son Coup De Griffes -> '" + cible.getNom() +"' !");
        cible.recevoirDegats(this.degats * 4);
    }
}