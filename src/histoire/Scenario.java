package histoire;

import personnages.Druide;
import personnages.Gaulois;
import personnages.Romain;

public class Scenario {

    public static void main(String[] args) {
        Gaulois obelix = new Gaulois("Obélix", 25);
        Gaulois asterix = new Gaulois("Astérix", 8);
        Romain minus = new Romain("Minus", 6);
        Druide panoramix = new Druide("Panoramix", 5, 10);

        panoramix.parler("Bonjour, je suis le druide " + panoramix.getNom() + " et ma potion peut aller d'une force "
                + panoramix.getEffetPotionMin() + " à " + panoramix.getEffetPotionMax() + ".");
        panoramix.parler("Je vais aller préparer une petite potion...");

        panoramix.preparerPotion();

        panoramix.booster(obelix);

        panoramix.booster(asterix);

        obelix.parler("Par Bélénos, ce n'est pas juste!");

        asterix.boirePotion(6);
        asterix.parler("Bonjour");

        minus.parler("UN GAU... UN GAUGAU...");

        asterix.frapper(minus);

        minus.parler("J'abandonne...");
    }
}
