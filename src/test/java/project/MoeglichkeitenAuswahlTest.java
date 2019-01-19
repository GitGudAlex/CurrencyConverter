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
     * UnitTest der Methode MöglichkeitenAuswahl(), die bei einer input von einem vollständigen Wort oder nur einem
     * Teilwort eine Liste der möglichen Währungen ausgibt.
     * Testen, ob die ausgegebenen Vorschläge für z.B. dol, Eu oder euro richtig sind.
     * Testen, ob Groß- und Kleinschriebung, sowie das ganze Wort bzw. ein Teil des Wortes zum gleichen Ergebnis führen.
     */
    @Test
    public void möglichkeitenAuswahl() {

        String [] suggestionDol = new String [Main.currencylist.size()];
        String [] suggestionEuro = new String [Main.currencylist.size()];
        String [] suggestionAu = new String [Main.currencylist.size()];
        String [] suggestionNew = new String [Main.currencylist.size()];

        suggestionDol [0] = "U.S. dollar";
        suggestionDol [1] = "Australian dollar";
        suggestionDol [2] = "Brunei dollar";
        suggestionDol [3] = "Canadian dollar";
        suggestionDol [4] = "New Zealand dollar";
        suggestionDol [5] = "Singapore dollar";
        suggestionDol [6] = "Trinidadian dollar";

        suggestionEuro [0] = "Euro";

        suggestionAu [0] = "Australian dollar";
        suggestionAu [1] = "Mauritian rupee";
        suggestionAu [2] = "Saudi Arabian riyal";

        suggestionNew [0] = "Israeli New Shekel";
        suggestionNew [1] = "New Zealand dollar";

        Assert.assertArrayEquals(suggestionDol, Selection.MöglichkeitenAuswahl("dol"));
        Assert.assertArrayEquals(suggestionEuro, Selection.MöglichkeitenAuswahl("Eu"));
        Assert.assertArrayEquals(suggestionEuro, Selection.MöglichkeitenAuswahl("eur"));
        Assert.assertArrayEquals(suggestionEuro, Selection.MöglichkeitenAuswahl("Euro"));
        Assert.assertArrayEquals(suggestionAu, Selection.MöglichkeitenAuswahl("au"));
        Assert.assertArrayEquals(suggestionAu, Selection.MöglichkeitenAuswahl("Au"));
        Assert.assertArrayEquals(suggestionNew, Selection.MöglichkeitenAuswahl("new"));
    }
}
