/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kektura;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author user09
 */
public class kektura {
    static ArrayList<kektura_adatok> Klist = new ArrayList<>();
    static int tengerszint = 0;
    static public Boolean bennenincs(int i)
    {
        Boolean ok = false;
        if (Klist.get(i).getVegpont().contains("pecsetelohely"))
        {
            ok = false;
        }
        return ok;
    }
    public static void main(String[] args)
    {
        try
        {   
            System.setProperty("file.encoding", "UTF8");
            FileReader fr = new FileReader("Kektura.csv");
            BufferedReader br = new BufferedReader(fr);
            String sor = null;
            tengerszint = Integer.parseInt(br.readLine());
            while ((sor = br.readLine()) !=null) 
            {                
                String[] dbok=sor.split(";");
                String Kiindulopont = dbok[0];
                String Vegpont = dbok[1];
                String beHossz = dbok[2];
                String Hosszi = beHossz.replace(",", ".");
                double Hossz = Double.parseDouble(Hosszi);
                int Emelkedes = Integer.parseInt(dbok[3]);
                int Lejtes = Integer.parseInt(dbok[4]);
                Boolean Pecsetelohely = false;
                if (dbok[5].contains("i")) 
                {
                    Pecsetelohely = true;
                }
                kektura_adatok KA = new kektura_adatok(Kiindulopont, Vegpont, Hossz, Emelkedes, Lejtes, Pecsetelohely);
                Klist.add(KA);
            }
            br.close();
            fr.close();
        }
        
        catch(IOException | NumberFormatException e)
        {
            System.out.println("Hiba: "+ e);
        }
        System.out.println("A fájlbeolvasás megtörtént");
        System.out.println("3. Feladat: Szakaszok száma: " + Klist.size() + " db");
        Double teljesHossz = 0.0;
        for (kektura_adatok x: Klist) 
        {
            teljesHossz += x.getHossz();
        }
        System.out.println("4. Feladat: A túra teljes hossza: " + String.format("%.3f", teljesHossz) + " Km");
        System.out.println("5. Feladat: A legrövidebb szakasz adatai: ");
        Double legrovidebbszakasz = Klist.get(0).getHossz();
        String kezdet5 = Klist.get(0).getKiindulopont();
        String veg5 = Klist.get(0).getVegpont();
        for (int i = 0; i < Klist.size(); i++) 
        {
            if (legrovidebbszakasz > Klist.get(i).getHossz()) 
            {
                legrovidebbszakasz = Klist.get(i).getHossz();
                kezdet5 = Klist.get(i).getKiindulopont();
                veg5 = Klist.get(i).getVegpont();
            }
        }
        System.out.println("\t Kezdete: "+ kezdet5);
        System.out.println("\t Vége: "+ veg5);
        System.out.println("\t Távolság: "+ String.format("%.3f", legrovidebbszakasz) + " km");
        System.out.println("7. Feladat: Hiányos állomásnevek: " + veg5);
        int db = 0;
        for (int i = 0; i < Klist.size(); i++) 
        {
            System.out.println(Klist.get(i).getPecsetelohely());
            if (!bennenincs(i) && Klist.get(i).getPecsetelohely())
            {
                System.out.println("\t " + Klist.get(i).getVegpont());
            }
        }
        if (db > 0) 
        {
            System.out.println("Nincs hiányos állomásnév");
        }
        System.out.println("8. Feladat: A túra legmagasabban fekvő végpontja");
        String vegpont8 = "";
        int legmagasabbtengerszint = tengerszint + Klist.get(0).getEmeledes();
        for (int i=1; i<Klist.size(); i++)
        {
            if (legmagasabbtengerszint < (tengerszint + Klist.get(i).getEmeledes()))
            {
                legmagasabbtengerszint = tengerszint + Klist.get(i).getEmeledes() + Klist.get(i).getEmeledes();
                vegpont8 = Klist.get(i).getVegpont();
            }
        }
        System.out.println("\t A végpont neve: " + vegpont8);
        System.out.println("\t A végpont tengerszint feletti magassága: " + legmagasabbtengerszint + " m");
        System.out.println("9. Feladat: ");
        try
        {
            System.setProperty("file.encoding", "utf8");
            PrintWriter pw = new PrintWriter("kektura2.txt");
            String seged = "";
            pw.write(tengerszint + " \n");
            for (int j = 0; j < Klist.size(); j++) {
                pw.write(Klist.get(j).getKiindulopont());
                if (!bennenincs(j) && Klist.get(j).getPecsetelohely())
                {
                    pw.write(Klist.get(j).getVegpont()+" pecsetelohely ");
                }
                else
                {
                    pw.write(Klist.get(j).getVegpont() + " ");
                }
                pw.write(Klist.get(j).getEmeledes()+" "+ Klist.get(j).getLejtes() + " " );
                if (Klist.get(j).getPecsetelohely()) 
                {
                    seged = "i";
                }
                else
                {
                    seged = "n";
                }
                pw.write(seged + "\r\n");
                
            }
            pw.close();
        }
        catch (IOException h)
        {
            System.out.println("Hiba: " + h);
        }
    }   
}
