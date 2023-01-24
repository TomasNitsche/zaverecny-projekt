/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.itnetwork.evidencepojisteni;



/**
 *
 * @author nitsc
 */
public class PojistenaOsoba {
    private String jmeno;
    private String prijmeni;
    private int vek;
    private String telCislo;
    
    public PojistenaOsoba(String jmeno, String prijmeni, int vek, String telCislo) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.vek = vek;
        this.telCislo = telCislo;
    }
    
   public String getJmeno () { return jmeno; }
   public String getPrijmeni () { return prijmeni; }
   public int getVek () { return vek; }
   public String getTelCislo () { return telCislo; }

   @Override
   public String toString(){
       return String.format(this.jmeno + "   " + this.prijmeni + "   " + this.vek + " let  +420 " + this.telCislo);
   }
   
    
}
