package project;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;



public class InputTest {

    /**
     * UnitTest der Methode getInput(), die die nächste Input des Benutzers zurückgibt.
     * Test findet mit festgelegter Benutzereingabe statt.
     */
    @Test
    public void getInput(){
        String inputTwo = "2";
        String inputOne = "1";
        String inputZero = "0";
        String inputDollar = "Dollar";
        String inputValue = "3.56";

        InputStream inTwo = new ByteArrayInputStream(inputTwo.getBytes());
        InputStream inOne = new ByteArrayInputStream(inputOne.getBytes());
        InputStream inZero = new ByteArrayInputStream(inputZero.getBytes());
        InputStream inDollar = new ByteArrayInputStream(inputDollar.getBytes());
        InputStream inValue = new ByteArrayInputStream(inputValue.getBytes());

        System.setIn(inTwo);
        Assert.assertEquals("2", Input.getInput());

        System.setIn(inOne);
        Assert.assertEquals("1", Input.getInput());

        System.setIn(inZero);
        Assert.assertEquals("0", Input.getInput());

        System.setIn(inDollar);
        Assert.assertEquals("Dollar", Input.getInput() );

        System.setIn(inValue);
        Assert.assertEquals("3.56", Input.getInput());
    }
}

