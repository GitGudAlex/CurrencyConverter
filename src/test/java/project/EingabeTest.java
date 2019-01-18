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
        String inputEins = "1";
        InputStream inEins = new ByteArrayInputStream(inputEins.getBytes());
        System.setIn(inEins);
        Assert.assertEquals("1", Eingabe.getEingabe());
    }

    @Test
    public void getEingabeEins(){
        String inputNull = "0";
        InputStream inNull = new ByteArrayInputStream(inputNull.getBytes());
        System.setIn(inNull);
        Assert.assertEquals("0", Eingabe.getEingabe());
    }

    @Test
    public void eingabeHasNext() {
    }
}

