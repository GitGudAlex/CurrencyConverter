package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String toBuy = "not set";
        String toSell = "not set";
        String top = "Currency to buy: " + toBuy + "\nCurrency to sell: " + toSell + "\n++++++++++++++++++++++++++++";
        String exitStart = "Please choose an option (>>x<< to exit)";
        String auswahlStart = "0: Select currency to buy: \n1: Select currency to sell: \n2: Choose amount to be converted:";
        String auswahl = "Enter a currency´s name or part of it (>>xxx<< to exit):";
        String select = "Select a currency by index:";
        String auswahl2 = "Enter an amount:";
        String c;

        int b = 0;

        boolean zweiAusgewählt = false;
        boolean auswahlGesetzt = false;


        File file = new File("currencies.csv");


        ArrayList<Currency> currencylist = new ArrayList<>();

        System.out.println(top+"\n"+auswahlStart+"\n\n\n"+exitStart);

        Scanner eingabe = new Scanner(System.in);

        while (eingabe.hasNext()) {

            if (eingabe.nextInt()==0) {

            } else if (eingabe.nextInt()==1) {

            } else if (eingabe.nextInt()==2) {

            } else if (eingabe.next()=="x") {

            } else {
                System.out.println("ungültige Eingabe!");
                eingabe.next();
            }
        }

        try {
            Scanner s = new Scanner(file);
            while (s.hasNext()) {

                c = s.nextLine();
                String a[] = c.split(":");
                Currency neu = new Currency (a[0],a[1]);
                currencylist.add(b, neu);
                //System.out.println(currencylist.get(b).getRate());
                b++;


            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static String[] Vorschlaege (String s, ArrayList a){
        String [] b = new String[50];
        return b;
    }

    private static double Umrechner (String buy, String sell){
        return 1.2;
    }
}
