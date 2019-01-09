package project;

import javax.xml.stream.events.EndDocument;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        String toBuy = "not set";
        String toSell = "not set";
        String sternchen = "++++++++++++++++++++++++++++";
        String top = "Currency to buy: " + toBuy + "\nCurrency to sell: " + toSell + "\n" + sternchen;
        String exitStart = "Please choose an option (>>x<< to exit)";
        String auswahlStart = "0: Select currency to buy: \n1: Select currency to sell: \n2: Choose amount to be converted:";
        String auswahl = "Enter a currency´s name or part of it (>>xxx<< to exit):";
        String select = "Select a currency by index:";
        String auswahl2 = "Enter an amount:";
        String c;
        String a = "";
        String f = "";
        String h = "";

        int b = 0;
        int j = 0;
        int m = 0;

        boolean zweiAusgewählt = false;
        boolean auswahlGesetzt = false;

        double umgerechneterBetrag = 0;
        double wert = 0;


        File file = new File("currencies.csv");


        ArrayList<Currency> currencylist = new ArrayList<>();

        try {
            Scanner s = new Scanner(file);
            while (s.hasNext()) {

                c = s.nextLine();
                String p[] = c.split(":");
                Currency neu = new Currency(p[0], p[1]);
                currencylist.add(b, neu);
                //System.out.println(currencylist.get(b).getRate());
                b++;


            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(top + "\n" + auswahlStart + "\n\n\n" + exitStart);

        Scanner eingabe = new Scanner(System.in);

        while (eingabe.hasNext() && auswahlGesetzt == false) {
            String e = eingabe.next();

            if (e.equals("0")) {

                if (zweiAusgewählt==false) {
                    System.out.println("Currency to buy: " + toBuy + "\nCurrency to sell: " + toSell + "\n" + sternchen + "\n" + auswahlStart + "\n\n\n" + exitStart + "\n" + auswahl);
                } else if (zweiAusgewählt == true) {
                    System.out.println("Buying "+wert+" of "+toBuy);
                    System.out.println("Selling "+umgerechneterBetrag+" of "+toSell);
                    System.out.println(sternchen+"\n"+auswahlStart+"\n\n"+exitStart+"\n"+auswahl);
                }

                e = eingabe.next();

                j = 0;
                String[] vorschlag = new String[50];
                for (int i = 0; i < 50; i++) {

                    a = currencylist.get(i).getName();

                    if (a.contains(e)) {
                        vorschlag[j] = a;
                        System.out.println(j + ": " + vorschlag[j]);
                        j++;

                    }
                }

                System.out.println("\n" + select);
                e = eingabe.next();

                for (int i = 0; i < vorschlag.length; i++)

                    if (e.equals("" + i)) {
                        toBuy = vorschlag[i];
                        if (zweiAusgewählt == false) {
                            System.out.println("Currency to buy: " + toBuy + "\nCurrency to sell: " + toSell + "\n++++++++++++++++++++++++++++");
                        } else if (zweiAusgewählt == true){

                            for (i = 0; i < 50; i++) {

                                a = currencylist.get(i).getName();

                                if (a.contains(toBuy)) {
                                    vorschlag[j] = a;
                                    f = currencylist.get(i).getRate();
                                } else if (a.contains(toSell)){
                                    vorschlag[m] = a;
                                    h = currencylist.get(i).getRate();
                                }
                            }

                            umgerechneterBetrag = Umrechner(f, h, wert);

                            System.out.println("Buying "+wert+" of "+toBuy);
                            System.out.println("Selling "+umgerechneterBetrag+" of "+toSell);
                        }
                    }

                System.out.println(auswahlStart + "\n\n" + exitStart);



            } else if (e.equals("1")) {

                if (zweiAusgewählt==false) {
                    System.out.println("Currency to buy: " + toBuy + "\nCurrency to sell: " + toSell + "\n" + sternchen + "\n" + auswahlStart + "\n\n\n" + exitStart + "\n" + auswahl);
                } else if (zweiAusgewählt == true) {
                    System.out.println("Buying "+wert+" of "+toBuy);
                    System.out.println("Selling "+umgerechneterBetrag+" of "+toSell);
                    System.out.println(sternchen+"\n"+auswahlStart+"\n\n"+exitStart+"\n"+auswahl);
                }


                e = eingabe.next();

                j = 0;
                String[] vorschlag = new String[50];
                for (int i = 0; i < 50; i++) {

                    a = currencylist.get(i).getName();

                    if (a.contains(e)) {
                        vorschlag[j] = a;
                        System.out.println(j + ": " + vorschlag[j]);
                        j++;

                    }
                }

                System.out.println("\n" + select);
                e = eingabe.next();

                for (int i = 0; i < vorschlag.length; i++)

                    if (e.equals("" + i)) {
                        toSell = vorschlag[i];

                        System.out.println("Currency to buy: " + toBuy + "\nCurrency to sell: " + toSell + "\n++++++++++++++++++++++++++++");

                    }

                System.out.println(auswahlStart + "\n\n" + exitStart);

            } else if (e.equals("2")) {

                zweiAusgewählt = true;

                System.out.println(auswahl2);

                wert = eingabe.nextDouble();


                f = "";
                h = "";
                String[] vorschlag = new String[50];
                for (int i = 0; i < 50; i++) {

                    a = currencylist.get(i).getName();

                    if (a.contains(toBuy)) {
                        vorschlag[j] = a;
                        f = currencylist.get(i).getRate();
                    } else if (a.contains(toSell)){
                        vorschlag[m] = a;
                        h = currencylist.get(i).getRate();
                    }
                }

                umgerechneterBetrag = Umrechner(f, h, wert);

                System.out.println("Buying "+wert+" of "+toBuy);
                System.out.println("Selling "+umgerechneterBetrag+" of "+toSell);
                System.out.println(sternchen+"\n"+auswahlStart+"\n\n"+exitStart);

            } else if (e.equals("x")) {

                break;

            } else {
                System.out.println("ungültige Eingabe!");
                eingabe.next();
            }

        }

    }

    private static double Umrechner(String buy, String sell, double geldbetrag) {
        Double rateBuy = Double.valueOf(buy);
        Double rateSell = Double.valueOf(sell);
        double sdr = geldbetrag/rateBuy;
        double umgerechneterBetrag = sdr*rateSell;
        return umgerechneterBetrag;
    }
}
