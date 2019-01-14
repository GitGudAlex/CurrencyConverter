package project;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class HelperTest {

    @Test
    public void bestehtAusZahlen() {
    }

    @Test
    public void eingabeKorrekt() {
        Assert.assertEquals(true, Helper.EingabeKorrekt("euro"));
        Assert.assertEquals(true, Helper.EingabeKorrekt("U.S. dollar"));
    }
}