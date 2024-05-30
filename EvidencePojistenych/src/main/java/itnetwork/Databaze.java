package itnetwork;

import java.util.ArrayList;

/**
 * Databáze
 */
public class Databaze {

    /**
     * Databaze pojištěnců
     */
    private ArrayList<Pojistenec> evidencePojistencu;

    /**
     * Konstruktor
     */
    public Databaze() {
        evidencePojistencu = new ArrayList<>();
    }

    /**
     * Přidá záznam do databáze pojištěnců
     *
     * @param jmeno          Jméno pojištěnce
     * @param prijmeni       Přijmení pojištěnce
     * @param vek            Věk pojištěnce
     * @param telefonniCislo Telefonní číslo pojištěnce
     */
    public void pridejPojistence(String jmeno, String prijmeni, int vek, String telefonniCislo) {
        evidencePojistencu.add(new Pojistenec(jmeno, prijmeni, vek, telefonniCislo));
    }

    /**
     * Najde pojištěnce podle jména a přijmení
     *
     * @param jmeno    Jmeno pojištěnce
     * @param prijmeni Přijmeni pojištěnce
     * @return Kolekce nalezených pojištěnců
     */
    public ArrayList<Pojistenec> najdiPojistence(String jmeno, String prijmeni) {
        ArrayList<Pojistenec> nalezene = new ArrayList<>();
        for (Pojistenec pojistenec : evidencePojistencu) {
            if (pojistenec.getJmeno().equals(jmeno) && pojistenec.getPrijmeni().equals(prijmeni)) {
                nalezene.add(pojistenec);
            }
        }
        return nalezene;
    }

    /**
     * Vrátí seznam všech pojištěnců
     *
     * @return Kolekce všech pojištěnců
     */
    public ArrayList<Pojistenec> getEvidencePojistencu() {
        return new ArrayList<>(evidencePojistencu);
    }

}