package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    //Test
    // Folgende UnitTests fehlen noch: Länderauswahl, Main auch?
    //Fehler bei Rechner. Wenn kein Wert eingegeben wird, sondern Buchstaben = Error NumberFormatException
    //Nach falscher Eingabe bei Laender Auswahl -> Programm springt an Anfang
    //Bei zweitem Durchlauf obiger Fehler = NullPointerException


    //Variablendeklaration public
    public static ArrayList<Currency> currencylist = new ArrayList<>();
    public static int laengeArrayAuswahl = 0;
    public static Scanner scannerEingabe = new Scanner(System.in);

    public static final String exitStart = "Please choose an option (>>x<< to exit)";
    public static final String auswahlStart = "0: Select currency to buy: \n1: Select currency to sell: \n2: Choose amount to be converted:";
    public static final String auswahl2 = "Enter an amount:";

    public static boolean betragAusgewählt = false; //gibt an ob Betrag (Auswahl 2) ausgewählt und gesetzt worden ist
    public static boolean auswahlGesetzt = false; //gibt an ob eine Auswahl ausgewählt wurde
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

        //ArrayList currencylist wird mit Daten aus anderer Datei gefüllt
        currencyListeFüllen();

        System.out.println(KopfBereich.KopfbereichEins(toSell, toBuy) + "\n" + auswahlStart + "\n\n\n" + exitStart);

        label:
        while (scannerEingabe.hasNext() || !auswahlGesetzt) {
            eingabe = scannerEingabe.next();
            auswahlGesetzt = true;

                switch (eingabe) {

                    case "0":
                        //currency wird für to buy ausgewählt
                        toBuy = Auswahl.Laenderauswahl(toSell, toBuy, betragAusgewählt, eingegebenerWert, umgerechneterBetrag, eingabe);
                        break;

                    case "1":
                        //currency wird für to sell ausgewählt
                        toSell = Auswahl.Laenderauswahl(toSell, toBuy, betragAusgewählt, eingegebenerWert, umgerechneterBetrag, eingabe);
                        break;

                    case "2":
                        if (toBuy.equals("not set") || toSell.equals("not set")) {
                            System.out.println("Please select a currency");
                        } else {
                            System.out.println(auswahl2);
                            eingabe = scannerEingabe.next();

                            do {
                                betragAusgewählt = true;
                                eingegebenerWert = Math.round(Rechner.PunktKomma(eingabe) * 100);
                                eingegebenerWert /= 100;
                                if (eingegebenerWert < 0) {
                                    betragAusgewählt = false;
                                    System.out.println("please enter a positiv amount");
                                    eingabe = scannerEingabe.next();
                                }
                            } while (betragAusgewählt == false);

                            umgerechneterBetrag = Rechner.BlockZwei(toSell, toBuy, eingegebenerWert);
                        }
                        break;

                    case "x":
                        break label;

                    default:
                        System.out.println("invalid input. Please select a currency.");
                        auswahlGesetzt = false;
                        break;
                }

             }

        }

    /**
     * Füllt die currency-Liste
     */
    public static void currencyListeFüllen (){
        String zwischenspeicher;

        // Integervariablen
        int listenNummer = 0;

        // Dateifile der Datei currencies.csv, die die SDR Werte enthält
        File file = new File("currencies.csv");


        try {
            // Deklaration Scanner, der Inhalt aus Datei ließt
            Scanner s = new Scanner(file);

            //wird ausgeführt, solange der Scanner in der Datei noch Inhalt findet
            while (s.hasNext()) {
                zwischenspeicher = s.nextLine();
                //Name der Currency wird in [0] und SDR-Wert in [1] gespeichert
                String[] p = zwischenspeicher.split(":");
                //Überprüfung ob Currency "korrekten" SDR-Wert hat
                korrekterZahlenwert = Currency.korrekterSDRWert(p[1]);
                //wird ausgeführt, falls Currency "korrekten" SDR-Wert hat
                if (korrekterZahlenwert) {
                    //neues Currency-Objekt wird erstellt
                    Currency neuesObjekt = new Currency(p[0], p[1]);
                    //Objekt wird Currency-Liste hinzugefügt
                    currencylist.add(listenNummer, neuesObjekt);
                    listenNummer++;
                }
            }
        } catch (FileNotFoundException e) {
            //Falls keine Datei gefunden wird:
            System.out.println("Datei nicht gefunden");
            e.printStackTrace();
        }
    }
}
