package personnages;

public enum Equipement {
    CASQUE("Casque"),
    BOUCLIER("Bouclier");

    private String description;

    Equipement(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
