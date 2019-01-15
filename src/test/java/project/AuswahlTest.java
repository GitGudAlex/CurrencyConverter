package project;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class AuswahlTest {

    @Test
    public void laenderauswahl() {
    }

    @Test
    public void möglichkeitenAuswahl() {
        String expected [] = {"U.S. dollar", "Australian dollar", "Brunei dollar", "Canadian dollar", "New Zealand dollar", "Singapore dollar", "Trinidadian dollar" };

        Assert.assertArrayEquals(expected, Auswahl.MöglichkeitenAuswahl("dol"));
    }
}