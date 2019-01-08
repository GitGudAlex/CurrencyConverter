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

        System.out.println(top+"\n"+auswahlStart+"\n\n\n"+exitStart);

        Scanner eingabe = new Scanner(System.in);

        while (eingabe.hasNext()&& auswahlGesetzt==false) {
            String e = eingabe.next();

            if (e.equals("0")) {
                auswahlGesetzt = true;

                System.out.println(top+"\n"+auswahlStart+"\n\n\n"+exitStart+"\n"+auswahl);

                e = eingabe.next();

                int j = 0;
                String[] vorschlag = new String[50];
                for(int i = 0; i<50; i++){

                    String a = currencylist.get(i).getName();

                    if (a.contains(e)) {
                        vorschlag [j] = a;
                        System.out.println(j + ": " + vorschlag[j]);
                        j++;

                    }
                }
                e = eingabe.next();

                for(int i = 0; i<vorschlag.length; i++)

                    if(e.equals(""+i)){
                        System.out.println("Depp");
                    }

            } else if (e.equals("1")) {
                auswahlGesetzt = true;

            } else if (e.equals("2")) {
                auswahlGesetzt = true;

            } else if (e.equals("x")) {
                auswahlGesetzt = true;

            } else {
                System.out.println("ungültige Eingabe!");
                eingabe.next();
            }
        }


    }


    private static double Umrechner (String buy, String sell){
        return 1.2;
    }
}
