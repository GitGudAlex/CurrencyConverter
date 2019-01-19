package project;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;



public class EingabeTest {

    /**
     * UnitTest der Methode getEingabe(), die die nächste Eingabe des Benutzers zurückgibt.
     * Test findet mit festgelegter Benutzereingabe statt.
     */
    @Test
    public void getEingabe(){
        String inputZwei = "2";
        String inputEins = "1";
        String inputNull = "0";
        String inputDollar = "Dollar";
        String inputWert = "3.56";

        InputStream inZwei = new ByteArrayInputStream(inputZwei.getBytes());
        InputStream inEins = new ByteArrayInputStream(inputEins.getBytes());
        InputStream inNull = new ByteArrayInputStream(inputNull.getBytes());
        InputStream inDollar = new ByteArrayInputStream(inputDollar.getBytes());
        InputStream inWert = new ByteArrayInputStream(inputWert.getBytes());

        System.setIn(inZwei);
        Assert.assertEquals("2", Eingabe.getEingabe());

        System.setIn(inEins);
        Assert.assertEquals("1", Eingabe.getEingabe());

        System.setIn(inNull);
        Assert.assertEquals("0", Eingabe.getEingabe());

        System.setIn(inDollar);
        Assert.assertEquals("Dollar",Eingabe.getEingabe() );

        System.setIn(inWert);
        Assert.assertEquals("3.56", Eingabe.getEingabe());
    }

    /**
     * UnitTest der Methode EingabeHasNext(), die überprüft, ob eine Eingabe des Benutzers vorhanden ist.
     * Test findet mit festgelegter Benutzereingabe statt.
     */
    @Test
    public void eingabeHasNext() {
        String inputZwei = "2";
        String inputEins = "1";
        String inputNull = "0";
        String inputDollar = "Dollar";
        String inputWert = "3.56";

        InputStream inZwei = new ByteArrayInputStream(inputZwei.getBytes());
        InputStream inEins = new ByteArrayInputStream(inputEins.getBytes());
        InputStream inNull = new ByteArrayInputStream(inputNull.getBytes());
        InputStream inDollar = new ByteArrayInputStream(inputDollar.getBytes());
        InputStream inWert = new ByteArrayInputStream(inputWert.getBytes());

        System.setIn(inZwei);
        Assert.assertTrue(Eingabe.EingabeHasNext());

        System.setIn(inEins);
        Assert.assertTrue(Eingabe.EingabeHasNext());

        System.setIn(inNull);
        Assert.assertTrue(Eingabe.EingabeHasNext());

        System.setIn(inDollar);
        Assert.assertTrue(Eingabe.EingabeHasNext());

        System.setIn(inWert);
        Assert.assertTrue(Eingabe.EingabeHasNext());

    }
}

