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
        String inputTwo = "2";
        String inputOne = "1";
        String inputZero = "0";
        String inputDollar = "Dollar";
        String inputValue = "3.56";

        InputStream inTwo = new ByteArrayInputStream(inputTwo.getBytes());
        InputStream inOne = new ByteArrayInputStream(inputOne.getBytes());
        InputStream inZero = new ByteArrayInputStream(inputZero.getBytes());
        InputStream inDollar = new ByteArrayInputStream(inputDollar.getBytes());
        InputStream inValue = new ByteArrayInputStream(inputValue.getBytes());

        System.setIn(inTwo);
        Assert.assertEquals("2", Eingabe.getEingabe());

        System.setIn(inOne);
        Assert.assertEquals("1", Eingabe.getEingabe());

        System.setIn(inZero);
        Assert.assertEquals("0", Eingabe.getEingabe());

        System.setIn(inDollar);
        Assert.assertEquals("Dollar",Eingabe.getEingabe() );

        System.setIn(inValue);
        Assert.assertEquals("3.56", Eingabe.getEingabe());
    }
}

