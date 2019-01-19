package project;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MoeglichkeitenAuswahlTest {

    @Before
    public void initialisieren (){
        Main.currencyListeFüllen();
    }

    /**
     * UnitTest der Methode MöglichkeitenAuswahl(), die bei einer Eingabe von einem vollständigen Wort oder nur einem
     * Teilwort eine Liste der möglichen Währungen ausgibt.
     * Testen, ob die ausgegebenen Vorschläge für z.B. dol, Eu oder euro richtig sind.
     * Testen, ob Groß- und Kleinschriebung, sowie das ganze Wort bzw. ein Teil des Wortes zum gleichen Ergebnis führen.
     */
    @Test
    public void möglichkeitenAuswahl() {

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
}
