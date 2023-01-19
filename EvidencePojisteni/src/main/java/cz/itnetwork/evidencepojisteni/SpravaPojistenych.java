/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.itnetwork.evidencepojisteni;

import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author nitsc
 */
public class SpravaPojistenych {
    Scanner sc = new Scanner(System.in, "Windows-1250");
    private LinkedList<PojistenaOsoba> pojisteneOsoby = new LinkedList<>();
    private PojistenaOsoba posledniPridany;
    
    /*
    * Hlavní metoda ve které program běží
    * zajišťuje vkládání nových pojištěnců i jejich výpisy
    */
    public void spustitSpravu() {
        vypisUvod();
        vypisPrikazoveMenu();
        System.out.println("Zadejte číslo příkazu a stiskni klávesu \"Enter\"");
        int prikaz = Integer.parseInt(sc.nextLine());
        
        /*
        * while cyklus který nám zajišťuje opakování zadávíní příkazů dokud uživatel nezadá, že chce ukončit
        * příkazy jsou vložení pojištěného, vypsání všechn pojištěných, najít pojištěného a ukončit aplikaci
        */
        
        while (prikaz != 4) {
            if (prikaz >=1 && prikaz <= 4) {
            switch (prikaz) {
                case 1 -> {
                    vlozPojisteneho();
                }
                case 2 -> {
                    vypisVsechny();
                }
                case 3 -> {
                    najdiPojisteneho();
                }
                case 4 -> { 
                    System.out.println("Ukončuji evidenci. Nashledanou");
                    System.exit(0);
                }    
                }
            } else { System.out.println("Zadali jste neplatnou hodnotu:"); }
     
            vypisPrikazoveMenu();
            prikaz = Integer.parseInt(sc.nextLine());
            
 
        }
    }
    // Vypisuje se při spuštění programu. je to nápis EVIDENCE
    private void vypisUvod() {
        System.out.println("||||| \\\\       // || |||\\\\    ||||| ||\\\\    ||  //||\\  |||||");
        System.out.println("||     \\\\     //  || ||   \\\\  ||    || \\\\   || ||   || ||");
        System.out.println("||||    \\\\   //   || ||   ||  ||||  ||  \\\\  || ||      ||||");
        System.out.println("||       \\\\ //    || ||  //   ||    ||   \\\\ || ||   || ||");
        System.out.println("|||||     \\\\/     || |||//    ||||| ||    \\\\||  \\\\||/  |||||");
        System.out.println("");
        System.out.println("Dobrý den, sputili jste aplikaci Evidence pojištěných");
        System.out.println("------------------------------------------------------------");    
    }
    /*
    * příkazové menu podle kterého uživatel zadává co má v úmyslu
    */
    private void vypisPrikazoveMenu(){
        System.out.println("Zadej příkaz v podobě čísla příkazu a stiskni klávesu \"Enter\"");
        System.out.println("1 -> Přidání nového pojištěného");
        System.out.println("2 -> Vypsání všech pojištěných");
        System.out.println("3 -> Najdi pojištěného");
        System.out.println("4 -> Ukonči Evidenci pojištěných");
    }
    /*
    * metoda na vkládání pojištěnce
    * zjišťujeme jméno, příjmení, věk, tel. číslo
    * v try a catch chceme vědět zda-li nám někdo nezadal místo číslo jiný symbol
    */
    private void vlozPojisteneho() {
        try {
        System.out.println("Napiš jméno pojištěného a stiskni klávesu \"Enter\"");
        String jmeno = sc.nextLine();
        System.out.println("Napiš příjmení pojištěného a stiskni klávesu \"Enter\"");
        String prijmeni = sc.nextLine();
        System.out.println("Zadej věk pojištěného a stiskni klávesu \"Enter\"");
        int vek = Integer.parseInt(sc.nextLine());
        
        // zjištění zda-li jsme omylem nezadali chybné číslo
        if (vek > 125) {
            System.out.println("Věk se zdá být zadaný chybně");
            zeptejSeNaPokracovani();
        }
        System.out.println("Zadej telefonní číslo pojištěného bez mezer ve tvaru 123456789 a stiskni klávesu \"Enter\"");
        int telCislo = Integer.parseInt(sc.nextLine());
        // zjištění zda-li jsme omylem nezadali chybné číslo
        if ((telCislo > 999999999) && (telCislo < 100000000))
                System.out.println("Telefonní číslo se zdá být zadané chybně");
        
        // vytvoření nového pojištěného v záznamu
        PojistenaOsoba pojistenaOsoba = new PojistenaOsoba(jmeno, prijmeni, vek, telCislo);
        pojisteneOsoby.addLast(pojistenaOsoba);
        posledniPridany = pojistenaOsoba;
        vypisVlozeny();
    }
        catch(Exception e) 
                { System.out.println("Něco se zdá být špatně. Přesvěčte se že zadávate správně jméno, příjmění věk a telefonní číslo");
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
    private void vypisVsechny() {
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
                }
    }
    /*
    * na základě příjmení a jmena metoda hledá pojištěného
    * pokud se jméno ani přijmení neshoduje se žádným se záznamů metoda napíše, že nenašla pojištěného
    */
    private void najdiPojisteneho() {
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
            System.out.println("Ukončuji evidenci. Nashledanou");
            System.exit(0);
        } else {
            System.out.println("------------------------------------------------------------");
        }
        
    }
}
    

