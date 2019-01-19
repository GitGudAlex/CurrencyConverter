package project;

import org.junit.Assert;
import org.junit.Test;

public class HeaderTest {

    /**
     * UnitTest der Methode headerOne(), die den Kopfbereich mit den übergebenen Parametern ausgibt.
     */
    @Test
    public void headerOne() {
        String EuroUSDollar = "\n\n\n\ncurrency to buy: Euro\ncurrency to sell: U.S. dollar\n++++++++++++++++++++++++++++++++++";
        String MexicanPesoNepaleseRupee = "\n\n\n\ncurrency to buy: Mexican Peso\ncurrency to sell: Nepalese Rupee\n++++++++++++++++++++++++++++++++++";
        Assert.assertEquals(EuroUSDollar, Header.headerOne("U.S. dollar", "Euro"));
        Assert.assertEquals(MexicanPesoNepaleseRupee, Header.headerOne("Nepalese Rupee", "Mexican Peso"));
    }

    /**
     * UnitTest der Methode headerTwo(), die den Kopfbereich mit den übergebenen Parametern ausgibt.
     */
    @Test
    public void headerTwo() {
        String EuroUSDollar = "\n\n\n\nBuying: 3.5 Euro\nSelling: 3.71 U.S. dollar\n++++++++++++++++++++++++++++++++++";
        String MexicanPesoNepaleseRupee = "\n\n\n\nBuying: 5.0 Mexican peso\nSelling: 27.33 Nepalese rupee\n++++++++++++++++++++++++++++++++++";
        Assert.assertEquals(EuroUSDollar, Header.headerTwo("U.S. dollar", "Euro", 3.5, 3.71));
        Assert.assertEquals(MexicanPesoNepaleseRupee, Header.headerTwo("Nepalese rupee", "Mexican peso", 5.0, 27.33));
    }
}