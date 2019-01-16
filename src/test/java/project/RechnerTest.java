package project;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class RechnerTest {
    /**
     * Unit Test: Methode Umrechner
     */
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
        Main.currencyListeFüllen();
        Assert.assertArrayEquals(new String[]{"1.349170", "1.273760"}, Rechner.SDRWert("U.S. dollar", "Euro"));
        Assert.assertArrayEquals(new String[]{"38.080200", "1.362120"}, Rechner.SDRWert("Uruguayan peso", "Swiss franc"));
        Assert.assertArrayEquals(new String[]{"1.920520", "26.381300"}, Rechner.SDRWert("New Zealand dollar", "Mexican peso"));
        Assert.assertArrayEquals(new String[]{"14.024600", "1.273760"}, Rechner.SDRWert("Botswana pula", "Euro"));
        Assert.assertArrayEquals(new String[]{"1.349170", "14.024600"}, Rechner.SDRWert("U.S. dollar", "Botswana pula"));
    }

    @Test
    public void blockZwei() {
        Main.currencyListeFüllen();
        Assert.assertEquals(5.3 , Rechner.BlockZwei("U.S. dollar", "Euro", 5.0), 1e-15);
        Assert.assertEquals(67.1 , Rechner.BlockZwei("Mexican peso", "Canadian dollar", 4.6), 1e-15);
        Assert.assertEquals(8924.62 , Rechner.BlockZwei("Uruguayan peso", "Kazakhstani tenge", 100000.0), 1e-15);
        Assert.assertEquals(5.0 , Rechner.BlockZwei("Kazakhstani tenge", "Kazakhstani tenge", 5.0), 1e-15);
        Assert.assertEquals(19.49 , Rechner.BlockZwei("Malaysian ringgit", "Australian dollar", 5.78), 1e-15);
    }

    @Test
    public void punktKomma() {
        Assert.assertEquals(3.4, Rechner.PunktKomma("3.4"), 1e-15);
        Assert.assertEquals(3.4, Rechner.PunktKomma("3,4"), 1e-15);
        Assert.assertEquals(5463.9921, Rechner.PunktKomma("5463.9921"), 1e-15);
        Assert.assertEquals(5463.9921, Rechner.PunktKomma("5463,9921"), 1e-15);
    }
}