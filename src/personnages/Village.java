package personnages;

public class Village {

	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int NbVillageois;
	private int NbvillageoisMax;

	public Village(String nom, int NbvillageoisMax) {
		this.nom = nom;
		this.NbvillageoisMax = NbvillageoisMax;
		this.villageois = new Gaulois[NbvillageoisMax];
		this.NbVillageois = 0;

	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public String getNom() {
		return nom;
	}

	public void ajouterHabitant(Gaulois gaulois) {
		if (NbVillageois < NbvillageoisMax) {
			villageois[NbVillageois] = gaulois;
			NbVillageois++;
		}

		else {
			System.out.println("Nombre de villageois max atteint");
		}
	}

	public Gaulois trouverHabitant(int NumVillageois) {
		if (NumVillageois >= 0 && NumVillageois < NbVillageois) {
			return villageois[NumVillageois];
		} else {
			System.out.println("Le NumVillageois n'est pas correct");
			return null;
		}
	}

	public void afficherVillageois() {
		System.out.println("Dans le village du chef" + chef.getNom() + "vivent les légendaires gaulois :");
		for (int i = 0; i < NbVillageois; i++) {
			System.out.println("-" + villageois[i].getNom());
		}
	}

	public static void main(String[] args) {
		Village village = new Village("Village des Irréductibles", 30);
		// Gaulois gaulois = village.trouverHabitant(30);
		// Introuvable car le numero (30) est hors du tableau
		Chef Abraracourcix = new Chef("Abraracourcix", 6);
		village.setChef(Abraracourcix);

		Gaulois asterix = new Gaulois("Asterix", 8);
		village.ajouterHabitant(asterix);

		// Gaulois gaulois = village.trouverHabitant(1);
		// System.out.println(gaulois);
		// affiche cette reponse car il n'y a qu'un habitant (asterix) qui est le numero
		// 0

		Gaulois obelix = new Gaulois("Obelix", 25);
		village.ajouterHabitant(obelix);

		village.afficherVillageois();

	}
}
