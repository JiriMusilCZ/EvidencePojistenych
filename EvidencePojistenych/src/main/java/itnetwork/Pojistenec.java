package itnetwork;

/**
 * Pojištěnec
 */

public class Pojistenec {

    /**
     * Jméno pojištěnce
     */
    private String jmeno;

    /**
     * Přijmení pojištěnce
     */
    private String prijmeni;

    /**
     * Věk pojištěnce
     */
    private int vek;

    /**
     * Telefonní číslo pojištěnce
     */
    private String telefonniCislo;

    /**
     * Konstruktor
     *
     * @param jmeno Jmeno pojištěnce
     * @param prijmeni Přijmení pojištěnce
     * @param vek Věk pojištěnce
     * @param telefonniCislo Mobilní číslo pojištěnce
     */
    public Pojistenec(String jmeno, String prijmeni, int vek, String telefonniCislo) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.vek = vek;
        this.telefonniCislo = telefonniCislo;
    }

    /**
     * Vrátí jméno pojištěnce
     *
     * @return Jmeno pojištěnce
     */
    public String getJmeno() {
        return jmeno;
    }

    /**
     * Nastaví jméno pojištěnce
     *
     * @param jmeno Jméno pojištěnce
     */
    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    /**
     * Vrátí příjmení pojištěnce
     *
     * @return Přijmení pojištěnce
     */
    public String getPrijmeni() {
        return prijmeni;
    }

    /**
     * Nastaví příjmení pojištěnce
     *
     * @param prijmeni Příjmení pojištěnce
     */
    public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
    }

    /**
     * Vrátí věk pojištěnce
     *
     * @return Věk pojištěnce
     */
    public int getVek() {
        return vek;
    }

    /**
     * Nastaví věk pojištěnce
     *
     * @param vek Věk pojištěnce
     */
    public void setVek(int vek) {
        this.vek = vek;
    }

    /**
     * Vrátí telefonní číslo pojištěnce
     *
     * @return Telefonní číslo pojištěnce
     */
    public String getTelefonniCislo() {
        return telefonniCislo;
    }

    /**
     * Nastaví telefonní číslo pojištěnce
     *
     * @param telefonniCislo Telefonní číslo pojištěnce
     */
    public void setTelefonniCislo(String telefonniCislo) {
        this.telefonniCislo = telefonniCislo;
    }

    /**
     * Vrátí textový řetězec prezenace záznamu pojištěnce
     *
     * @return Textový řetězec s atributy Pojištěnce
     */
    @Override
    public String toString() {
        return String.format("%-15s %-20s %-8d %-15s", jmeno, prijmeni, vek, telefonniCislo);
    }

}