package project;

import java.util.Scanner;

public class Auswahl {


    public static String Laenderauswahl(String toSell, String toBuy, boolean betragAusgewaehlt, double eingegebenerWert, double umgerechneterBetrag, String eingabe) {
        String kopfbereich = "";
        String[] sdrWert;
        String[] toSellAndToBuy = new String[2];
        final String auswahlStart = "0: Select currency to buy: \n1: Select currency to sell: \n2: Choose amount to be converted:";
        final String exitStart = "Please choose an option (>>x<< to exit)";
        final String auswahl = "Enter a currency´s name or part of it (>>xxx<< to exit):";
        final String select = "Select a currency by index:";
        String eingabeAuswahl;

        Scanner scannerEingabe = new Scanner(System.in);

        eingabeAuswahl = eingabe;
        if (!betragAusgewaehlt) {
            kopfbereich = KopfBereich.KopfbereichEins(toSell, toBuy);

        } else if (betragAusgewaehlt) {
            kopfbereich = KopfBereich.KopfbereichZwei(toSell, toBuy, eingegebenerWert, umgerechneterBetrag);
        }

        System.out.println(kopfbereich + "\n" + auswahlStart + "\n\n" + exitStart + "\n" + auswahl);

        eingabe = scannerEingabe.next();


        while (!Helper.EingabeKorrekt(eingabe)) {
            System.out.println("currency does not exist. Please try again");
            eingabe = scannerEingabe.next();
        }

        if (!eingabe.equals("xxx")) {
            MöglichkeitenAuswahl(eingabe);
            String[] vorschlag = new String[Main.laengeArrayAuswahl];


            if (vorschlag.length > 1) {
                System.out.println(kopfbereich);
                for (int i = 0; i < vorschlag.length; i++) {
                    vorschlag[i] = MöglichkeitenAuswahl(eingabe)[i];

                    System.out.println(i + ":" + vorschlag[i]);
                }

                System.out.println("\n" + select);

                eingabe = scannerEingabe.next();

            } else {
                vorschlag[0] = MöglichkeitenAuswahl(eingabe)[0];
                eingabe = "0";
            }







        }
        if (!betragAusgewaehlt) {
            System.out.println(KopfBereich.KopfbereichEins(toSell, toBuy));
        } else if (betragAusgewaehlt){

            sdrWert = Rechner.SDRWert(toSell, toBuy);

            umgerechneterBetrag = Rechner.Umrechner(sdrWert, eingegebenerWert);

            System.out.println(KopfBereich.KopfbereichZwei(toSell, toBuy, eingegebenerWert, umgerechneterBetrag));
        }

        System.out.println(auswahlStart + "\n\n" + exitStart);

        if (eingabeAuswahl.equals("0")) {
            return toBuy;
        } else {
            return toSell;
        }
    }

    /**
     * Methode MöglichkeitenAuswahl: Auslesen der Arrayliste, welche Währungen mit der Eingabe des Benutzers
     * teilweise oder ganz übereinstimmen.
     *
     * @param eingabe übergibt die Benutzereingabe
     * @return Array vorschlag, der die Auswahl der Länder enthält
     */
    public static String[] MöglichkeitenAuswahl(String eingabe) {

        int zaehler = 0;
        String[] vorschlag = new String[Main.currencylist.size()];
        for (int i = 0; i < vorschlag.length; i++) {
            String zwischenspeicher = Main.currencylist.get(i).getName();
            String ausgabe = zwischenspeicher;
            if (zwischenspeicher.toLowerCase().contains(eingabe.toLowerCase())) {
                vorschlag[zaehler] = ausgabe;

                zaehler++;
            }

        }
        Main.laengeArrayAuswahl = zaehler;
        return vorschlag;
    }

    public static String ausgewaehlt (String eingabe, String [] vorschlag, String eingabeAuswahl){
        String [] s = new String [2];
        for (int i = 0; i < vorschlag.length; i++){

            if (eingabe.equals("" + i)) {
                if (eingabeAuswahl.equals("0")) {
                    return s[0] = vorschlag[i];
                } else if (eingabeAuswahl.equals("1")) {
                    return s[1] = vorschlag[i];
                }
            }
        }
        if (eingabe.equals("xxx")){
            return "not set";
        }

        return "not set";
    }
}
