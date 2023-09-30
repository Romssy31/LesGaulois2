package personnages;

public class Romain {
	private String nom;
	private int force;

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}
	
	public int getForce() {
		return force;
	}

	public void parler(String texte) {
		System.out.println(prendreParole()+ texte );
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	public void recevoirCoup(int forceCoup) {
		assert testForcePositive();
		force -= forceCoup;
		if (force > 0) {
			parler("Aie");
		} else {
			parler("J'abandonne...");
		}
	}

	private boolean testForcePositive() {
		return force >= 0;
	}
	
	 public static void main(String[] args) {
	        Romain romain = new Romain("Maximus", 10);
	        
	        romain.parler("Bonjour tout le monde !");
	        romain.recevoirCoup(5);
	    }
}