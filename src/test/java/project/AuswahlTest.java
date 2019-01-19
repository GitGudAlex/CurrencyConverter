package project;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;


public class AuswahlTest {

    /**
     * Aufruf Methode currencyListeFüllen(): Die Daten (Währungen und SDR Werte),
     * werden aus der Datei ausgelesen und in eine ArrayListe geschrieben.
     */
    @Before
    public void initialisieren (){
        Main.currencyListeFüllen();
    }

    /**
     * UnitTest der Methode Länderauswahl(), die bei der Auswahl der Option 0 oder 1 aufgerufen wird um eine
     * Währung für toBuy oder toSell festzulegen.
     * Der Test findet mit einer vorausgesetzen Scannereingabe statt.
     */
    @Test
     public void laenderauswahl() {

        String inputEuro = "euro";
        String inputDol = "dol";
        String inputNull = "0";

        InputStream inEuro = new ByteArrayInputStream(inputEuro.getBytes());

        System.setIn(inEuro);
        Assert.assertEquals("Euro", Auswahl.Laenderauswahl("Australian dollar", "U.S. dollar", true, 3.0,3.96, "0" ));
   }

    /**
     * UnitTest der Methode Ausgewählt(), bei der die Auswahl einer Währung aus der ausgegebenen Liste
     * (von MöglichkeitenAuswahl) stattfindet.
     */
    @Test
    public void ausgewaehlt () {
        String [] vorschlagEuro = {"Euro"};
        String [] vorschlagDol = {"U.S. dollar", "Australian dollar", "Brunei dollar", "Canadian dollar", "New Zealand dollar", "Singapore dollar", "Trinidadian dollar"};
        String [] vorschlagPeso = {"Chilean peso", "Mexican peso", "Philippine peso", "Uruguayan peso"};
        Assert.assertEquals("not set", Auswahl.ausgewaehlt("xxx", vorschlagEuro, "0", "not set", "not set"));
        Assert.assertEquals("not set", Auswahl.ausgewaehlt("xxx", vorschlagDol, "0", "not set", "not set"));
        Assert.assertEquals("not set", Auswahl.ausgewaehlt("xxx", vorschlagDol, "1", "not set", "not set"));
        Assert.assertEquals("Australian dollar", Auswahl.ausgewaehlt("1", vorschlagDol, "0", "not set", "not set"));
        Assert.assertEquals("Singapore dollar", Auswahl.ausgewaehlt("5", vorschlagDol, "0", "not set", "not set"));
        Assert.assertEquals("Chilean peso", Auswahl.ausgewaehlt("0", vorschlagPeso, "0", "Euro", "U.S. dollar"));
        Assert.assertEquals("Chilean peso", Auswahl.ausgewaehlt("0", vorschlagPeso, "1", "New Zealand dollar", "Trinidadian dollar"));

    }
}