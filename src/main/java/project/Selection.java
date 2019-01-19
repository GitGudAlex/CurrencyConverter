package project;

public class Selection {


    public static String currency(String toSell, String toBuy, boolean selectedAmount, double enteredAmount, double convertedAmount, String input) {
        //Variablendeklaration
        String header = "";
        String[] sdrValue;
        boolean running = false;
        int counter = 0;

        final String selectionStart = "0: Select currency to buy: \n1: Select currency to sell: \n2: Choose amount to be converted:";
        final String exitStart = "Please choose an option (>>x<< to exit)";
        final String selection = "Enter a currency´s name or part of it (>>xxx<< to exit):";
        final String select = "Select a currency by index:";
        String inputSelection;
        inputSelection = input;

        //Überprüfen ob bereits ein Betrag eingegeben wurde, um entsprechenden Kopfbereich auszugeben
        if (!selectedAmount) {
            header = Header.headerOne(toSell, toBuy);

        } else if (selectedAmount) {
            header = Header.headerTwo(toSell, toBuy, enteredAmount, convertedAmount);
        }

        System.out.println(header + "\n" + selectionStart + "\n\n" + exitStart + "\n" + selection);
        //Benutzereingabe scannen
        input = Input.getInput();

        //Bei falscher Eingabe erneut Scannen
        while (!Helper.correctInput(input)) {
            System.out.println("currency does not exist. Please try again");
            input = Input.getInput();
        }

        //Solange nicht mit "xxx" abgebrochen wird, wird eine Länderauswahl entsprechend der possibilitySelection Methode ausgegeben
        if (!input.equals("xxx")) {
            possibilitySelection(input);
            String[] suggestion = new String[Main.lengthArraySelection];

            //Wenn es mehr als eine Auswahl gibt, wird der "header" ausgegeben
            if (suggestion.length > 1) {
                System.out.println(header);
                //Die Auswahlmöglichkeiten werden ausgegeben
                for (int i = 0; i < suggestion.length; i++) {
                    suggestion[i] = possibilitySelection(input)[i];
                    counter = i;
                    System.out.println(i + ":" + suggestion[i]);
                }
                //Benutzer wird zur Auswahl aufgefördert
                System.out.println("\n" + select);
                //Scannen der Benutzereingabe
                input = Input.getInput();

            //Wenn es nur eine Auswahl gibt, wird diese direkt ausgewählt
            } else {
                suggestion[0] = possibilitySelection(input)[0];
                input = "0";
            }

            while (!running) {
                running=true;
                //Wenn am Anfang die Option "0" ausgewählt wurde, wird die Währung in toBuy geschrieben
                if (inputSelection.equals("0")) {
                    toBuy = selected(input, suggestion, inputSelection, toSell, toBuy);
                //Wenn am Anfang die Option "1" ausgewählt wurde, wir die Währung in toSell geschrieben
                } else if (inputSelection.equals("1")) {
                    toSell = selected(input, suggestion, inputSelection, toSell, toBuy);
                }

                try{ //Falls bei der Auswahl der Währung eine größere oder kleinere Zahl eingegeben wird, Wiederholung while-Schleife
                    int inputInt = Integer.valueOf(input);
                    if (inputInt > counter || inputInt < 0) {
                        running = false;
                        System.out.println("Please enter a valid number.");
                    }
                }catch (NumberFormatException e){//Falls Buchstaben eingegeben werden, wird der Fehler abgefangen und die while-Schleife wiederholt
                    System.out.println("Please enter a valid number.");
                    running = false;
                }

                try {// Wenn kein Betrag ausgewählt wurde und die Währung in toBuy/toSell geschrieben wurde, wird der "header" ausgegeben
                    if (!selectedAmount&&running) {
                        System.out.println(Header.headerOne(toSell, toBuy));

                    } else if (selectedAmount) {//Wenn ein Betrag ausgewählt wurde

                        sdrValue = Helper.sdrValue(toSell, toBuy); //Aufrufen der Methode die SDRWerte der Währungen zurückgibt

                        convertedAmount = Helper.converter(sdrValue, enteredAmount);//Aufrufen der Methode, die den eingegebenen Betrag umrechnet und zurückgibt

                        System.out.println(Header.headerTwo(toSell, toBuy, enteredAmount, convertedAmount));//Ausgabe "header"
                        running=true;
                    }else if(!running){//Wenn bei der Auswahl der Währung eine zu große oder zu kleine Zahl eingegeben wurde, erneut scannen der Benutzereingabe
                        input= Input.getInput();
                    }

                }catch (NullPointerException e) { //Abfangen der Fehlermeldung, wenn bei der Auswahl der Währungen eine falsche Eingabe stattfindet und toBuy/toSell ungleich "not set" sind
                    running = false;
                    input = Input.getInput(); //Scannen der Benutzereingabe
                }
            }
        }
            System.out.println(selectionStart + "\n\n" + exitStart);
            //Wenn am Anfang Option "0" ausgewählt wurde, wird toBuy zurückgegeben
            if (inputSelection.equals("0")) {
                return toBuy;
            } else {//Wenn am Anfang Option "1" ausgewählt wurde, wird toSell zurückgegeben
                return toSell;
            }
        }


    /**
     * Methode possibilitySelection: Auslesen der Arrayliste, welche Währungen mit dem Input des Benutzers
     * teilweise oder ganz übereinstimmen.
     *
     * @param input übergibt die Benutzereingabe
     * @return Array vorschlag, der die Selection der Länder enthält
     */
    public static String[] possibilitySelection(String input) {

        int counter = 0;
        String[] suggestion = new String[Main.currencylist.size()];

        for (int i = 0; i < suggestion.length; i++) {
            //Auslesen der Währungen aus der Currencyliste, abspeichern im "cache"
            String cache = Main.currencylist.get(i).getName();
            String output = cache;
            if (cache.toLowerCase().contains(input.toLowerCase())) { // Überprüfen ob "cache" in Eingabe enthalten ist, wenn ja abspeichern in Array "suggestion"
                suggestion[counter] = output;
                counter++;
            }
        }
        Main.lengthArraySelection = counter;
        return suggestion; //Rückgabe der Vorschläge der möglichen Währungen
    }

    public static String selected(String input, String [] suggestion, String inputSelection, String toSell, String toBuy){
        // Auswahl aus der Liste der möglichen Währungen
        for (int i = 0; i < suggestion.length; i++){

            if (input.equals("" + i)) {
                return suggestion[i]; //zurückgeben der ausgewählten Währung
            }
        }
        if (input.equals("xxx")){ // Bei Eingabe von "xxx" (ein Schritt zurück) und anfänglicher Auswahl der Option "0", wird toBuy zurückgegeben
            if(inputSelection.equals("0")){
                return toBuy;
            } else if (inputSelection.equals("1")){ // Bei Eingabe von "xxx" (ein Schritt zurück) und anfänglicher Auswahl der Option "1", wird toSell zurückgegeben
                return toSell;
            }
        }

        return "not set"; //Ansonsten Rückgabe von "not set"
    }
}
