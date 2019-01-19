package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
     //Variablendeklaration public
    public static ArrayList<Currency> currencylist = new ArrayList<>();
    public static int lengthArraySelection = 0;

    public static final String exitStart = "Please choose an option (>>x<< to exit)";
    public static final String selectionStart = "0: Select currency to buy: \n1: Select currency to sell: \n2: Choose amount to be converted:";
    public static final String selection2 = "Enter an amount:";

    public static boolean selectedAmount = false; //gibt an ob Betrag (Selection 2) ausgewählt und gesetzt worden ist
    public static boolean selected = false; //gibt an ob eine Selection ausgewählt wurde
    public static boolean correctNumber;


    public static void main(String[] args) {

        // Variablendeklaration
        // Strings
        String toBuy = "not set";
        String toSell = "not set";
        String input;
        boolean running = true;

        // Doublevariablen
        double convertedAmount = 0;
        double enteredAmount = 0;

        //ArrayList currencylist wird mit Daten aus anderer Datei gefüllt
        fillCurrencyList();

        System.out.println(Header.headerOne(toSell, toBuy) + "\n" + selectionStart + "\n\n\n" + exitStart);


        while (running || !selected) {
            input = Input.getInput();
            selected = true;

                switch (input) {
                    case "0":
                        //currency wird für to buy ausgewählt
                        toBuy = Selection.currency(toSell, toBuy, selectedAmount, enteredAmount, convertedAmount, input);
                        break;

                    case "1":
                        //currency wird für to sell ausgewählt
                        toSell = Selection.currency(toSell, toBuy, selectedAmount, enteredAmount, convertedAmount, input);
                        break;

                    case "2":
                        if (toBuy.equals("not set") || toSell.equals("not set")) {
                            System.out.println("Please select a currency");
                        } else {
                            System.out.println(selection2);
                            input = Input.getInput();

                            do {
                                selectedAmount = true;
                                enteredAmount = Math.round(Helper.replace(input) * 100);
                                enteredAmount /= 100;
                                if (enteredAmount < 0) {
                                    selectedAmount = false;
                                    System.out.println("please enter a positiv amount");
                                    input = Input.getInput();
                                }
                            } while (selectedAmount == false);

                            convertedAmount = Helper.selectionTwo(toSell, toBuy, enteredAmount);
                        }
                        break;

                    case "x":
                        running=false;
                        break;

                    default:
                        System.out.println("invalid Input. Please select a currency.");
                        selected = false;
                        break;
                }

             }

        }

    /**
     * Füllt die currency-Liste
     */
    public static void fillCurrencyList(){
        String cache;

        // Integervariablen
        int listNumber = 0;

        // Dateifile der Datei currencies.csv, die die SDR Werte enthält
        File file = new File("currencies.csv");


        try {
            // Deklaration Scanner, der Inhalt aus Datei ließt
            Scanner s = new Scanner(file);

            //wird ausgeführt, solange der Scanner in der Datei noch Inhalt findet
            while (s.hasNext()) {
                cache = s.nextLine();
                //Name der currency wird in [0] und SDR-Wert in [1] gespeichert
                String[] p = cache.split(":");
                //Überprüfung ob currency "korrekten" SDR-Wert hat
                correctNumber = Currency.correctSDRValue(p[1]);
                //wird ausgeführt, falls currency "korrekten" SDR-Wert hat
                if (correctNumber) {
                    //neues currency-Objekt wird erstellt
                    Currency neuesObjekt = new Currency(p[0], p[1]);
                    //Objekt wird currency-Liste hinzugefügt
                    currencylist.add(listNumber, neuesObjekt);
                    listNumber++;
                }
            }
        } catch (FileNotFoundException e) {
            //Falls keine Datei gefunden wird:
            System.out.println("Datei nicht gefunden");
            e.printStackTrace();
        }
    }
}
