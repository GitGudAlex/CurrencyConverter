package project;

import javax.swing.*;
import javax.xml.stream.events.EndDocument;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static ArrayList<Currency> currencylist = new ArrayList<>();
    public static int laengeArrayAuswahl = 0;

    public static void main(String[] args) {

        // Variablendeklaration

        // Strings
        String toBuy = "not set";
        String toSell = "not set";
        String eingabe;
        String zwischenspeicherLänder = "";
        String kopfbereich = "";
        String zwischenspeicher;

        // konstante Strings
        final String exitStart = "Please choose an option (>>x<< to exit)";
        final String auswahlStart = "0: Select currency to buy: \n1: Select currency to sell: \n2: Choose amount to be converted:";
        final String auswahl = "Enter a currency´s name or part of it (>>xxx<< to exit):";
        final String select = "Select a currency by index:";
        final String auswahl2 = "Enter an amount:";

        // String Array

        String [] sdrWert;

        // Integervariablen
        int listenNummer = 0;
        int j = 0;

        // boolean
        boolean betragAusgewählt = false;
        boolean auswahlGesetzt = false;


        // Doublevariablen
        double umgerechneterBetrag = 0;
        double eingegebenerWert = 0;

        // Dateifile der Datei currencies.csv, die die SDR Werte enthält
        File file = new File("currencies.csv");


        try {
            // Deklaration Scanner zur Abfrage der Benutzereingabe um eine Auswahl zu treffen
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

        while (scannerEingabe.hasNext() && !auswahlGesetzt) {
            eingabe = scannerEingabe.next();

            if (eingabe.equals("0")) {

                if (!betragAusgewählt) {
                    kopfbereich = KopfbereichEins(toSell,toBuy);
                } else if (betragAusgewählt) {
                   kopfbereich = KopfbereichZwei(toSell,toBuy,eingegebenerWert,umgerechneterBetrag);
                }

                System.out.println(kopfbereich + "\n" + auswahlStart + "\n\n" + exitStart + "\n" + auswahl);

                eingabe = scannerEingabe.next();



                while(EingabeKorrekt(eingabe)==false){
                    System.out.println("currency does not exist. Please try again");
                    eingabe = scannerEingabe.next();
                    System.out.println(eingabe+EingabeKorrekt(eingabe));
                }

                System.out.println(kopfbereich);
                MöglichkeitenAuswahl(eingabe);
                String [] vorschlag = new String[laengeArrayAuswahl];

                for (int i = 0 ; i<vorschlag.length; i++){
                    vorschlag[i]=MöglichkeitenAuswahl(eingabe)[i];
                    System.out.println(i + ":" + vorschlag[i]);
                }

                System.out.println("\n" + select);

                eingabe = scannerEingabe.next();

                for (int i = 0; i < vorschlag.length; i++)

                    if (eingabe.equals("" + i)) {
                        toBuy = vorschlag[i];
                        if (!betragAusgewählt) {
                            System.out.println(KopfbereichEins(toSell,toBuy));
                        } else if (betragAusgewählt){

                            sdrWert = SDRWert(toSell,toBuy);

                            umgerechneterBetrag = Umrechner(sdrWert, eingegebenerWert);

                            System.out.println(KopfbereichZwei(toSell,toBuy,eingegebenerWert,umgerechneterBetrag));
                        }
                    }

                System.out.println(auswahlStart + "\n\n" + exitStart);



            } else if (eingabe.equals("1")) {

                if (!betragAusgewählt) {
                    System.out.println(KopfbereichEins(toSell,toBuy) + "\n" + auswahlStart + "\n\n\n" + exitStart + "\n" + auswahl);
                } else if (betragAusgewählt) {
                    System.out.println(KopfbereichZwei(toSell,toBuy,eingegebenerWert,umgerechneterBetrag)+"\n"+auswahlStart+"\n\n"+exitStart+"\n"+auswahl);
                }
                String [] vorschlag = new String [laengeArrayAuswahl];

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
                        if (!betragAusgewählt) {
                            System.out.println(KopfbereichEins(toSell,toBuy));
                        } else if (betragAusgewählt){

                            sdrWert = SDRWert(toSell,toBuy);

                            umgerechneterBetrag = Umrechner(sdrWert, eingegebenerWert);

                            System.out.println(KopfbereichZwei(toSell,toBuy,eingegebenerWert,umgerechneterBetrag));
                        }
                    }

                System.out.println(auswahlStart + "\n\n" + exitStart);

            } else if (eingabe.equals("2")) {

                betragAusgewählt = true;

                System.out.println(auswahl2);

                eingegebenerWert = scannerEingabe.nextDouble();

                sdrWert = SDRWert(toSell, toBuy);
                umgerechneterBetrag = Umrechner(sdrWert, eingegebenerWert);

                System.out.println(KopfbereichZwei(toSell,toBuy,eingegebenerWert,umgerechneterBetrag)+"\n"+auswahlStart+"\n\n"+exitStart);

            } else if (eingabe.equals("x")) {

                break;

            } else {
                System.out.println("ungültige Eingabe!");
                scannerEingabe.next();
            }

        }

    }
    // Methoden

    /**
     * Methode Umrechner: rechnet den von Benutzer eingegebenen Geldbetrag, mithilfe des
     * SDR Wertes in die gewünschte Währung um.
     * Dazu wird der vom Benutzer eingegebene Wert, sowie die SDR-Werte von der
     * toBuy-Währung und der toSell-Währung übergeben.
     * @param wert SDR-Werte der Währungen
     * @param geldbetrag vom Benutzer eingegebener Betrag zum umrechnen
     * @return umgerechneter Betrag
     */
    private static double Umrechner(String [] wert, double geldbetrag) {
        //Umwandlung des SDR-Wertes aus einem StringArray in eine Variable vom Typ double
        Double rateBuy = Double.valueOf(wert[1]);
        Double rateSell = Double.valueOf(wert[0]);
        /*Der umzurechnende Geldbetrag wird durch den SDR-Wert der toBuy Währung dividiert
          und in einer Doublevariable sdr zwischengespeichert
         */
        double sdr = geldbetrag/rateBuy;
        /*Der zwischengespeicherte SDR-Betrag wird mit dem SDR-Wert der toSell Währung multipliziert
          und in eine Doublevariable umgerechneter Betrag gespeichert, diese anschließend von der Methode
          zurückgegeben wird.
         */
        double umgerechneterBetrag = sdr*rateSell;
        umgerechneterBetrag = Math.round(umgerechneterBetrag *100); //Auf 2 Nachkommastellen runden (Zwischenlösung)1
        umgerechneterBetrag /= 100;
        return umgerechneterBetrag;
    }

    /**
     * Methode KopfbereichEins: Methode zur Ausgabe des Kopfbereich, solange noch kein Betrag
     * zum Umrechnen eingegeben wurde.
     * @param toSell Währung des Landes
     * @param toBuy Währung des Landes
     * @returnAusgabe des Kopfbereichs
     */
    private static String KopfbereichEins (String toSell, String toBuy){
        String s = "Currency to buy: " + toBuy + "\nCurrency to sell: " + toSell +
                    "\n++++++++++++++++++++++++++++++++++";
        return s;
    }


    /**
     * Methode KopfbereichZwei: Methode zur Ausgabe des Kopfbereich, nachdem bereits ein Betrag
     * zum Umrechnen eingegeben wurde.
     * @param toSell Währung des Landes
     * @param toBuy Währung des Landes
     * @param umzurechnenderWert eingegebener Wert des Benutzers, der umgerechnet werden soll
     * @param umgerechneterWert
     * @return Ausgabe des Kopfbereichs
     */
    private static String KopfbereichZwei (String toSell, String toBuy, double umzurechnenderWert, double umgerechneterWert){
        String s = "Buying: " + umzurechnenderWert + " " + toBuy + "\n" +
                    "Selling: " + umgerechneterWert + " " + toSell +
                    "\n++++++++++++++++++++++++++++++++++";
        return s;
    }

    /**
     * Methode SDRWert: Methode zur Auslesen des SDR-Wertes für die jeweilige Währung des Landes
     * @param toSell Währung des Landes
     * @param toBuy Währung des Landes
     * @return SDR-Werte der jeweiligen Währung von toSell und toBuy
     */
    private static String[] SDRWert (String toSell, String toBuy){
        String [] wert = new String [2];
        for (int i = 0 ; i < 50 ; i++){
            String zwischenspeicher = currencylist.get(i).getName();
            if(zwischenspeicher.contains(toSell)){
                wert [0]= currencylist.get(i).getRate();
            } else if (zwischenspeicher.contains(toBuy)){
                wert[1]=currencylist.get(i).getRate();
            } else {
                System.out.println("ungültige Eingabe");
            }
        }
        return wert;
    }

    /**
     * Methode MöglichkeitenAuswahl: Auslesen der Arrayliste, welche Währungen mit der Eingabe des Benutzers
     * teilweise oder ganz übereinstimmen.
     * @param eingabe übergibt die Benutzereingabe
     * @return Array vorschlag, der die Auswahl der Länder enthält
     */
    private static String[] MöglichkeitenAuswahl (String eingabe){
        int zähler = 0;
        String [] vorschlag = new String [50];
        for(int i = 0 ; i < vorschlag.length ; i++){
            String zwischenspeicher = currencylist.get(i).getName();
            String ausgabe = zwischenspeicher;
            if(zwischenspeicher.toLowerCase().contains(eingabe.toLowerCase())){
                vorschlag [zähler] = ausgabe;

                zähler++;
            }

        }
        laengeArrayAuswahl = zähler;
        return vorschlag;
    }

    private static boolean EingabeKorrekt (String eingabe){
        boolean test = true;

        for(int i = 0 ; i < 50 ; i++){
            String zwischenspeicher = currencylist.get(i).getName();
            if(zwischenspeicher.toLowerCase().contains(eingabe.toLowerCase())){
                return test = true;
            } else if(!zwischenspeicher.toLowerCase().contains(eingabe.toLowerCase())){
                test = false;
            }

        }

        return test;
    }
}
