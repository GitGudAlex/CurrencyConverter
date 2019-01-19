package project;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;


public class SelectionTest {

    /**
     * Aufruf Methode fillCurrencyList(): Die Daten (Währungen und SDR Werte),
     * werden aus der Datei ausgelesen und in eine ArrayListe geschrieben.
     */
    @Before
    public void initialize (){
        Main.fillCurrencyList();
    }



    /**
     * UnitTest der Methode Ausgewählt(), bei der die Selection einer Währung aus der ausgegebenen Liste
     * (von possibilitySelection) stattfindet.
     */
    @Test
    public void selected() {
        String [] suggestionEuro = {"Euro"};
        String [] suggestionDol = {"U.S. dollar", "Australian dollar", "Brunei dollar", "Canadian dollar", "New Zealand dollar", "Singapore dollar", "Trinidadian dollar"};
        String [] suggestionPeso = {"Chilean peso", "Mexican peso", "Philippine peso", "Uruguayan peso"};
        Assert.assertEquals("not set", Selection.selected("xxx", suggestionEuro, "0", "not set", "not set"));
        Assert.assertEquals("not set", Selection.selected("xxx", suggestionDol, "0", "not set", "not set"));
        Assert.assertEquals("not set", Selection.selected("xxx", suggestionPeso, "1", "not set", "not set"));
        Assert.assertEquals("Australian dollar", Selection.selected("1", suggestionDol, "0", "not set", "not set"));
        Assert.assertEquals("Singapore dollar", Selection.selected("5", suggestionDol, "0", "not set", "not set"));
        Assert.assertEquals("Chilean peso", Selection.selected("0", suggestionPeso, "0", "Euro", "U.S. dollar"));
        Assert.assertEquals("Chilean peso", Selection.selected("0", suggestionPeso, "1", "New Zealand dollar", "Trinidadian dollar"));

    }
}