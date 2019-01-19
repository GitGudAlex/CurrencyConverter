package project;

import org.junit.Assert;
import org.junit.Test;

public class HeaderTest {

    /**
     * UnitTest der Methode kopfbereichEins(), die den Kopfbereich mit den übergebenen Parametern ausgibt.
     */
    @Test
    public void kopfbereichEins() {
        String EuroUSDollar = "\n\n\n\nCurrency to buy: Euro\nCurrency to sell: U.S. dollar\n++++++++++++++++++++++++++++++++++";
        String MexicanPesoNepaleseRupee = "\n\n\n\nCurrency to buy: Mexican Peso\nCurrency to sell: Nepalese Rupee\n++++++++++++++++++++++++++++++++++";
        Assert.assertEquals(EuroUSDollar, Header.KopfbereichEins("U.S. dollar", "Euro"));
        Assert.assertEquals(MexicanPesoNepaleseRupee, Header.KopfbereichEins("Nepalese Rupee", "Mexican Peso"));
    }

    /**
     * UnitTest der Methode kopfbereichZwei(), die den Kopfbereich mit den übergebenen Parametern ausgibt.
     */
    @Test
    public void kopfbereichZwei() {
        String EuroUSDollar = "\n\n\n\nBuying: 3.5 Euro\nSelling: 3.71 U.S. dollar\n++++++++++++++++++++++++++++++++++";
        String MexicanPesoNepaleseRupee = "\n\n\n\nBuying: 5.0 Mexican peso\nSelling: 27.33 Nepalese rupee\n++++++++++++++++++++++++++++++++++";
        Assert.assertEquals(EuroUSDollar, Header.KopfbereichZwei("U.S. dollar", "Euro", 3.5, 3.71));
        Assert.assertEquals(MexicanPesoNepaleseRupee, Header.KopfbereichZwei("Nepalese rupee", "Mexican peso", 5.0, 27.33));
    }
}