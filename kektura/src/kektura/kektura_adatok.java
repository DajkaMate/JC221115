/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kektura;

/**
 *
 * @author user09
 */
public class kektura_adatok {
    private String Kiindulopont;
    private String Vegpont;
    private Double Hossz;
    private int Emeledes;
    private int Lejtes;
    private Boolean Pecsetelohely;

    public kektura_adatok(String Kiindulopont, String Vegpont, Double Hossz, int Emeledes, int Lejtes, Boolean Pecsetelohely) {
        this.Kiindulopont = Kiindulopont;
        this.Vegpont = Vegpont;
        this.Hossz = Hossz;
        this.Emeledes = Emeledes;
        this.Lejtes = Lejtes;
        this.Pecsetelohely = Pecsetelohely;
    }
    
    public String getKiindulopont() {
        return Kiindulopont;
    }

    public String getVegpont() {
        return Vegpont;
    }

    public Double getHossz() {
        return Hossz;
    }

    public int getEmeledes() {
        return Emeledes;
    }

    public int getLejtes() {
        return Lejtes;
    }

    public Boolean getPecsetelohely() {
        return Pecsetelohely;
    }

    public void setKiindulopont(String Kiindulopont) {
        this.Kiindulopont = Kiindulopont;
    }

    public void setVegpont(String Vegpont) {
        this.Vegpont = Vegpont;
    }

    public void setHossz(Double Hossz) {
        this.Hossz = Hossz;
    }

    public void setEmeledes(int Emeledes) {
        this.Emeledes = Emeledes;
    }

    public void setLejtes(int Lejtes) {
        this.Lejtes = Lejtes;
    }

    public void setPecsetelohely(Boolean Pecsetelohely) {
        this.Pecsetelohely = Pecsetelohely;
    }
    
    
}
