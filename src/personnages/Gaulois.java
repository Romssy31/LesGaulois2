package personnages;

public class Gaulois {
    private String nom;
    private int force;
    private int effetPotion = 1;

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
        return "Le gaulois " + nom;
    }

    public void frapper(Romain romain) {
        int forceCoup = (force / 3) * effetPotion;
        System.out.println(nom + " envoie un coup dans la mâchoire de " + romain.getNom()
                + " avec une force de " + forceCoup);
        romain.recevoirCoup(forceCoup);
    }

    public void boirePotion(int forcePotion) {
        effetPotion = forcePotion;
        parler("Merci Druide, je sens que ma force est " + effetPotion + " fois décuplée.");
    }

    @Override
    public String toString() {
        return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
    }

    public static void main(String[] args) {
        Gaulois asterix = new Gaulois("Asterix", 8);
        //System.out.println(asterix);
        //asterix.parler("TEST");

        asterix.boirePotion(3);

        Romain romain = new Romain("Ennemi", 10);
        asterix.frapper(romain);
    }
}
