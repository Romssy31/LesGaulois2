package personnages;
import java.util.Arrays;

public class Gaulois {
	private static final int CAPACITE_MAX = 200;
	private String nom;
	private int effetPotion = 1;
	private int force;
	private int nbTrophees;
	private Equipement[] trophees = new Equipement[100];
	private Trophee[] trophe = new Trophee[CAPACITE_MAX]; // Assurez-vous d'avoir une constante ou une valeur définie



	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + " : " + texte);
	}

	private String prendreParole() {
		return "Le gaulois " + nom + " : ";

	}

	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement[] trophees = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; trophees != null && i < trophees.length; i++, nbTrophees++) {
			this.trophees[nbTrophees] = trophees[i];
		}
	}

	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
		parler("Merci Druide, je sens que ma force est " + effetPotion + " fois décuplée.");
	}

	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}
	


    // Méthode pour faire une donation au musée
	public void faireUneDonnation(Musee musee) {
	    if (nbTrophees > 0) {
	        System.out.println("Le gaulois " + nom + " : \"Je donne au musée tous mes trophées :\"");
	        
	        for (int i = 0; i < nbTrophees; i++) {
	            Trophee trophee = trophe[i];
	            System.out.println("- " + trophee.getEquipement());
	            musee.donnerTrophees(trophee.getGaulois(), trophee.getEquipement());
	        }
	        
	        System.out.println("Fin de la donation.");
	        
	        // Réinitialiser le tableau de trophées du Gaulois
	        Arrays.fill(trophees, null); // Réinitialise tous les éléments à null
	        nbTrophees = 0;
	    } else {
	        System.out.println("Le gaulois " + nom + " n'a aucun trophée à donner.");
	    }
	}


    public static void main(String[] args) {
        Gaulois asterix = new Gaulois("Asterix", 8);
        asterix.boirePotion(3);

        Romain romain = new Romain("Ennemi", 10);
        asterix.frapper(romain);

        Equipement equipement = Equipement.BOUCLIER;

        Musee musee = new Musee();

        Trophee trophee = new Trophee(asterix, equipement);

        musee.donnerTrophees(trophee.getGaulois(), trophee.getEquipement());
    }
}