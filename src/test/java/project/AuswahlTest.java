package project;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class AuswahlTest {

    @Test
    public void laenderauswahl() {
    }

    @Test
    public void möglichkeitenAuswahl() {
    }

    @Test
    public void ausgewaehlt () {
        String [] vorschlagEuro = {"Euro"};
        String [] vorschlagDol = {"U.S. dollar", "Australian dollar", "Brunei dollar", "Canadian dollar", "New Zealand dollar", "Singapore dollar", "Trinidadian dollar"};
        String [] vorschlagPeso = {"Chilean peso", "Mexican peso", "Philippine peso", "Uruguayan peso"};
        Assert.assertEquals("not set", Auswahl.ausgewaehlt("xxx", vorschlagEuro, "0", "not set", "not set"));
        Assert.assertEquals("not set", Auswahl.ausgewaehlt("xxx", vorschlagDol, "0", "not set", "not set"));
        Assert.assertEquals("not set", Auswahl.ausgewaehlt("xxx", vorschlagDol, "1", "not set", "not set"));
        Assert.assertEquals("Australian dollar", Auswahl.ausgewaehlt("1", vorschlagDol, "0", "not set", "not set"));
        Assert.assertEquals("Singapore dollar", Auswahl.ausgewaehlt("5", vorschlagDol, "0", "not set", "not set"));
        Assert.assertEquals("Chilean peso", Auswahl.ausgewaehlt("0", vorschlagPeso, "0", "Euro", "U.S. dollar"));
        Assert.assertEquals("Chilean peso", Auswahl.ausgewaehlt("0", vorschlagPeso, "1", "New Zealand dollar", "Trinidadian dollar"));

    }
}