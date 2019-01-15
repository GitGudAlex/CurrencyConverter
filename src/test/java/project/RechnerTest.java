package project;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class RechnerTest {

    @Test
    public void umrechner() {
        String EuroMexicanPeso [] = {"26.381300", "1.273760"};
        String EuroUSDollar [] = {"1.349170", "1.273760"};
        String BahrainDinarKazakhstaniTenge [] = {"426.687000", "0.507287"};
        String KazakhstaniTengeBahrainDinar [] = {"0.507287", "426.687000"};

        Assert.assertEquals(72.49, Rechner.Umrechner(EuroMexicanPeso, 3.5), 1e-15);
        Assert.assertEquals(2.07113584977E9, Rechner.Umrechner(EuroMexicanPeso, 1.0E8), 1e-15);
        Assert.assertEquals(5.3, Rechner.Umrechner(EuroUSDollar, 5.0), 1e-15);
        Assert.assertEquals(0.0, Rechner.Umrechner(EuroUSDollar, 0.0), 1e-15);
        Assert.assertEquals(105920.27, Rechner.Umrechner(EuroUSDollar, 100000.0), 1e-15);
        Assert.assertEquals(0.0, Rechner.Umrechner(KazakhstaniTengeBahrainDinar, 1.0), 1e-15);
        Assert.assertEquals(118.89, Rechner.Umrechner(KazakhstaniTengeBahrainDinar, 100000.0), 1e-15);
        Assert.assertEquals(8.411155815E7, Rechner.Umrechner(BahrainDinarKazakhstaniTenge, 100000.0), 1e-15);
        Assert.assertEquals(-8411.16, Rechner.Umrechner(BahrainDinarKazakhstaniTenge, -10.0), 1e-15);

    }

    @Test
    public void SDRWert() {
        //Assert.assertArrayEquals(new String[]{"1.273760", "1.349170"}, Rechner.SDRWert("U.S. dollar", "Euro"));
    }

    @Test
    public void blockZwei() {
        //Assert.assertEquals(5.3 , Rechner.BlockZwei("U.S. dollar", "Euro", 5.0), 1e-15);
    }

    @Test
    public void punktKomma() {
        Assert.assertEquals(3.4, Rechner.PunktKomma("3.4"), 1e-15);
        Assert.assertEquals(3.4, Rechner.PunktKomma("3,4"), 1e-15);
        Assert.assertEquals(5463.9921, Rechner.PunktKomma("5463.9921"), 1e-15);
        Assert.assertEquals(5463.9921, Rechner.PunktKomma("5463,9921"), 1e-15);
    }
}