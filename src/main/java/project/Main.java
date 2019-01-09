package project;

import javax.swing.*;
import javax.xml.stream.events.EndDocument;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static ArrayList<Currency> currencylist = new ArrayList<>();

    public static void main(String[] args) {


        String toBuy = "not set";
        String toSell = "not set";

        final String exitStart = "Please choose an option (>>x<< to exit)";
        final String auswahlStart = "0: Select currency to buy: \n1: Select currency to sell: \n2: Choose amount to be converted:";
        final String auswahl = "Enter a currency´s name or part of it (>>xxx<< to exit):";
        final String select = "Select a currency by index:";
        final String auswahl2 = "Enter an amount:";
        String kopfbereich = "";
        String zwischenspeicher;

        String [] vorschlag = new String[50];
        String eingabe;
        String zwischenspeicherLänder = "";
        String f = "";
        String h = "";

        int listenNummer = 0;
        int j = 0;
        int m = 0;

        boolean betragAusgewählt = false;
        boolean auswahlGesetzt = false;

        double umgerechneterBetrag = 0;
        double eingegebenerWert = 0;


        File file = new File("currencies.csv");


        try {
            Scanner s = new Scanner(file);
            while (s.hasNext()) {
                zwischenspeicher = s.nextLine();
                String p[] = zwischenspeicher.split(":");
                Currency neuesObjekt = new Currency(p[0], p[1]);
                currencylist.add(listenNummer, neuesObjekt);
                listenNummer++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Datei nicht gefunden");
            e.printStackTrace();
        }

        System.out.println(KopfbereichEins(toSell,toBuy) + "\n" + auswahlStart + "\n\n\n" + exitStart);

        Scanner scannerEingabe = new Scanner(System.in);

        while (scannerEingabe.hasNext() && auswahlGesetzt == false) {
            eingabe = scannerEingabe.next();

            if (eingabe.equals("0")) {

                if (betragAusgewählt==false) {
                    kopfbereich = KopfbereichEins(toSell,toBuy);
                } else if (betragAusgewählt == true) {
                   kopfbereich = KopfbereichZwei(toSell,toBuy,eingegebenerWert,umgerechneterBetrag);
                }

                System.out.println(kopfbereich + "\n" + auswahlStart + "\n\n" + exitStart + "\n" + auswahl);

                eingabe = scannerEingabe.next();

                System.out.println(kopfbereich);
                MöglichkeitenAuswahl(eingabe);
                System.out.println("\n" + select);

                eingabe = scannerEingabe.next();

                for (int i = 0; i < vorschlag.length; i++)

                    if (eingabe.equals("" + i)) {
                        toBuy = vorschlag[i];
                        if (betragAusgewählt == false) {
                            System.out.println(KopfbereichEins(toSell,toBuy));
                        } else if (betragAusgewählt == true){

                            String [] sdrWert = SDRWert(toSell,toBuy);

                            umgerechneterBetrag = Umrechner(sdrWert, eingegebenerWert);

                            System.out.println(KopfbereichZwei(toSell,toBuy,eingegebenerWert,umgerechneterBetrag));
                        }
                    }

                System.out.println(auswahlStart + "\n\n" + exitStart);



            } else if (eingabe.equals("1")) {

                if (betragAusgewählt==false) {
                    System.out.println(KopfbereichEins(toSell,toBuy) + "\n" + auswahlStart + "\n\n\n" + exitStart + "\n" + auswahl);
                } else if (betragAusgewählt == true) {
                    System.out.println(KopfbereichZwei(toSell,toBuy,eingegebenerWert,umgerechneterBetrag)+"\n"+auswahlStart+"\n\n"+exitStart+"\n"+auswahl);
                }


                eingabe = scannerEingabe.next();

                j = 0;

                for (int i = 0; i < 50; i++) {

                    zwischenspeicherLänder = currencylist.get(i).getName();

                    if (zwischenspeicherLänder.contains(eingabe)) {
                        vorschlag[j] = zwischenspeicherLänder;
                        System.out.println(j + ": " + vorschlag[j]);
                        j++;

                    }
                }

                System.out.println("\n" + select);
                eingabe = scannerEingabe.next();

                for (int i = 0; i < vorschlag.length; i++)

                    if (eingabe.equals("" + i)) {
                        toSell = vorschlag[i];
                        if (betragAusgewählt == false) {
                            System.out.println(KopfbereichEins(toSell,toBuy));
                        } else if (betragAusgewählt == true){

                            for (i = 0; i < 50; i++) {

                                zwischenspeicherLänder = currencylist.get(i).getName();

                                if (zwischenspeicherLänder.contains(toBuy)) {
                                    vorschlag[j] = zwischenspeicherLänder;
                                    f = currencylist.get(i).getRate();
                                } else if (zwischenspeicherLänder.contains(toSell)){
                                    vorschlag[m] = zwischenspeicherLänder;
                                    h = currencylist.get(i).getRate();
                                }
                            }

                            //umgerechneterBetrag = Umrechner(, eingegebenerWert);

                            System.out.println(KopfbereichZwei(toSell,toBuy,eingegebenerWert,umgerechneterBetrag));
                        }
                    }

                System.out.println(auswahlStart + "\n\n" + exitStart);

            } else if (eingabe.equals("2")) {

                betragAusgewählt = true;

                System.out.println(auswahl2);

                eingegebenerWert = scannerEingabe.nextDouble();


                f = "";
                h = "";

                for (int i = 0; i < 50; i++) {

                    zwischenspeicherLänder = currencylist.get(i).getName();

                    if (zwischenspeicherLänder.contains(toBuy)) {
                        vorschlag[j] = zwischenspeicherLänder;
                        f = currencylist.get(i).getRate();
                    } else if (zwischenspeicherLänder.contains(toSell)){
                        vorschlag[m] = zwischenspeicherLänder;
                        h = currencylist.get(i).getRate();
                    }
                }

               // umgerechneterBetrag = Umrechner(f, h, eingegebenerWert);

                System.out.println(KopfbereichZwei(toSell,toBuy,eingegebenerWert,umgerechneterBetrag)+"\n"+auswahlStart+"\n\n"+exitStart);

            } else if (eingabe.equals("x")) {

                break;

            } else {
                System.out.println("ungültige Eingabe!");
                scannerEingabe.next();
            }

        }

    }

    private static double Umrechner(String [] wert, double geldbetrag) {
        Double rateBuy = Double.valueOf(wert[1]);
        Double rateSell = Double.valueOf(wert[0]);
        double sdr = geldbetrag/rateBuy;
        double umgerechneterBetrag = sdr*rateSell;
        return umgerechneterBetrag;
    }

    private static String KopfbereichEins (String toSell, String toBuy){
        String s = "Currency to buy: " + toBuy + "\nCurrency to sell: " + toSell +
                    "\n++++++++++++++++++++++++++++++++++";
        return s;
    }

    private static String KopfbereichZwei (String toSell, String toBuy, double umzurechnenderWert, double umgerechneterWert){
        String s = "Buying: " + umzurechnenderWert + " " + toBuy + "\n" +
                    "Selling: " + umgerechneterWert + " " + toSell +
                    "\n++++++++++++++++++++++++++++++++++";
        return s;
    }

    private static String[] SDRWert (String toSell, String toBuy){
        String [] wert = new String [2];
        for (int i = 0 ; i < 50 ; i++){
            String zwischenspeicher = currencylist.get(i).getName();
            if(zwischenspeicher.contains(toSell)){
                wert [0]= currencylist.get(i).getRate();
            } else if (zwischenspeicher.contains(toBuy)){
                wert[1]=currencylist.get(i).getRate();
            }
        }
        return wert;
    }


    private static String[] MöglichkeitenAuswahl (String eingabe){
        int zähler = 0;
        String [] vorschlag = new String [50];
        for(int i = 0 ; i < vorschlag.length ; i++){
            String zwischenspeicher = currencylist.get(i).getName();

            if(zwischenspeicher.contains(eingabe)){
                vorschlag [zähler] = zwischenspeicher;
                System.out.println(zähler + ":" + vorschlag[zähler]);
                zähler++;
            }
        }
        return vorschlag;
    }
}
