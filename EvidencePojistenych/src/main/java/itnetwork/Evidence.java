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
        String jmeno;

        // Získání jména s kontrolou prázdného vstupu
        while (true) {
            System.out.print("Zadejte jméno pojištěného: ");
            jmeno = scanner.nextLine().trim();
            if (!jmeno.isEmpty()) {
                break;
            }
            System.out.println("Jméno nebylo zadáno, prosím zadejte jméno.");
        }

        System.out.print("Zadejte příjmení: ");
        String prijmeni = scanner.nextLine().trim();

        System.out.print("Zadejte telefonní číslo: ");
        String telefonniCislo = scanner.nextLine().trim();

        System.out.print("Zadejte věk: ");
        int vek = Integer.parseInt(scanner.nextLine().trim());

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
        for (Pojistenec pojistenec : databaze.getEvidencePojistencu()) {
            System.out.println(pojistenec);
        }
    }

    /**
     * Vyzve uživatele k zadání jména a příjmení a najde odpovídající pojištěnce v kolekci
     */
    public void vyhledejPojistence() {
        String jmeno;

        // Získání jména s kontrolou prázdného vstupu
        while (true) {
            System.out.print("Zadejte jméno pojištěného: ");
            jmeno = scanner.nextLine().trim();
            if (!jmeno.isEmpty()) {
                break;
            }
            System.out.println("Jméno nebylo zadáno, prosím zadejte jméno.");
        }

        System.out.print("Zadejte příjmení: ");
        String prijmeni = scanner.nextLine().trim();

        ArrayList<Pojistenec> nalezeneZaznamy = databaze.najdiPojistence(jmeno, prijmeni);

        if (nalezeneZaznamy.isEmpty()) {
            System.out.println("Nebyly nalezeny žádné záznamy");
        } else {
            for (Pojistenec pojistenec : nalezeneZaznamy) {
                System.out.println(pojistenec);
            }
        }

        System.out.println("Pokračujte klávesou enter.");
        scanner.nextLine();
    }

    /**
     * Grafický prvek pro výpis do konzole
     */
    public static void hlavickaEvidence() {
        System.out.println("----------------------------------------------------------------");
        System.out.println("Evidence pojištěných");
        System.out.println("----------------------------------------------------------------");
    }


}