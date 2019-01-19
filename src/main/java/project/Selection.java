package project;

public class Selection {

    /**
     * Auswahl der Währungen wird ausgegeben und weitere Eingabe zur Eingabe für Währung gespeichert und in toBuy/toSell abgespeichert.
     * Außerdem wird, wenn 2 zum zweiten Mal ausgewählt, Betrag neu berechnet.
     * @param toSell bisheriger Wert von toSell
     * @param toBuy bisheriger Wert von toBuy
     * @param selectedAmount gibt an ob Betrag (Selection 2) ausgewählt und gesetzt worden ist
     * @param enteredAmount eingegebener Umrechnungswert
     * @param convertedAmount umgerechneter Wert
     * @param input übergibt Eingabe (0, 1, oder 2). Wird in inputSelection gespeichert
     * @return Wert für toBuy/toSell, je nachdem, welche Option (1 oder 2) gewählt worden ist
     */
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
                    //Wenn xxx eingegeben, while-Schleife abbrechen
                    if(input.equals("xxx")) break;
                    try{
                        int inputInt = Integer.valueOf(input);
                        //Falls eingegebene Zahl kleiner als null oder größer als Auswahl. Warnung wird geschrieben und while-Schleife wiederholt
                        if (inputInt > counter || inputInt < 0) {
                            running = false;
                            System.out.println("Please enter a valid number.");
                        }
                    //Falls Buchstaben eingegeben werden, wird der Fehler abgefangen und die while-Schleife wiederholt
                    }catch (NumberFormatException e){
                        System.out.println("Please enter a valid number.");
                        running = false;
                    }

                    try {
                        // Wenn kein Betrag ausgewählt wurde und Auswahl der Währung korrekt war, wird der "header1" ausgegeben
                        if (!selectedAmount&&running) {
                            System.out.println(Header.headerOne(toSell, toBuy));

                        } else if (selectedAmount) {//Wenn ein Betrag ausgewählt wurde
                            //Aufrufen der Methode die SDRWerte der Währungen zurückgibt
                            sdrValue = Helper.sdrValue(toSell, toBuy);
                            //Aufrufen der Methode, die den eingegebenen Betrag umrechnet und zurückgibt
                            convertedAmount = Helper.converter(sdrValue, enteredAmount);
                            //Ausgabe "header2"
                            System.out.println(Header.headerTwo(toSell, toBuy, enteredAmount, convertedAmount));
                            running=true;
                        }else if(!running){//Wenn bei der Auswahl der Währung falsche/keine Zahl eingegeben wurde, erneut scannen der Benutzereingabe
                            input= Input.getInput();
                        }

                    }catch (NullPointerException e) { //Abfangen der Fehlermeldung, wenn bei der Auswahl der Währungen eine falsche Eingabe stattfindet und toBuy/toSell ungleich "not set" sind
                        running = false;
                        //Scannen der Benutzereingabe
                        input = Input.getInput();
                    }
            }
        }

        if(input.equals("xxx")){
            if(!selectedAmount){
                System.out.println(Header.headerOne(toSell, toBuy));
            }else{
                System.out.println(Header.headerTwo(toSell,toBuy,enteredAmount,convertedAmount));
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
            // Überprüfen ob "cache" in Eingabe enthalten ist, wenn ja, abspeichern in Array "suggestion"
            if (cache.toLowerCase().contains(input.toLowerCase())) {
                suggestion[counter] = output;
                counter++;
            }
        }
        Main.lengthArraySelection = counter;
        //Rückgabe der Vorschläge der möglichen Währungen
        return suggestion;
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
