package project;

public class Header {


    /**
     * Methode zur Ausgabe des Kopfbereich, solange noch kein Betrag
     * zum Umrechnen eingegeben wurde.
     *
     * @param toSell Währung des Landes
     * @param toBuy  Währung des Landes
     * @return Ausgabe des Kopfbereichs
     */
    public static String headerOne(String toSell, String toBuy) {

        return "\n\n\n\ncurrency to buy: " + toBuy + "\ncurrency to sell: " + toSell +
                "\n++++++++++++++++++++++++++++++++++";
    }

    /**
     * Methode zur Ausgabe des Kopfbereich, nachdem bereits ein Betrag
     * zum Umrechnen eingegeben wurde.
     *
     * @param toSell Währung des Landes
     * @param toBuy Währung des Landes
     * @param toconvertedValue eingegebener Wert des Benutzers, der umgerechnet werden soll
     * @param convertedValue umgerechneter Wert
     * @return Ausgabe des Kopfbereichs
     */
    public static String headerTwo(String toSell, String toBuy, double toconvertedValue, double convertedValue) {

        return  "\n\n\n\nBuying: " + toconvertedValue + " " + toBuy + "\n" +
                "Selling: " + convertedValue + " " + toSell +
                "\n++++++++++++++++++++++++++++++++++";
    }
}
