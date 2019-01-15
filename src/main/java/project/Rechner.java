package project;

public class Rechner {

    /**
     * Methode Rechner: rechnet den von Benutzer eingegebenen Geldbetrag, mithilfe des
     * SDR Wertes in die gewünschte Währung um.
     * Dazu wird der vom Benutzer eingegebene Wert, sowie die SDR-Werte von der
     * toBuy-Währung und der toSell-Währung übergeben.
     *
     * @param wert       SDR-Werte der Währungen
     * @param geldbetrag vom Benutzer eingegebener Betrag zum umrechnen
     * @return umgerechneter Betrag
     */
    public static double Umrechner(String[] wert, double geldbetrag) {
        //Umwandlung des SDR-Wertes aus einem StringArray in eine Variable vom Typ double
        Double rateBuy = Double.valueOf(wert[1]);
        Double rateSell = Double.valueOf(wert[0]);
        /*Der umzurechnende Geldbetrag wird durch den SDR-Wert der toBuy Währung dividiert
          und in einer Doublevariable sdr zwischengespeichert
         */
        double sdr = geldbetrag / rateBuy;
        /*Der zwischengespeicherte SDR-Betrag wird mit dem SDR-Wert der toSell Währung multipliziert
          und in eine Doublevariable umgerechneter Betrag gespeichert, diese anschließend von der Methode
          zurückgegeben wird.
         */
        double umgerechneterBetrag = sdr * rateSell;
        umgerechneterBetrag = Math.round(umgerechneterBetrag * 100); //Auf 2 Nachkommastellen runden (Zwischenlösung)1
        umgerechneterBetrag /= 100;
        return umgerechneterBetrag;
    }

    /**
     * Methode SDRWert: Methode zur Auslesen des SDR-Wertes für die jeweilige Währung des Landes
     *
     * @param toSell Währung des Landes
     * @param toBuy  Währung des Landes
     * @return SDR-Werte der jeweiligen Währung von toSell und toBuy
     */
    public static String[] SDRWert(String toSell, String toBuy) {
        String[] wert = new String[2];
        for (int i = 0; i < Main.currencylist.size(); i++) {
            String zwischenspeicher = Main.currencylist.get(i).getName();
            if (zwischenspeicher.contains(toSell)) {
                wert[0] = Main.currencylist.get(i).getRate();
            }
            if (zwischenspeicher.contains(toBuy)) {
                wert[1] = Main.currencylist.get(i).getRate();
            }
        }
        return wert;
    }

    public static double BlockZwei (String toSell, String toBuy, double eingegebenerWert){

        String [] sdrWert = Rechner.SDRWert(toSell, toBuy);
        double umgerechneterBetrag = Rechner.Umrechner(sdrWert, eingegebenerWert);

        System.out.println(KopfBereich.KopfbereichZwei(toSell, toBuy, eingegebenerWert, umgerechneterBetrag) + "\n" + Main.auswahlStart + "\n\n" + Main.exitStart);
        return umgerechneterBetrag;
    }

    public static double PunktKomma (String eingabe){
        boolean a = true;
        while (a == true) {
            if (eingabe.contains(",")) {
                eingabe = eingabe.replaceFirst(",", ".");
                a = false;
            }
            try {
                double eingabeDouble = Double.valueOf(eingabe);

                return eingabeDouble;

            } catch (NumberFormatException e) {
                System.out.println("Please enter a value.");
                eingabe = Main.scannerEingabe.next();
            }
        }
        double eingabeDouble = Double.valueOf(eingabe);

        return eingabeDouble;


    }
}
