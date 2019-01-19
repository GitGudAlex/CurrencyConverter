package project;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class CurrencySelection {
    /**
     * Aufruf Methode fillCurrencyList(): Die Daten (Währungen und SDR Werte),
     * werden aus der Datei ausgelesen und in eine ArrayListe geschrieben.
     */
    @Before
    public void initialize (){
        Main.fillCurrencyList();
    }

    /**
     * UnitTest der Methode Länderauswahl(), die bei der Selection der Option 0 oder 1 aufgerufen wird um eine
     * Währung für toBuy oder toSell festzulegen.
     * Der Test findet mit einer vorausgesetzen Scannereingabe statt.
     */
    @Test
    public void currencySelection() {

        String inputEuro = "euro";

        InputStream inEuro = new ByteArrayInputStream(inputEuro.getBytes());

        System.setIn(inEuro);
        Assert.assertEquals("Euro", Selection.currencySelection("Australian dollar", "U.S. dollar", true, 3.0,3.96, "0" ));
    }
}
