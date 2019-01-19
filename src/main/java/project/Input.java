package project;

import java.util.Scanner;

public class Input {

    /**
     *Scannen der Benutzereingabe
      */
    public static String getInput(){
        //Initialisierung Scanner
        Scanner inputScanner = new Scanner(System.in);
        //nächste Eingabe scannen
        return inputScanner.next();
    }
}
