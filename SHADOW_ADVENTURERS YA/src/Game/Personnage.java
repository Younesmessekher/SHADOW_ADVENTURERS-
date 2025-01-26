package Game;

public abstract  class Personnage implements Attaquable {

    protected String nom;
	protected String genre;
	protected int pointsDeVie;
	protected int degats; // Dégâts de base
	protected int niveau;
	protected int experience;
	protected boolean choix; // indice aide a conaitre quelle personnage est choisi
	protected double competence; // bare de competence s'augmente apres chaque attaque 
	protected double critique; // probabilite d'un coup critique


	public Personnage() {
		this.nom = "personnage";
		this.pointsDeVie = 200;
		this.degats = 20;
		this.choix = false;
		this.competence = 0;
		this.niveau = 1;
		this.experience = 0;
		this.critique = 0;
	}

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
		return this.choix == true;
	}

	public void recevoirDegats(int degats) {
		this.pointsDeVie -= degats;
		this.competence += degats*0.25;
		System.out.println("|(--)"+this.nom + " a reçu " + degats + " points de dégâts. \n|~Points de vie restants : " + (this.pointsDeVie<0? 0 : this.pointsDeVie));
	}
	public void gagnerExperience(int xp) {
		this.experience += xp;
		if (this.experience >= 5) {
			this.niveau++;
			this.experience = 0;
			System.out.println(this.nom + " a atteint le niveau " + this.niveau + " !");
		}
	}

	public boolean estVivant() {
		return this.pointsDeVie > 0;
	}

	public String getNom() {
		return this.nom;
	}

    public String getGenre() {
        return this.genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

}
