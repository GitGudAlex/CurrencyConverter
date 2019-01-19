package project;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;


public class AuswahlTest {

    @Test
    public void laenderauswahl() {
        Main.currencyListeFüllen();
        String inputEuro = "euro";
        String inputDol = "dol";
        String inputNull = "0";

        InputStream inEuro = new ByteArrayInputStream(inputEuro.getBytes());
        InputStream inDol = new ByteArrayInputStream(inputDol.getBytes());
        InputStream inNull = new ByteArrayInputStream(inputNull.getBytes());

        System.setIn(inEuro);
        Assert.assertEquals("Euro", Auswahl.Laenderauswahl("not set", "not set", false, 0,0,"0"));

        System.setIn(inEuro);
        Assert.assertEquals("Euro", Auswahl.Laenderauswahl("U.S. dollar", "Australian dollar", false, 0,0,"1"));

        System.setIn(inEuro);
        Assert.assertEquals("Euro", Auswahl.Laenderauswahl("Australian dollar", "U.S. dollar", true, 3.0,3.96, "0" ));
    }

    @Test
    public void möglichkeitenAuswahl() {
        Main.currencyListeFüllen();
        String [] vorschlagDol = new String [Main.currencylist.size()];
        String [] vorschlagEuro = new String [Main.currencylist.size()];
        String [] vorschlagAu = new String [Main.currencylist.size()];
        String [] vorschlagNew = new String [Main.currencylist.size()];

        vorschlagDol [0] = "U.S. dollar";
        vorschlagDol [1] = "Australian dollar";
        vorschlagDol [2] = "Brunei dollar";
        vorschlagDol [3] = "Canadian dollar";
        vorschlagDol [4] = "New Zealand dollar";
        vorschlagDol [5] = "Singapore dollar";
        vorschlagDol [6] = "Trinidadian dollar";

        vorschlagEuro [0] = "Euro";

        vorschlagAu [0] = "Australian dollar";
        vorschlagAu [1] = "Mauritian rupee";
        vorschlagAu [2] = "Saudi Arabian riyal";

        vorschlagNew [0] = "Israeli New Shekel";
        vorschlagNew [1] = "New Zealand dollar";

        Assert.assertArrayEquals(vorschlagDol, Auswahl.MöglichkeitenAuswahl("dol"));
        Assert.assertArrayEquals(vorschlagEuro, Auswahl.MöglichkeitenAuswahl("Eu"));
        Assert.assertArrayEquals(vorschlagEuro, Auswahl.MöglichkeitenAuswahl("eur"));
        Assert.assertArrayEquals(vorschlagEuro, Auswahl.MöglichkeitenAuswahl("Euro"));
        Assert.assertArrayEquals(vorschlagAu, Auswahl.MöglichkeitenAuswahl("au"));
        Assert.assertArrayEquals(vorschlagAu, Auswahl.MöglichkeitenAuswahl("Au"));
        Assert.assertArrayEquals(vorschlagNew, Auswahl.MöglichkeitenAuswahl("new"));
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