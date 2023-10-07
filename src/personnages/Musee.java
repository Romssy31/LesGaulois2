package personnages;

public class Musee {
    private Trophee[] trophees;
    private int nbTrophees;

    public Musee() {
        this.trophees = new Trophee[200];
        this.nbTrophees = 0;
    }

    public void donnerTrophees(Gaulois gaulois, Equipement equipement) {
        if (nbTrophees < trophees.length) {
            Trophee nouveauTrophee = new Trophee(gaulois, equipement);
            trophees[nbTrophees] = nouveauTrophee;
            nbTrophees++;
            System.out.println("Le Gaulois " + gaulois.getNom() + " a fait un don au musée : " + equipement);
        } else {
            System.out.println("Le musée est plein, impossible d'ajouter un nouveau trophée.");
        }
    }
    
    public String extraireInstructionsOCaml() {
        StringBuilder ocamlCode = new StringBuilder();
        ocamlCode.append("let musee = [\n");

        for (int i = 0; i < nbTrophees; i++) {
            Trophee trophee = trophees[i];
            ocamlCode.append("\"").append(trophee.getGaulois().getNom()).append("\", \"")
                    .append(trophee.getEquipement()).append("\";\n");
        }

        ocamlCode.append("]\n");

        return ocamlCode.toString();
    }
    
    public static void main(String[] args) {
        Musee musee = new Musee();

        Gaulois asterix = new Gaulois("Astérix", 8);
        Gaulois obelix = new Gaulois("Obélix", 10);

        musee.donnerTrophees(asterix, Equipement.BOUCLIER);
        musee.donnerTrophees(asterix, Equipement.CASQUE);
        musee.donnerTrophees(obelix, Equipement.BOUCLIER);
        musee.donnerTrophees(obelix, Equipement.CASQUE);
        musee.donnerTrophees(obelix, Equipement.CASQUE);

        String ocamlCode = musee.extraireInstructionsOCaml();

        System.out.println(ocamlCode);
    }
}
