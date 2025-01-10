package Game;

abstract class Personnage implements Attaquable {

    protected String nom;
	protected int pointsDeVie;
	protected int degats; // Dégâts de base
	protected int niveau;
	protected int experience;
	protected boolean choix; // indice aide a conaitre quelle personnage est choisi
	protected double competence; // bare de competence s'augmente apres chaque attaque 
	protected double critique; // probabilite d'un coup critique

	public Personnage(String nom, int pointsDeVie, int degats) {
		this.nom = nom;
		this.pointsDeVie = pointsDeVie;
		this.degats = degats;
		this.choix = false;
		this.competence = 0;
		this.niveau = 1;
		this.experience = 0;
		this.critique = 0;
	}

	//methode indique si le personnage est choisi
	public boolean estChoisi(){
		return choix == true;
	}
	public void recevoirDegats(int degats) {
		pointsDeVie -= degats;
		competence += degats*0.25;
		System.out.println(nom + " a reçu " + degats + " points de dégâts. \nPoints de vie restants : " + (pointsDeVie<0? 0 : pointsDeVie));
	}

	public boolean estVivant() {
		return pointsDeVie > 0;
	}

	public String getNom() {
		return nom;
	}



	
	public void gagnerExperience(int xp) {
		experience += xp;
		if (experience >= 100) {
			niveau++;
			experience = 0;
			System.out.println(nom + " a atteint le niveau " + niveau + " !");
		}
	}

}
