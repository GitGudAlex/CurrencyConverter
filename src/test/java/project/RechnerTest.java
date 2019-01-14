package project;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class RechnerTest {

    @Test
    public void umrechner() {
    }

    @Test
    public void SDRWert() {
        Assert.assertArrayEquals(new String[]{"1.273760", "1.349170"}, Rechner.SDRWert("U.S. dollar", "Euro"));
    }

    @Test
    public void blockZwei() {
    }

    @Test
    public void punktKomma() {
    }
}