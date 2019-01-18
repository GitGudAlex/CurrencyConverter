package project;

public class Rechner {

    /**
     * Methode Rechner: rechnet den von Benutzer eingegebenen Geldbetrag, mithilfe des
     * SDR Wertes in die gewünschte Währung um.
     * Dazu wird der vom Benutzer eingegebene Wert, sowie die SDR-Werte von der
     * toBuy-Währung und der toSell-Währung übergeben.
     *
     * @param wert SDR-Werte der Währungen
     * @param geldbetrag vom Benutzer eingegebener Betrag zum umrechnen
     * @return umgerechneterBetrag
     */
    public static double Umrechner(String[] wert, double geldbetrag) {
        //Umwandlung des SDR-Wertes aus einem StringArray in eine Variable vom Typ double
        Double rateBuy = Double.valueOf(wert[1]);
        Double rateSell = Double.valueOf(wert[0]);
        //Umzurechnender Geldbetrag wird durch SDR-Wert der toBuy Währung dividiert
        double sdr = geldbetrag / rateBuy;
        //Zwischengespeicherter SDR-Betrag wird mit SDR-Wert der toSell Währung multipliziert
        double umgerechneterBetrag = sdr * rateSell;
        //umgerechneterBetrag wird auf 2 Nachkommastellen gerundet
        umgerechneterBetrag = Math.round(umgerechneterBetrag * 100);
        umgerechneterBetrag /= 100;
        //umgerechneter Betrag wird zurückgegeben
        return umgerechneterBetrag;
    }

    /**
     * Methode SDRWert: Methode zur Auslesen des SDR-Wertes für die jeweilige Währung des Landes
     *
     * @param toSell Währung des Landes
     * @param toBuy  Währung des Landes
     * @return wert SDR-Werte der jeweiligen Währung von toSell und toBuy
     */
    public static String[] SDRWert(String toSell, String toBuy) {
        //String array wird deklariert
        String[] wert = new String[2];
        //wird ausgeführt, solange i kleiner ist als Länge der Currency-Liste
        for (int i = 0; i < Main.currencylist.size(); i++) {
            String zwischenspeicher = Main.currencylist.get(i).getName();
            //falls Name der Currency, der ausgewählten toSell-Currency entspricht
            if (zwischenspeicher.contains(toSell)) {
                //zugehöriger SDR-Wert wird gespeichert
                wert[0] = Main.currencylist.get(i).getRate();
            }
            //falls Name der Currency, der ausgewählten toBuy-Currency entspricht
            if (zwischenspeicher.contains(toBuy)) {
                //zugehöriger SDR-Wert wird gespeichert
                wert[1] = Main.currencylist.get(i).getRate();
            }
        }
        //SDR-Wert von toBuy- und toSell-Currency wird zurückgegeben
        return wert;
    }

    /**
     * Methode zur Ausführung von Auswahl 2
     * @param toSell
     * @param toBuy
     * @param eingegebenerWert
     * @return umgerechneterBetrag
     */
    public static double BlockZwei (String toSell, String toBuy, double eingegebenerWert){
        //SDR-Werte werden berechnet
        String[] sdrWert = Rechner.SDRWert(toSell, toBuy);
        //SDR-Wert für toSell wird ausgerechnet
        double umgerechneterBetrag = Rechner.Umrechner(sdrWert, eingegebenerWert);
        //Kopfbereich wird gebildet und wird zusammen mit Rest ausgegeben
        System.out.println(KopfBereich.KopfbereichZwei(toSell, toBuy, eingegebenerWert, umgerechneterBetrag) + "\n" + Main.auswahlStart + "\n\n" + Main.exitStart);
        //umgerechneterBetrag wird zurückgegeben
        return umgerechneterBetrag;
    }

    /**
     * Methode die überprüft ob Punkt oder Komma eingegeben wurde. Falls komma eingegeben wurde wir dies
     * in einen Punkt umgewandelt
     * @param eingabe
     * @return eingabeDouble
     */
    public static double PunktKomma (String eingabe){
        //Deklaration Boolean-Variable
        boolean a = true;
        double eingabeDouble = 0;
        //wird ausgeführt solange a wahr ist
        while (a == true) {
            //wenn der eingegebene Wert ein Komma enthält
            if (eingabe.contains(",")) {
                //Komma wird durch Punkt ersetzt
                eingabe = eingabe.replaceFirst(",", ".");
                //a wird auf false gesetzt, damit while-Schleife nicht noch einmal durchläuft
                a = false;
            }
            try {
                //eingegener Wert wird als double gespeichert
                eingabeDouble = Double.valueOf(eingabe);
                //eingabeDouble wird zurück gegeben
                return eingabeDouble;
            } catch (NumberFormatException e) {
                //Wenn eingabe nicht in double-Wert gespeichert werden kann, da eingabe keine Zahl
                System.out.println("Please enter a value.");
                //erneute eingabe; While-Schleife wird wiederholt
                eingabe = Main.scannerEingabe.next();
            }
        }
        return eingabeDouble;
    }

    public static double GroßeZahlenRunden (double umgerechneterBetrag){
        if (umgerechneterBetrag >= 10000000) {


        }
        return umgerechneterBetrag;
    }
}
