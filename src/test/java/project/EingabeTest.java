package project;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import java.util.Scanner;

import static org.junit.Assert.*;

public class EingabeTest {
    //IntegerAsker asker = mock(IntegerAsker.class);
    //when(asker.ask(anyString())).thenReturn(3);



    @Test
    public void getEingabe(){
        String inputZwei = "2";
        String inputEins = "1";
        String inputNull = "0";

        InputStream inZwei = new ByteArrayInputStream(inputZwei.getBytes());
        InputStream inEins = new ByteArrayInputStream(inputEins.getBytes());
        InputStream inNull = new ByteArrayInputStream(inputNull.getBytes());

        System.setIn(inZwei);
        Assert.assertEquals("2", Eingabe.getEingabe());

        System.setIn(inEins);
        Assert.assertEquals("1", Eingabe.getEingabe());

        System.setIn(inNull);
        Assert.assertEquals("0", Eingabe.getEingabe());
    }

    @Test
    public void eingabeHasNext() {
    }
}

