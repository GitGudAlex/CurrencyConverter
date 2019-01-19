package project;

public class Header {


    /**
     * Methode headerOne: Methode zur Ausgabe des Kopfbereich, solange noch kein Betrag
     * zum Umrechnen eingegeben wurde.
     *
     * @param toSell Währung des Landes
     * @param toBuy  Währung des Landes
     * @returnAusgabe des Kopfbereichs
     */
    public static String headerOne(String toSell, String toBuy) {

        return "\n\n\n\nCurrency to buy: " + toBuy + "\nCurrency to sell: " + toSell +
                "\n++++++++++++++++++++++++++++++++++";
    }

    /**
     * Methode headerTwo: Methode zur Ausgabe des Kopfbereich, nachdem bereits ein Betrag
     * zum Umrechnen eingegeben wurde.
     *
     * @param toSell             Währung des Landes
     * @param toBuy              Währung des Landes
     * @param toconvertedValue eingegebener Wert des Benutzers, der umgerechnet werden soll
     * @param convertedValue
     * @return Ausgabe des Kopfbereichs
     */
    public static String headerTwo(String toSell, String toBuy, double toconvertedValue, double convertedValue) {

        return  "\n\n\n\nBuying: " + toconvertedValue + " " + toBuy + "\n" +
                "Selling: " + convertedValue + " " + toSell +
                "\n++++++++++++++++++++++++++++++++++";
    }


}
