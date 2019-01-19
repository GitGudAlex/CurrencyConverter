package project;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class HelperTest {

    /**
     * Aufruf Methode fillCurrencyList(): Die Daten (Währungen und SDR Werte),
     * werden aus der Datei ausgelesen und in eine ArrayListe geschrieben.
     */
    @Before
    public void initialize () {
        Main.fillCurrencyList();
    }

    /**
     * UnitTest der Methode correctInput(), welche überprüft, ob es sich bei der Selection der Währung um eine korrekte
     * Input handelt (d.h. eine vorhandene Währung)
     */
    @Test
    public void correctInput() {

        Assert.assertEquals(true, Helper.correctInput("euro"));
        Assert.assertEquals(true, Helper.correctInput("U.S. dollar"));
        Assert.assertEquals(false, Helper.correctInput("sifjiweqtgwehq"));

        Assert.assertTrue(Helper.correctInput("xxx"));
        Assert.assertTrue(Helper.correctInput("Australian dollar"));
        Assert.assertTrue(Helper.correctInput("Mexican peso"));

        Assert.assertFalse(Helper.correctInput("1"));
        Assert.assertFalse(Helper.correctInput("34857dsf"));
        Assert.assertFalse(Helper.correctInput("Hallo"));
    }

    /**
     * UnitTest der Methode converter(), die überprüft ob der richtige Wert berechnet wird beim aufrufen der Methode
     */
    @Test
    public void converter() {
        String EuroMexicanPeso [] = {"26.381300", "1.273760"};
        String EuroUSDollar [] = {"1.349170", "1.273760"};
        String BahrainDinarKazakhstaniTenge [] = {"426.687000", "0.507287"};
        String KazakhstaniTengeBahrainDinar [] = {"0.507287", "426.687000"};

        Assert.assertEquals(72.49, Helper.converter(EuroMexicanPeso, 3.5), 1e-15);
        Assert.assertEquals(2.07113584977E9, Helper.converter(EuroMexicanPeso, 1.0E8), 1e-15);
        Assert.assertEquals(5.3, Helper.converter(EuroUSDollar, 5.0), 1e-15);
        Assert.assertEquals(0.0, Helper.converter(EuroUSDollar, 0.0), 1e-15);
        Assert.assertEquals(105920.27, Helper.converter(EuroUSDollar, 100000.0), 1e-15);
        Assert.assertEquals(0.0, Helper.converter(KazakhstaniTengeBahrainDinar, 1.0), 1e-15);
        Assert.assertEquals(118.89, Helper.converter(KazakhstaniTengeBahrainDinar, 100000.0), 1e-15);
        Assert.assertEquals(8.411155815E7, Helper.converter(BahrainDinarKazakhstaniTenge, 100000.0), 1e-15);
        Assert.assertEquals(-8411.16, Helper.converter(BahrainDinarKazakhstaniTenge, -10.0), 1e-15);

    }

    /**
     * UniTest der Methode sdrValue: zur Überprüfung, ob der richtige sdrValue aus der Currencyliste ausgelesen wird
     * beim übergeben der Währung
     */
    @Test
    public void sdrValue() {
        Assert.assertArrayEquals(new String[]{"1.349170", "1.273760"}, Helper.sdrValue("U.S. dollar", "Euro"));
        Assert.assertArrayEquals(new String[]{"38.080200", "1.362120"}, Helper.sdrValue("Uruguayan peso", "Swiss franc"));
        Assert.assertArrayEquals(new String[]{"1.920520", "26.381300"}, Helper.sdrValue("New Zealand dollar", "Mexican peso"));
        Assert.assertArrayEquals(new String[]{"14.024600", "1.273760"}, Helper.sdrValue("Botswana pula", "Euro"));
        Assert.assertArrayEquals(new String[]{"1.349170", "14.024600"}, Helper.sdrValue("U.S. dollar", "Botswana pula"));
    }

    /**
     * UnitTest der Methode selectionTwo(), zur Überprüfung, ob bei der Übergabe der Währungen der eingegebene Wert
     * richtig umgerechnet wird.
     */
    @Test
    public void selectionTwo() {
        Assert.assertEquals(5.3 , Helper.selectionTwo("U.S. dollar", "Euro", 5.0), 1e-15);
        Assert.assertEquals(67.1 , Helper.selectionTwo("Mexican peso", "Canadian dollar", 4.6), 1e-15);
        Assert.assertEquals(8924.62 , Helper.selectionTwo("Uruguayan peso", "Kazakhstani tenge", 100000.0), 1e-15);
        Assert.assertEquals(5.0 , Helper.selectionTwo("Kazakhstani tenge", "Kazakhstani tenge", 5.0), 1e-15);
        Assert.assertEquals(19.49 , Helper.selectionTwo("Malaysian ringgit", "Australian dollar", 5.78), 1e-15);
    }

    /**
     * UniTest ob bei der Methode replace(), Werte, die mit "," geschrieben sind ein Werte, die mit "." getrennt
     * sind umgeschrieben werden.
     */
    @Test
    public void replace() {
        Assert.assertEquals(3.4, Helper.replace("3.4"), 1e-15);
        Assert.assertEquals(3.4, Helper.replace("3,4"), 1e-15);
        Assert.assertEquals(5463.9921, Helper.replace("5463.9921"), 1e-15);
        Assert.assertEquals(5463.9921, Helper.replace("5463,9921"), 1e-15);
    }
}