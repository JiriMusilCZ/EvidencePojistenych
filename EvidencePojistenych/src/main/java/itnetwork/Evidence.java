package itnetwork;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Evidence
 */
public class Evidence {

    /**
     * Databáze
     */
    private Databaze databaze;

    /**
     * Scanner
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     * Konstruktor
     */
    public Evidence() {
        databaze = new Databaze();
    }

    /**
     * Vyzve uživatele k zadání atributů pojištěnce a přidá pojištěnce do databáze
     */
    public void pridejPojistence() {
        String jmeno = ziskejNeprazdnyVstup("Zadejte jméno pojištěného: ");
        String prijmeni = ziskejNeprazdnyVstup("Zadejte příjmení: ");
        String telefonniCislo = ziskejPlatneTelefonniCislo();

        // Kontrola platného věku
        int vek = -1;
        while (vek < 0) {
            try {
                String vekVstup = ziskejNeprazdnyVstup("Zadejte věk: ");
                vek = Integer.parseInt(vekVstup);
            } catch (NumberFormatException e) {
                System.out.println("Věk musí být číslo, zkuste to znovu.");
            }
        }

        databaze.pridejPojistence(jmeno, prijmeni, vek, telefonniCislo);

        System.out.println();
        System.out.print("Data byla uložena. Pokračujte klávesou enter.");
        scanner.nextLine();
    }

    /**
     * Vypíše všechny pojištěnce v kolekci
     */
    public void vypisPojistence() {
        hlavickaEvidence();
        hlavickaTabulky();
        for (Pojistenec pojistenec : databaze.getEvidencePojistencu()) {
            System.out.println(pojistenec);
        }
    }

    /**
     * Vyzve uživatele k zadání jména a příjmení a najde odpovídající pojištěnce v kolekci
     */
    public void vyhledejPojistence() {
        String jmeno = "";
        String prijmeni = "";

        while (jmeno.isEmpty() || prijmeni.isEmpty()) {
            System.out.print("Zadejte jméno a přijmení pojištěného: ");
            String vstup = scanner.nextLine().trim();

            if (vstup.isEmpty()) {
                System.out.println("Jméno a příjmení musí být zadáno.");
                continue;
            }

            String[] casti = vstup.split("\\s+");
            if (casti.length < 2) {
                System.out.println("Je třeba zadat jméno a příjmení.");
                continue;
            }

            jmeno = casti[0];
            prijmeni = casti[1];

            ArrayList<Pojistenec> nalezeneZaznamy = databaze.najdiPojistence(jmeno, prijmeni);

            if (nalezeneZaznamy.isEmpty()) {
                System.out.println("Nebyly nalezeny žádné záznamy.");
            } else {
                for (Pojistenec pojistenec : nalezeneZaznamy) {
                    hlavickaEvidence();
                    hlavickaTabulky();
                    System.out.println(pojistenec);
                }
            }

            System.out.println("Pokračujte klávesou enter.");
            scanner.nextLine();
            break;
        }
    }

    /**
     * Grafický prvek pro výpis do konzole
     */
    public static void hlavickaEvidence() {
        System.out.println("----------------------------------------------------------------");
        System.out.println("Evidence pojištěných");
        System.out.println("----------------------------------------------------------------");
    }

    /**
     * Grafický prvek pro výpis záznamů hlavička tabulky
     */

    private void hlavickaTabulky(){
        System.out.printf("%-15s %-20s %-8s %-15s%n", "Jméno", "Příjmení", "Věk", "Telefonní číslo");
        System.out.println("----------------------------------------------------------------");
    }


    /**
     * Uzavření skeneru po ukončení použití
     */
    public void uzavriScanner() {
        scanner.close();
    }

    /**
     * Validace vstupních informací
     *
     * @param vyzva Text výzvy pro zadání vstupní proměnné do evidence
     * @return Zvalidovaný atribut Pojištěnce
     */
    private String ziskejNeprazdnyVstup(String vyzva) {
        String vstup = "";
        while (vstup.isEmpty()) {
            System.out.print(vyzva);
            vstup = scanner.nextLine().trim();
            if (vstup.isEmpty()) {
                System.out.println("Vstup není zadaný, zkuste to znovu.");
            }
        }
        return vstup;
    }

    /**
     * Získá platné telefonní číslo od uživatele ve formátu "XXX XXX XXX"
     * @return platné telefonní číslo
     */
    private String ziskejPlatneTelefonniCislo() {
        String telefonniCislo = "";
        while (true) {
            System.out.print("Zadejte telefonní číslo ve formátu XXX XXX XXX: ");
            telefonniCislo = scanner.nextLine().trim();

            // Kontrola, zda číslo odpovídá formátu "XXX XXX XXX" a obsahuje pouze čísla
            if (telefonniCislo.matches("\\d{3} \\d{3} \\d{3}")) {
                break;
            } else {
                System.out.println("Telefonní číslo není ve správném formátu. Musí být 9 číslic ve formátu XXX XXX XXX.");
            }
        }
        return telefonniCislo;
    }


}