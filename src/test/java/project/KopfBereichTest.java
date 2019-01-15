package project;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class KopfBereichTest {

    @Test
    public void kopfbereichEins() {
        String EuroUSDollar = "\n\n\n\nCurrency to buy: Euro\nCurrency to sell: U.S. dollar\n++++++++++++++++++++++++++++++++++";
        String MexicanPesoNepaleseRupee = "\n\n\n\nCurrency to buy: Mexican Peso\nCurrency to sell: Nepalese Rupee\n++++++++++++++++++++++++++++++++++";
        Assert.assertEquals(EuroUSDollar, KopfBereich.KopfbereichEins("U.S. dollar", "Euro"));
        Assert.assertEquals(MexicanPesoNepaleseRupee, KopfBereich.KopfbereichEins("Nepalese Rupee", "Mexican Peso"));
    }

    @Test
    public void kopfbereichZwei() {
        String EuroUSDollar = "\n\n\n\nBuying: 3.5 Euro\nSelling: 3.71 U.S. dollar\n++++++++++++++++++++++++++++++++++";
        String MexicanPesoNepaleseRupee = "\n\n\n\nBuying: 5.0 Mexican peso\nSelling: 27.33 Nepalese rupee\n++++++++++++++++++++++++++++++++++";
        Assert.assertEquals(EuroUSDollar, KopfBereich.KopfbereichZwei("U.S. dollar", "Euro", 3.5, 3.71));
        Assert.assertEquals(MexicanPesoNepaleseRupee, KopfBereich.KopfbereichZwei("Nepalese rupee", "Mexican peso", 5.0, 27.33));
    }
}