package project;

public class KopfBereich {


    /**
     * Methode KopfbereichEins: Methode zur Ausgabe des Kopfbereich, solange noch kein Betrag
     * zum Umrechnen eingegeben wurde.
     *
     * @param toSell Währung des Landes
     * @param toBuy  Währung des Landes
     * @returnAusgabe des Kopfbereichs
     */
    public static String KopfbereichEins(String toSell, String toBuy) {

        return "Currency to buy: " + toBuy + "\nCurrency to sell: " + toSell +
                "\n++++++++++++++++++++++++++++++++++";
    }

    /**
     * Methode KopfbereichZwei: Methode zur Ausgabe des Kopfbereich, nachdem bereits ein Betrag
     * zum Umrechnen eingegeben wurde.
     *
     * @param toSell             Währung des Landes
     * @param toBuy              Währung des Landes
     * @param umzurechnenderWert eingegebener Wert des Benutzers, der umgerechnet werden soll
     * @param umgerechneterWert
     * @return Ausgabe des Kopfbereichs
     */
    public static String KopfbereichZwei(String toSell, String toBuy, double umzurechnenderWert, double umgerechneterWert) {

        return  "Buying: " + umzurechnenderWert + " " + toBuy + "\n" +
                "Selling: " + umgerechneterWert + " " + toSell +
                "\n++++++++++++++++++++++++++++++++++";
    }


}
