package personnages;

public enum Equipement {
    CASQUE("Casque"),
    BOUCLIER("Bouclier");

    private String nom;

    private Equipement(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return nom;
    }
}
