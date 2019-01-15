package project;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CurrencyTest {

    @Test
    public void getName() {
        Currency Euro = new Currency("Euro", "1.273760");
        Currency USdollar = new Currency("U.S. dollar", "1.349170");
        Assert.assertEquals("Euro", Euro.getName());
        Assert.assertEquals("U.S. dollar", USdollar.getName());
    }

    @Test
    public void getRate() {
        Currency Euro = new Currency("Euro", "1.273760");
        Currency USdollar = new Currency("U.S. dollar", "1.349170");
        Assert.assertEquals("1.273760", Euro.getRate());
        Assert.assertEquals("1.349170", USdollar.getRate());
    }

    @Test
    public void setName() {
        Currency Euro = new Currency("", "");
        Currency USdollar = new Currency("", "");
        Assert.assertEquals("Euro", Euro.setName("Euro"));
        Assert.assertEquals("U.S. dollar", USdollar.setName("U.S. dollar"));
    }

    @Test
    public void setRate() {
        Currency Euro = new Currency("", "");
        Currency USdollar = new Currency("", "");
        Assert.assertEquals("1.273760", Euro.setRate("1.273760"));
        Assert.assertEquals("1.349170", USdollar.setRate("1.349170"));
    }

    @Test
    public void korrekterSDRWert() {
        String [] Euro = {"1.273760"};
        String [] USDollar = {"1.349170"};
        String [] ColumbianPeso = {"4,017.050000"};
        String [] IranianRial = {"43.725.000000"};
        String [] KoreanWon = {"1.555.180000"};
        Assert.assertEquals(true, Currency.korrekterSDRWert(Euro [0]));
        Assert.assertEquals(true, Currency.korrekterSDRWert(USDollar[0]));
        Assert.assertEquals(false, Currency.korrekterSDRWert(ColumbianPeso[0]));
        Assert.assertEquals(false, Currency.korrekterSDRWert(IranianRial[0]));
        Assert.assertEquals(false, Currency.korrekterSDRWert(KoreanWon[0]));
    }
}