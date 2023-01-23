package cz.itnetwork.evidencepojisteni;

import java.util.LinkedList;
import java.util.Scanner;

public class DatabazePojistenych {
    Scanner sc = new Scanner(System.in, "UTF-8");
    private LinkedList<PojistenaOsoba> pojisteneOsoby = new LinkedList<>();
    private PojistenaOsoba posledniPridany;
    private String jmeno;
    private String prijmeni;
    private int vek;
    private int telCislo;

    /*
     * metoda na vkládání pojištěnce
     * zjišťujeme jméno, příjmení, věk, tel. číslo
     * v try a catch chceme vědět zda-li nám někdo nezadal místo číslo jiný symbol
     */
    protected void vlozPojisteneho() {
        try {
            System.out.println("Napiš jméno pojištěného a stiskni klávesu \"Enter\"");
            String jmeno = sc.nextLine();
            System.out.println("Napiš příjmení pojištěného a stiskni klávesu \"Enter\"");
            String prijmeni = sc.nextLine();

            System.out.println("Zadej věk pojištěného a stiskni klávesu \"Enter\"");
            int vek = Integer.parseInt(sc.nextLine());

            // zjištění zda-li jsme omylem nezadali chybné číslo
            while ((vek > 125) ||(vek<0)) {
                System.out.println("Věk se zdá být zadaný chybně");
                zeptejSeNaPokracovani();
                System.out.println("Zadej věk pojištěného a stiskni klávesu \"Enter\"");
                vek = Integer.parseInt(sc.nextLine());

            }
            System.out.println("Zadej telefonní číslo pojištěného bez mezer ve tvaru 123456789 a stiskni klávesu \"Enter\"");
            int telCislo = Integer.parseInt(sc.nextLine());

            // zjištění zda-li jsme omylem nezadali chybné číslo
            while ((telCislo > 999999999) || (telCislo < 100000000)) {
                System.out.println("Telefonní číslo se zdá být zadané chybně");
                zeptejSeNaPokracovani();
                System.out.println("Zadej telefonní číslo pojištěného bez mezer ve tvaru 123456789 a stiskni klávesu \"Enter\"");
                telCislo = Integer.parseInt(sc.nextLine());

            }

            // vytvoření nového pojištěného v záznamu
            PojistenaOsoba pojistenaOsoba = new PojistenaOsoba(jmeno, prijmeni, vek, telCislo);
            pojisteneOsoby.addLast(pojistenaOsoba);
            posledniPridany = pojistenaOsoba;
            vypisVlozeny();
        }
        catch(Exception e)
        { System.out.println("Něco se zdá být špatně. Přesvěčte se že zadávate správně jméno, příjmění, věk a telefonní číslo ve formátu 123456789");
            zeptejSeNaPokracovani();
        }
    }

    /*
     * metoda nám zobrazuje vloženou osobu
     */
    private void vypisVlozeny() {
        System.out.println("------------------------------------------------------------");
        System.out.println("Úspěšně jste vložili pojištěnou osobu:");
        System.out.println(posledniPridany);
        System.out.println("------------------------------------------------------------");
    }
    /*
     * metoda nám vypisje všechny záznamy pojištěných
     * kontroluje zda-li je vůbec obsažen nějaký záznam
     */
    protected void vypisVsechny() {
        System.out.println("------------------------------------------------------------");
        if (pojisteneOsoby.size() < 1) {
            System.out.println("Evidence je bez záznamu");
            zeptejSeNaPokracovani();
        } else {
            System.out.println("Seznam všech pojištěných");
            for (int i = 0; i < pojisteneOsoby.size(); i++) {
                System.out.println((i+1) + " " +pojisteneOsoby.get(i).getJmeno() + " " +
                        pojisteneOsoby.get(i).getPrijmeni() + " " +
                        pojisteneOsoby.get(i).getVek() + " " +
                        pojisteneOsoby.get(i).getTelCislo());}
            System.out.println("------------------------------------------------------------");
            zeptejSeNaPokracovani();
        }
    }
    /*
     * na základě příjmení a jmena metoda hledá pojištěného
     * pokud se jméno ani přijmení neshoduje se žádným se záznamů metoda napíše, že nenašla pojištěného
     */
    protected void najdiPojisteneho() {
        System.out.println("------------------------------------------------------------");
        if (pojisteneOsoby.size() < 1) {
            System.out.println("Evidence je bez záznamu");
            zeptejSeNaPokracovani();
        } else {
            System.out.println("Napiš jméno pojištěného");
            String hledaneJmeno = sc.nextLine();
            System.out.println("Zadej příjmení pojištěného");
            String hledanePrijmeni = sc.nextLine();
            for (PojistenaOsoba osoba : pojisteneOsoby) {
                if (hledaneJmeno.equalsIgnoreCase(osoba.getJmeno()) && hledanePrijmeni.equalsIgnoreCase(osoba.getPrijmeni())) {
                    System.out.println(osoba);
                } else {
                    System.out.println("Tento pojištěný není v Evidenci");

                }
            }
            System.out.println("------------------------------------------------------------");
            zeptejSeNaPokracovani();
        }
    }
    /*
     * V programu jsou místa, kde se ptáme zda-li chce uživatel prokračovat
     * Volba je pokračování nebo ukončení aplikace
     */
    private void zeptejSeNaPokracovani() {
        System.out.println("Přejete si pokračovat? Ano / Ne");
        System.out.println("1 -> Ano");
        System.out.println("2 -> Ne");
        int volbaPokracovani = Integer.parseInt(sc.nextLine());
        if (volbaPokracovani == 2) {
            System.out.println("Ukončuji aplikaci Evidence pojištění. Nashledanou");
            System.exit(0);
        } else {
            System.out.println("------------------------------------------------------------");
        }
    }
}
