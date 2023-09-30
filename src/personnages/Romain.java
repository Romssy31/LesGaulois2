package personnages;

public class Romain {
    private String nom;
    private int force;
    private Equipement[] equipements;
    private int nbEquipements;

    public Romain(String nom, int force) {
        this.nom = nom;
        this.force = force;
        this.equipements = new Equipement[2];
        this.nbEquipements = 0;
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
		assert testForcePositive() : "la force d’un Romain est positive";
		force -= forceCoup;
		if (force > 0) {
			parler("Aie");
		} else {
			parler("J'abandonne...");
		}
		assert testForcePositive() : "la force d’un Romain a diminué";
	}

	private boolean testForcePositive() {
		return force >= 0;
	}
	
	public void equiper(Equipement equipement) {
        parler("Équipé de : " + equipement);
    }
	
	 public void sEquiper(Equipement equipement) {
	        switch (nbEquipements) {
	            case 0:
	                ajouterEquipement(equipement);
	                break;
	            case 1:
	                if (equipements[0] == equipement) {
	                    parler("Le soldat " + nom + " possède déjà un " + equipement + " !");
	                } else {
	                    ajouterEquipement(equipement);
	                }
	                break;
	            case 2:
	                parler("Le soldat " + nom + " est déjà bien protégé !");
	                break;
	            default:
	                parler("Nombre d'équipements non pris en charge !");
	        }
	    }
	
	 private void ajouterEquipement(Equipement equipement) {
	        equipements[nbEquipements++] = equipement;
	        parler("Le soldat " + nom + " s'équipe avec un " + equipement + ".");
	    }
	
	
	    public static void main(String[] args) {
	        Romain romain = new Romain("Minus", 10);

	        romain.sEquiper(Equipement.CASQUE);
	        romain.sEquiper(Equipement.CASQUE);
	        romain.sEquiper(Equipement.BOUCLIER);
	        romain.sEquiper(Equipement.CASQUE);
	    }
}