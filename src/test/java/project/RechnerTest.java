package project;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class RechnerTest {

    @Test
    public void umrechner() {
        String EuroMexicanPeso [] = {"26.381300", "1.273760"};
        String EuroUSDollar [] = {"1.349170", "1.273760"};
        Assert.assertEquals(72.49, Rechner.Umrechner(EuroMexicanPeso, 3.5), 1e-15);
        Assert.assertEquals(5.3, Rechner.Umrechner(EuroUSDollar, 5.0), 1e-15);
        Assert.assertEquals(0.0, Rechner.Umrechner(EuroUSDollar, 0.0), 1e-15);
    }

    @Test
    public void SDRWert() {
        //Assert.assertArrayEquals(new String[]{"1.273760", "1.349170"}, Rechner.SDRWert("U.S. dollar", "Euro"));
    }

    @Test
    public void blockZwei() {
    }

    @Test
    public void punktKomma() {
    }
}