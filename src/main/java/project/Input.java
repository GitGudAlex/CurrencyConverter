package project;

import java.util.Scanner;

public class Input {

    // Methode zum Scannen der Benutzereingabe
    public static String getInput(){
        Scanner inputScanner = new Scanner(System.in); //Initialisierung Scanner
        return inputScanner.next(); //nächste Eingabe scannen
    }
}
