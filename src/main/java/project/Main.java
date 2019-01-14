package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static ArrayList<Currency> currencylist = new ArrayList<>();
    public static int laengeArrayAuswahl = 0;
    public static Scanner scannerEingabe = new Scanner(System.in);

    public static final String exitStart = "Please choose an option (>>x<< to exit)";
    public static final String auswahlStart = "0: Select currency to buy: \n1: Select currency to sell: \n2: Choose amount to be converted:";
    public static final String auswahl2 = "Enter an amount:";


    public static void main(String[] args) {

        // Variablendeklaration

        // Strings
        String toBuy = "not set";
        String toSell = "not set";
        String eingabe;
        String zwischenspeicherLänder = "";
        String zwischenspeicher;

        // konstante Strings

        // String Array

        String[] sdrWert;

        // Integervariablen
        int listenNummer = 0;

        // boolean
        boolean betragAusgewählt = false;
        boolean auswahlGesetzt = false;
        boolean korrekterZahlenwert;

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
                korrekterZahlenwert=Currency.korrekterSDRWert(p[1]);

                if(korrekterZahlenwert){
                Currency neuesObjekt = new Currency(p[0], p[1]);
                currencylist.add(listenNummer, neuesObjekt);
                listenNummer++;

                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Datei nicht gefunden");
            e.printStackTrace();
        }

        System.out.println(KopfBereich.KopfbereichEins(toSell, toBuy) + "\n" + auswahlStart + "\n\n\n" + exitStart);

        while (scannerEingabe.hasNext() || auswahlGesetzt) {
            eingabe = scannerEingabe.next();
            auswahlGesetzt = false;

            if (eingabe.equals("0")) {
                toBuy = Laenderauswahl(toSell, toBuy, betragAusgewählt, eingegebenerWert, umgerechneterBetrag, eingabe);
            } else if (eingabe.equals("1")) {
                toSell = Laenderauswahl(toSell, toBuy, betragAusgewählt, eingegebenerWert, umgerechneterBetrag, eingabe);

            } else if (eingabe.equals("2")) {

                if (toBuy.equals("not set") || toSell.equals("not set")){
                    System.out.println("Please select a currency");
                } else {
                    betragAusgewählt = true;
                    System.out.println(auswahl2);
                    eingabe = scannerEingabe.next();
                    eingegebenerWert = Math.round(Rechner.PunktKomma(eingabe)*100);
                    eingegebenerWert /= 100;

                    umgerechneterBetrag = Rechner.BlockZwei(toSell, toBuy,eingegebenerWert);
                }


            } else if (eingabe.equals("x")) {

                break;

            } else {
                System.out.println("invalid input. Please selecte a currency");
                auswahlGesetzt = true;
            }

        }

    }
    // Methoden

    /**
     * Methode MöglichkeitenAuswahl: Auslesen der Arrayliste, welche Währungen mit der Eingabe des Benutzers
     * teilweise oder ganz übereinstimmen.
     *
     * @param eingabe übergibt die Benutzereingabe
     * @return Array vorschlag, der die Auswahl der Länder enthält
     */
    private static String[] MöglichkeitenAuswahl(String eingabe) {
        int zaehler = 0;
        String[] vorschlag = new String[currencylist.size()];
        for (int i = 0; i < vorschlag.length; i++) {
            String zwischenspeicher = currencylist.get(i).getName();
            String ausgabe = zwischenspeicher;
            if (zwischenspeicher.toLowerCase().contains(eingabe.toLowerCase())) {
                vorschlag[zaehler] = ausgabe;

                zaehler++;
            }

        }
        laengeArrayAuswahl = zaehler;
        return vorschlag;
    }

    private static boolean EingabeKorrekt(String eingabe) {
        boolean test = true;

        for (int i = 0; i < currencylist.size(); i++) {
            String zwischenspeicher = currencylist.get(i).getName();
            if (zwischenspeicher.toLowerCase().contains(eingabe.toLowerCase())) {
                return test = true;
            } else if (!zwischenspeicher.toLowerCase().contains(eingabe.toLowerCase())) {
                test = false;
            }

        }

        return test;
    }

    private static String Laenderauswahl(String toSell, String toBuy, boolean betragAusgewählt, double eingegebenerWert, double umgerechneterBetrag, String eingabe) {
        String kopfbereich = "";
        String[] sdrWert;
        String[] toSellAndToBuy = new String[2];
        final String auswahlStart = "0: Select currency to buy: \n1: Select currency to sell: \n2: Choose amount to be converted:";
        final String exitStart = "Please choose an option (>>x<< to exit)";
        final String auswahl = "Enter a currency´s name or part of it (>>xxx<< to exit):";
        final String select = "Select a currency by index:";
        String eingabeAuswahl;


        eingabeAuswahl = eingabe;
        if (!betragAusgewählt) {
            kopfbereich = KopfBereich.KopfbereichEins(toSell, toBuy);
        } else if (betragAusgewählt) {
            kopfbereich = KopfBereich.KopfbereichZwei(toSell, toBuy, eingegebenerWert, umgerechneterBetrag);
        }

        System.out.println(kopfbereich + "\n" + auswahlStart + "\n\n" + exitStart + "\n" + auswahl);

        eingabe = scannerEingabe.next();

        while (!EingabeKorrekt(eingabe)) {
            System.out.println("currency does not exist. Please try again");
            eingabe = scannerEingabe.next();
        }


        MöglichkeitenAuswahl(eingabe);
        String[] vorschlag = new String[laengeArrayAuswahl];


        if (vorschlag.length>1) {
            System.out.println(kopfbereich);
            for (int i = 0; i < vorschlag.length; i++) {
                vorschlag[i] = MöglichkeitenAuswahl(eingabe)[i];

                System.out.println(i + ":" + vorschlag[i]);
            }

            System.out.println("\n" + select);

            eingabe = scannerEingabe.next();

        } else {
            vorschlag [0] = MöglichkeitenAuswahl(eingabe)[0];
            eingabe = "0";
        }

        for (int i = 0; i < vorschlag.length; i++){

                if (eingabe.equals("" + i)) {
                    if (eingabeAuswahl.equals("0")) {
                        toBuy = vorschlag[i];
                    } else if (eingabeAuswahl.equals("1")) {
                        toSell = vorschlag[i];
                    }
                    if (!betragAusgewählt) {
                        System.out.println(KopfBereich.KopfbereichEins(toSell, toBuy));
                    } else if (betragAusgewählt) {

                        sdrWert = Rechner.SDRWert(toSell, toBuy);

                        umgerechneterBetrag = Rechner.Umrechner(sdrWert, eingegebenerWert);

                        System.out.println(KopfBereich.KopfbereichZwei(toSell, toBuy, eingegebenerWert, umgerechneterBetrag));
                    }

                }
                }

        System.out.println(auswahlStart + "\n\n" + exitStart);

        if (eingabeAuswahl.equals("0")) {
            return toBuy;
        } else {
            return toSell;
        }
    }
}
