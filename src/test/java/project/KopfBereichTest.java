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
    }
}