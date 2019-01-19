package project;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class HelperTest {

    @Before
    public void initialisieren () {
        Main.currencyListeFüllen();
    }

    @Test
    public void eingabeKorrekt() {

        Assert.assertEquals(true, Helper.EingabeKorrekt("euro"));
        Assert.assertEquals(true, Helper.EingabeKorrekt("U.S. dollar"));
        Assert.assertEquals(false, Helper.EingabeKorrekt("sifjiweqtgwehq"));

        Assert.assertTrue(Helper.EingabeKorrekt("xxx"));
        Assert.assertTrue(Helper.EingabeKorrekt("Australian dollar"));
        Assert.assertTrue(Helper.EingabeKorrekt("Mexican peso"));

        Assert.assertFalse(Helper.EingabeKorrekt("1"));
        Assert.assertFalse(Helper.EingabeKorrekt("34857dsf"));
        Assert.assertFalse(Helper.EingabeKorrekt("Hallo"));
    }
}