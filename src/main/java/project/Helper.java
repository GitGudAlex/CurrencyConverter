package project;

public class Helper {

    /**
     * Methode Rechner: rechnet den von Benutzer eingegebenen Geldbetrag, mithilfe des
     * SDR Wertes in die gewünschte Währung um.
     * Dazu wird der vom Benutzer eingegebene Wert, sowie die SDR-Werte von der
     * toBuy-Währung und der toSell-Währung übergeben.
     *
     * @param value       SDR-Werte der Währungen
     * @param amount vom Benutzer eingegebener Betrag zum umrechnen
     * @return umgerechneterBetrag
     */
    public static double converter(String[] value, double amount) {
        //Umwandlung des SDR-Wertes aus einem StringArray in eine Variable vom Typ double
        Double rateBuy = Double.valueOf(value[1]);
        Double rateSell = Double.valueOf(value[0]);
        //Umzurechnender Geldbetrag wird durch SDR-Wert der toBuy Währung dividiert
        double sdr = amount / rateBuy;
        //Zwischengespeicherter SDR-Betrag wird mit SDR-Wert der toSell Währung multipliziert
        double convertedAmount = sdr * rateSell;
        //umgerechneterBetrag wird auf 2 Nachkommastellen gerundet
        convertedAmount = Math.round(convertedAmount * 100);
        convertedAmount /= 100;
        //umgerechneter Betrag wird zurückgegeben
        return convertedAmount;
    }

    /**
     * Methode sdrValue: Methode zur Auslesen des SDR-Wertes für die jeweilige Währung des Landes
     * @param toSell Währung des Landes
     * @param toBuy  Währung des Landes
     * @return wert SDR-Werte der jeweiligen Währung von toSell und toBuy
     */
    public static String[] sdrValue(String toSell, String toBuy) {
        //String array wird deklariert
        String[] value = new String[2];
        //wird ausgeführt, solange i kleiner ist als Länge der currency-Liste
        for (int i = 0; i < Main.currencylist.size(); i++) {
            String cache = Main.currencylist.get(i).getName();
            //falls Name der currency, der ausgewählten toSell-currency entspricht
            if (cache.contains(toSell)) {
                //zugehöriger SDR-Wert wird gespeichert
                value[0] = Main.currencylist.get(i).getRate();
            }
            //falls Name der currency, der ausgewählten toBuy-currency entspricht
            if (cache.contains(toBuy)) {
                //zugehöriger SDR-Wert wird gespeichert
                value[1] = Main.currencylist.get(i).getRate();
            }
        }
        //SDR-Wert von toBuy- und toSell-currency wird zurückgegeben
        return value;
    }

    /**
     * Methode zur Ausführung von Selection 2
     *
     * @param toSell
     * @param toBuy
     * @param enteredAmount
     * @return umgerechneterBetrag
     */
    public static double selectionTwo(String toSell, String toBuy, double enteredAmount) {
        //SDR-Werte werden berechnet
        String[] sdrWert = Helper.sdrValue(toSell, toBuy);
        //SDR-Wert für toSell wird ausgerechnet
        double convertedAmount = Helper.converter(sdrWert, enteredAmount);
        //Kopfbereich wird gebildet und wird zusammen mit Rest ausgegeben
        System.out.println(Header.headerTwo(toSell, toBuy, enteredAmount, convertedAmount) + "\n" + Main.selectionStart + "\n\n" + Main.exitStart);
        //umgerechneterBetrag wird zurückgegeben
        return convertedAmount;
    }

    /**
     * Methode die überprüft ob Punkt oder Komma eingegeben wurde. Falls komma eingegeben wurde wir dies
     * in einen Punkt umgewandelt
     *
     * @param input
     * @return eingabeDouble
     */
    public static double replace(String input) {
        //Deklaration Boolean-Variable
        boolean running = true;
        double inputDouble = 0;
        //wird ausgeführt solange a wahr ist
        while (running) {
            //wenn der eingegebene Wert ein Komma enthält
            if (input.contains(",")) {
                //Komma wird durch Punkt ersetzt
                input = input.replaceFirst(",", ".");
                //a wird auf false gesetzt, damit while-Schleife nicht noch einmal durchläuft
                running = false;
            }
            try {
                //eingegener Wert wird als double gespeichert
                inputDouble = Double.valueOf(input);
                //eingabeDouble wird zurück gegeben
                return inputDouble;
            } catch (NumberFormatException e) {
                //Wenn eingabe nicht in double-Wert gespeichert werden kann, da eingabe keine Zahl
                System.out.println("Please enter a value.");
                //erneute eingabe; While-Schleife wird wiederholt
                input = Input.getInput();
            }
        }
        return inputDouble;
    }

    /**
     *
     * @param input
     * @return
     */
    public static boolean correctInput(String input) {
        boolean test = true;
        //falls "xxx" eingegeben wurde, ist Input korrekt
        if (input.equals("xxx")){
            //gebe true zurück
            return true;
        }
        for (int i = 0; i < Main.currencylist.size(); i++) {
            String cache = Main.currencylist.get(i).getName();
            if (cache.toLowerCase().contains(input.toLowerCase())) {
                return true;
            } else {
                test = false;
            }
        }
        return test;
    }

}
