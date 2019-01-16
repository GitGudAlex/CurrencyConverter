package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    //Test
    //Fehler bei Rechner. Wenn kein Wert eingegeben wird, sondern Buchstaben = Error NumberFormatException

    public static ArrayList<Currency> currencylist = new ArrayList<>();
    public static int laengeArrayAuswahl = 0;
    public static Scanner scannerEingabe = new Scanner(System.in);

    public static final String exitStart = "Please choose an option (>>x<< to exit)";
    public static final String auswahlStart = "0: Select currency to buy: \n1: Select currency to sell: \n2: Choose amount to be converted:";
    public static final String auswahl2 = "Enter an amount:";

    public static boolean betragAusgewählt = false;
    public static boolean auswahlGesetzt = false;
    public static boolean korrekterZahlenwert;


    public static void main(String[] args) {

        // Variablendeklaration

        // Strings
        String toBuy = "not set";
        String toSell = "not set";
        String eingabe;


        // Doublevariablen
        double umgerechneterBetrag = 0;
        double eingegebenerWert = 0;


        currencyListeFüllen();


        System.out.println(KopfBereich.KopfbereichEins(toSell, toBuy) + "\n" + auswahlStart + "\n\n\n" + exitStart);

        label:
        while (scannerEingabe.hasNext() || auswahlGesetzt) {
            eingabe = scannerEingabe.next();
            auswahlGesetzt = false;

            switch (eingabe) {
                case "0":
                    toBuy = Auswahl.Laenderauswahl(toSell, toBuy, betragAusgewählt, eingegebenerWert, umgerechneterBetrag, eingabe);
                    break;
                case "1":
                    toSell = Auswahl.Laenderauswahl(toSell, toBuy, betragAusgewählt, eingegebenerWert, umgerechneterBetrag, eingabe);

                    break;
                case "2":

                    if (toBuy.equals("not set") || toSell.equals("not set")) {
                        System.out.println("Please select a currency");
                    } else {
                        betragAusgewählt = true;
                        System.out.println(auswahl2);
                        eingabe = scannerEingabe.next();
                        eingegebenerWert = Math.round(Rechner.PunktKomma(eingabe) * 100);
                        eingegebenerWert /= 100;
                        eingegebenerWert = Math.abs(eingegebenerWert);

                        umgerechneterBetrag = Rechner.BlockZwei(toSell, toBuy, eingegebenerWert);
                    }


                    break;
                case "x":

                    break label;

                default:
                    System.out.println("invalid input. Please select a currency.");
                    auswahlGesetzt = true;
                    break;
            }

        }

    }

    public static void currencyListeFüllen (){
        String zwischenspeicher;

        // Integervariablen
        int listenNummer = 0;

        // Dateifile der Datei currencies.csv, die die SDR Werte enthält
        File file = new File("currencies.csv");


        try {
            // Deklaration Scanner zur Abfrage der Benutzereingabe um eine Auswahl zu treffen
            Scanner s = new Scanner(file);
            while (s.hasNext()) {
                zwischenspeicher = s.nextLine();
                String[] p = zwischenspeicher.split(":");
                korrekterZahlenwert = Currency.korrekterSDRWert(p[1]);

                if (korrekterZahlenwert) {
                    Currency neuesObjekt = new Currency(p[0], p[1]);
                    currencylist.add(listenNummer, neuesObjekt);
                    listenNummer++;

                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Datei nicht gefunden");
            e.printStackTrace();
        }
    }
}
