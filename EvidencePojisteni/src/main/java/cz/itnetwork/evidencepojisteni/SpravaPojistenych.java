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
    Scanner sc = new Scanner(System.in, "UTF-8");
    DatabazePojistenych databaze = new DatabazePojistenych();

    /*
     * spustí program Evidence pojištěných
     * jediná veřejně přístupná metoda ostatní jsou private
     */
    public void spustitSpravu() {
        vypisUvod();
        zapniProgram();
    }
    /*
     * Hlavní metoda ve které program běží
     * zajišťuje vkládání nových pojištěnců i jejich výpisy
     */
    private void zapniProgram() {
        vypisPrikazoveMenu();
        try {
            System.out.println("Zadejte číslo příkazu a stiskni klávesu \"Enter\"");
            int prikaz = Integer.parseInt(sc.nextLine());
            /*
             * while cyklus který nám zajišťuje opakování zadávíní příkazů dokud uživatel nezadá, že chce ukončit
             * příkazy jsou vložení pojištěného, vypsání všechn pojištěných, najít pojištěného a ukončit aplikaci
             */

            while (prikaz != 4) {
                if (prikaz >= 1 && prikaz <= 4) {
                    switch (prikaz) {
                        case 1 -> {
                            databaze.vlozPojisteneho();
                        }
                        case 2 -> {
                            databaze.vypisVsechny();
                        }
                        case 3 -> {
                            databaze.najdiPojisteneho();
                        }
                        case 4 -> {
                            // sem se kód nedostane a aplikace se vypne
                            System.exit(0);
                        }
                    }
                } else {
                    System.out.println("Zadali jste neplatnou hodnotu:");
                }

                vypisPrikazoveMenu();
                prikaz = Integer.parseInt(sc.nextLine());

            }
            vypisKonecAplikace();
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Zadali jste neplatnou hodnotu. Prosím zadejte příkaz pomocí číslovky");
            zapniProgram();
        }

    }
    /*
     * Vypisuje se při spuštění programu. je to nápis EVIDENCE
     */
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
    * Vypisuje konec aplikace Evidence pojištění
    * Obsahuje ukončovací linku
     */
    private void vypisKonecAplikace() {
        System.out.println("------------------------------------------------------------");
        System.out.println("Ukončuji aplikaci Evidence pojištění. Nashledanou");
        for (int i = 0; i < 30; i++)
        try {
            System.out.print("->");
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            System.err.println("Ukončuji aplikaci Evidence pojištění. Nashledanou");
        }
    }
}

    

